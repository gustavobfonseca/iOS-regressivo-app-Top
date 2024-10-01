package org.example.PageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    private AppiumDriver driver;
    private MobileElement msgBoaViagem;
    private MobileElement botaoBiometria;
    private MobileElement botaoBilhetes;
    private MobileElement botaoModalQueroConhecer;
    private PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    private MobileElement modal;
    private MobileElement fotoDePerfil;
    private MobileElement textoDadosPessoais;
    private MobileElement textoMockTokenGemalto;
    private MobileElement botaoTogleMockTokenGemalto;
    private MobileElement botaoCartaoTop;
    private MobileElement iconePerfil;
    private MobileElement campoSenhaDoAplicativo;
    private MobileElement senhaAtualRedefinir;
    private MobileElement botaoEditarSenha;
    private MobileElement senhaNovaRedefinir;
    private MobileElement confirmarSenhaNovaRedefinir;
    private MobileElement botaoEnviarRedefinirSenha;


    public Home(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarFotoDePerfil(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]")));

        fotoDePerfil = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]");
    }

    public void esperarBotaoBiometria() {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para ativar biometria.\"]/android.view.ViewGroup")));

        botaoBiometria = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para ativar biometria.\"]/android.view.ViewGroup");

    }

    public void redefinirSenhaPeloPerfil() throws InterruptedException {
        clicarIconePerfil();
        clicarPerfilSenhaDoAplicativo();
        redefinirSenha("Devires@1234", "Devires@123", "Devires@123");

    }

    public void redefinirSenha(String senhaAtual, String novaSenha, String confirmaSenha) throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Digite a senha atual\"]")));
        senhaAtualRedefinir = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Digite a senha atual\"]");
        senhaAtualRedefinir.sendKeys(senhaAtual);
        botaoEditarSenha = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão EDITAR\"]/android.view.ViewGroup");
        botaoEditarSenha.click();
        Thread.sleep(1000);
        senhaNovaRedefinir = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Digite a nova senha\"]");
        confirmarSenhaNovaRedefinir = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Digite a nova senha novamente\"]");
        senhaNovaRedefinir.sendKeys(novaSenha);
        confirmarSenhaNovaRedefinir.sendKeys(confirmaSenha);
        Thread.sleep(1000);
        botaoEnviarRedefinirSenha = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão ENVIAR\"]/android.view.ViewGroup");
        botaoEnviarRedefinirSenha.click();

        WebDriverWait espera2 = new WebDriverWait(driver, 60);
        espera2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Clique para editar a senha\"]/android.view.ViewGroup")));


    }


    public void clicarBotaoAtivarBiometria() {
        botaoBiometria.click();
    }

    public void clicarFotoDePerfil(){
        fotoDePerfil.click();
    }

    public void buscarModal() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]")));

        modal = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]");


    }

    public void buscarMensagemBemVindo() {
        msgBoaViagem = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Tenha uma boa viagem.\"]");
    }


    public void arrastarModalParaBaixo() throws InterruptedException {
        Thread.sleep(10000);
        buscarModal();
        driver.executeScript("gesture: swipe", ImmutableMap.of("elementId", modal.getId(),
                "percentage", 100,
                "direction", "down"));
        Thread.sleep(500);
        buscarMensagemBemVindo();
    }

    public void scrolAteOpcaoMock(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"DADOS PESSOAIS\"]")));

        textoMockTokenGemalto = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Mock gemalto token\"));"));

        botaoTogleMockTokenGemalto = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Mock gemalto token\"]/android.view.ViewGroup");

    }

    public void clicarBotaoMockTokenGemalto(){
        botaoTogleMockTokenGemalto.click();
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void buscarBotaoBilhetes(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Bilhetes\n" +
                "QR Code\"]")));

        botaoBilhetes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Bilhetes\n" +
                "QR Code\"]");
    }

    public void buscarBotaoCartaoTop(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Cartão\n" +
                "TOP\"]")));

        botaoCartaoTop = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Cartão\n" +
                "TOP\"]");
    }

    public void clicarBotaoCartaoTop(){
        botaoCartaoTop.click();
    }
      
    public void clicarBotaoBilhetes() {
        botaoBilhetes.click();
    }

    public void clicarIconePerfil() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]")));
        iconePerfil = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]");
        iconePerfil.click();
    }

    public void clicarPerfilSenhaDoAplicativo() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"DADOS PESSOAIS\"]")));

        campoSenhaDoAplicativo = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Senha do aplicativo\"));"));

        campoSenhaDoAplicativo = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Clique para editar a senha\"]/android.view.ViewGroup");
        campoSenhaDoAplicativo.click();
    }

    public void clicarBotaoModalQueroConhecer() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        By botaoModalQueroConhecerLocator = By.xpath("//android.view.ViewGroup[@content-desc=\"Botão de navegação tela de vantagens.\"]/android.view.ViewGroup");

        try {
            espera.until(ExpectedConditions.presenceOfElementLocated(botaoModalQueroConhecerLocator));
            MobileElement botaoModalQueroConhecer = (MobileElement) driver.findElement(botaoModalQueroConhecerLocator);
            botaoModalQueroConhecer.click();
            Thread.sleep(2000);
            driver.navigate().back();
            buscarMensagemBemVindo();
        } catch (TimeoutException e) {
            buscarMensagemBemVindo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public MobileElement getMsgBoaViagem() {
        return msgBoaViagem;
    }

    public PointerInput getFinger() {
        return finger;
    }

    public MobileElement getModal() {
        return modal;
    }
}
