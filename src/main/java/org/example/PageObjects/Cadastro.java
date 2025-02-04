package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;


public class Cadastro {


    private AppiumDriver driver;
    private MobileElement inputCpf;
    private MobileElement inputNome;
    private MobileElement dtNasc;
    private MobileElement genero;
    private MobileElement masculino;
    private MobileElement inputEmail;
    private MobileElement inputNEmail;
    private MobileElement inputTelefone;
    private MobileElement botaoContinuar;
    private MobileElement inputSms;
    private MobileElement nomeObrigatorio;
    private MobileElement dtObrigatorio;
    private MobileElement generoObrigatorio;
    private MobileElement emailObrigatorio;
    private MobileElement telefoneObrigatorio;
    private MobileElement botaoConfirmarCadastroSenha;
    private MobileElement botaoTermos;
    private MobileElement botaoContinuarTermos;
    private MobileElement botaoPrivacidade;
    private MobileElement botaoContinuarPrivacidade;
    private MobileElement modalCadastrado;
    private MobileElement botaoIrParaLogin;
    private MobileElement botaoIrParaLoginModalJaCadastrado;
    private MobileElement cpfInvalido;
    private MobileElement modalErroSms;
    private MobileElement botaoReverCodigo;
    private MobileElement reenviarCodigo;
    private MobileElement editarCelular;
    private MobileElement editarEmail;
    private MobileElement inputAlterarNumero;
    private MobileElement inputAlterarEmail;
    private MobileElement msgValidacaoInputAlteraNumero;
    private MobileElement msgValidacaoInputAlteraEmail;
    private MobileElement botaoConfirmarAlterarNumero;
    private MobileElement botaoConfirmarAlterarEmail;
    private MobileElement textoComNumeroAlterado;
    private MobileElement textoComEmailAlterado;
    private MobileElement inputSuaSenha;
    private MobileElement inputConfirmarSenha;
    private MobileElement visualizarNovaSenha;
    private MobileElement visualizarConfirmarNovaSenha;
    private MobileElement minimoDeOito1;
    private MobileElement umaMaiuscula2;
    private MobileElement umaMinuscula3;
    private MobileElement minimoUmNumero4;


