package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.*;
import org.example.PageObjects.Home;
import org.example.PageObjects.InserirDadosCartao;
import org.example.PageObjects.Login;
import org.example.PageObjects.Tela;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StepDefinitionBilheteUnico {

    AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    Tela tela = new Tela();

    @Quando("navego ate Bilhete Unico")
    public void selecionoOMotivoDoCancelamentoDoCadastro() throws InterruptedException {
//        tela.clicarEmElemento("//android.widget.TextView[@text=\"Bilhete\n" +
//                "Único\"]", 30);
        tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"\uE9C1 Bilhetes\n" +
                "QR Code \uE884 Cartão\n" +
                "TOP \uEA4F Bilhete\n" +
                "Único \uE989 Mapa das\n" +
                "Estações \uE906 Mobilidade Barra de rolagem vertical, 2 páginas\"]/XCUIElementTypeScrollView",20);
//        Thread.sleep(9000);
        GestosEmulador.clickCoordenada(333,550);
    }


    @Entao("visualizo a tela de onboarding de Bilhete Unico")
    public void visualizoATelaDeOnboardingDeBilheteUnico() {
        MobileElement msgOnboarding = tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Agora você pode recarregar seu Bilhete Único pelo App TOP\"]", 10);
        Assert.assertTrue(msgOnboarding.isDisplayed());
    }

    @E("clico em Cadasrar Bilhete Unico")
    public void clicoEmCadasrarBilheteUnico() {
        tela.buscarElementoNaTela("(//XCUIElementTypeOther[@name=\"CADASTRAR BILHETE ÚNICO\"])[2]",10);

        GestosEmulador.rolarTelaVertical("(//XCUIElementTypeOther[@name=\"CADASTRAR BILHETE ÚNICO\"])[2]");

        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"CADASTRAR BILHETE ÚNICO\"])[2]", 10);
    }

    @E("clico em Onde Encontrar o Numero do Bilhete Unico")
    public void clicoEmOndeEncontrarONumeroDoBilheteUnico() {
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Onde encontrar o número do \n" +
                "Bilhete Único?\"]", 10);
    }

    @Entao("visualizo o modal informativo sobre a localizacao do numero do bilhete")
    public void visualizoOModalInformativoSobreALocalizacaoDoNumeroDoBilhete() {
        MobileElement modalNumeroBilhete = tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Onde encontrar o número do Bilhete Único?\"]", 10);
        Assert.assertTrue(modalNumeroBilhete.isDisplayed());
    }

    @E("submeto as informacoes validas do bilhete")
    public void submetoAsInformacoesValidasDoBilhete(DataTable dataTable) {
        List<Map<String, String>> dados = dataTable.asMaps(String.class, String.class);
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        InserirDadosCartao paginaCartoes = new InserirDadosCartao(driver);
        for (Map<String, String> linha : dados) {
            String numBu = linha.get("numero");
            String apelido = linha.get("apelido");

            tela.inputNoElemento("//XCUIElementTypeTextField[@value=\"0000000000\"]", numBu);
            tela.inputNoElemento("//XCUIElementTypeTextField[@value=\"Ex.: Meu Bilhete Único\"]", apelido);
        }
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"CONTINUAR\"]", 10);
    }

    @Entao("devo visualizar a tela do BU")
    public void devoVisualizarATelaDoBU() {
        MobileElement telaBu = tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"BU Matheus\"]", 10);

        Assert.assertTrue(telaBu.isDisplayed());

    }

    @E("clico em Saiba Mais na tela de BU")
    public void clicoEmSaibaMaisNaTelaDeBU() {
        tela.clicarEmElemento("//XCUIElementTypeStaticText[@name=\"Saber mais\"]", 10);
    }

    @E("clico em adicionar novo cartao")
    public void clicoEmAdicionarNovoCartao() {
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"ADICIONAR NOVO CARTÃO\"])[2]", 10);
    }

