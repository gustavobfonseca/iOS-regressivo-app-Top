package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.pt.*;
import org.example.PageObjects.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import sun.jvm.hotspot.utilities.AssertionFailure;

import java.io.File;
import java.io.IOException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DefinicaoPassosCucumber {

    @Dado("que estou na área não logada do app")
    public void anExampleScenario() throws InterruptedException {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
    }

    @Quando("submeto minhas credenciais inválidas para login")
    public void allStepDefinitionsAreImplemented() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("32772147886", "SenhaIncorreta");
        MobileElement tela = (MobileElement) driver.findElementByAccessibilityId("Que bom ter você aqui! Confirme seus dados para continuar. \uEA38 CPF Espaço para digitar o cpf  icon_Espaço para digitar o cpf  \uE985 SENHA Espaço para digitar senha \uE91C Esqueci minha senha. env Botão para acessar o aplicativo É novo por aqui?  Crie uma conta.");
        tela.click();
        telaLogin.logar();
    }

    @Entao("visualizo o modal de CPF e, ou Senha inválidos")
    public void theScenarioPasses() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarModalErro();
//        telaLogin.buscarBotaoFecharModalCPFSenha();
//        telaLogin.clicarBotaoFecharModalCPFSenha();
//        telaLogin.buscarElementos();
//        telaLogin.limparCamposLogin();
    }

    @Quando("submeto minhas credenciais válidas para login, cpf {string} e senha {string}")
    public void submetoMinhasCredenciaisVálidasParaLogin(String cpf, String senha) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario(cpf, senha);
        MobileElement tela = (MobileElement) driver.findElementByAccessibilityId("Que bom ter você aqui! Confirme seus dados para continuar. \uEA38 CPF Espaço para digitar o cpf  icon_Espaço para digitar o cpf  \uE985 SENHA Espaço para digitar senha \uE91C Esqueci minha senha. env Botão para acessar o aplicativo É novo por aqui?  Crie uma conta.");
        tela.click();
        telaLogin.logar();
    }


    @Entao("acesso a home do aplicativo")
    public void acessoAHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Home telaHome = new Home(driver);

//        Thread.sleep(3000);
//        telaHome.esperarBotaoBiometria();
//        telaHome.clicarBotaoAtivarBiometria();
//        try {
//            telaHome.arrastarModalParaBaixo();
//        } catch (Exception e) {
////            telaHome.clicarBotaoModalQueroConhecer();
//            throw new RuntimeException("nao arrastou o modal para baixo");
//        }
        telaHome.buscarMensagemBemVindo();
    }

    @Entao("acesso a tela home do aplicativo")
    public void acessoATelaHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
//        telaHome.clicarBotaoModalQueroConhecer();
    }

    @Entao("visualizo o modal de codigo invalido")
    public void visualizarModalErroCodigoSms() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        EsqueciMinhaSenha esqueciMinhaSenha = new EsqueciMinhaSenha(driver);


        esqueciMinhaSenha.buscarModalErroSms();
    }


    //    @After
    public void after(Scenario scenario) throws IOException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        // Pega o caminho do arquivo da feature
        String nomeFeature = scenario.getUri().getPath();
