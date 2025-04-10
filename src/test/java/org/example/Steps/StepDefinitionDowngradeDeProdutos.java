package org.example.Steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.example.AppiumDriverConfig;
import org.example.GestosEmulador;
import org.example.PageObjects.Home;
import org.example.PageObjects.Login;
import org.example.PageObjects.Tela;
import org.example.PostUser;

public class StepDefinitionDowngradeDeProdutos {
    AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    private String cpf;
    private final String xpathBaning ="//XCUIElementTypeStaticText[@name=\"Banking\"]";
    MobileElement banking= (MobileElement)driver.findElementByXPath(xpathBaning);


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    Tela tela = new Tela();

    @E("dou scroll até Cancelar Cartao Ou Conta Digital")
    public void douScrollAtéCancelarCartaoOuContaDigital() {
        Tela.espera(2000);
        GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"Cancelar Cartão ou Conta Digital\"]");
    }

    @E("clico em Cancelar Cartao Ou Conta Digital")
    public void clicoEmCancelarCartaoOuContaDigital() {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Cancelar Cartão ou Conta Digital\"]",10);
    }

    @E("clico em Cartao De Credito TOP")
    public void clicoEmCartaoDeCreditoTOP() {
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"\uE8FD Cartão de Crédito TOP Cartão Mastercard para compras no crédito. \uE8B9\"])[2]", 60);
    }


    @E("clico em cancelar o cartao de credito")
    public void clicoEmCancelarOCartaoDeCredito() {
        GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"CANCELAR O CARTÃO DE CRÉDITO\"]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"CANCELAR O CARTÃO DE CRÉDITO\"]", 10);

    }

    @E("clico em prosseguir com cancelamento")
    public void clicoEmProsseguirComCancelamento() {
    GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"Prosseguir com o cancelamento\"]");
    Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Prosseguir com o cancelamento\"]");
    }

    @E("clico em Conta Digital")
    public void clicoEmContaDigital() {
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"\uE800 Conta Digital Cartão de débito sem tarifas mensais. \uE8B9\"])[2]", 60);
    }

    @E("clico em cancelar a conta digital")
    public void clicoEmCancelarAContaDigital() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Cancelamento\"]");
        GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"QUERO CANCELAR A CONTA DIGITAL\"]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"QUERO CANCELAR A CONTA DIGITAL\"]", 10);

    }


    @E("clico em prosseguir com cancelamento de conta digital")
    public void clicoEmProsseguirComCancelamentoDeContaDigital() {
        tela.scrollAteElemento("//android.widget.TextView[@text=\"Como cancelar a função Conta Digital:\"]",
                10,
                "new UiSelector().text(\"PROSSEGUIR COM O CANCELAMENTO\")");
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"PROSSEGUIR COM O CANCELAMENTO\"]", 10);
    }

    @E("clico em Cartao Transporte")
    public void clicoEmCartaoTransporte() {
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"\uE884 Cartão Transporte Cartão TOP Transporte utilizado nos \n" +
                "Trens e Ônibus Intermunicipais. \uE8B9\"])[2]", 60);
    }


    @Entao("visualizo a pendência de saldo existente")
    public void souVisualizoAPendênciaDeSaldoExistente() {
       Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Notamos que você tem algumas pendências\n" +
               "que impossibilitam o cancelamento do seu\n" +
               "Cartão nesse momento.\"]");

       Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"\uE908 Saldo existente:\"]");
    }

    @E("clico em quero cancelar meu cartao TOP")
    public void clicoEmQueroCancelarMeuCartaoTOP() {
GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"QUERO CANCELAR MEU CARTÃO\"]");
//    Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"QUERO CANCELAR MEU CARTÃO\"]");
    }


    @E("seleciono o motivo do cancelamento")
    public void selecionoOMotivoDoCancelamento() {
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Mudança para local não atendido pelo\n" +
                "serviço TOP\"]", 20);
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Continuar\"]", 20);
    }


    @E("confirmo meus dados cadastrais")
    public void confirmoMeusDadosCadastrais() {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Continuar\"]", 10);
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"E-mail\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Telefone\"]");
    }

    @E("clico no botao Quero Cancelar Meu Cartao TOP")
    public void clicoEmQueroCancelarMeuCartao() {
//        Tela.buscarElementoNaTela("");
        Tela.espera(4000);
        GestosEmulador.clickCoordenada(200,722);

    }

    @Entao("visualizo a tela de cartao cancelado com sucesso")
    public void visualizoATelaDeCartaoCanceladoComSucesso() throws InterruptedException {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Cancelamento Enviado\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Sua solicitação foi enviada com sucesso.\"]");
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[@name=\"Botão principal\"])[2]");
    }

    @E("clico em Reportar Cartao Perdido ou Danificado")
    public void clicoEmReportarCartaoPerdidoOuDanificado() {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Reportar Cartão perdido ou danificado\"]", 60);

    }

    @E("clico em cancelar a cartao perdido ou danificado")
    public void clicoEmCancelarACartaoPerdidoOuDanificado() {
        GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"Prosseguir com o cancelamento\"]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Prosseguir com o cancelamento\"]");
    }

    @E("seleciono o motivo do cancelamento do puro transporte")
    public void selecionoOMotivoDoCancelamentoDoPuroTransporte() {
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Perdi meu Cartão\"]", 10);
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Continuar\"]", 10);

    }

    @Entao("visualizo a tela de cartao cancelado com sucesso com a opcao de solicitar a segunda via")
    public void visualizoATelaDeCartaoCanceladoComSucessoComAOpcaoDeSolicitarASegundaVia() {
      Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"Botão secundário\"]");
      Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Sua solicitação foi enviada com sucesso.\"]");

    }

    @E("vou ate conta digital")
    public void vouAteContaDigital() {
        tela.clicarEmElemento("//XCUIElementTypeButton[@name=\"\uE800\"]", 60);
    }

    @E("vou ate cartao TOP")
    public void vouAteCartaoTOP() {
        tela.clicarEmElemento("//XCUIElementTypeButton[@name=\"\uE884\"]", 60);
    }

    @E("vou ate a home")
    public void vouAteAHome() {
        tela.clicarEmElemento("//XCUIElementTypeButton[@name=\"\uE96F\"]", 60);
    }

    @E("clico em encerrar cadastro no TOP")
    public void clicoEmEncerrarCadastroNoTOP() {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Encerrar Cadastro no TOP\"]", 50);
    }


    @Entao("visualizo as pendencias antes de encerrar")
    public void visualizoAsPendenciasAntesDeEncerrar() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Notamos que você tem algumas pendências\n" +
                "que impossibilitam o cancelamento do cadastro\n" +
                "nesse momento.\"]");
    }

    @E("clico em Quero cancelar meu cadastro")
    public void clicoEmQueroCancelarMeuCadastro() {
        GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"QUERO CANCELAR MEU CADASTRO\"]");