    public Cadastro(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("cpf_register_input")));

        inputCpf = (MobileElement) driver.findElementByAccessibilityId("cpf_register_input");
        inputNome = (MobileElement) driver.findElementByAccessibilityId("name_register_input");
        dtNasc = (MobileElement) driver.findElementByAccessibilityId("birth_day_register_input");
        genero = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"\uE959 Sexo Campo para informar o gênero icon_Campo para informar o gênero\"]");
        inputEmail = (MobileElement) driver.findElementByAccessibilityId("email_register_input");
        inputTelefone = (MobileElement) driver.findElementByAccessibilityId("phone_register_input");
        botaoContinuar = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Botão para próximo passo do cadastro\"])[2]");
    }

    public void preencherCpf(String cpf) throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("cpf_register_input")));
        for (char c : cpf.toCharArray()) {
            inputCpf.sendKeys(String.valueOf(c));
            Thread.sleep(10);
        }
        inputCpf.sendKeys(Keys.RETURN);

    }

    public void preencherCpf() throws Exception {
        String cpf = fakeCpf();
        for (char c : cpf.toCharArray()) {
            inputCpf.sendKeys(String.valueOf(c));
            Thread.sleep(10);
        }
        inputCpf.sendKeys(Keys.RETURN);

    }

    public void preencherNome() {
        inputNome.sendKeys("Teste Cadastro");
        inputNome.sendKeys(Keys.RETURN);

    }

    public void preencherDataNascimento(String dataNascimento) throws InterruptedException {
        for (char c : dataNascimento.toCharArray()) {
            dtNasc.sendKeys(String.valueOf(c));
            Thread.sleep(10); // Atraso de 100ms entre cada caractere
        }
        dtNasc.sendKeys(Keys.RETURN);
    }

    public void preencherDataNascimentoPadrao() throws InterruptedException {
        String data = "24052005";
        for (char c : data.toCharArray()) {
            dtNasc.sendKeys(String.valueOf(c));
            Thread.sleep(10); // Atraso de 100ms entre cada caractere
        }
        dtNasc.sendKeys(Keys.RETURN);

    }

    public void escolherGenero() {
        genero.click();
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Masculino\"])[2]")));
        masculino = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Masculino\"])[2]");
        masculino.click();
    }

    public void preencherEmail(String email) throws InterruptedException {
        for (char c : email.toCharArray()) {
            inputEmail.sendKeys(String.valueOf(c));
            Thread.sleep(10); // Atraso de 100ms entre cada caractere
        }
        inputEmail.sendKeys(Keys.RETURN);
    }

    public void preencherEmailPadrao() throws InterruptedException {
        String email = "testecav8@gmail.com";
        for (char c : email.toCharArray()) {
            inputEmail.sendKeys(String.valueOf(c));
            Thread.sleep(10); // Atraso de 100ms entre cada caractere
        }
        inputEmail.sendKeys(Keys.RETURN);
    }

    public void preencherTelefone(String telefone) throws InterruptedException {
        for (char c : telefone.toCharArray()) {
            inputTelefone.sendKeys(String.valueOf(c));
            Thread.sleep(10); // Atraso de 100ms entre cada caractere
        }
        inputTelefone.sendKeys(Keys.RETURN);

    }

    public void limparTelefone() {
        inputTelefone.clear();
    }

    public void preencherTelefonePadrao() throws InterruptedException {
        String telefone = "11922334456";
        for (char c : telefone.toCharArray()) {
            inputTelefone.sendKeys(String.valueOf(c));
            Thread.sleep(10); // Atraso de 100ms entre cada caractere
        }
        inputTelefone.sendKeys(Keys.RETURN);
    }

    public void clicarBotaoContinuar() {
        botaoContinuar.click();
    }

    public void mensagemCpfInválido() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"error_cpf_register_input\"]")));
        cpfInvalido = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"error_cpf_register_input\"]");
        cpfInvalido.getText().equals("CPF inválido");
    }

    public void mensagemEmailInvalido() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement emailObrigatorio = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"error_email_register_input\"]")));
        String mensagemErro = emailObrigatorio.getText();
        if (mensagemErro.equalsIgnoreCase("Email inválido")) {
            System.out.println("A mensagem de erro está correta.");
        } else {
            System.out.println("A mensagem de erro está incorreta. Mensagem encontrada: " + mensagemErro);
        }
    }

    public void dtNascInvalida() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement dtNascInvalida = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"error_birth_day_register_input\"]")));
        String mensagemErro = dtNascInvalida.getText();

        if (mensagemErro.equalsIgnoreCase("Não é possível cadastrar menores de idade")) {
            System.out.println("A mensagem de erro está correta.");
        } else {
            System.out.println("A mensagem de erro está incorreta. Mensagem encontrada: " + mensagemErro);
        }
    }

    public void mensagemTelefoneInvalido() {
        WebDriverWait espera = new WebDriverWait(driver, 10);

        MobileElement telefone = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"error_phone_register_input\"]")));
        String mensagemErro = telefone.getText();
        if (mensagemErro.equalsIgnoreCase("Telefone inválido")) {
            System.out.println("A mensagem de erro está correta.");
        } else {
            System.out.println("A mensagem de erro está incorreta. Mensagem encontrada: " + mensagemErro);
        }
    }


    public void aceitarTermos() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Aceitar termos de uso\"]")));
        botaoTermos = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Aceitar termos de uso\"]");
        botaoTermos.click();
        Thread.sleep(500);
        botaoContinuarTermos = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"accept_button\"]");
        botaoContinuarTermos.click();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Aceitar política de privacidade\"]")));
        botaoPrivacidade = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Aceitar política de privacidade\"]");
        botaoPrivacidade.click();
        Thread.sleep(500);
        botaoContinuarPrivacidade = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"accept_button\"]");
        botaoContinuarPrivacidade.click();
    }

    public void visualizarModalCadastrado() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Seja muito bem-vindo ao TOP! Agora basta entrar com seu CPF e senha\n" +
                "cadastrados para começar a usar o App. Cadastro realizado, entrar no aplicativo\"])[4]")));

        //        modalCadastrado = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup");
        botaoIrParaLogin = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Seja muito bem-vindo ao TOP! Agora basta entrar com seu CPF e senha\n" +
                "cadastrados para começar a usar o App. Cadastro realizado, entrar no aplicativo\"])[4]");
        botaoIrParaLogin.click();
    }


    public void buscarMensagensErroObrigatoria() {
        System.out.println("buscando msg erro");
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"error_name_register_input\"]")));

        nomeObrigatorio = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"error_name_register_input\"]");
        dtObrigatorio = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"error_birth_day_register_input\"]");
        generoObrigatorio = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"\uE959 Sexo Campo para informar o gênero icon_Campo para informar o gênero Erro Campo para informar o gênero\"]");
        emailObrigatorio = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"error_email_register_input\"]");
        telefoneObrigatorio = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"error_phone_register_input\"]");

    }

    public void buscarModalCpfJaCadastrado() {
        WebDriverWait espera = new WebDriverWait(driver, 5);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Vimos que você já tem cadastro no App Para fazer o login, utilize seu CPF e senha\n" +
                "cadastrados. Caso não lembre a senha, toque\n" +
                "em “Esqueci minha senha” na tela inicial. Botão ir para a tela de login\"])[1]")));
        botaoIrParaLoginModalJaCadastrado = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Vimos que você já tem cadastro no App Para fazer o login, utilize seu CPF e senha\n" +
                "cadastrados. Caso não lembre a senha, toque\n" +
                "em “Esqueci minha senha” na tela inicial. Botão ir para a tela de login\"])[1]");
        botaoIrParaLoginModalJaCadastrado.click();
    }

    private static String fakeCpf() throws Exception {
        String url = "https://www.4devs.com.br/ferramentas_online.php";
        HttpResponse<String> response = Unirest.post(url)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("acao", "gerar_cpf")
                .field("sexo", "I")
                .field("pontuacao", "N")
                .field("idade", "20")
                .field("cep_estado", "SP")
                .field("txt_qtde", "1")
                .field("cep_cidade", "9668")
                .asString();

        if (response.getStatus() == 200) {
            return response.getBody();
        } else {
            throw new RuntimeException("Erro ao gerar CPF: " + response.getStatusText());
        }
    }

    public void buscarModalErroSms() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Opa! O código informado é inválido. Botão rever código\"])[5]")));
        modalErroSms = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Opa! O código informado é inválido. Botão rever código\"])[5]");

        botaoReverCodigo = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Opa! O código informado é inválido. Botão rever código\"])[5]");
        botaoReverCodigo.click();
    }

    public void esperarReenviarCodigo(String xpath) {
        WebDriverWait esperarAparecer = new WebDriverWait(driver, 60);
        esperarAparecer.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

        reenviarCodigo = (MobileElement) driver.findElementByXPath(xpath);
        reenviarCodigo.click();
    }


    public static void main(String[] args) throws Exception {
        System.out.println(fakeCpf());
    }

    public void clicarEditarNumeroCelular() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Editar meu número de celular\"]")));
        editarCelular = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Editar meu número de celular\"]");
        editarCelular.click();
    }

    public void alterarNumero() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Campo para alterar telefone de cadastro\"]")));

        inputAlterarNumero = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo para alterar telefone de cadastro\"]");
        inputAlterarNumero.sendKeys("1193392346");

        confirmarAlterarNumero();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para alterar telefone de cadastro\"]")));