//        System.out.println(nomeFeature);

        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "image1");
            System.out.println("\n alguns cenários precisam que o driver seja inicializado com 'appium --allow-insecure=adb_shell'\n");
        }

        if (nomeFeature.toLowerCase().contains("login")) {
//            System.out.println("É cenário da feature de login");
            try {
//                Celular.limparCache(driver);
                Celular.resetApp(driver);
            } catch (Exception e) {
                System.out.println("Tentando resetar o app novamente, feature de login");
//                Celular.limparCache(driver);
                Celular.resetApp(driver);
            }
        } else {
            try {
                Celular.resetApp(driver);
            } catch (Exception e) {
                System.out.println("Tentando resetar o app novamente");
                Celular.resetApp(driver);
            }
        }
    }

    @Quando("submeto minhas credenciais bloqueadas para login")
    public void submetoMinhasCredenciaisBloqueadasParaLogin() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);


        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("73040542559", "Teste123");
        MobileElement tela = (MobileElement) driver.findElementByAccessibilityId("Que bom ter você aqui! Confirme seus dados para continuar. \uEA38 CPF Espaço para digitar o cpf  icon_Espaço para digitar o cpf  \uE985 SENHA Espaço para digitar senha \uE91C Esqueci minha senha. env Botão para acessar o aplicativo É novo por aqui?  Crie uma conta.");
        tela.click();
        telaLogin.logar();
    }


    @Entao("visualizo o modal de usuário bloqueado")
    public void visualizoOModalDeUsuárioBloqueado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarModalContaBloqueada();
    }

    @Entao("sou direcionado para o WhatsApp da Central de atendimento Autopass")
    public void verificarRedirecionamentoWhatsapp() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.verificarRedirecionamentoWhatsapp();
    }

    @Entao("visualizo o modal de \"CPF já cadastrado\".")
    public void modalCpfJaCadastrado() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarModalCpfJaCadastrado();
    }

    @E("clico no botão 'Atendimento via Whatsapp' no modal")
    public void clicarBotaoAtendimentoWhatsApp() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.clicarBotaoAtendimentoWhatsApp();
    }

    @Dado("que acesso a opção esqueci minha senha na área não logada")
    public void queAcessoAOpçãoEsqueciMinhaSenhaNaÁreaNãoLogada() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.clicarEsqueciMinhaSenha();
    }

    @Quando("informo um CPF bloqueado")
    public void informoUmCPFBloqueado() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciSenha.buscarElementos();

        telaEsqueciSenha.preencherInputCpf("73040542559");
        MobileElement tela =(MobileElement) driver.findElementByAccessibilityId("Nova Senha");
        tela.click();
        telaEsqueciSenha.clicarBotaoConfirmar();
    }

    @Quando("clico na opção \"Central de Ajuda\"")
    public void clicoCentralDeAjuda() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login login = new Login(driver);
        login.clicarCentralDeAjuda();
    }

    @E("clico no botão \"Enviar mensagem\"")
    public void enviarMensagem() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login login = new Login(driver);

        login.clicarEnviarMensagem();
    }

    @E("clico em \"Continuar\" com os demais campos preenchidos corretamente, menos o e-mail")
    public void continuarComEmailSemArroba() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherNome();
        cadastro.preencherDataNascimentoPadrao();
        cadastro.escolherGenero();
        Thread.sleep(2000);
        cadastro.preencherTelefonePadrao();
        cadastro.clicarBotaoContinuar();
    }

    @E("clico em \"Continuar\" com os demais campos preenchidos corretamente, menos o celular")
    public void continuarComCelularSemDDD() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherNome();
        cadastro.preencherDataNascimentoPadrao();
        cadastro.escolherGenero();
        Thread.sleep(2000);
        cadastro.preencherEmailPadrao();
        cadastro.clicarBotaoContinuar();
    }

    @E("clico em \"Continuar\" com os demais campos preenchidos dentro dos critérios de aceite, menos a data de nascimento")
    public void continuarComIdadeMenorQue13() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherNome();
        cadastro.escolherGenero();
        Thread.sleep(2000);
        cadastro.preencherEmailPadrao();
        cadastro.preencherTelefonePadrao();
        cadastro.clicarBotaoContinuar();
    }

    @E("informo e-mail fora do padrão sem \"@\"")
    public void emailSemArroba() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherEmail("emailSemArroba.com");
    }

    @E("informo a data de nascimento menor que 18 anos")
    public void menorDe13Anos() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

        LocalDate currentDate = LocalDate.now();
        Integer anoAtual = currentDate.getYear();
        Integer anoDeNascimento = anoAtual - 17;
        String dataNascimento = "01/01/" + anoDeNascimento;

        cadastro.buscarElementos();
        cadastro.preencherDataNascimento(dataNascimento);
    }

    @E("informo DDD + celular com menos de 11 dígitos")
    public void celularDDDMenos11Digitos() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherTelefone("1193392346");
    }

    @E("informo DDD + celular inválido sem começar com 9")
    public void celularInvalido() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.limparTelefone();
        cadastro.preencherTelefone("11333923464");
    }

    @Entao("visualizo a mensagem de \"E-mail inválido\" no campo \"E-mail\".")
    public void emailInválido() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.mensagemEmailInvalido();
    }

    @Entao("visualizo a mensagem de \"Não é possível cadastrar menores de idade\" no campo \"Data de nascimento\"")
    public void dtNascMenorDe13() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.dtNascInvalida();
    }

    @Entao("visualizo a mensagem de \"Telefone inválido\" no campo \"Celular\".")
    public void telefoneInvalido() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.mensagemTelefoneInvalido();
    }

    @Entao("visualizo o modal de usuário bloqueado na tela de esqueci minha senha")
    public void visualizoOModalDeUsuárioBloqueadoNaTelaDeEsqueciMinhaSenha() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciSenha.buscarMensagemContaBloqueada();
        assertTrue(telaEsqueciSenha.getTextoModalContaBloqueada().isDisplayed());
    }

    @Quando("informo um CPF inválido")
    public void informoUmCPFInválido() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciminhaSenha.buscarElementos();
        telaEsqueciminhaSenha.preencherInputCpf("12345678910");
        MobileElement tela = (MobileElement) driver.findElementByAccessibilityId("Nova Senha");
        tela.click();
        telaEsqueciminhaSenha.clicarBotaoConfirmar();
    }

    @E("informo um CPF inválido para cadastro")
    public void informoUmCPFInválidoCadastro() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherCpf("12312312377");
    }


    @Entao("visualizo a mensagem de Documento inválido")
    public void visualizoAMensagemDeDocumentoInválido() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciminhaSenha.buscarMensagemCPFInvalido();
        assertTrue(telaEsqueciminhaSenha.getMsgCPFInvalido().isDisplayed());

    }

    @Quando("reseto o app")
    public void resetoOApp() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Celular.resetApp(driver);
    }

    @Dado("que reseto o app")
    public void queResetoOApp() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Celular.resetApp(driver);
    }

    @E("clico em cancelar")
    public void clicoEmCancelar() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.buscarElementos();
        telaEsqueciminhaSenha.clicarBotaoCancelar();
    }

    @E("vou para a minha home do aplicativo")
    public void vouParaAMinhaHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
