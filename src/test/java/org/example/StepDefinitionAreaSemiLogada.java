package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.eo.Se;
import io.cucumber.java.pt.*;
import org.example.PageObjects.*;
import org.junit.Assert;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

public class StepDefinitionAreaSemiLogada {

    @Dado("que realizo o logout para a área semi logada do app, estando com a biometria habilitada")
    public void queRealizoOLogoutParaAÁreaSemiLogadaDoAppEstandoComABiometriaHabilitada() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("13715099054", "Devires@123");
        telaLogin.logar();

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
//        telaHome.clicarBotaoAtivarBiometria();

        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());

        telaHome.deslogar();
    }

    @Dado("que realizo o logout para a área semi logada do app, estando com a biometria desabilitada")
    public void queRealizoOLogoutParaAÁreaSemiLogadaDoAppEstandoComABiometriaDesabilitada() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("13715099054", "Devires@123");
        telaLogin.logar();

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
//        telaHome.clicarBotaoAtivarBiometria();

        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());

        telaHome.desativarBiometria();
    }

    @Quando("submeto a senha correta do CPF")
    public void submetoASenhaCorretaDoCPF() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.buscarElementos();
        semiLogado.preencherSenhaPadrao();

    }

    @E("clico em \"Entrar\" na área semi logada")
    public void clicoEmEntrar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.clicarBotaoEntrar();
    }

    @Então("sou logado para a home do aplicativo com o modal de ativação de biometria")
    public void souLogadoParaAHomeDoAplicativoComOModalDeAtivaçãoDeBiometria() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home telaHome = new Home(driver);

        Thread.sleep(3000);
        telaHome.esperarBotaoBiometria();

        telaHome.buscarMensagemBemVindo();
    }

    @Então("visualizo a solicitação de biometria para login")
    public void visualizoOModalTelaDeSolicitaçãoDeBiometriaParaLogin() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.buscarMensagemSenhaObrigatoria();
        driver.navigate().back();
        semiLogado.buscarElementos();
    }

    @Dado("que acesso a área semi logada do aplicativo")
    public void queAcessoAÁreaSemiLogadaDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("659.989.520-49", "Laura107");
        telaLogin.logar();

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
//        telaHome.clicarBotaoAtivarBiometria();

        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());

        telaHome.desativarBiometria();
    }


    @Quando("clico em \"Esqueci minha senha.\"")
    public void clicoEmEsqueciMinhaSenha() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarElementos();
        semiLogado.getLinkEsqueciMinhaSenha().click();
    }

    @Quando("submeto a senha incorreta para o CPF")
    public void submetoASenhaIncorretaParaOCPF() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.buscarElementos();
        semiLogado.preencherSenha("SenhaIncorreta@123");

    }

    @Então("visualizo o modal de CPF e, ou senha incorretos")
    public void visualizoOModalDeCPFEOuSenhaIncorretos() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarModalErro();
        Assert.assertEquals("CPF e/ou senha inválidos.", telaLogin.getModalErro().getText());
        telaLogin.buscarBotaoFecharModalCPFSenha();
        telaLogin.clicarBotaoFecharModalCPFSenha();

        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarElementos();
    }

    @Dado("que acesso a área semi logada do aplicativo tendo bilhetes QR Code disponíveis para utilização,")
    public void queAcessoAÁreaSemiLogadaDoAplicativoTendoBilhetesQRCodeDisponíveisParaUtilização() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("659.989.520-49", "Laura107");
        telaLogin.logar();

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
//        telaHome.clicarBotaoAtivarBiometria();

        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());

        telaHome.desativarBiometria();
    }


    @Quando("acesso a opção \"Bilhetes Offline\"")
    public void acessoAOpçãoBilhetesOffline() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarElementos();
        semiLogado.clicarBilhetes();
    }


    @Quando("clico em \"Trocar de conta\"")
    public void clicoEmTrocarDeConta() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarElementos();
        semiLogado.trocarDeConta();
    }

    @E("confirmo no modal")
    public void confirmoNoModal() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.confirmarTrocaDeConta();
    }

    @Então("sou direcionado para a tela da área não logada")
    public void souDirecionadoParaATelaDaÁreaNãoLogada() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login login = new Login(driver);
        login.buscarElementos();

    }

    @Quando("acesso a opção Mapa das Estações")
    public void acessoAOpçãoMapaDasEstações() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.clicarMapaEstacao();
    }

    @Então("visualizo o Mapa do Transporte Metropolitano de SP")
    public void visualizoOMapaDoTransporteMetropolitanoDeSP() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.buscarMapa();
    }

    @Quando("acesso a opção \"Central de Ajuda\"")
    public void acessoAOpçãoCentralDeAjuda() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarElementos();
        semiLogado.clicarCentralAjuda();
    }

    @Então("visualizo a página inicial da Central de Ajuda Autopass")
    public void visualizoAPáginaInicialDaCentralDeAjudaAutopass() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarCentralDeAjuda();
    }

    @Dado("que acesso o menu \"Bilhetes QR Code\" tendo bilhetes disponíveis para utilização")
    public void queAcessoOMenuBilhetesQRCodeTendoBilhetesDisponíveisParaUtilização() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("365.369.350-04", "Devires@123");
        telaLogin.logar();

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
//        telaHome.clicarBotaoAtivarBiometria();

        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());

        telaHome.buscarBotaoBilhetes();
        telaHome.clicarBotaoBilhetes();

        MeusBilhetes meusBilhetes = new MeusBilhetes(driver);
        meusBilhetes.buscarElementos();
        meusBilhetes.verificarQtdDeBilhete();
        meusBilhetes.clicarSetaVoltar();
    }

    @E("faço o logoff do app para a área semi logada")
    public void façoOLogoffDoAppParaAÁreaSemiLogada() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);

        home.deslogar();

    }

    @Então("visualizo meus bilhetes disponíveis para utilização")
    public void visualizoMeusBilhetesDisponíveisParaUtilização() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarBilhetes();
    }


    @E("retorno a senha para a senha alterada não atrapalhe na continuação dos outros testes do regressivo")
    public void retornoASenhaParaASenhaAlteradaNãoAtrapalheNaContinuaçãoDoRegressivo() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.inserirNovaSenha("Teste@123");
        perfilDoUsuario.inserirConfirmarNovaSenha("Teste@123");
        perfilDoUsuario.enviarNovaSenha();
        perfilDoUsuario.buscarConfirmacaoSenhaAlteradaSucesso();
        perfilDoUsuario.buscarSenhaDoAplicativo();


    }

    @E("submeto a senha correta do CPF {string}")
    public void submetoASenhaCorretaDoCPF(String senha) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.buscarElementos();
        semiLogado.preencherSenha(senha);
    }

    @Então("sou direcionado para a página dos termos de uso na Central de Ajuda Autopass")
    public void souDirecionadoParaAPáginaDosTermosDeUsoNaCentralDeAjudaAutopass() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarSiteTermosUso();
    }

    @Então("sou direcionado à área semi logada do aplicativo TOP")
    public void souDirecionadoÀÁreaSemiLogadaDoAplicativoTOP() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarElementos();
    }
}
