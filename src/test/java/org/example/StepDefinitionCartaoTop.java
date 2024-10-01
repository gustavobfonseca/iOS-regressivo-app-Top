package org.example;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.CartaoTop;
import org.example.PageObjects.Celular;
import org.example.PageObjects.Home;
import org.example.PageObjects.MeusBilhetes;

import static org.junit.Assert.assertTrue;

public class StepDefinitionCartaoTop {
    @Quando("eu clico em Cartão TOP")
    public void euClicoEmCartãoTOP() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home telaHome = new Home(driver);

        telaHome.buscarBotaoCartaoTop();
        telaHome.clicarBotaoCartaoTop();
    }

    @E("clico em Comprar Créditos")
    public void clicoEmComprarCréditos() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);

        tela1CartaoTop.buscarBotaoComprarCreditos();
        Thread.sleep(2000);
        tela1CartaoTop.clicarBotaoComprarCreditos();

    }

    @E("clico na opção Comum")
    public void clicoNaOpçãoComum() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);

        tela2CartaoTop.buscarBotaoComum();
        tela2CartaoTop.clicarBotaoComum();

    }


    @E("insiro o valor de R$ {string}")
    public void insiroOValorDeR$(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);

        tela2CartaoTop.inputarValorDeCredito(arg0);

    }

    @E("clico em Comprar")
    public void clicoEmComprar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);

        tela2CartaoTop.buscarBotaoComprarTela2();
        tela2CartaoTop.clicarBotaoComprarTela2();
    }

    @E("submeto a opção Cartão de crédito como forma de pagamento")
    public void submetoAOpçãoCartãoDeCréditoComoFormaDePagamento() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela3CartaoTop = new CartaoTop(driver);

        tela3CartaoTop.buscarBotaoCartaoDeCredito();
        tela3CartaoTop.clicarBotaoCartaoDeCredito();
        tela3CartaoTop.buscarBotaoConfirmarTela3();
        tela3CartaoTop.clicarBotaoConfirmarTela3();
    }

    @E("finalizo com o cvv incorreto")
    public void finalizoComOCvvIncorreto() {


    }

    @E("submeto a opção Cartão de Débito como forma de pagamento")
    public void submetoAOpçãoCartãoDeDébitoComoFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela3CartaoTop = new CartaoTop(driver);

        tela3CartaoTop.buscarBotaoCartaoDeDebito();
        tela3CartaoTop.clicarBotaoCartaoDeDebito();
        tela3CartaoTop.buscarBotaoConfirmarTela3();
        tela3CartaoTop.clicarBotaoConfirmarTela3();
    }

    @E("clico na opção Escolar")
    public void clicoNaOpçãoEscolar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);

        tela2CartaoTop.buscarBotaoEscolar();
        tela2CartaoTop.clicarBotaoEscolar();
    }

    @E("submeto pix como forma de pagamento")
    public void submetoPixComoFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela3CartaoTop = new CartaoTop(driver);

        tela3CartaoTop.buscarOpcaoPix();
        tela3CartaoTop.clicarOpcaoPix();
        tela3CartaoTop.buscarBotaoConfirmarTela3();
        tela3CartaoTop.clicarBotaoConfirmarTela3();
    }

    @Então("visualizo a tela de codigo pix gerado para pagamento")
    public void visualizoATelaDeCodigoPixGeradoParaPagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela4CartaoTop = new CartaoTop(driver);

        tela4CartaoTop.buscarTelaPix();
        assertTrue(tela4CartaoTop.getTextoCopiarCodigoPix().isDisplayed());
    }

    @E("expando o modal de saldo")
    public void expandoOModalDeSaldo() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);

        tela1CartaoTop.buscarBotaoExpandirModalSaldo();
        tela1CartaoTop.clicarBotaoExpandirModalSaldo();

    }

    @E("clico na opção Saiba mais no item escolar")
    public void clicoNaOpçãoSaibaMaisNoItemEscolar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);

        tela1CartaoTop.buscarSaibaMaisEscolar();
        tela1CartaoTop.clicarBotaoSaibaMais();
    }

    @Entao("visualizo a tela de beneficio escolar meia tarifa")
    public void visualizoATelaDeBeneficioEscolarMeiaTarifa() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);

        tela2CartaoTop.buscarTelaInformativoMeiaTarifa();
        assertTrue(tela2CartaoTop.getTextoBeneficioEscolar().isDisplayed());
    }

    @Então("visualizo a tela de confirmação de pagamento via pix")
    public void visualizoATelaDeConfirmaçãoDePagamentoViaPix() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarFormaDePagamentoTelaConfirmacaoPix();
        assertTrue(telaMeusBilhetes.getTextoPixCopiaECola().isDisplayed());
    }
}