//        telaHome.clicarBotaoAtivarBiometria();
        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
    }

    @E("redefino a senha")
    public void redefinirSenha() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Home telaHme = new Home(driver);
        telaHme.redefinirSenhaPeloPerfil();
    }

    @E("informo um CPF já cadastrado")
    public void cpfCadastrado() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherCpf("54926406829");

    }

    @Quando("que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado")
    public void queEuAcessoOMenuNaHomeDoAplicativoTendoCartãoDeCréditoCadastrado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home telaHome = new Home(driver);

        //Celular.resetApp(driver);

//        telaHome.buscarBotaoBilhetes();
        telaHome.clicarBotaoBilhetes();
    }

    @Quando("acesso a opção \"Criar uma conta\"")
    public void criarUmaConta() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaHome = new Login(driver);

        telaHome.buscarElementos();
        telaHome.clicarCriarConta();
    }

    @E("clico na opçao Comprar Bilhetes")
    public void clicoNaOpçaoComprarBilhetes() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        Thread.sleep(10000);
//        paginaMeusBilhetes.buscarElementosTentativasMaximas();
//        paginaMeusBilhetes.buscarElementos();
        //paginaMeusBilhetes.clicarFormasDePgto();
        paginaMeusBilhetes.clicarBotaoComprarBilhetes();
    }

    @E("clico na opçao Comprar Bilhetes estando offline")
    public void clicoNaOpçaoComprarBilhetesEstandoOffline() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        Thread.sleep(10000);