//        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"QUERO CANCELAR MEU CADASTRO\"]");
    }

    @E("seleciono o motivo do cancelamento do cadastro")
    public void selecionoOMotivoDoCancelamentoDoCadastro() {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Mudança para local não atendido pelo\n" +
                "serviço TOP\"]", 30);
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Continuar\"]", 20);

    }

    @E("clico no botao Quero Cancelar Meu Cadastro")
    public void clicoNoBotaoQueroCancelarMeuCadastro() {
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[@name=\"Ao prosseguir você concorda com os ,[object Object], Tem certeza que deseja cancelar seu cadastro no ,[object Object], Cancelar Cancelar\"])[1]");
        Tela.espera(2000);
        GestosEmulador.clickCoordenada(202,720);
    }

    @Entao("visualizo a tela de cancelamento efetuado com sucesso")
    public void visualizoATelaDeCancelamentoEfetuadoComSucesso() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Cancelamento Enviado\"]", 60);
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Sua solicitação foi enviada com sucesso.\"]", 60);
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"Botão principal\"])[2]");

    }

    @E("ao finalizar devo ser desligado do app")
    public void aoFinalizarDevoSerDesligadoDoApp() {
       Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"CPF\"]");
       Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"SENHA\"]");
       Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"signin_button\"]");
    }

    @E("navego ate cartao de credito")
    public void navegoAteCartaoDeCredito() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Banking\"]");
        Tela.espera(2000);
        GestosEmulador.clickCoordenada(215,banking.getLocation().y+127);
    }

    @E("submeto as seguintes credenciais validas para login com cpf bloqueado")
    public void submetoAsSeguintesCredenciaisValidasParaLoginCpfSenha() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);


        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario(getCpf(),"Teste123");
//        telaLogin.logar();
    }

    @Dado("que acesso o app com uma conta nova para desativar")
    public void queAcessoOAppComUmaContaNova() throws Exception {
        String senha = "Teste123";
        String cpf = PostUser.criarUser(senha,19);
        System.out.println(cpf);

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);


        telaLogin.buscarElementos();
        telaLogin.preencherFormulario(cpf, senha);

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();

    }

    @E("arrasto modal super TOP pra baixo")
    public void arrastoModalSuperTOPPraBaixo() {
        Tela.espera(7000);
        GestosEmulador.arrastar(190,180,190,654);
    }
}