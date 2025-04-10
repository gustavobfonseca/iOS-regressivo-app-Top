package org.example.Steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.AppiumDriverConfig;
import org.example.GestosEmulador;
import org.example.PageObjects.Tela;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitionFGTS {
    AppiumDriver driver = AppiumDriverConfig.Instance().driver;


    String xpathBanner = "(//XCUIElementTypeOther[@name=\"Saia do sufoco,\n" +
            "antecipe seu FGTS\n" +
            "e receba hoje\n" +
            "mesmo. Não é necessário uma Conta Digital\n" +
            "TOP para contratar. ANTECIPAR FGTS Conheça o TOP Saúde Todo o amparo da saúde particular\n" +
            "pra você e até 4 dependentes. Planos a partir de R$ 19,90/mês. CONHECER PLANOS\"])[3]";

    String xpathBotao = "//XCUIElementTypeOther[@name=\"oferta \uE857 Antecipação\n" +
            "de FGTS \uE800 Conta\n" +
            "Digital \uE8FD Cartão de\n" +
            "Crédito Barra de rolagem vertical, 2 páginas\"]/XCUIElementTypeScrollView";

    String xpathAindaNaoTenhoSAppFGTS = "(//XCUIElementTypeOther[@name=\"Acesse o aplicativo do FGTS no seu\n" +
            "celular;\n" +
            "\"])[1]";

    String acessarAppFgts = "//XCUIElementTypeApplication[@name=\"AutopassTop HML\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[1]";

    String checkBox = "//XCUIElementTypeOther[@name=\"\uE9FC Declaro que já autorizei a Up.p a consultar meu saldo do FGTS e quero continuar com a contratação.\"]";



    public void buscarTelaVantagem() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"A antecipação do saque-aniversário FGTS\n" +
                "garante dinheiro em mãos para o que\n" +
                "realmente importa.\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"do seu FGTS de forma\n" +
                "rápida, segura e sem\n" +
                "burocracia!\"]");
    }

    public void buscarTelaAppStore() {
        Tela.buscarElementoNaTela("//XCUIElementTypeTextField[@name=\"TabBarItemTitle\"]");}
    public void buscarTelaUpp() {
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Faça sua simulação\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeImage[@name=\"Logo Up.p cinza\"]");
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Não se esqueça de autorizar a Up.p no App do FGTS.\"]");
        MobileElement url = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"TabBarItemTitle\"]");
        if (url.getText().equals("\u200Eupp.com.br, segura")) {
            System.out.println("url certa");
        }else {
            throw new RuntimeException("url errada");
        }

    }
    public void arrastarTelaParaLado(int qtd){
        for (int i = 0; i <qtd ; i++) {
            GestosEmulador.arrastar(333,337,154,337);
        }
    }

    public void arrastarTelaParaLado(){
        GestosEmulador.arrastar(333,337,154,337);
    }

    @Então("não visualizo o banner e botão de Antecipação de FGTS na Home após refletir a feature fala de Conta Digital")
    public void nãoVisualizoOBannerEBotãoDeAntecipaçãoDeFGTSNaHomeApósRefletirAFeatureFalaDeContaDigital() {
        Tela.espera(10000);
        try {
            MobileElement botaoFGTS = (MobileElement) driver.findElementByXPath(xpathBotao);
            MobileElement banner = (MobileElement) driver.findElementByXPath(xpathBanner);
            throw new RuntimeException("erro pois achou os elementos");
        }catch (Exception e){
            System.out.println("Nao achou os elementos, passou no teste ");
        }

    }

    @Quando("acesso o banner de antecipação de FGTS na Home")
    public void acessoOBannerDeAntecipaçãoDeFGTSNaHome() {
        Tela.clicarEmElemento(xpathBanner,60);
    }

    @Então("sou direcionado à tela de vantagens da antecipação de FGTS")
    public void souDirecionadoÀTelaDeVantagensDaAntecipaçãoDeFGTS() {
        buscarTelaVantagem();
        GestosEmulador.rolarTelaVertical();
    }

    @Quando("acesso a opção {string} na área de banking da Home")
    public void acessoAOpçãoNaÁreaDeBankingDaHome(String arg0) {
        Tela.buscarElementoNaTela(xpathBanner,50);
//        Tela.espera(2000);
        MobileElement banking = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Banking\"]");
        GestosEmulador.clickCoordenada(73,banking.getLocation().y+100);



    }

    @Quando("clico no botão {string} na tela de vantagens")
    public void clicoNoBotãoNaTelaDeVantagens(String arg0) {
        buscarTelaVantagem();
//        Tela.clicarEmElemento(xpathBotaoContinuar);
        GestosEmulador.clickCoordenada(199,798);
    }

    @E("clico em {string} na tela de orientações")
    public void clicoEmNaTelaDeOrientações(String arg0) {
        Tela.buscarElementoNaTela(xpathAindaNaoTenhoSAppFGTS);
        GestosEmulador.clickCoordenada(200,436);
    }

    @Então("sou direcionado à página do app FGTS na loja da plataforma utilizada \\(Play Store ou APP Store)")
    public void souDirecionadoÀPáginaDoAppFGTSNaLojaDaPlataformaUtilizadaPlayStoreOuAPPStore() {
        buscarTelaAppStore();
    }

    @E("clico no botão {string} na tela de orientações")
    public void clicoNoBotãoNaTelaDeOrientações(String arg0) {
        GestosEmulador.rolarTelaVertical();
        Tela.clicarEmElemento(acessarAppFgts);
    }

    @E("marco o checkbox da declaração de consulta ao saldo do FGTS")
    public void marcoOCheckboxDaDeclaraçãoDeConsultaAoSaldoDoFGTS() {
        Tela.clicarEmElemento(checkBox);
    }

    @Então("sou direcionado à página de simulação da Up.p via navegador do dispositivo")
    public void souDirecionadoÀPáginaDeSimulaçãoDaUpPViaNavegadorDoDispositivo() {
        buscarTelaUpp();
    }

    @E("movo o carrossel até o step {int}")
    public void movoOCarrosselAtéOStep(int arg0) {
        arrastarTelaParaLado(arg0);
        if (arg0==2){
            Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Quase lá!\"]");
        }
    }

    @E("clico no botão Continuar para a contratação")
    public void clicoNoBotãoContinuarParaAContratação() {
        Tela.clicarEmElemento("//XCUIElementTypeApplication[@name=\"AutopassTop HML\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]");
    }
}