//        paginaMeusBilhetes.buscarElementosTentativasMaximas();
        paginaMeusBilhetes.buscarElementos();
        //paginaMeusBilhetes.clicarFormasDePgto();
        paginaMeusBilhetes.clicarBotaoComprarBilhetes();
    }

    @E("informo um CPF válido ainda não cadastrado")
    public void cpfValidoNaoCadastrado() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherCpf();

        try {
            cadastro.buscarModalCpfJaCadastrado();

            Login telaHome = new Login(driver);
            telaHome.buscarElementos();
            telaHome.clicarCriarConta();

            cpfValidoNaoCadastrado();
        } catch (Exception exception) {

        }
    }

    @E("clico em confirmar cadastrar senha")
    public void confirmarCadastrarSenha() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.clicarBotaoConfirmarCadastroSenha();
    }

    @Entao("visualizo a mensagem de \"CPF inválido\" no campo CPF.")
    public void visualizarMensagemCpfInválido() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.mensagemCpfInválido();
    }

    @E("aceito os termos de uso e privacidade")
    public void aceitarTermos() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.aceitarTermos();
    }

    @Entao("visualizo o modal de \"Cadastro realizado com sucesso\".")
    public void visualizarModalCadastro() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.visualizarModalCadastrado();
    }

    @E("submeto os demais dados corretamente até a finalização do formulário")
    public void finalizarCadastro() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

        cadastro.buscarElementos();
        cadastro.preencherNome();
        cadastro.preencherDataNascimentoPadrao();
        cadastro.escolherGenero();
        Thread.sleep(2000);
        cadastro.preencherEmailPadrao();
        cadastro.preencherTelefonePadrao();
        cadastro.clicarBotaoContinuar();
    }

    @E("clico na opção CPTM, Metrô")
    public void clicoNaOpção() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarBotaoCPTM();
        telaMeusBilhetes.clicarBotaoCPTM();

    }

    @E("seleciono a quantidade de bilhetes")
    public void selecionoAQuantidadeDeBilhetes() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);
        telaMeusBilhetes.buscarBotaoUnidades();
        telaMeusBilhetes.clicarBotaoUnidades();
    }

    @E("confirmo Cartão de crédito como forma de pagamento")
    public void confirmoCartãoDeCréditoComoFormaDePagamento() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarOpcaoCartaoDeCredito();
        telaMeusBilhetes.clicarOpcaoCartaoDeCredito();
        Thread.sleep(500);
        telaMeusBilhetes.clicarBotaoConfirmarFormaPagamento();
    }

    @Então("visualizo a tela de Pagamento efetuado com sucesso")
    public void visualizoATelaDePagamentoEfetuadoComSucesso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarMensagemCompraRealizadaComSucesso();
        assertTrue(telaMeusBilhetes.getMensagemCompraRealizadaComSucesso().isDisplayed());
        telaMeusBilhetes.buscarBotaoVoltarParaHome();
        telaMeusBilhetes.clicarBotaoVoltarParaHome();

    }

    @E("confirmo o pagamento informando o CVV {string}")
    public void confirmoOPagamentoInformandoOCVV(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarElementosConfirmarCompra();
        telaMeusBilhetes.inserirCvv(arg0);
        telaMeusBilhetes.clicarBotaoConfirmarCompra();
    }

    @Então("visualizo a tela de Erro no pagamento")
    public void visualizoATelaDeErroNoPagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarMensagemFalhaNoPagamento();
        assertTrue(telaMeusBilhetes.getMensagemFalhaNoPagamento().isDisplayed());
        telaMeusBilhetes.buscarBotaoVoltarParaHome();
        telaMeusBilhetes.clicarBotaoVoltarParaHome();
    }

    @Quando("informo o seguinte CPF {string} que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'")
    public void informoOSeguinteCPF(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciminhaSenha.buscarElementos();
        telaEsqueciminhaSenha.preencherInputCpf(arg0);
        MobileElement tela = (MobileElement) driver.findElementByAccessibilityId("Nova Senha");
        tela.click();
        telaEsqueciminhaSenha.clicarBotaoConfirmar();
    }

    @E("insiro o token sms")
    public void insiroOTokenSms() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        Thread.sleep(2000);
        telaEsqueciminhaSenha.buscarInput0sms();
        telaEsqueciminhaSenha.clicarInput0();
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("+5511922334456");
        telaEsqueciminhaSenha.inserirInputs(token);
        Thread.sleep(2000);
    }

    @E("insiro o token sms invalido")
    public void insiroOTokenSmsInvalido() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

        cadastro.buscarInput0sms();
        cadastro.inserirInputSms("1111111");
        Thread.sleep(2000)
        ;
    }

    @E("insiro o token sms invalido p cadastro")
    public void insiroOTokenSmsInvalidopCadastro() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

        cadastro.buscarInput0sms();
        cadastro.inserirInputSms("111111");
        Thread.sleep(2000)
        ;
    }

    @E("insiro o token email")
    public void insiroOTokenEmail() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        Thread.sleep(2000);
        telaEsqueciminhaSenha.buscarInput0email();
        telaEsqueciminhaSenha.clicarInput0();
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("testecav8@gmail.com");
        telaEsqueciminhaSenha.inserirInputs(token);
        Thread.sleep(2000);

    }@E("insiro o token email invalido p cadastro")
    public void insiroOTokenEmailinvalidocadastro() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

        Thread.sleep(2000);
        MobileElement tela =(MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Por favor, informe o código recebido para prosseguir com seu cadastro:\"]");
        tela.click();

        cadastro.buscarInput0email();
        cadastro.inserirInputEmail("1111111");
        Thread.sleep(2000);
    }

    @E("insiro o token email invalido")
    public void insiroOTokenEmailInvalido() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha esqueciMinhaSenha = new EsqueciMinhaSenha(driver);

        esqueciMinhaSenha.buscarInput0email();
        esqueciMinhaSenha.clicarInput0();
        Thread.sleep(3000);
        esqueciMinhaSenha.inserirInputs("111111");
    }

    @E("clico em confirmar")
    public void confirmar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciMinhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciMinhaSenha.clicarBotaoConfirmar();
    }

    @E("clico em confirmar sms")
    public void confirmarSms() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciminhaSenha.clicarBotaoConfirmarSms();
    }

    @E("insiro a senha {string}")
    public void inserirNovaSenha(String novaSenha) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.preencherInputSuaSenha(novaSenha);
    }

    @E("confirmo a nova senha {string}")
    public void confirmarNovaSenha(String confirmarSenha) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.preencherInputConfirmarSenha(confirmarSenha);
    }

    @E("clico em confirmar redefinir senha")
    public void confirmarRedefinirSenha() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        MobileElement tela = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[contains(@label, 'Sua senha')]");
        tela.click();
        telaEsqueciminhaSenha.clicarBotaoConfirmarRedefinirSenha();
    }

    @E("clico no botão \"Continuar\" com os demais campos em branco")
    public void continuarComCamposEmBranco() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        MobileElement tela =(MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"DADOS PESSOAIS\"]");
        tela.click();
        cadastro.clicarBotaoContinuar();
    }

    @Entao("visualizo as mensagens de campos obrigatórios nos campos em branco.")
    public void vizualizarMensagemErroBranco() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