//        msgValidacaoInputAlteraNumero = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Campo para alterar telefone de cadastro\"]");

        inputAlterarNumero.clear();
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para alterar telefone de cadastro\"]")));

        inputAlterarNumero.sendKeys("1412345678914");

        confirmarAlterarNumero();
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para alterar telefone de cadastro\"]")));

        inputAlterarNumero.clear();
        inputAlterarNumero.sendKeys("14996237865");

        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para alterar telefone de cadastro\"]")));
    }

    public void confirmarAlterarNumero() {
        botaoConfirmarAlterarNumero = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão ir para a tela de login\"]/android.view.ViewGroup");
        botaoConfirmarAlterarNumero.click();
    }

    public void confirmarAlterarEmail() {
        botaoConfirmarAlterarEmail = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão editar e-mail\"]/android.view.ViewGroup");
        botaoConfirmarAlterarEmail.click();
    }

    public void buscarTextoComNumeroAlterado() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Enviamos um código de 6 dígitos via SMS para o número: (11) *****-4456\"]")));
        textoComNumeroAlterado = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Enviamos um código de 6 dígitos via SMS para o número: (11) *****-4456\"]");
    }

    public void clicarEditarEmail() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Editar meu endereço de e-mail\"]")));
        editarEmail = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Editar meu endereço de e-mail\"]");
        editarEmail.click();
    }

    public void alterarEmail() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Campo para alterar email de cadastro\"]")));

        inputAlterarEmail = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo para alterar email de cadastro\"]");
        inputAlterarEmail.sendKeys("emailSemArroba.com");
        confirmarAlterarEmail();
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para alterar email de cadastro\"]")));

        inputAlterarEmail.clear();
        confirmarAlterarEmail();
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para alterar email de cadastro\"]")));

