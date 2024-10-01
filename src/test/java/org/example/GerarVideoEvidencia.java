package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerarVideoEvidencia {
    private static String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    public static String nomeArquivoVideo;
    private Process screenRecordProcess;
    private final String caminho = System.getProperty("user.dir") + File.separator + "target" + File.separator + "evidencias";


    @Before
    public void gravarEvidencia(Scenario scenario) throws IOException {
        nomeArquivoVideo = scenario.getName().replaceAll(" ", "_") + "_" + timestamp + ".mp4";

        ProcessBuilder processBuilder = new ProcessBuilder("xcrun", "simctl", "io", "booted", "recordVideo", caminho + File.separator + nomeArquivoVideo);
        screenRecordProcess = processBuilder.start();

    }

    @After
    public void pararGravacao() throws IOException {
        if (screenRecordProcess != null) {
            Runtime.getRuntime().exec("kill -2 " + screenRecordProcess.pid());
        }
    }
}