//        cadastro.buscarElementos();
        cadastro.buscarMensagensErroObrigatoria();
    }

    @E("clico em confirmar email")
    public void confirmarEmail() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.clicarBotaoConfirmarEmail();
    }

    @E("confirmo Cartão de débito como forma de pagamento")
    public void confirmoCartãoDeDébitoComoFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarOpcaoCartaoDebito();
        telaMeusBilhetes.clicarOpcaoDebito();
        telaMeusBilhetes.clicarBotaoConfirmarFormaPagamento();
    }


    @E("submeto as informações corretas do cartão")
    public void submetoAsInformaçõesCorretasDoCartão(DataTable dataTable) {
        List<Map<String, String>> dados = dataTable.asMaps(String.class, String.class);
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        InserirDadosCartao paginaCartoes = new InserirDadosCartao(driver);
        for (Map<String, String> linha : dados) {
            String nomeCartao = linha.get("NomeCartao");
            String numeroCartao = linha.get("numeroCartao");
            String validadeCartao = linha.get("dtVal");
            String cvvCartao = linha.get("cvv");
            String cpfTitular = linha.get("numCelular");

            paginaCartoes.buscarElementos();
            paginaCartoes.preencherFormularioCadastroCartao(nomeCartao, numeroCartao, validadeCartao, cvvCartao, cpfTitular);

        }
    }

    @E("submeto as credenciais para login")
    public void submetoAsCredenciaisParaLogin(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> dados = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> linha : dados) {
            String argumento1 = linha.get("cpf");
            String argumento2 = linha.get("senha");

            AppiumDriver driver = AppiumDriverConfig.Instance().driver;
            Login telaLogin = new Login(driver);

            telaLogin.buscarElementos();
            telaLogin.limparCamposLogin();
            telaLogin.preencherFormulario(argumento1, argumento2);
            telaLogin.logar();
        }
    }

    @E("clico na opção Formas de Pagamento")
    public void clicoNaOpçãoFormasDePagamento() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