//        inputAlterarEmail.sendKeys("exemplo.de.email.com.um.tamanho.bem.especifico.com.noventa.e.noveeeeexemplo.de.email.com.um.tamanho.bem.especifico.com.noventa.e.nove.caracteres@exemplo.com.br\nexemplo.de.email.com.um.tamanho.bem.especifico.com.noventa.e.nove.caracteres@exemplo.com.br\nexemplo.de.email.com.um.tamanho.bem.especifico.com.noventa.e.nove.caracteres@exemplo.com.br\nexemplo.de.email.com.um.tamanho.bem.especifico.com.noventa.e.nove.caracteres@exemplo.com.br\nexemplo.de.email.com.um.tamanho.bem.especifico.com.noventa.e.nove.caracteres@exemplo.com.br\nexemplo.de.email.com.um.tamanho.bem.especifico.com.noventa.e.nove.caracteres@exemplo.com.br\nexemplo.de.email.com.um.tamanho.bem.especifico.com.noventa.e.nove.caracteres@exemplo.com.br\n.caracteres@exemplo.com.br");
//        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para alterar email de cadastro\"]")));
//        inputAlterarEmail.clear();

        inputAlterarEmail.sendKeys("testecav8@gmail.com");

        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para alterar email de cadastro\"]")));
    }

    public void buscarTextoComEmailAlterado() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Um e-mail com um código de 6 dígitos acaba de ser enviado para: testecav8@gmail.com\"]")));

        textoComEmailAlterado = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Um e-mail com um código de 6 dígitos acaba de ser enviado para: testecav8@gmail.com\"]");
    }

    public void preencherInputSuaSenha(String senhaNova) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeSecureTextField[@name=\"password_register_input\"]")));

        inputSuaSenha = (MobileElement) driver.findElementByXPath("//XCUIElementTypeSecureTextField[@name=\"password_register_input\"]");

        inputSuaSenha.sendKeys(senhaNova);
    }

    public void preencherInputConfirmarSenha(String confirmarSenha) {
        inputConfirmarSenha = (MobileElement) driver.findElementByXPath("//XCUIElementTypeSecureTextField[@name=\"password_confirmation_register_input\"]");
        inputConfirmarSenha.sendKeys(confirmarSenha);
    }

    public void cadastrarSenhaTesteCriterioDeAceite() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeSecureTextField[@name=\"password_confirmation_register_input\"]")));

