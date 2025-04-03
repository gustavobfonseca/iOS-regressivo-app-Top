package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.*;
import org.example.PageObjects.*;

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
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"COPIAR CÓDIGO PIX\"])[2]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"PIX\"]");

    }

    @Quando("acesso o menu Transporte")
    public void acessoOMenuTransporte() {
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");
    }

    @E("seleciono a opção Receber em casa")
    public void selecionoAOpçãoReceberEmCasa() throws InterruptedException {
        Tela.clicarEmElemento("(//XCUIElementTypeOther[contains(@name, 'Receber em casa')])[last()]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"lg_button_home\"]");
        Tela.espera(3000);
        GestosEmulador.clickCoordenada(200,730,"confirmar modal");

    }

    @Então("sou direcionado para o serviço de envio de cartão da Pacman")
    public void souDirecionadoParaOServiçoDeEnvioDeCartãoDaPacman() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Cartão TOP\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"1ª via do Cartão TOP\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeButton[@name=\"Solicitar\"]");

    }

    @Dado("que acesso o app com uma conta nova, tendo {int} anos ou mais")
    public void queAcessoOAppComUmaContaNovaTendoAnosOuMais(int arg0) throws Exception {
            String senha = "Teste123";
            String cpf = PostUser.criarUser(senha,arg0+1);

            AppiumDriver driver = AppiumDriverConfig.Instance().driver;
            Login telaLogin = new Login(driver);


            telaLogin.buscarElementos();
            telaLogin.preencherFormulario(cpf, senha);

            Home telaHome = new Home(driver);
            telaHome.buscarMensagemBemVindo();

        }

    @E("clico em {string} na tela sobre direito à gratuidade")
    public void clicoEmNaTelaSobreDireitoÀGratuidade(String arg0) {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"next_step_button\"]");
    }

    @Então("visualizo apenas a opção de {string} como forma de recebimento do cartão")
    public void visualizoApenasAOpçãoDeComoFormaDeRecebimentoDoCartão(String arg0) {
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"Retirar nas Pernambucanas (grátis)\"])[2]");
    }

    @Dado("que acesso o menu {string} tendo o produto {string} ativo")
    public void queAcessoOMenuTendoOProdutoAtivo(String arg0, String arg1) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("51919740856", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");

    }

    @Quando("submeto a recarga comum informando valor entre {string} e {string}")
    public void submetoARecargaComumInformandoValorEntreE(String arg0, String arg1) throws InterruptedException {
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[contains(@name, \"Cartão Transporte\")]");
        Thread.sleep(4000);
        GestosEmulador.clickCoordenada(100,500);

        Tela.inputNoElemento("//XCUIElementTypeTextField[@name=\"lg_credit_value_input\"]","500");

        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"CONFIRMAR\"]");

    }

    @Dado("que acesso o menu {string} tendo o produto {string} ativo com Cartão de Crédito cadastrado")
    public void queAcessoOMenuTendoOProdutoAtivoComCartãoDeCréditoVálidoCadastrado(String arg0, String arg1) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("016.276.920-29", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,550,"clicar em cartao top na home");
    }

    @E("possuo Cartão de Crédito inválido cadastrado")
    public void possuoCartãoDeCréditoInválidoCadastrado() {
    }

    @E("submeto a compra com cartão de crédito inválido")
    public void submetoACompraComCartãoDeCréditoInválido() throws InterruptedException {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"TROCAR\"]");
        Thread.sleep(3000);
        GestosEmulador.clickCoordenada(180,640);
    }

    @Dado("que acesso o menu {string} tendo o produto {string} ativo com Cartão de Débito cadastrado")
    public void queAcessoOMenuTendoOProdutoAtivoComCartãoDeDébitoCadastrado(String arg0, String arg1) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("016.276.920-29", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");
    }

    @E("submeto a compra com cartão de débito inválido")
    public void submetoACompraComCartãoDeDébitoInválido() throws InterruptedException {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"TROCAR\"]");
        Thread.sleep(3000);