//    @Entao("visualizo o numero do novo cartao cadastrado igual a {string}")
//    public void visualizoONumeroDoNovoCartaoCadastradoIgualA(String arg0) {
//        MobileElement numeroBu = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"463114703\"]", 10);
//        Assert.assertTrue(numeroBu.isDisplayed());
//    }

    @Entao("visualizo a tela de bilhetes cadastrados")
    public void visualizoATelaDeBilhetesCadastrados() {
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"VER TODOS OS CARTÕES\"]", 10);

        MobileElement bilhete1 = tela.buscarElementoNaTela("//XCUIElementTypeOther[contains(@label, '556005492')]", 10);
        MobileElement bilhete2 = tela.buscarElementoNaTela("//XCUIElementTypeOther[contains(@label, '463114703')]", 10);

        Assert.assertTrue(bilhete1.isDisplayed() && bilhete2.isDisplayed());
    }

    @Entao("visualizo a tela de bilhetes cadastrados com os {int} bilhetes")
    public void visualizoATelaDeBilhetesCadastradosComOsBilhetes(int arg0) {
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"VER TODOS OS CARTÕES\"]", 10);

        MobileElement bilhete1 = tela.buscarElementoNaTela("//XCUIElementTypeOther[contains(@label, '507755490')]", 10);
        MobileElement bilhete2 = tela.buscarElementoNaTela("//XCUIElementTypeOther[contains(@label, '510356863')]", 10);
        MobileElement bilhete3 = tela.buscarElementoNaTela("//XCUIElementTypeOther[contains(@label, '533727865')]", 10);

        Assert.assertTrue(bilhete1.isDisplayed() && bilhete2.isDisplayed() && bilhete3.isDisplayed());
    }

    @E("o botao de cadastrar bilhete unico inativo")
    public void oBotaoDeCadastrarBilheteUnicoInativo() throws InterruptedException {
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"ADICIONAR NOVO CARTÃO\"])[2]", 10);
        Thread.sleep(1500);
        MobileElement bilhete3 = tela.buscarElementoNaTela("//XCUIElementTypeOther[contains(@label, '510824478')]", 10);
        Assert.assertTrue(bilhete3.isDisplayed());
    }

    @E("excluo o cartao recem cadastrado")
//    public void excluoOCartaoRecemCadastrado() {
//        tela.clicarEmElemento("//android.widget.TextView[@text=\"510824478\"]", 10);
//        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"\uE912 Editar\n" +
//                "Cartão\"]", 20);
//        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"EXCLUIR BILHETE ÚNICO\"]", 20);
//        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"SIM, EXCLUIR\"]", 20);
//    }

    @E("excluo o cartao numero {string} e nome {string}")
    public void excluoOCartaoNumero(String arg0, String arg1) {

        Date dataAtual = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatador.format(dataAtual);

        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"APELIDO DO CARTÃO: "+arg1+" NÚMERO: "+arg0+" Adicionado em "+dataFormatada+" \"]",10);

        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"\uE912 Editar\n" +
                "Cartão\"]", 20);
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"EXCLUIR BILHETE ÚNICO\"]", 20);
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"SIM, EXCLUIR\"]", 20);

    }

    @Entao("visualizo a mensagem de Bilhete Unico ja vinculado ao seu cadastro no campo numero")
    public void visualizoAMensagemDeBilheteUnicoJaVinculadoAoSeuCadastroNoCampoNumero() {
        MobileElement textoConflito = tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Bilhete Único já vinculado ao seu cadastro.\"]", 20);
        Assert.assertTrue(textoConflito.isDisplayed());
    }

    @E("clico no bilhete unico de numero {string}")
    public void clicoNoBilheteUnicoDeNumero(String arg0) {
        tela.clicarEmElemento("//XCUIElementTypeOther[contains(@label, '"+arg0+"')]", 10);
    }

    @E("clico em editar bilhete unico")
    public void clicoEmEditarBilheteUnico() {
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"\uE912 Editar\n" +
                "Cartão\"]", 20);
    }

    @E("altero o apelido do cartao")
    public void alteroOApelidoDoCartao() {
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"\uE912\"])[2]", 10);
        tela.buscarElementoNaTela("//XCUIElementTypeTextField[@value=\"BU Matheus 3\"]", 10);
        MobileElement input = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextField[@value=\"BU Matheus 3\"]");
        input.clear();
        input.sendKeys("MATHEUS ESTUDANTE");
        input.sendKeys(Keys.RETURN);
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"SALVAR ALTERAÇÃO\"]", 10);
    }

    @Entao("visualizo a tela de visualizacao de bilhete com o nome alterado")
    public void visualizoATelaDeVisualizacaoDeBilheteComONomeAlterado() {
        MobileElement bilheteAlterado = tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"MATHEUS ESTUDANTE\"]", 20);
    }

    @E("clico em Recargar")
    public void clicoEmRecargar() {
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"\uEA45 Recarregar\"]", 20);
    }

    @E("clico em Comum")
    public void clicoEmComum() {
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Comum Recarga unitária.\"]", 20);
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"CONTINUAR\"])[2]", 20);
    }

    @E("confirmo um valor entre {int} e {int}")
    public void confirmoUmValorEntreE(int arg0, int arg1) throws InterruptedException {
        Thread.sleep(2000);
        GestosEmulador.clickCoordenada(200,457);
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"CONTINUAR\"])[2]", 20);
    }

    @E("confirmo pix como forma de pagamento para recarga de BU")
    public void confirmoPixComoFormaDePagamentoParaRecargaDeBU() {
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"\uEA4D Pix Copie e cole o código para pagamento\"])[2]", 20);
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"CONTINUAR\"]", 20);
    }

    @Entao("visualizo a tela de codigo pix gerado para recarga de bilhete unico podendo copiar o codigo via icone ou botao Copiar Codigo Pix")
    public void visualizoATelaDeCodigoPixGeradoParaRecargaDeBilheteUnicoPodendoCopiarOCodigoViaIconeOuBotaoCopiarCodigoPix() {
        MobileElement textoRecargaBu = tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Recarga de Bilhete Único\"]", 60);