//        paginaMeusBilhetes.buscarBotaoFormasDePagamento();

        Thread.sleep(10000);
        paginaMeusBilhetes.clicarFormasDePgto();
    }

    @E("clico em Adicionar forma de pagamento")
    public void clicoEmAdicionarFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarElementosFormasDePagamento();
        paginaMeusBilhetes.clicarBotaoAdicionarFormaPagamento();
    }

    @E("clico na opção Cartão de crédito")
    public void clicoNaOpçãoCartãoDeCrédito() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarFormasDePagamento();
        paginaMeusBilhetes.clicarBotaoCartaoDeCreditoFormaPgto();
    }


    @Entao("visualizo a tela de Cartão cadastrado com sucesso")
    public void visualizoATelaDeCartãoCadastroComSucesso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarElementosTelaCadastroRealizado();
        assertTrue(paginaMeusBilhetes.getMsgCadastroCartaoSucesso().isDisplayed());
        paginaMeusBilhetes.clicarBotaoVoltarParaInicio();
    }

    @Entao("verifico os criterios de aceite dos campos \"Sua senha\" e \"Confirmar senha\" validando as mensagens exibidas")
    public void criterioDeAceiteNovaSenha() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha esqueciMinhaSenha = new EsqueciMinhaSenha(driver);

        esqueciMinhaSenha.novaSenhaTesteCriterioDeAceite();
    }

    @E("clico na opção excluir cartão {string}")
    public void clicoNaOpçãoExcluirCartão(String tipo) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

//        paginaMeusBilhetes.buscarLixeiraExcluirCartao();
        Thread.sleep(1000);
        paginaMeusBilhetes.clicarLixeiraExcluirCartao(tipo);
    }

    @E("confirmo a exclusão")
    public void confirmoAExclusão() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

//        paginaMeusBilhetes.buscarBotaoConfirmarExclusaoCartao();
        paginaMeusBilhetes.clicarBotaoConfirmarExclusaoCartao();
    }

    @Entao("o cartão não deverá estar listado")
    public void oCartãoNãoDeveráEstarListado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        //Thread.sleep(10000);
        WebDriverWait espera = new WebDriverWait(driver, 50);
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeOther[@name=\"\uE98E ADICIONAR CARTÃO\"]")));

    }

    @E("volto para o menu")
    public void voltoParaOMenu() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);


    }

    @E("clico na opção Cartão de débito")
    public void clicoNaOpçãoCartãoDeDébito() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarFormasDePagamento();
        paginaMeusBilhetes.clicarBotaoCartaoDeDebitoFormaPgto();
    }

    @Entao("visualizo a tela de falha no cadastro")
    public void visualizoATelaDeFalhaNoCadastro() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarElementosTelaFalhaCadastro();
        assertTrue(telaMeusBilhetes.getMsgFalhaCadastroCartao().isDisplayed());
        telaMeusBilhetes.buscarBotaoVoltarParaOInicio();
        telaMeusBilhetes.clicarBotaoVoltarParaHome();
    }
    @E("eu desligo a conexão de internet do dispositivo")
    public void euDesligoAConexãoDeInternetDoDispositivo() {
    GestosEmulador.desligarWifi();
    }

    @E("clico na opção Acessar meus bilhetes Offline")
    public void clicoNaOpçãoAcessarMeusBilhetesOffline() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarElementosTelaSemConexao();
        telaMeusBilhetes.clicarBotaoAcessarBilhetesOffline();

    }

    @E("submeto as seguintes credenciais validas para login, cpf {string}, senha {string}")
    public void submetoAsSeguintesCredenciaisValidasParaLoginCpfSenha(String arg0, String arg1) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);


        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario(arg0, arg1);
        MobileElement tela = (MobileElement) driver.findElementByAccessibilityId("Que bom ter você aqui! Confirme seus dados para continuar. \uEA38 CPF Espaço para digitar o cpf  icon_Espaço para digitar o cpf  \uE985 SENHA Espaço para digitar senha \uE91C Esqueci minha senha. env Botão para acessar o aplicativo É novo por aqui?  Crie uma conta.");
        tela.click();
        telaLogin.logar();
    }

    @Entao("visualizo a lista de bilhetes disponiveis para uso")
    public void visualizoAListaDeBilhetesDisponiveisParaUso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarMensagemListaDeBilhetes();
        assertTrue(telaMeusBilhetes.getMsgListaDeBilhetes().isDisplayed());

    }

    @E("reestabeleço a conexão com a internet")
    public void reestabeleçoAConexãoComAInternet() {
        GestosEmulador.ligarWifi();
    }

    @E("clico em tentar novamente")
    public void clicoEmTentarNovamente() throws InterruptedException {
        Thread.sleep(7000);
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarElementosTelaSemConexao();
        telaMeusBilhetes.clicarBotaoTentarNovamente();
    }

    @Entao("visualizo a tela de formas de pagamento")
    public void visualizoATelaDeFormasDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarCartoesEmFormasDePgto();
