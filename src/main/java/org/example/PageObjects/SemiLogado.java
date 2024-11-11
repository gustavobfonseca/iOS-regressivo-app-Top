package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SemiLogado {
    private AppiumDriver driver;
    private MobileElement inputSenha;
    private MobileElement botaoEntrar;
    private MobileElement linkTrocarDeConta;
    private MobileElement linkEsqueciMinhaSenha;
    private MobileElement iconeVisuSenha;
    private MobileElement mapa;
    private MobileElement bilhete;
    private MobileElement centralDeAjuda;


    public SemiLogado(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() {
        try {
            WebDriverWait espera = new WebDriverWait(driver, 20);
            espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Esqueci minha senha.\"]")));
            inputSenha = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Espaço para digitar senha\"]");
            botaoEntrar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup");
            linkEsqueciMinhaSenha = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Esqueci minha senha.\"]");
            mapa = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Mapa das ,\n" + ",Estações\"]");
            bilhete = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Bilhetes Offline\"]");
            centralDeAjuda = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Central de,\n" +
                    ",Ajuda\"]");

            linkTrocarDeConta = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Trocar de conta\"]");
        } catch (Exception e) {
            botaoEntrar = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"ENTRAR\"));"));
            buscarElementos();
        }
    }

    public void preencherSenha(String senha) {
        buscarElementos();
        inputSenha.clear();
        inputSenha.sendKeys(senha);
    }

    public void preencherSenhaPadrao() {
        inputSenha.sendKeys("Devires@123");
    }

    public void clicarBotaoEntrar() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup")));
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup")));

        botaoEntrar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup");
        botaoEntrar.click();
        System.out.println("clicar botão de entrar na área semi logada");
    }


    public void buscarMensagemSenhaObrigatoria() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        Thread.sleep(3000);
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("android.widget.TextView[@resource-id=\"error_password_login_input\"]")));
    }

    public MobileElement getLinkEsqueciMinhaSenha() {
        return linkEsqueciMinhaSenha;
    }

    public void clicarMapaEstacao() {
        buscarElementos();
        mapa.click();
    }

    public void buscarMapa() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement mapaEstacao = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"\uE82F Mapa Metrô e Trem \uE8C8\"])[1]")));
    }

    public void clicarBilhetes() {
        buscarElementos();
        bilhete.click();
    }

    public void buscarBilhetes() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Utilizar Bilhetes\"]")));

        MeusBilhetes meusBilhetes = new MeusBilhetes(driver);

        System.out.println(meusBilhetes.getNumeroDeBilhetes());
        try {
            MobileElement txtQtdBilheteOff = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1, de ," + meusBilhetes.getNumeroDeBilhetes() + "\"]");
        } catch (RuntimeException runtimeException) {
            System.out.println("não encontramos o elemneto");
        }
    }

    public void trocarDeConta() {
        linkTrocarDeConta.click();
    }

    public void confirmarTrocaDeConta() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));

        MobileElement confirmarTroca = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
        confirmarTroca.click();
    }

    public void clicarCentralAjuda() {
        centralDeAjuda.click();
    }

    public void buscarCentralDeAjuda() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.webkit.WebView")));

    }

    public void buscarApelidoNomeSocialModificado() {
        String nomeAtualizado = PerfilDoUsuario.getNomeAtualizado();
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement apelidoNomeSocial = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Olá, " + nomeAtualizado + ".\"]")));


    }

    public void buscarSiteTermosUso() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement termoUso = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.android.chrome:id/url_bar\"]")));
        if (termoUso.getText().equals("ajuda.boradetop.com.br/hc/pt-br/articles/15126520483611-Termos-de-Uso-do-Aplicativo-TOP")) {
            System.out.println("url ok");
        }else {
            System.out.println("url não ok");
        }
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
    }
}
