//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerarVideoEvidencia {
    private static String timestamp = (new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")).format(new Date());
    public static String nomeArquivoVideo;
    private Process screenRecordProcess;
    private final String caminho;

    public GerarVideoEvidencia() {
        String var10001 = System.getProperty("user.dir");
        this.caminho = var10001 + File.separator + "target" + File.separator + "evidencias";
    }

    @Before
    public void gravarEvidencia(Scenario scenario) throws IOException {
        String var10000 = scenario.getName().replaceAll(" ", "_");
        nomeArquivoVideo = var10000 + "_" + timestamp + ".mp4";
        ProcessBuilder processBuilder = new ProcessBuilder(new String[]{"xcrun", "simctl", "io", "booted", "recordVideo", this.caminho + File.separator + nomeArquivoVideo});
        this.screenRecordProcess = processBuilder.start();
    }

    @After
    public void pararGravacao() throws IOException {
        if (this.screenRecordProcess != null) {
            Runtime.getRuntime().exec("kill -2 " + this.screenRecordProcess.pid());
        } else {
            throw new RuntimeException("vídeo null");
        }
    }
}
