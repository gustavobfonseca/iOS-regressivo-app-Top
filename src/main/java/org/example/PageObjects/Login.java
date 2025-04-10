//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.PageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.example.GestosEmulador;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
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
        WebDriverWait espera = new WebDriverWait(this.driver, 30L);
        this.campoUsuario = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeTextField[@name=\"cpf_login_input\"]")));
        this.campoSenha = (MobileElement) this.driver.findElementById("password_login_input");
        botaoLogin = (MobileElement) driver.findElementById("signin_button");
        this.criarConta = (MobileElement) this.driver.findElementById("É novo por aqui?  Crie uma conta.");
        this.linkEsqueciMinhaSenha = (MobileElement) this.driver.findElementByAccessibilityId("Esqueci minha senha.");

    }

    public void preencherFormulario(String usuario, String senha) throws InterruptedException {
        char[] var3 = usuario.toCharArray();
        int var4 = var3.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            char digito = var3[var5];
            this.campoUsuario.sendKeys(new CharSequence[]{String.valueOf(digito)});
        }
        campoUsuario.sendKeys(Keys.RETURN);

        this.campoSenha.sendKeys(new CharSequence[]{senha});
        campoSenha.sendKeys(Keys.RETURN);

    }

    public void preencherFormularioUsuario(String usuario) {
        this.campoUsuario.sendKeys(new CharSequence[]{usuario});
    }

    public void preencherFormularioSenha(String senha) {
        this.campoSenha.sendKeys(new CharSequence[]{senha});
    }

    public void logar() {
        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
        MobileElement BLogin = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.id("signin_button")));
        BLogin.click();
    }

    public void buscarModalErro() {
        WebDriverWait espera = new WebDriverWait(this.driver, 30L);
        MobileElement modalErro = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Ícone times-circle Erro CPF e/ou senha inválidos. Fechar\"])[1]")));
    }

    public void clicarEsqueciMinhaSenha() {
        this.linkEsqueciMinhaSenha.click();
    }

    public void buscarModalContaBloqueada() {
        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Para sua segurança o acesso ao Aplicativo foi\n" +
                "temporariamente bloqueado.\n" +
                "Te ajudamos a desbloquear através da nossa\n" +
                "Central de Atendimento.\n" +
                "\n" +
                "Ligue para (11) 3888-2200 ou chame-nos no WhatsApp. SOLICITAR ATENDIMENTO VIA WHATSAPP \"])[1]")));
    }

    public void buscarMensagemContaBloqueada() {
        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("Para sua segurança o acesso ao Aplicativo foi bloqueado temporariamente.")));
        this.textoModalContaBloqueada = (MobileElement) this.driver.findElementByAccessibilityId("Para sua segurança o acesso ao Aplicativo foi bloqueado temporariamente.");
    }

    public void arrastarModalContaBloqueadaBaixo() {
        this.buscarMensagemContaBloqueada();
        Dimension tamanhoTela = this.driver.manage().window().getSize();
        int alturaTela = tamanhoTela.getHeight();
        int alturaModal = alturaTela * 2 / 3;
        int larguraModal = tamanhoTela.getWidth() / 2;
        this.driver.executeScript("mobile: flingGesture", new Object[]{ImmutableMap.of("elementId", this.textoModalContaBloqueada.getId(), "percentage", 100, "direction", "down", "speed", 500)});
    }

    public void buscarBotaoFecharModalCPFSenha() {
        WebDriverWait espera = new WebDriverWait(driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Ícone times-circle Erro CPF e/ou senha inválidos. Fechar\"])[4]")));
        botaoFecharModalErroCPFSenha = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Ícone times-circle Erro CPF e/ou senha inválidos. Fechar\"])[4]");
    }

    public void clicarBotaoFecharModalCPFSenha() {
        System.out.println("click fechar modal");
        botaoFecharModalErroCPFSenha.click();
    }

    public void clicarBotaoAtendimentoWhatsApp() throws InterruptedException {
        Thread.sleep(2000);
        GestosEmulador.clickCoordenada(190,771);
//        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
//        espera.until(ExpectedConditions.elementToBeClickable(By.id("botao_modal_bloqueio")));
//        this.botaoAtendimentoViaWhatsApp = (MobileElement) this.driver.findElementByAccessibilityId("botao_modal_bloqueio");
//        this.botaoAtendimentoViaWhatsApp.click();
    }

    public void clicarCentralDeAjuda() {
        this.centralDeAjuda = (MobileElement) this.driver.findElementByAccessibilityId("Central de Ajuda");
        this.centralDeAjuda.click();
    }

    public void clicarCriarConta() {
        this.criarConta.click();
    }

    public void clicarEnviarMensagem() {
        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"ENVIAR MENSAGEM PORTAL DE NEGOCIAÇÃO\"])[2]")));
//        this.enviarMensagem = (MobileElement) this.driver.findElementByAccessibilityId("Abrir suporte via WhatsApp");
//        this.enviarMensagem.click();
        GestosEmulador.clickCoordenada(190,717);
    }

    public void verificarRedirecionamentoWhatsapp() {
        WebDriverWait espera = new WebDriverWait(this.driver, 15L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("TabBarItemTitle")));
        MobileElement elemento = (MobileElement) this.driver.findElementByAccessibilityId("TabBarItemTitle");
        System.out.println(elemento.getText());
        if (!elemento.getText().contains("api.whatsapp.com")) {
            throw new AssertionError("A url não é do whatsapp");
        }
    }

    public void limparCamposLogin() {
        if (!this.campoUsuario.getText().equals("***.***.***-**")) {
            this.campoUsuario.clear();
            this.campoSenha.clear();
        }

    }

    public MobileElement getCampoUsuario() {
        return this.campoUsuario;
    }

    public void setCampoUsuario(MobileElement campoUsuario) {
        this.campoUsuario = campoUsuario;
    }

    public MobileElement getCampoSenha() {
        return this.campoSenha;
    }

    public void setCampoSenha(MobileElement campoSenha) {
        this.campoSenha = campoSenha;
    }

    public MobileElement getBotaoLogin() {
        return this.botaoLogin;
    }

    public void setBotaoLogin(MobileElement botaoLogin) {
        this.botaoLogin = botaoLogin;
    }

    public MobileElement getModalErro() {
        return this.modalErro;
    }

    public void setModalErro(MobileElement modalErro) {
        this.modalErro = modalErro;
    }

    public MobileElement getTextoModalContaBloqueada() {
        return this.textoModalContaBloqueada;
    }
}
