package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.example.PageObjects.Tela;
import org.junit.Assert;

public class StepDefinitionDowngradeDeProdutos {

    AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    Tela tela = new Tela();

    @E("dou scroll até Cancelar Cartao Ou Conta Digital")
    public void douScrollAtéCancelarCartaoOuContaDigital() {
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
        tela.scrollAteElemento("//android.widget.TextView[@text=\"Como cancelar a função Crédito:\"]",
                10,
                "new UiSelector().text(\"PROSSEGUIR COM O CANCELAMENTO\")");
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"PROSSEGUIR COM O CANCELAMENTO\"]", 10);
    }

    @E("clico em Conta Digital")
    public void clicoEmContaDigital() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Conta Digital\"]", 60);
    }

    @E("clico em cancelar a conta digital")
    public void clicoEmCancelarAContaDigital() {
        tela.scrollAteElemento("//android.widget.TextView[@text=\"Poxa! Tem certeza que deseja cancelar\n" +
                "a função Conta Digital?\"]", 10, "new UiSelector().text(\"QUERO CANCELAR A CONTA DIGITAL\")");
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"QUERO CANCELAR A CONTA DIGITAL\"]", 10);

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
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Cartão Transporte\"]", 60);
    }


    @Entao("visualizo a pendência de saldo existente")
    public void souVisualizoAPendênciaDeSaldoExistente() {
        MobileElement textoSaldo = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Saldo existente:\"]", 20);

        Assert.assertTrue(textoSaldo.isDisplayed());
    }

    @E("clico em quero cancelar meu cartao TOP")
    public void clicoEmQueroCancelarMeuCartaoTOP() {
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"QUERO CANCELAR MEU CARTÃO\"]", 10);
    }


    @E("seleciono o motivo do cancelamento")
    public void selecionoOMotivoDoCancelamento() {
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"Mudança para local não atendido pelo\n" +
                "serviço TOP\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 20);
    }


    @E("confirmo meus dados cadastrais")
    public void confirmoMeusDadosCadastrais() {
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 10);
    }

    @E("clico no botao Quero Cancelar Meu Cartao TOP")
    public void clicoEmQueroCancelarMeuCartao() {

    }

    @Entao("visualizo a tela de cartao cancelado com sucesso")
    public void visualizoATelaDeCartaoCanceladoComSucesso() throws InterruptedException {
        Thread.sleep(10000);
    }

    @E("clico em Reportar Cartao Perdido ou Danificado")
    public void clicoEmReportarCartaoPerdidoOuDanificado() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Reportar Cartão perdido ou danificado\"]", 60);

    }

    @E("clico em cancelar a cartao perdido ou danificado")
    public void clicoEmCancelarACartaoPerdidoOuDanificado() {
        tela.scrollAteElemento("//android.widget.TextView[@text=\"Como cancelar seu Cartão\n" +
                "perdido ou danificado:\"]", 20, "new UiSelector().text(\"PROSSEGUIR COM O CANCELAMENTO\")");
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"PROSSEGUIR COM O CANCELAMENTO\"]", 10);
    }

    @E("seleciono o motivo do cancelamento do puro transporte")
    public void selecionoOMotivoDoCancelamentoDoPuroTransporte() {
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"Perdi meu Cartão\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 10);

    }

    @Entao("visualizo a tela de cartao cancelado com sucesso com a opcao de solicitar a segunda via")
    public void visualizoATelaDeCartaoCanceladoComSucessoComAOpcaoDeSolicitarASegundaVia() {
        MobileElement solicitacaoEnviada = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Sua solicitação foi enviada com sucesso.\"]", 10);
        MobileElement solicitarSegundaVia = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"SOLICITAR SEGUNDA VIA\"]", 10);

        Assert.assertTrue(solicitacaoEnviada.isDisplayed());
        Assert.assertTrue(solicitarSegundaVia.isDisplayed());

    }

    @E("vou ate conta digital")
    public void vouAteContaDigital() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"\uE800\"]", 60);
    }

    @E("vou ate cartao TOP")
    public void vouAteCartaoTOP() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"\uE884\"]", 60);
    }

    @E("vou ate a home")
    public void vouAteAHome() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"\uE96F\"]", 60);
    }

    @E("clico em encerrar cadastro no TOP")
    public void clicoEmEncerrarCadastroNoTOP() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Encerrar Cadastro no TOP\"]", 20);
    }


    @Entao("visualizo as pendencias antes de encerrar")
    public void visualizoAsPendenciasAntesDeEncerrar() {
        MobileElement textoPendencias = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Notamos que você tem algumas pendências\n" +
                "que impossibilitam o cancelamento do cadastro\n" +
                "nesse momento.\"]", 60);
        Assert.assertTrue(textoPendencias.isDisplayed());
    }

    @E("clico em Quero cancelar meu cadastro")
    public void clicoEmQueroCancelarMeuCadastro() {
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"QUERO CANCELAR MEU CADASTRO\"]", 60);
    }

    @E("seleciono o motivo do cancelamento do cadastro")
    public void selecionoOMotivoDoCancelamentoDoCadastro() {
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"Mudança para local não atendido pelo\n" +
                "serviço TOP\"]", 30);
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 20);

    }

    @E("clico no botao Quero Cancelar Meu Cadastro")
    public void clicoNoBotaoQueroCancelarMeuCadastro() {

    }

    @Entao("visualizo a tela de cancelamento efetuado com sucesso")
    public void visualizoATelaDeCancelamentoEfetuadoComSucesso() {
        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Sua solicitação foi enviada com sucesso.\"]", 60);

    }

    @E("ao finalizar devo ser desligado do app")
    public void aoFinalizarDevoSerDesligadoDoApp() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Sua solicitação foi enviada com sucesso.\"]", 10);
        MobileElement telaLogin = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Crie uma conta.\"]", 30);

        Assert.assertTrue(telaLogin.isDisplayed());
    }
}
