package org.example.Steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.AppiumDriverConfig;
import org.example.GestosEmulador;
import org.example.PageObjects.Home;
import org.example.PageObjects.Login;
import org.example.PageObjects.PerfilDoUsuario;
import org.example.PageObjects.Tela;

public class StepDefinitionMobilidade {

    @Quando("clico na opção Mapa das estações")
    public void clicoNaOpçãoMapaDasEstações() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.buscarMapa();

    }

    @Quando("clico na opção Mobilidade")
    public void clicoNaOpçãoMobilidade() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);

        home.buscarMobilidade();

    }

    @Dado("que eu acesso a tela home do aplicativo")
    public void queEuAcessoATelaHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("54926406829", "Teste123");
//        MobileElement tela = (MobileElement) driver.findElementByAccessibilityId("Que bom ter você aqui! Confirme seus dados para continuar. \uEA38 CPF Espaço para digitar o cpf  icon_Espaço para digitar o cpf  \uE985 SENHA Espaço para digitar senha \uE91C Esqueci minha senha. env Botão para acessar o aplicativo É novo por aqui?  Crie uma conta.");
//        tela.click();
//        telaLogin.logar();
        Home telaHome = new Home(driver);

//        try {
//            telaHome.arrastarModalParaBaixo();
//        } catch (Exception e) {
////            telaHome.clicarBotaoModalQueroConhecer();
//            throw new RuntimeException("nao arrastou o modal para baixo");
//        }
        telaHome.buscarMensagemBemVindo();
    }


    @Então("visualizo a tela de \"Disponível em breve\"")
    public void visualizoATelaDeDisponivelEmBreve() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);

        home.buscarDisponivelEmBreve();
    }

    @Dado("que eu esteja na tela home do aplicativo")
    public void queEuEstejaNaTelaHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
//        Thread.sleep(15000);
        home.buscarBotaoBilhetes();
//        Assert.assertEquals("Tenha uma boa viagem.", home.getMsgBoaViagem().getText());

    }

    @Então("minha foto é removida no perfil de usuário")
    public void minhaFotoÉRemovidaNoPerfilDeUsuário() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        if (perfilDoUsuario.verificarFotoPerfil()){
            throw new RuntimeException();
        }
    }

    @E("removida na apresentação da Home")
    public void removidaNaApresentaçãoDaHome() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.buscarFotoDePerfil();
    }


    @E("insiro um endereco de origem e destino")
    public void insiroUmEnderecoDeOrigemEDestino() {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"200 Geary St, San Francisco, CA 94102, EUA\"]");
        Tela.inputNoElemento("//XCUIElementTypeTextField[@value=\"Onde você está?\"]","Av");
        GestosEmulador.clickCoordenada(200,150);
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"Avenida Paulista - Bela Vista, São Paulo - SP, Brasil\"])[4]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Para onde vamos?\"]");
        Tela.inputNoElemento("//XCUIElementTypeTextField[@value=\"Para onde vamos?\"]","Haddock");
        GestosEmulador.clickCoordenada(200,150);
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"Rua Haddock Lobo - Cerqueira César, São Paulo - SP, Brasil\"])[4]");

    }

    @Quando("seleciono a opção Ônibus e Metrô no modal")
    public void selecionoAOpçãoÔnibusEMetrôNoModal() {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Ônibus e metrô\"]");
        GestosEmulador.arrastar(200,177,200,696);


    }

    @Então("visualizo o modal {string} listando todos os endereços dos pontos retornados.")
    public void visualizoOModalListandoTodosOsEndereçosDosPontosRetornados(String arg0) {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Ônibus e metrô próximos de você\"]");

    }

    @Quando("movo a posição do mapa")
    public void movoAPosiçãoDoMapa() {
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"Rotas e trajetos\"]");
        Tela.espera(4000);
        GestosEmulador.arrastar(200,177,200,696);
        System.out.println("loc sumiu");
    }

    @E("clico no botão de centralização")
    public void clicoNoBotãoDeCentralização() {
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"\uF37F\"])[2]");
    }

    @Então("o mapa centraliza para a minha posição atual")
    public void oMapaCentralizaParaAMinhaPosiçãoAtual() {
Tela.espera(200);
    }

    @Então("visualizo a lista de opções de rotas possíveis")
    public void visualizoAListaDeOpçõesDeRotasPossíveis() {
        GestosEmulador.clickCoordenada(200,350);
        Tela.espera(5000);
//        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[@name=\"\uF5B3 \uF130 Linha 2 \uF130 \uF5B3 \uF130 Barra de rolagem vertical, 1 página \uF112 17,2 min | 1,7 km\"])[4]");
    }

    @Então("visualizo todo o trajeto entre meu endereço de origem até meu destino")
    public void visualizoTodoOTrajetoEntreMeuEndereçoDeOrigemAtéMeuDestino() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Siga as instruções abaixo até o seu destino\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Avenida Paulista, Bela Vista, São Paulo, São Paulo\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Rua Haddock Lobo, Cerqueira César, São Paulo, São Paulo\"]");
    }

    @E("clico na opção Encerrar viagem")
    public void clicoNaOpçãoEncerrarViagem() {
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"\uF223 Encerrar viagem\"])[2]");

    }

    @Então("retorno ao status inicial, limpando toda busca realizada")
    public void retornoAoStatusInicialLimpandoTodaBuscaRealizada() {
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"Avenida Paulista - Bela Vista, São Paulo - SP, Brasil\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"Para onde vamos?\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"Rotas e trajetos\"]");
    }
}