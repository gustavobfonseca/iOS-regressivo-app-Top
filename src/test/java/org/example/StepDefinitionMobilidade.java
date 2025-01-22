package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.Home;
import org.example.PageObjects.Login;
import org.example.PageObjects.PerfilDoUsuario;
import org.junit.Assert;

public class StepDefinitionMobilidade {

    @Quando("clico na opção \"Mapa das estações\"")
    public void clicoNaOpçãoMapaDasEstações() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.buscarMapa();

    }

    @Quando("clico na opção \"Mobilidade\"")
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
        telaLogin.preencherFormulario("54926406829", "Teste@123");
        MobileElement tela = (MobileElement) driver.findElementByAccessibilityId("Que bom ter você aqui! Confirme seus dados para continuar. \uEA38 CPF Espaço para digitar o cpf  icon_Espaço para digitar o cpf  \uE985 SENHA Espaço para digitar senha \uE91C Esqueci minha senha. env Botão para acessar o aplicativo É novo por aqui?  Crie uma conta.");
        tela.click();
        telaLogin.logar();
        Home telaHome = new Home(driver);

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

        perfilDoUsuario.buscarPerfilSemFoto();
    }

    @E("removida na apresentação da Home")
    public void removidaNaApresentaçãoDaHome() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.buscarFotoDePerfil();
    }


}