//        GestosEmulador.clickCoordenada(180,711);
        GestosEmulador.clickCoordenada(185,620);

    }

    @Dado("que acesso o menu {string} tendo cartão híbrido ativo com saldo em conta")
    public void queAcessoOMenuTendoCartãoHíbridoAtivoComSaldoEmConta(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("519.197.408-56", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");
    }

    @Dado("que acesso o menu {string} tendo o produto Transporte Escolar ativo e Cartão de Crédito válido cadastrado")
    public void queAcessoOMenuTendoOProdutoTransporteEscolarAtivoECartãoDeCréditoVálidoCadastrado(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("054.540.810-51", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");
    }

    @Quando("submeto a recarga escolar informando valor entre {string} e {string}")
    public void submetoARecargaEscolarInformandoValorEntreE(String arg0, String arg1) throws InterruptedException {
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[contains(@name, \"Cartão Transporte\")]");
        Thread.sleep(3000);
        GestosEmulador.clickCoordenada(100,500);

        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"Escolar\"])[2]");

        Tela.inputNoElemento("//XCUIElementTypeTextField[@name=\"lg_credit_value_input\"]","1000");

        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"CONFIRMAR\"]");

    }

    @Quando("expando o modal de {string}")
    public void expandoOModalDe(String arg0) throws InterruptedException {
            Tela.buscarElementoNaTela("//XCUIElementTypeButton[@name=\"\uE884 Transporte\"]");
            Thread.sleep(3000);
            GestosEmulador.clickCoordenada(196, 400);
            Thread.sleep(2000);
        }

    @E("clico na opção {string} no item {string}")
    public void clicoNaOpçãoNoItem(String arg0, String arg1) {
        GestosEmulador.clickCoordenada(120,607);
    }

    @E("clico na opção {string} no item {string} possuindo escolar")
    public void clicoNaOpçãoNoItemEscolar(String arg0, String arg1) {
        Tela.espera(5000,"espera");
//        Tela.clicarEmElemento("(//XCUIElementTypeOther[contains(@name,\"Saiba mais\")])");
        GestosEmulador.clickCoordenada(120,656);
    }

    @Então("visualizo a tela informativa do benefício {string}")
    public void visualizoATelaInformativaDoBenefício(String arg0) {
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name,\"Escolar\")])");
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name,\"Benefício Escolar\")])");
    }

    @Então("visualizo a tela informativa do benefício sênior")
    public void visualizoATelaInformativaDoBenefíciosenior(String arg0) {
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name,\"Senior\")])");
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name,\"Benefício Senior\")])");
    }

    @Quando("clico na label de {string}")
    public void clicoNaLabelDe(String arg0) throws InterruptedException {
        GestosEmulador.rolarTelaVertical();
        Thread.sleep(2000);
        GestosEmulador.clickCoordenada(200,690);
    }

    @Dado("que acesso o menu {string} tendo o produto {string} ativo e Cartão de Débito válido cadastrado")
    public void queAcessoOMenuTendoOProdutoAtivoECartãoDeDébitoVálidoCadastrado(String arg0, String arg1) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("365.369.350-04", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");
    }

    @Dado("que tendo cartão híbrido ativo com saldo em conta eu habilito o mock do token no perfil")
    public void queTendoCartãoHíbridoAtivoComSaldoEmContaEuHabilitoOMockDoTokenNoPerfil() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("519.197.408-56", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();

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

    @E("acesse o Cartao Top na Home")
    public void acesseOCartaoTopNaHome() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
Home home = new Home(driver);
home.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");


    }

    @Quando("aplico filtros por {string} e {string}")
    public void aplicoFiltrosPorE(String arg0, String arg1) {
        Tela.buscarElementoNaTela("//XCUIElementTypeButton[@name=\"\uE884 Transporte\"]");
        GestosEmulador.clickCoordenada(360,680);
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Filtros\"]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"7 dias\"]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Compra/Recarga\"]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Aplicar filtros\"]");

    }

    @Então("retorno à página inicial de Transporte sendo retornado apenas os registros de histórico correspondentes aos filtros aplicados")
    public void retornoÀPáginaInicialDeTransporteSendoRetornadoApenasOsRegistrosDeHistóricoCorrespondentesAosFiltrosAplicados() {
        Tela.clicarEmElemento("//XCUIElementTypeButton[@name=\"\uE884 Transporte\"]");

    }

    @Dado("que acesso o menu {string} tendo o produto Puro Transporte ativo")
    public void queAcessoOMenuTendoOProdutoPuroTransporteAtivo(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("325.056.645-44", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");


    }

    @E("submeto o cancelamento")
    public void submetoOCancelamento() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Motivo de Cancelamento\"]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Meu Cartão foi danificado\"]");
        Tela.espera(2000);
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Continuar\"]");
        Tela.espera(1000);
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Continuar\"]");
        Tela.espera(2000);
        GestosEmulador.clickCoordenada(200,722);

    }

    @Então("visualizo a tela de {string} com a opção de {string}")
    public void visualizoATelaDeComAOpçãoDe(String arg0, String arg1) {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Cancelamento Enviado\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"Botão principal\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"Botão secundário\"]");
    }

    @Dado("que acesso o menu {string} tendo o produto {string} ativo com {string} liberado")
    public void queAcessoOMenuTendoOProdutoAtivoComLiberado(String arg0, String arg1, String arg2) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("511.684.292-42", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");
    }

    @Dado("que acesso o menu {string} tendo o produto {string} ativo com Sênior liberado")
    public void queAcessoOMenuTendoOProdutoAtivoComSeniorLiberado(String arg0, String arg1) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("799.647.710-88", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");
    }

    @E("cancelo e retorno")
    public void canceloERetorno() {
        GestosEmulador.clickCoordenada(190,790);
        Tela.espera(2000);
        GestosEmulador.clickCoordenada(190,790);
        Tela.espera(5000);
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");
        Tela.espera(5000);
        GestosEmulador.clickCoordenada(291,494);
    }

    @Quando("expando o modal de {string} possuindo escolar")
    public void expandoOModalDePossuindoEscolar(String arg0) throws InterruptedException {
        Tela.buscarElementoNaTela("//XCUIElementTypeButton[@name=\"\uE884 Transporte\"]");
        Thread.sleep(3000);
        GestosEmulador.clickCoordenada(196, 585);
        Thread.sleep(2000);
    }

    @Quando("expando o modal de {string} possuindo senior")
    public void expandoOModalDePossuindoSenior(String arg0) throws InterruptedException {
        Tela.buscarElementoNaTela("//XCUIElementTypeButton[@name=\"\uE884 Transporte\"]");
        Thread.sleep(4000);
        GestosEmulador.clickCoordenada(196, 585,"expandir modal");
        Thread.sleep(2000);
    }

    @Quando("clico na label de Dúvidas sobre seu Benefício Escolar?")
    public void clicoNaLabelDeDúvidasSobreSeuBenefícioEscolar() {
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name,\"Benefício Escolar\")])");
        GestosEmulador.rolarTelaVertical();
            GestosEmulador.clickCoordenada(200,760);
        }

    @Quando("clico no texto {string}")
    public void clicoNoTexto(String arg0) {
        GestosEmulador.rolarTelaVertical();
        GestosEmulador.clickCoordenada(190,776);

    }
    @Quando("clico no texto {string} no Senior")
    public void clicoNoTextonoSenior(String arg0) {
        GestosEmulador.rolarTelaVertical();
        GestosEmulador.clickCoordenada(200,770);

    }

    @Então("sou direcionado para a página do TOP Sênior na Central de Ajuda Autopass")
    public void souDirecionadoParaAPáginaDoTOPSêniorNaCentralDeAjudaAutopass() {
        Tela.buscarElementoNaTela("//XCUIElementTypeTextField[@name=\"TabBarItemTitle\"]");
       if (Tela.getTexto("//XCUIElementTypeTextField[@name=\"TabBarItemTitle\"]").contains("ajuda.boradetop.com.br")){
           System.out.println("http ok");
       }else{
           throw new RuntimeException("link errado");
       }

    }

    @Dado("que acesso o menu {string} tendo o produto {string} ativo com possuo os benefícios {string} e {string}")
    public void queAcessoOMenuTendoOProdutoAtivoComPossuoOsBenefíciosE(String arg0, String arg1, String arg2, String arg3) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("614.258.833-03", "Teste123");

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
        GestosEmulador.clickCoordenada(200,380,"clicar em cartao top na home");


    }

    @Então("visualizo a informação de ambos os benefícios com suas datas de validade")
    public void visualizoAInformaçãoDeAmbosOsBenefíciosComSuasDatasDeValidade() {
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name, 'Senior')])");
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name, 'Escolar Passe Livre')])");
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name, 'VALID.')])");
    }

    @E("clico na opção {string} no item Passe Livre possuindo escolar")
    public void clicoNaOpçãoNoItemPasseLivrePossuindoEscolar(String arg0) {
        Tela.espera(2000);
        GestosEmulador.clickCoordenada(120,657,"saiba mais");

    }

    @Então("visualizo a tela informativa do benefício Sênior")
    public void visualizoATelaInformativaDoBenefícioSênior() {
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name,\"Benefício Senior\")])");
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name,\"Senior\")])");

    }

    @E("clico em Outro valor")
    public void clicoEmOutroValor() throws InterruptedException {
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[@name=\"R$ 0,00 AGORA NÃO R$ 0,60 60 PONTOS R$ 1,00 100 PONTOS R$ 1,50 150 PONTOS OUTRO VALOR Barra de rolagem vertical, 2 páginas\"])[2]/XCUIElementTypeScrollView");
        GestosEmulador.rolarScrollViewHorizontalmente("(//XCUIElementTypeOther[@name=\"R$ 0,00 AGORA NÃO R$ 0,60 60 PONTOS R$ 1,00 100 PONTOS R$ 1,50 150 PONTOS OUTRO VALOR Barra de rolagem vertical, 2 páginas\"])[2]/XCUIElementTypeScrollView");
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"OUTRO VALOR\"])[3]");
    }

    @E("submeto o valor de R${int}")
    public void submetoOValorDeR$(int arg1) {
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[@name=\"Qual valor deseja converter em\n" +
                " pontos supertroco? Adicione valores entre R$ 0,10 e R$ 10,00 Valor Informe o valor desejado CONFIRMAR\"])[3]");
        GestosEmulador.inserirNumero(arg1);
        Tela.espera(200);
        GestosEmulador.clickCoordenada(200,735);
        GestosEmulador.rolarTelaVertical();
    }
}


