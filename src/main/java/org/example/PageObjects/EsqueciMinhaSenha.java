//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

public class EsqueciMinhaSenha {
    private AppiumDriver driver;
    private MobileElement textoModalContaBloqueada;
    private MobileElement inputCPFUsuario;
    private MobileElement inputSuaSenha;
    private MobileElement inputConfirmarSenha;
    private MobileElement botaoConfirmar;
    private MobileElement botaoConfirmarSms;
    private MobileElement botaoConfirmarEmail;
    private MobileElement botaoConfirmarRedefinirSenha;
    private MobileElement msgCPFInvalido;
    private MobileElement botaoCancelar;
    private MobileElement input0;
    private MobileElement modalErroToken;
    private MobileElement botaoConfirmarModalErroToken;
    private MobileElement mensagemErroCampoNovaSenha;
    private MobileElement mensagemErroCampoRepetirNovaSenha;
    private MobileElement visualizarNovaSenha;
    private MobileElement visualizarConfirmarNovaSenha;

    public EsqueciMinhaSenha(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("cpf_input")));
        this.inputCPFUsuario = (MobileElement)this.driver.findElementByAccessibilityId("cpf_input");
        this.botaoConfirmar = (MobileElement)this.driver.findElementByAccessibilityId("confirm_button_cpf");
        this.botaoCancelar = (MobileElement)this.driver.findElementByAccessibilityId("signin_button_cpf");
    }

    public void preencherInputCpf(String cpf) {
        char[] var2 = cpf.toCharArray();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char digito = var2[var4];
            this.inputCPFUsuario.sendKeys(new CharSequence[]{String.valueOf(digito)});
        }

    }

    public void preencherInputSuaSenha(String senhaNova) {
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, 10L);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password_register_input")));
        inputSuaSenha = (MobileElement)this.driver.findElementByAccessibilityId("password_register_input");
        char[] var2 = senhaNova.toCharArray();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char digito = var2[var4];
            inputSuaSenha.sendKeys(new CharSequence[]{
                    String.valueOf(digito)
            });

        }
        inputSuaSenha.sendKeys(Keys.RETURN);
    }

    public void preencherInputConfirmarSenha(String confirmarSenha) {
        inputConfirmarSenha = (MobileElement)this.driver.findElementByAccessibilityId("password_confirmation_register_input");
        char[] var2 = confirmarSenha.toCharArray();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char digito = var2[var4];
            inputConfirmarSenha.sendKeys(new CharSequence[]{
                    String.valueOf(digito)
            });

        }
        inputConfirmarSenha.sendKeys(Keys.RETURN);
    }

    public void clicarBotaoConfirmar() {
        this.botaoConfirmar.click();
    }

    public void clicarBotaoConfirmarSms() {
        this.botaoConfirmarSms = (MobileElement)this.driver.findElementByAccessibilityId("confirm_button_sms_verification");
        this.botaoConfirmarSms.click();
    }

    public void clicarBotaoConfirmarEmail() {
        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("submit_button_email_verification")));
        this.botaoConfirmarEmail = (MobileElement)this.driver.findElementByAccessibilityId("submit_button_email_verification");
        this.botaoConfirmarEmail.click();
    }

    public void clicarBotaoConfirmarRedefinirSenha() {
        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("confirm_button_reset_password")));
        this.botaoConfirmarRedefinirSenha = (MobileElement)this.driver.findElementByAccessibilityId("confirm_button_reset_password");
        this.botaoConfirmarRedefinirSenha.click();
    }

    public void clicarBotaoCancelar() {
        this.botaoCancelar.click();
    }

    public void buscarMensagemContaBloqueada() {
        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Para sua segurança o acesso ao Aplicativo foi\ntemporariamente bloqueado.\nTe ajudamos a desbloquear através da nossa\nCentral de Atendimento.\n\nLigue para (11) 3888-2200 ou chame-nos no WhatsApp.\"]")));
        this.textoModalContaBloqueada = (MobileElement)this.driver.findElementByXPath("//android.widget.TextView[@text=\"Para sua segurança o acesso ao Aplicativo foi\ntemporariamente bloqueado.\nTe ajudamos a desbloquear através da nossa\nCentral de Atendimento.\n\nLigue para (11) 3888-2200 ou chame-nos no WhatsApp.\"]");
    }

    public void buscarMensagemCPFInvalido() {
        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("error_cpf_input")));
        this.msgCPFInvalido = (MobileElement)this.driver.findElementByAccessibilityId("error_cpf_input");
    }

    public void buscarInput0sms() {
        WebDriverWait espera = new WebDriverWait(driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Insira o código de segurança que enviamos para o ,+5511922****56\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText")));
        input0 = (MobileElement)driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Insira o código de segurança que enviamos para o ,+5511922****56\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
    }

    public void buscarInput0email() {
        WebDriverWait espera = new WebDriverWait(driver, 10L);

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Insira o código de segurança que enviamos para o seu ,testeca*****ail.com\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]")));
        input0 = (MobileElement)driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Insira o código de segurança que enviamos para o seu ,testeca*****ail.com\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]");
    }

    public void clicarInput0() {
        this.input0.click();
    }

    public void inserirInputs(String codigo) {
        System.out.println("inserir o codigo");
        char[] var2 = codigo.toCharArray();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char digito = var2[var4];
            input0.sendKeys(new CharSequence[]{
                    String.valueOf(digito)
            });
        }

    }


    public void buscarModalErroSms() {
        WebDriverWait espera = new WebDriverWait(this.driver, 10L);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Ícone times-circle Erro O código enviado é invalido. Confirmar \"])[1]")));
        this.modalErroToken = (MobileElement)this.driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Ícone times-circle Erro O código enviado é invalido. Confirmar \"])[1]");
        this.modalErroToken.click();
    }

    public void novaSenhaTesteCriterioDeAceite() throws InterruptedException {
        clicarBotaoConfirmarRedefinirSenha();
//
//        visualizarNovaSenha = (MobileElement) driver.findElementByXPath("(/(//XCUIElementTypeStaticText[@name=\"\ue91c\"])[1]");
//        visualizarConfirmarNovaSenha = (MobileElement) driver.findElementByXPath("(/(//XCUIElementTypeStaticText[@name=\"\ue91c\"])[2]");
        Thread.sleep(500L);
        mensagemErroCampoNovaSenha = (MobileElement) driver.findElementByAccessibilityId("error_password_register_input");
        mensagemErroCampoRepetirNovaSenha = (MobileElement) driver.findElementByAccessibilityId("error_password_confirmation_register_input");
//        Assert.state(mensagemErroCampoNovaSenha.getText().equals("Campo obrigatório"), "Mensagem de erro incorreta era pra ser Campo obrigatório ");
        Thread.sleep(500L);
        mensagemErroCampoNovaSenha.click();
        mensagemErroCampoRepetirNovaSenha.click();
//        Assert.state(mensagemErroCampoRepetirNovaSenha.getText().equals("Campo obrigatório"), "Mensagem de erro incorreta era pra ser Campo obrigatório ");
        preencherInputSuaSenha("1");
        Thread.sleep(500L);
        mensagemErroCampoNovaSenha.click();
//        Assert.state(mensagemErroCampoNovaSenha.getText().equals("Senha deve conter pelo menos 8 dígitos"), "Mensagem de erro incorreta era pra ser Sua senha deve conter pelo menos 8 dígitos");
        Thread.sleep(500L);
        preencherInputSuaSenha("12345678");
        Thread.sleep(500L);
        mensagemErroCampoNovaSenha.click();
//        Assert.state(mensagemErroCampoNovaSenha.getText().equals("A senha precisa ter pelo menos 1 caractere maiúsculo, 1 minúsculo e 1 número"), "Mensagem de erro incorreta era pra ser A senha precisa ter pelo menos 1 caractere maiúsculo, 1 minúsculo e 1 número");
        Thread.sleep(500L);
        preencherInputSuaSenha("12345678Aa");
        Thread.sleep(500L);
        preencherInputConfirmarSenha("1");
        Thread.sleep(500L);
        mensagemErroCampoRepetirNovaSenha.click();
//        Assert.state(mensagemErroCampoRepetirNovaSenha.getText().equals("As senhas devem ser iguais"), "Mensagem de erro incorreta era pra ser As senhas devem ser iguais");
        Thread.sleep(500L);
        preencherInputConfirmarSenha("12345678Aa");
        Thread.sleep(500L);

    }


    public MobileElement getMensagemErroCampoNovaSenha() {
        return this.mensagemErroCampoNovaSenha;
    }

    public MobileElement getMensagemErroCampoRepetirNovaSenha() {
        return this.mensagemErroCampoRepetirNovaSenha;
    }

    public MobileElement getTextoModalContaBloqueada() {
        return this.textoModalContaBloqueada;
    }

    public MobileElement getMsgCPFInvalido() {
        return this.msgCPFInvalido;
    }
}