//        assertTrue(telaMeusBilhetes.getCartaoDeCredito().isDisplayed());
    }

    @E("clico no ultimo registro de compra no historico")
    public void clicoNoUltimoRegistroDeCompraNoHistorico() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarUltimaCompraDeBilhete();
        telaMeusBilhetes.clicarUltimaCompraDeBilhete();
    }

    @Entao("visualizo o modal com os detalhes da compra")
    public void visualizoOModalComOsDetalhesDaCompra() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarModalDetalhesCompra();
//        Assert.assertTrue(telaMeusBilhetes.getModalDetalhesCompra().isDisplayed());
    }

    @E("eu habilito o mock do token no perfil do usuario")
    public void euHabilitoOMockDoTokenNoPerfilDoUsuario() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home telaHome = new Home(driver);

//        telaHome.buscarFotoDePerfil();
        Thread.sleep(3000);
        telaHome.clicarFotoDePerfil();
        telaHome.scrolAteOpcaoMock();
        telaHome.clicarBotaoMockTokenGemalto();
        Thread.sleep(1000);
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.voltarHome();
        Thread.sleep(2000);
    }

    @E("confirmo saldo disponível como forma de pagamento")
    public void confirmoSaldoDisponívelComoFormaDePagamento() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarOpcaoSaldoEmConta();
        telaMeusBilhetes.clicarSaldoEmConta();
        telaMeusBilhetes.clicarBotaoConfirmarFormaPagamento();

    }

    @E("confirmo o pagamento informando a senha correta {string}")
    public void confirmoOPagamentoInformandoASenhaCorreta(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarInputSenhaSaldoEmConta();
        telaMeusBilhetes.clicarInput0SenhaSaldoEmConta();
        telaMeusBilhetes.inserirSenhaConta(arg0);
        telaMeusBilhetes.clicarBotaoConfirmarCompra();
    }

    @Dado("que eu reseto o driver")
    public void queEuResetoODriver() throws Exception {
        AppiumDriverConfig.Instance().driver = null;
    }

    @E("clico em 'Continuar' informando todos os dados pessoais corretamente")
    public void clicoEmInformandoTodosOsDadosPessoaisCorretamente() throws Exception {
        AppiumDriver appiumDriver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(appiumDriver);
        cadastro.buscarElementos();
        Thread.sleep(1000);
        cadastro.preencherCpf();
        cadastro.buscarElementos();
        cadastro.preencherNome();
        cadastro.preencherDataNascimentoPadrao();
        cadastro.escolherGenero();
        Thread.sleep(1000);
        cadastro.preencherEmailPadrao();
        cadastro.preencherTelefonePadrao();
        cadastro.clicarBotaoContinuar();
    }

    @Então("visualizo o modal de código inválido")
    public void visualizoOModalDeCódigoInválido() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarModalErroSms();
    }

    @E("clico em \"REENVIAR CÓDIGO\" após término do contador SMS")
    public void clicoEmReenviarCódigoApósTérminoDoContadorSms() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("+5514996237865");
        System.out.println("primeiro código sms: " + token);
        cadastro.esperarReenviarCodigo("//XCUIElementTypeOther[@name=\"resend_button_sms_verification\"]");
    }

    @E("clico em \"REENVIAR CÓDIGO\" após término do contador e-mail")
    public void clicoEmReenviarCódigoApósTérminoDoContadorEmail() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        Thread.sleep(2000);
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("testecav8@gmail.com");
        System.out.println("primeiro código e-mail: " + token);

        cadastro.esperarReenviarCodigo("//XCUIElementTypeOther[@name=\"resend_button_email_verification\"]");
    }

    @Então("recebo um novo código atualizado via SMS")
    public void receboUmNovoCódigoAtualizadoViaSMS() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("+5514996237865");


        if (token.isEmpty()) {
            throw new AssertionError("token vazio");
        } else {
            System.out.println("recebido novo token sms: " + token);

            WebDriverWait esperarSumir = new WebDriverWait(driver, 10);

            esperarSumir.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"resend_button_sms_verification\"]")));
            Thread.sleep(1500);
        }
    }

    @Então("recebo um novo código atualizado via e-mail")
    public void receboUmNovoCódigoAtualizadoViaEmail() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("testecav8@gmail.com");

        if (token.isEmpty()) {
            throw new AssertionError("token vazio");
        } else {
            System.out.println("recebido novo token e-mail: " + token);

            WebDriverWait esperarSumir = new WebDriverWait(driver, 10);

            esperarSumir.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"resend_button_sms_verification\"]")));
            Thread.sleep(1500);
        }

    }

    @E("clico em \"Editar meu número de celular\"")
    public void editarNumeroDeCelular() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.clicarEditarNumeroCelular();
    }

    @E("informo o número de telefone errado \"11911234567\"")
    public void informoONúmeroDeTelefoneErrado() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

        cadastro.buscarElementos();
        cadastro.preencherTelefone("11911234567");
    }

    @E("clico em \"CONFIRMAR NÚMERO\" após inserir um novo número de celular")
    public void clicoEmConfirmarNúmeroApósInserirUmNovoNúmeroDeCelular() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.alterarNumero();
        cadastro.confirmarAlterarNumero();

    }

    @Então("o modal é fechado exibindo a tela de confirmação com os 4 últimos dígitos do número atualizado")
    public void oModalÉFechadoExibindoATelaDeConfirmaçãoComOsÚltimosDígitosDoNúmeroAtualizado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarTextoComNumeroAlterado();
    }

    @E("clico em \"Editar meu endereço de e-mail\"")
    public void clicoEmEditarMeuEndereçoDeEMail() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.clicarEditarEmail();
    }

    @E("clico em \"CONFIRMAR E-MAIL\" após inserir um novo e-mail")
    public void clicoEmConfirmarEmailApósInserirUmNovoEMail() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.alterarEmail();
        cadastro.confirmarAlterarEmail();
    }

    @Então("o modal é fechado exibindo a tela de confirmação com o e-mail atualizado")
    public void oModalÉFechadoExibindoATelaDeConfirmaçãoComOEMailAtualizado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarTextoComEmailAlterado();
    }

    @E("informo o endereço de e-mail errado \"email.errado@gmail.com\"")
    public void informoOEndereçoDeEMailErrado() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherEmail("email.errado@gmail.com");
    }


    @Entao("verifico os criterios de aceite do campo \"Sua senha\" validando o estado do botão \"Confirmar\" e visualizando os checks nos requisítos da senha")
    public void verificoOsCriteriosDeAceiteDoCampoSuaSenhaValidandoOEstadoDoBotãoConfirmarEVisualizandoOsChecksNosRequisítosDaSenha() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.cadastrarSenhaTesteCriterioDeAceite();

    }

    @E("confirmo pix como forma de pagamento")
    public void confirmoPixComoFormaDePagamento() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarOpcaoPix();
        telaMeusBilhetes.clicarOpcaoPix();
        telaMeusBilhetes.clicarBotaoConfirmarFormaPagamento();
    }

    @E("insiro o token sms p cadastro")
    public void insiroOTokenSmsPCadastro() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarInput0sms();
        String codigo=  OTPUtils.getOTPtokenByPhoneNumberOrEmail("+5511922334456");
        cadastro.inserirInputSms(codigo);
    }

    @E("insiro o token email p cadastro")
    public void insiroOTokenEmailPCadastro() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        String codigo=  OTPUtils.getOTPtokenByPhoneNumberOrEmail("testecav8@gmail.com");
        cadastro.buscarInput0email();
        cadastro.inserirInputEmail(codigo);
    }

    @E("insiro o token sms invalido p login")
    public void insiroOTokenSmsInvalidoPLogin() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        Thread.sleep(2000);
        telaEsqueciminhaSenha.buscarInput0sms();
        telaEsqueciminhaSenha.clicarInput0();
        telaEsqueciminhaSenha.inserirInputs("111111");
        Thread.sleep(2000);
    }
}


