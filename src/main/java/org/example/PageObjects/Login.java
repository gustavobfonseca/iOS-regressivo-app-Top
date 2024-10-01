package org.example.PageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private AppiumDriver driver;
    private MobileElement campoUsuario;
    private MobileElement campoSenha;
    private MobileElement botaoLogin;
    private MobileElement textoModalContaBloqueada;
    private MobileElement linkEsqueciMinhaSenha;
    private MobileElement botaoFecharModalErroCPFSenha;
    private MobileElement iconeInformativo;
    private MobileElement botaoAtendimentoViaWhatsApp;
    private MobileElement centralDeAjuda;
    private MobileElement enviarMensagem;
    private MobileElement criarConta;
    private MobileElement modalErro;

    public Login(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 30);

        // Localizar o campo CPF
        campoUsuario = (MobileElement) espera.until(
                ExpectedConditions.presenceOfElementLocated(By.id("cpf_login_input")));

        // Localizar o campo Senha
        campoSenha = (MobileElement) driver.findElementById("password_login_input");

        // Localizar o botão Entrar
        botaoLogin = (MobileElement) driver.findElementById("signin_button");
    }


    public void preencherFormulario(String usuario, String senha) throws InterruptedException {
        campoUsuario.sendKeys(usuario);
        campoSenha.sendKeys(senha);
    }

    public void preencherFormularioUsuario(String usuario) {
        campoUsuario.sendKeys(usuario);
    }

    public void preencherFormularioSenha(String senha) {
        campoSenha.sendKeys(senha);
    }

    public void logar() {
        botaoLogin.click();
    }

    public void buscarModalErro() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
       MobileElement modalErro =(MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name='CPF e/ou senha inválidos.']")));

    }

    public void clicarEsqueciMinhaSenha(){
        linkEsqueciMinhaSenha.click();
    }

    public void buscarModalContaBloqueada(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("modal_bloqueio")));
    }

    public void buscarMensagemContaBloqueada(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("Para sua segurança o acesso ao Aplicativo foi bloqueado temporariamente.")));

        textoModalContaBloqueada = (MobileElement) driver.findElementByAccessibilityId("Para sua segurança o acesso ao Aplicativo foi bloqueado temporariamente.");
    }

    public void arrastarModalContaBloqueadaBaixo(){
        buscarMensagemContaBloqueada();

        Dimension tamanhoTela = driver.manage().window().getSize();
        int alturaTela = tamanhoTela.getHeight();
        int alturaModal = alturaTela * 2 / 3;
        int larguraModal = tamanhoTela.getWidth() / 2;

        driver.executeScript("mobile: flingGesture", ImmutableMap.of("elementId", textoModalContaBloqueada.getId(),
                "percentage", 100,
                "direction", "down",
                "speed", 500));
    }

    public void buscarBotaoFecharModalCPFSenha(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("Fechar")));

        botaoFecharModalErroCPFSenha = (MobileElement) driver.findElementByAccessibilityId("Fechar");
    }

    public void clicarBotaoFecharModalCPFSenha(){
        botaoFecharModalErroCPFSenha.click();
    }

    public void clicarBotaoAtendimentoWhatsApp() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.elementToBeClickable(By.id("botao_modal_bloqueio")));

        botaoAtendimentoViaWhatsApp = (MobileElement) driver.findElementByAccessibilityId("botao_modal_bloqueio");
        botaoAtendimentoViaWhatsApp.click();
    }

    public void clicarCentralDeAjuda() {
        centralDeAjuda = (MobileElement) driver.findElementByAccessibilityId("Central de Ajuda");
        centralDeAjuda.click();
    }

    public void clicarCriarConta() {
        criarConta.click();
    }

    public void clicarEnviarMensagem() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("ENVIAR MENSAGEM")));

        enviarMensagem = (MobileElement) driver.findElementByAccessibilityId("ENVIAR MENSAGEM");
        enviarMensagem.click();
    }

    public void verificarRedirecionamentoWhatsapp() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("Autopass")));

        MobileElement elemento = (MobileElement) driver.findElementByAccessibilityId("Autopass");

        if (elemento.getText().equals("Autopass")) {
            System.out.println(elemento.getText());
        } else {
            throw new AssertionError("Nome do contato não é Autopass.");
        }
    }

    public void limparCamposLogin() {
        if (!campoUsuario.getText().equals("***.***.***-**")) {
            campoUsuario.clear();
            campoSenha.clear();
        }
    }

    public MobileElement getCampoUsuario() {
        return campoUsuario;
    }

    public void setCampoUsuario(MobileElement campoUsuario) {
        this.campoUsuario = campoUsuario;
    }

    public MobileElement getCampoSenha() {
        return campoSenha;
    }

    public void setCampoSenha(MobileElement campoSenha) {
        this.campoSenha = campoSenha;
    }

    public MobileElement getBotaoLogin() {
        return botaoLogin;
    }

    public void setBotaoLogin(MobileElement botaoLogin) {
        this.botaoLogin = botaoLogin;
    }

    public MobileElement getModalErro() {
        return modalErro;
    }

    public void setModalErro(MobileElement modalErro) {
        this.modalErro = modalErro;
    }

    public MobileElement getTextoModalContaBloqueada() {
        return textoModalContaBloqueada;
    }

    public void buscarTeste() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement config = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.id("General")));
        config.click();
        Thread.sleep(4000);
    }
}