//        MobileElement iconeCopiarCodigo = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"\uE8F0\"]", 60);
        MobileElement botaoCopiarCodigo = tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"COPIAR CÓDIGO PIX\"]", 60);

        Assert.assertTrue(textoRecargaBu.isDisplayed() && botaoCopiarCodigo.isDisplayed());

    }

    @Entao("visualizo a tela de codigo pix expirado depois de mais de {int} minuto e meio de espera")
    public void visualizoATelaDeCodigoPixExpiradoDepoisDeMaisDeMinutoEMeioDeEspera(int arg0) {
        MobileElement codigoPixExpirado = tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Parece que o tempo para pagamento do código PIX foi excedido. Por favor, realize sua compra novamente.\"]", 180);

        Assert.assertTrue(codigoPixExpirado.isDisplayed());
    }

    @E("clico em Diaria")
    public void clicoEmDiaria() {
        try {
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Diário Até 10 viagens em até 24h.\"]", 3);
        }catch (TimeoutException e){
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Diário Até 10 viagens em até 24h.\"]", 3);
        }

        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"CONTINUAR\"])[2]", 3);

    }

    @E("confirmo a opcao Onibus Metro e Trem")
    public void confirmoAOpcaoOnibusMetroETrem() {
        try {
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Ônibus, Metrô e Trem Até 10 viagens em até 24h. R$ 24,00\"]", 3);
        }catch (TimeoutException e){
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Ônibus, Metrô e Trem Até 10 viagens a cada até 24h,\n" +
                    "por 31 dias. R$ 362,00\"]", 3);
        }
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"CONTINUAR\"])[2]", 20);
    }

    @E("confirmo o numero de cotas entre {int} e {int}")
    public void confirmoONumeroDeCotasEntreE(int arg0, int arg1) {
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"CONTINUAR\"])[2]", 20);
    }

    @E("confirmo a opcao Metro e Trem")
    public void confirmoAOpcaoMetroETrem() {
        try {
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Metrô e Trem Até 10 viagens em até 24h. R$ 19,00\"]", 3);
        }catch (TimeoutException e){
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Metrô e Trem Até 10 viagens a cada até 24h,\n" +
                    "por 31 dias. R$ 243,00\"]",3);
        }
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"CONTINUAR\"])[2]", 20);

    }

    @E("confirmo a opcao onibus")
    public void confirmoAOpcaoOnibus() {
        try {
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Ônibus Até 10 viagens em até 24h. R$ 16,80\"]", 3);
        }catch (TimeoutException e){
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Ônibus Até 10 viagens a cada até 24h,\n" +
                    "por 31 dias. R$ 213,80\"]",3);
        }
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"CONTINUAR\"])[2]", 20);
    }

    @E("clico em Mensal")
    public void clicoEmMensal() {
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Mensal Até 10 viagens a cada 24h, por 31 dias.\"]", 20);
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"CONTINUAR\"])[2]", 20);

    }

    @Entao("não devo visualizar o cartão numero {string} e o nome {string} na lista de cartoes")
    public void nãoDevoVisualizarOCartãoNumeroNaListaDeCartoes(String arg0, String arg1) throws InterruptedException {
        Thread.sleep(3000);
        Date dataAtual = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatador.format(dataAtual);

        List cartaoExcluido = driver.findElementsByXPath("//XCUIElementTypeOther[@name=\"APELIDO DO CARTÃO: "+arg1+" NÚMERO: "+arg0+" Adicionado em "+dataFormatada+"\"]");
        Assert.assertTrue(cartaoExcluido.isEmpty());
    }

    @E("excluo o único cartao cadastrado")
    public void excluoOÚnicoCartaoCadastrado() {
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"\uE912 Editar\n" +
                "Cartão\"]",10);
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"EXCLUIR BILHETE ÚNICO\"]", 20);
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"SIM, EXCLUIR\"]", 20);
    }

    @Então("visualizo a tela de - Você não possui nenhum bilhete único cadastrado.")
    public void visualizoATelaDeVocêNãoPossuiNenhumBilheteÚnicoCadastrado() {
        tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"ADICIONAR NOVO CARTÃO\"]", 30);

        MobileElement mensagemNenhumBu = tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Você não possui nenhum\n" +
                "Bilhete Único Cadastrado.\"]", 20);
        MobileElement botaoAdicionarCartao = tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"ADICIONAR NOVO CARTÃO\"]", 20);

        Assert.assertTrue(mensagemNenhumBu.isDisplayed() && botaoAdicionarCartao.isDisplayed());
    }

    @Entao("visualizo a mensagem de \"Bilhete único já está vinculado a outro perfil.” No campo Número")
    public void visualizoAMensagemDeBilheteÚnicoJáEstáVinculadoAOutroPerfilNoCampoNúmero() throws Throwable {
        MobileElement textoConflito = tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Bilhete Único já está vinculado a outro perfil.\"]", 20);
        Assert.assertTrue(textoConflito.isDisplayed());
    }

    @Entao("visualizo o modal de Como Validar Sua Recarga?")
    public void visualizoOModalDeComoValidarSuaRecarga() {
        tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Como validar a recarga?\"]",20);
        tela.buscarElementoNaTela("(//XCUIElementTypeOther[@name=\"ENTENDI\"])[2]",20);
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"ENTENDI\"])[2]",3);
    }

    @E("clico no bilhete unico de numero {string} e nome {string}")
    public void clicoNoBilheteUnicoDeNumeroENome(String arg0, String arg1) {
        Date dataAtual = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatador.format(dataAtual);

        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"APELIDO DO CARTÃO: "+arg1+" NÚMERO: "+arg0+" Adicionado em "+dataFormatada+" \"]",10);
    }

    @E("clico na opção {string} na vitrine de Puro Transporte")
    public void clicoNaOpçãoNaVitrineDePuroTransporte(String arg0) throws InterruptedException {
    GestosEmulador.rolarTelaVertical();
    Thread.sleep(2000);
    GestosEmulador.clickCoordenada(197,773,"eu quero");
    }

    @Dado("que acesso o app com uma conta nova")
    public void queAcessoOAppComUmaContaNova() throws Exception {
        String senha = "Teste123";
        String cpf = PostUser.criarUser(senha,19);

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);


        telaLogin.buscarElementos();
        telaLogin.preencherFormulario(cpf, senha);

        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();

    }

    @Quando("clico no botão Comunicar Perda Roubo")
    public void clicoNoBotãoComunicarPerdaRoubo() {
//        Tela.buscarElementoNaTela("//XCUIElementTypeButton[@name=\"\uE884 Transporte\"]");
//        GestosEmulador.clickCoordenada(360,580);
        Tela.espera(3000);
        GestosEmulador.arrastar(200,54,200,500);
        GestosEmulador.clickCoordenada(291,494);
    }

    @E("clico em Prosseguir com o cancelamento")
    public void clicoEmProsseguirComOCancelamento() {
        GestosEmulador.rolarTelaVertical();
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Prosseguir com o cancelamento\"]");
    }

    @Então("sou direcionado para o chatbot da Pefisa via WhatsApp")
    public void souDirecionadoParaOChatbotDaPefisaViaWhatsApp() {
        Tela.buscarElementoNaTela("//XCUIElementTypeTextField[@name=\"TabBarItemTitle\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Chatbot Pefisa TOP\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Iniciar conversa\"]");


    }
}