//        visualizarNovaSenha = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"\uE91C\"])[1]");
//        visualizarConfirmarNovaSenha = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"\uE91C\"])[2]");
//        visualizarNovaSenha.click();
//        visualizarConfirmarNovaSenha.click();

        preencherInputSuaSenha("MenosD8");
        preencherInputConfirmarSenha("MenosD8");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[1]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[2]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[3]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"No mínimo 8 caracteres;\"]/XCUIElementTypeOther")));

        System.out.println("MenosD8 OK");

        clicarBotaoConfirmarCadastroSenha();
        inputSuaSenha.clear();
        inputConfirmarSenha.clear();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[1]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[2]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[3]")));

        preencherInputSuaSenha("sem1maiuscula");
        preencherInputConfirmarSenha("sem1maiuscula");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[1]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[2]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[3]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Ao menos 1 letra maiúscula;\"]/XCUIElementTypeOther")));

        System.out.println("sem1maiuscula possui 3 checks");
        clicarBotaoConfirmarCadastroSenha();
        inputSuaSenha.clear();
        inputConfirmarSenha.clear();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[1]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[2]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[3]")));

        preencherInputSuaSenha("SEM1MINUSCULA");
        preencherInputConfirmarSenha("SEM1MINUSCULA");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[1]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[2]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[3]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Ao menos 1 letra minúscula;\"]/XCUIElementTypeOther")));

        System.out.println("SEM1MINUSCULA possui 3 checks");
        clicarBotaoConfirmarCadastroSenha();
        inputSuaSenha.clear();
        inputConfirmarSenha.clear();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[1]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[2]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[3]")));

        preencherInputSuaSenha("SemNumero");
        preencherInputConfirmarSenha("SemNumero");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[1]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[2]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[3]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Ao menos 1 número;\"]/XCUIElementTypeOther")));

        System.out.println("SemNumero possui 3 checks");
        clicarBotaoConfirmarCadastroSenha();
        inputSuaSenha.clear();
        inputConfirmarSenha.clear();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[1]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[2]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[3]")));

        preencherInputSuaSenha("SenhasDivergentes1");
        preencherInputConfirmarSenha("SenhaDivergentes1234");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[1]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[2]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[3]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[4]")));
        System.out.println("SenhasDivergentes1 possui 3 checks");
        clicarBotaoConfirmarCadastroSenha();
        inputSuaSenha.clear();
        inputConfirmarSenha.clear();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[1]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[2]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[3]")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"\uE834\"])[4]")));
    }

    public void clicarBotaoConfirmarCadastroSenha() throws InterruptedException {
        botaoConfirmarCadastroSenha = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"confirm_button\"]");
        botaoConfirmarCadastroSenha.click();
    }

    public void buscarInput0sms() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 50);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Editar meu número de celular\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]")));
        inputSms = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Editar meu número de celular\"])[1]");

    }

    public void buscarInput0email() {
        System.out.println("bucando elemento da input");
         WebDriverWait webDriverWait = new WebDriverWait(driver, 50);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Editar meu endereço de e-mail\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]")));
        inputNEmail = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Editar meu endereço de e-mail\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]");
        inputNEmail.click();
    }

    public void inserirInputSms(String number) {
        inputSms.sendKeys(number);
        inputSms.sendKeys(Keys.RETURN);
    }
    public void inserirInputEmail(String number) {
        inputNEmail.sendKeys(number);
        inputNEmail.sendKeys(Keys.RETURN);
    }

}

