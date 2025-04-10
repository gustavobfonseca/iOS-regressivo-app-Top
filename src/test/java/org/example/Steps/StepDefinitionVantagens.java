package org.example.Steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.*;
import org.example.AppiumDriverConfig;
import org.example.GestosEmulador;
import org.example.PageObjects.Home;
import org.example.PageObjects.Login;
import org.example.PageObjects.Tela;

public class StepDefinitionVantagens {


    @Quando("avanço pelas três etapas do onboarding")
    public void avançoPelasTrêsEtapasDoOnboarding() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Tela tela = new Tela();
        for (int i = 0; i < 2; i++) {
            tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"Botão para próximo passo do onboarding\"])[2]",15);
        }
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Botão ir para a Minu\"]",15);

    }

    @Entao("sou direcionado para a webview da Minu")
    public void souDirecionadoParaAWebviewDaMinu() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Tela tela = new Tela();

        tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"TOP+\"]",20);
    }

    @Quando("clico em {string} na primeira tela do onboarding")
    public void clicoEmNaPrimeiraTelaDoOnboarding(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Tela tela = new Tela();

        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"PULAR\"]",20);
    }

    @Quando("clico em {string} em alguma das telas do onboarding")
    public void clicoEmEmAlgumaDasTelasDoOnboarding(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Tela tela = new Tela();

        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"NÃO MOSTRAR MAIS\"]\n",20);
    }

    @E("fecho a webview da Minu")
    public void fechoAWebviewDaMinu() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Tela tela = new Tela();

        tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"TOP+\"]",20);
        tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"\uE8CF\"])[4]",10);

    }



    @Dado("que acesso o menu {string}")
    public void queAcessoOMenuNaHome(String arg0) throws InterruptedException {

        String scrollView = "//XCUIElementTypeOther[@name=\"Personalizar\n" +
                "Favoritos novidade SuperTOP\n" +
                " TOP+\n" +
                "Recompensas TOP\n" +
                "Saúde Drogaria\n" +
                "São Paulo Barra de rolagem vertical, 1 página\"]/XCUIElementTypeScrollView";
        GestosEmulador.rolarTelaVertical();

        if (arg0.equals("Drogaria São Paulo")) {
            System.out.println(arg0);

            GestosEmulador.rolarScrollViewHorizontalmente(scrollView);
            GestosEmulador.clickCoordenada(314, 420);
        }
        if (arg0.equals("TOP Saúde")) {
            System.out.println(arg0);

            GestosEmulador.rolarScrollViewHorizontalmente(scrollView);
            GestosEmulador.clickCoordenada(160, 418);
        }
        if (arg0.equals("TOP+ Recompensas")) {
            System.out.println(arg0);
            GestosEmulador.clickCoordenada(360, 415);
        }
        if (arg0.equals("Personalizar Favoritos")) {
            System.out.println(arg0);

            GestosEmulador.clickCoordenada(80, 415);
        }
        if (arg0.equals("SuperTOP")) {
            System.out.println(arg0);

            GestosEmulador.clickCoordenada(222, 415);
        }

    }

    @Quando("clico na opção {string}")
    public void clicoNaOpção(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela();
        tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"TOP Saúde\"]",20);

        if (arg0.equals("Ver guia de serviços")) {
            System.out.println(arg0);
            GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"VER GUIA DE SERVIÇOS\"]");
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"VER GUIA DE SERVIÇOS\"]", 10);
        }
        if (arg0.equals("Saiba mais sobre o TOP Saúde")){
            System.out.println(arg0);
            GestosEmulador.rolarTelaVertical("(//XCUIElementTypeOther[@name=\"Saiba mais sobre o TOP Saúde\"])[2]");
            tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"Saiba mais sobre o TOP Saúde\"])[2]", 10);
        }
    }
    @Entao("sou direcionado para a página {string}")
    public void souDirecionadoParaAPágina(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela();

        tela.clicarEmElemento("//XCUIElementTypeTextField[@name=\"TabBarItemTitle\"]\n",30);
        tela.buscarElementoNaTela("//XCUIElementTypeTextField[@name=\"URL\"]",30);

        MobileElement URL = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"URL\"]");

        if(arg0.equalsIgnoreCase("https://guiamedico.avus.com.br")){
            if (URL.getText().equals(arg0)){
                System.out.println("URL certa");
            }else {
                throw new RuntimeException("Redirecionado pra URL incorreta");
            }
        }
        if (arg0.equalsIgnoreCase("https://ajuda.boradetop.com.br/hc/pt-br/sections/16890580100123-TOP-Saúde")){
            if (URL.getText().equals(arg0)){
                System.out.println("URL certa");
            }else {
                throw new RuntimeException("Redirecionado pra URL incorreta");
            }
        }
        if (arg0.equalsIgnoreCase("https://www.drogariasaopaulo.com.br/login")){
            if (URL.getText().equals(arg0)){
                System.out.println("URL certa");
            }else {
                throw new RuntimeException("Redirecionado pra URL incorreta");
            }
        }
        if (arg0.equalsIgnoreCase("https://www.emtu.sp.gov.br/passe/indexregiao.htm")){
            if (URL.getText().equals(arg0)){
                System.out.println("URL certa");
            }else {
                throw new RuntimeException("Redirecionado pra URL incorreta");
            }
        }
        if (arg0.equalsIgnoreCase("https://www.emtu.sp.gov.br/passe/indexregiao.htm")){
            if (URL.getText().equals(arg0)){
                System.out.println("URL certa");
            }else {
                throw new RuntimeException("Redirecionado pra URL incorreta");
            }
        }

    }

    @Quando("clico no botão {string}")
    public void clicoNoBotão(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela();

//        tela.clicarEmElemento("//XCUIElementTypeTextField[@name=\"TabBarItemTitle\"]\n",30);
        if (arg0.equals("Quero Contratar")){
            tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"TOP Saúde\"]",20);
            System.out.println(arg0);
            GestosEmulador.rolarTelaVertical("(//XCUIElementTypeOther[@name=\"Saiba mais sobre o TOP Saúde\"])[1]/XCUIElementTypeOther[2]");
            tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"Saiba mais sobre o TOP Saúde\"])[1]/XCUIElementTypeOther[2]",20);
        }
        if (arg0.equals("Buscar Loja")){
            System.out.println(arg0);
            tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Drogaria São Paulo\"]",20);
            GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"Botão buscar loja\"]");
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Botão buscar loja\"]",10);

        }
        if (arg0.equals("Ir para o site")){
            System.out.println(arg0);
            tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Drogaria São Paulo\"]",20);
            GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"Botão Ir para o site\"]");
            tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Botão Ir para o site\"]",10);

        }
    }

    @Entao("sou direcionado para a webview da Avus")
    public void souDirecionadoParaAWebviewDaAvus() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela();
        tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Escolha seu Plano:\"]",20);

    }

    @Quando("acesso a aba {string}")
    public void acessoAAba(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Tela tela = new Tela();
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"DESCONTO ,\n" +
                ", PELO SITE\"]",20);
    }

    @E("clico em {string}")
    public void clicoEm(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela();
        tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"CONFIRMAR\"]",20);
    }

    @Entao("retorno à Home com a exibição dos menus de Vantagens reordenados de acordo com a minha escolha")
    public void retornoÀHomeComAExibiçãoDosMenusDeVantagensReordenadosDeAcordoComAMinhaEscolha() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        Tela tela = new Tela();

        home.buscarMensagemBemVindo();

        GestosEmulador.clickCoordenada(80, 415);
tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"TOP+ Recompensas\"]",20);
tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"\uE82F\"])[2]",20);

        home.buscarMensagemBemVindo();


    }

    @E("com a opção {string} ao final da lista")
    public void comAOpçãoAoFinalDaLista(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela();

        GestosEmulador.rolarTelaVertical();

        String scrollView = "//XCUIElementTypeOther[@name=\"TOP+\n" +
                "Recompensas novidade SuperTOP\n" +
                " TOP\n" +
                "Saúde Drogaria\n" +
                "São Paulo Personalizar\n" +
                "Favoritos Barra de rolagem vertical, 1 página\"]/XCUIElementTypeScrollView";

        GestosEmulador.rolarScrollViewHorizontalmente(scrollView);
        GestosEmulador.clickCoordenada(313,413);
        tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Favoritos\"]",20);

    }

    @Quando("reordeno a posição dos meus benefícios")
    public void reordenoAPosiçãoDosMeusBenefícios() {
        GestosEmulador.segurarEArrastar("(//XCUIElementTypeOther[@name=\"\uE90C TOP+ RECOMPENSAS 2\"])[3]","(//XCUIElementTypeOther[@name=\"\uE90C SUPERTOP 1\"])[3]");
    }

    @E("seleciono a opção Rotas e Trajetos no modal")
    public void selecionoAOpçãoRotasETrajetosNoModal() {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Rotas e trajetos\"]");
    }

    @E("pulo erro")
    public void puloErro() {
        Tela.clicarEmElemento("//XCUIElementTypeStaticText[@name=\"Dismiss (ESC)\"]");
    }

    @Quando("navego até o final da tela")
    public void navegoAtéOFinalDaTela() {
        GestosEmulador.rolarTelaVertical();
        GestosEmulador.rolarTelaVertical();
    }

    @Então("visualizo o botão Comprar Pontos")
    public void visualizoOBotãoComprarPontos() {
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"COMPRAR PONTOS\"])[4]");
    }

    @E("clico em {string} no modal do SuperTOP")
    public void clicoEmNoModalDoSuperTOP(String arg0) {
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[@name=\"Escolha quantos pontos supertroco deseja comprar e troque por produtos, serviços, doações ou descontos em lojas, restaurantes e streamings, além de concorrer a prêmios em dinheiro semanalmente. É simples: comprando R$ 1,00, você\n" +
                " recebe 100 pontos. A cada compra,\n" +
                " concorra a prêmios de até R$ 500 mil*. *Conheça os benefícios, programa e regulamento VAMOS LÁ!\"])[3]");
        GestosEmulador.clickCoordenada(200,804);
    }

    @E("clico em comprar pontos")
    public void clicoEmComprarPontos() {
        GestosEmulador.rolarTelaVertical("(//XCUIElementTypeOther[@name=\"COMPRAR PONTOS\"])[2]");
//        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"COMPRAR PONTOS\"])[2]");
    }

    @Quando("seleciono a compra de {int} pontos arrastando a barra até o máximo")
    public void selecionoACompraDePontosArrastandoABarraAtéOMáximo(int arg0) {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Comprar pontos\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Deslize para escolher quantos pontos supertroco deseja comprar\"]");

        GestosEmulador.arrastar(62,330,374,330);

        Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"PONTOS 1.000\"]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"CONTINUAR\"]");
    }

    @E("seleciono a opção {int} chance de ganhar até R$ {int} mil")
    public void selecionoAOpçãoChanceDeGanharAtéR$Mil(int arg0, int arg1) {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"1 chance de ganhar até\n" +
                "R$ 500 mil* Concorra a um prêmio maior, com menos chances.\"]");

        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"CONTINUAR PARA PAGAMENTO\"]");
    }

    @Dado("que eu acesso a tela home do aplicativo cpf {string} senha {string}")
    public void queEuAcessoATelaHomeDoAplicativoCpfSenha(String arg0, String arg1) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario(arg0, arg1);
        Home telaHome = new Home(driver);
        telaHome.buscarMensagemBemVindo();
    }

    @Quando("clico em Minhas Transações")
    public void clicoEmMinhasTransações() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"SuperTOP\"]");
        GestosEmulador.clickCoordenada(290,600);
    }

    @Então("visualizo a tela {string} com o botão {string}")
    public void visualizoATelaComOBotão(String arg0, String arg1) {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Minhas Transações\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"COMPRAR PONTOS\"]");
        GestosEmulador.clickCoordenada(180,330);
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"DETALHES DA TRANSAÇÃO\"]");

    }

    @Quando("clico em Sorteios")
    public void clicoEmSorteios() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"SuperTOP\"]");
        GestosEmulador.clickCoordenada(100,700);
    }

    @Então("visualizo o botão Comprar Pontos pelo sorteio")
    public void visualizoOBotãoComprarPontosPeloSorteio() {
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"COMPRAR PONTOS\"]");
    }

    @Quando("clico em Vencedores")
    public void clicoEmVencedores() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"SuperTOP\"]");
        GestosEmulador.clickCoordenada(280,720);
    }

    @Então("visualizo a opção Quero saber mais")
    public void visualizoAOpçãoQueroSaberMais() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"QUERO SABER MAIS\"]");
//        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Vencedores\"]");

    }

    @Quando("seleciono uma das rotas listadas")
    public void selecionoUmaDasRotasListadas() {
        GestosEmulador.clickCoordenada(200,350);

    }

    @E("arrasto o modal para cima")
    public void arrastoOModalParaCima() {
        Tela.espera(3000);
GestosEmulador.arrastar(200,605,200,52);
    }
}
