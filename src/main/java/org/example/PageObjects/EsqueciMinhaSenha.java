package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
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
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Digite o seu cpf para recuperar a senha\"]")));

        inputCPFUsuario = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Digite o seu cpf para recuperar a senha\"]");
        botaoConfirmar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para confirmar o cpf\"]/android.view.ViewGroup");
        botaoCancelar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para cancelar a recuperação de senha\"]");

    }

    public void preencherInputCpf(String cpf) {
        inputCPFUsuario.sendKeys(cpf);
    }

    public void preencherInputSuaSenha(String senhaNova) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Campo para digitar nova senha\"]\n")));

        inputSuaSenha = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo para digitar nova senha\"]");

        inputSuaSenha.sendKeys(senhaNova);
    }

    public void preencherInputConfirmarSenha(String confirmarSenha) {
        inputConfirmarSenha = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo para digitar confirmação de senha\"]");
        inputConfirmarSenha.sendKeys(confirmarSenha);
    }

    public void clicarBotaoConfirmar() {
        botaoConfirmar.click();
    }

    public void clicarBotaoConfirmarSms() {
        driver.hideKeyboard();
        botaoConfirmarSms = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão Confirmar código do Sms\"]/android.view.ViewGroup\n");
        botaoConfirmarSms.click();

    }

    public void clicarBotaoConfirmarEmail() {
        driver.hideKeyboard();
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão Confirmar código do Email\"]/android.view.ViewGroup\n")));
            botaoConfirmarEmail = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão Confirmar código do Email\"]/android.view.ViewGroup\n");
            botaoConfirmarEmail.click();
    }

    public void clicarBotaoConfirmarRedefinirSenha() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para confirmar a nova senha\"]/android.view.ViewGroup\n")));

        botaoConfirmarRedefinirSenha = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para confirmar a nova senha\"]/android.view.ViewGroup\n");
        botaoConfirmarRedefinirSenha.click();
    }

    public void clicarBotaoCancelar() {
        botaoCancelar.click();
    }

    public void buscarMensagemContaBloqueada() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Para sua segurança o acesso ao Aplicativo foi\n" +
                "temporariamente bloqueado.\n" +
                "Te ajudamos a desbloquear através da nossa\n" +
                "Central de Atendimento.\n" +
                "\n" +
                "Ligue para (11) 3888-2200 ou chame-nos no WhatsApp.\"]")));

        textoModalContaBloqueada = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Para sua segurança o acesso ao Aplicativo foi\n" +
                "temporariamente bloqueado.\n" +
                "Te ajudamos a desbloquear através da nossa\n" +
                "Central de Atendimento.\n" +
                "\n" +
                "Ligue para (11) 3888-2200 ou chame-nos no WhatsApp.\"]");
    }

    public void buscarMensagemCPFInvalido() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Digite o seu cpf para recuperar a senha\"]")));

        msgCPFInvalido = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Digite o seu cpf para recuperar a senha\"]");

    }

    public void buscarInput0Sms() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")));

        input0 = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");

    }

    public void buscarInput0Email() {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")));

        input0 = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]\n");
    }

    public void clicarInput0() {
        input0.click();
    }

    public void inserirInputs(String input0) {
        driver.getKeyboard().sendKeys(input0);
    }

    public void buscarModalErroSms() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"O código enviado é invalido.\"]\n")));

        modalErroToken = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"O código enviado é invalido.\"]\n");

        botaoConfirmarModalErroToken = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Confirmar \"]\n");
        botaoConfirmarModalErroToken.click();
    }

    public void novaSenhaTesteCriterioDeAceite() throws InterruptedException {

        clicarBotaoConfirmarRedefinirSenha();

        visualizarNovaSenha = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@text=\"\uE91C\"])[1]");
        visualizarConfirmarNovaSenha = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@text=\"\uE91C\"])[2]");

        Thread.sleep(500);

        mensagemErroCampoNovaSenha = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Campo para digitar nova senha\"]");
        mensagemErroCampoRepetirNovaSenha = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Campo para digitar confirmação de senha\"]");

        Assert.state(mensagemErroCampoNovaSenha.getText().equals("Campo obrigatório"), "Mensagem de erro incorreta era pra ser Campo obrigatório ");
        Thread.sleep(500);
        Assert.state(mensagemErroCampoRepetirNovaSenha.getText().equals("Campo obrigatório"), "Mensagem de erro incorreta era pra ser Campo obrigatório ");

        visualizarNovaSenha.click();
        visualizarConfirmarNovaSenha.click();

        preencherInputSuaSenha("1");
        Thread.sleep(500);
        Assert.state(mensagemErroCampoNovaSenha.getText().equals("Senha deve conter pelo menos 8 dígitos"), "Mensagem de erro incorreta era pra ser Sua senha deve conter pelo menos 8 dígitos");
        Thread.sleep(500);


        preencherInputSuaSenha("2345678");
        Thread.sleep(500);
        Assert.state(mensagemErroCampoNovaSenha.getText().equals("A senha precisa ter pelo menos 1 caractere maiúsculo, 1 minúsculo e 1 número"), "Mensagem de erro incorreta era pra ser A senha precisa ter pelo menos 1 caractere maiúsculo, 1 minúsculo e 1 número");
        Thread.sleep(500);

        preencherInputSuaSenha("Aa");
        Thread.sleep(500);

        preencherInputConfirmarSenha("1");
        Thread.sleep(500);
        Assert.state(mensagemErroCampoRepetirNovaSenha.getText().equals("As senhas devem ser iguais"), "Mensagem de erro incorreta era pra ser As senhas devem ser iguais");
        Thread.sleep(500);
        preencherInputConfirmarSenha("2345678Aa");

        Thread.sleep(500);
    }

    public MobileElement getMensagemErroCampoNovaSenha() {
        return mensagemErroCampoNovaSenha;
    }

    public MobileElement getMensagemErroCampoRepetirNovaSenha() {
        return mensagemErroCampoRepetirNovaSenha;
    }

    public MobileElement getTextoModalContaBloqueada() {
        return textoModalContaBloqueada;
    }

    public MobileElement getMsgCPFInvalido() {
        return msgCPFInvalido;
    }

}



