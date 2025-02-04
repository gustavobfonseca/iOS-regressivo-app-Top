package org.example.PageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.example.GestosEmulador;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class Home {
    private AppiumDriver driver;
    private MobileElement msgBoaViagem;
    private MobileElement botaoBiometria;
    private MobileElement botaoSair;
    private MobileElement botaoConfirmarSair;
    private MobileElement botaoNaoAtivarBiometria;
    private MobileElement botaoBilhetes;
    private MobileElement botaoModalQueroConhecer;
    private PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    private MobileElement modal;
    private MobileElement fotoDePerfil;
    private MobileElement textoDadosPessoais;
    private MobileElement textoMockTokenGemalto;
    private MobileElement botaoTogleMockTokenGemalto;
    private MobileElement botaoCartaoTop;
    private MobileElement iconePerfil;
    private MobileElement menuBiometria;
    private MobileElement campoSenhaDoAplicativo;
    private MobileElement senhaAtualRedefinir;
    private MobileElement botaoEditarSenha;
    private MobileElement senhaNovaRedefinir;
    private MobileElement confirmarSenhaNovaRedefinir;
    private MobileElement botaoEnviarRedefinirSenha;
    private MobileElement fotoDePerfilAdicionada;


    public Home(AppiumDriver driver) {
        this.driver = driver;
    }

    public void perfilPelaApresentacao() {
        MobileElement apresentacao = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[contains(@name, 'Tenha uma boa viagem')]");
        apresentacao.click();
    }

    public void buscarFotoDePerfilAdicionada() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView")));
    }

    public void buscarFotoDePerfil() {
        WebDriverWait espera = new WebDriverWait(driver, 40);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]")));

        fotoDePerfil = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]");
    }

    public void esperarBotaoBiometria() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para ativar biometria.\"]/android.view.ViewGroup")));
        botaoBiometria = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@resource-id=\"Botão para ativar biometria.\"]/android.view.ViewGroup");
        botaoBiometria.click();
//        botaoNaoAtivarBiometria = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@resource-id=\"Botão para não ativar biometria.\"]/android.view.ViewGroup");

    }

    public void redefinirSenhaPeloPerfil() throws InterruptedException {
        clicarIconePerfil();
        clicarPerfilSenhaDoAplicativo();
        redefinirSenha("Teste1234", "Teste123", "Teste123");

    }

    public void redefinirSenha(String senhaAtual, String novaSenha, String confirmaSenha) throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("lg_password_input")));
        senhaAtualRedefinir = (MobileElement) driver.findElementByAccessibilityId("lg_password_input");
        senhaAtualRedefinir.sendKeys(senhaAtual);
        botaoEditarSenha = (MobileElement) driver.findElementByAccessibilityId("Botão EDITAR");
        botaoEditarSenha.click();
        Thread.sleep(1000);
        senhaNovaRedefinir = (MobileElement) driver.findElementByAccessibilityId("lg_new_password_input");
        confirmarSenhaNovaRedefinir = (MobileElement) driver.findElementByAccessibilityId("lg_confirm_new_password_input");
        senhaNovaRedefinir.sendKeys(novaSenha);
        confirmarSenhaNovaRedefinir.sendKeys(confirmaSenha);
        Thread.sleep(1000);
        botaoEnviarRedefinirSenha = (MobileElement) driver.findElementByAccessibilityId("Botão ENVIAR");
        botaoEnviarRedefinirSenha.click();

        WebDriverWait espera2 = new WebDriverWait(driver, 60);
        espera2.until(ExpectedConditions.presenceOfElementLocated(By.id("Clique para editar a senha")));


    }


//    public void clicarBotaoAtivarBiometria() throws InterruptedException {
//        botaoBiometria.click();
//    }

    public void clicarBotaoNaoAtivarBiometria() {
        botaoNaoAtivarBiometria.click();
    }

    public void clicarFotoDePerfil() {
        GestosEmulador.clickCoordenada(280,170);
//        fotoDePerfil.click();
    }

    public void buscarModal() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"\uE88D Tem novidade no seu perfil! Notou que sua foto está diferente? Agora você é membro do TOP+ Recompensas,\n" +
                "o clube que te dá vantagens em compras e serviços, além de conteúdos gratuitos.\n" +
                "\n" +
                "Sempre que quiser acessar, toque em\n" +
                "Vantagens e depois em TOP+. Botão de navegação tela de vantagens.\"])[1]")));

        modal = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"\uE88D Tem novidade no seu perfil! Notou que sua foto está diferente? Agora você é membro do TOP+ Recompensas,\n" +
                "o clube que te dá vantagens em compras e serviços, além de conteúdos gratuitos.\n" +
                "\n" +
                "Sempre que quiser acessar, toque em\n" +
                "Vantagens e depois em TOP+. Botão de navegação tela de vantagens.\"])[1]");

        System.out.println("achou o modal");
    }

    public void buscarMensagemBemVindo() {
        WebDriverWait espera = new WebDriverWait(driver, 60);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("Transporte")));
        msgBoaViagem = (MobileElement) driver.findElementByAccessibilityId("Transporte");
    }

    // Método para clicar no botão "Não ativar biometria"
    public void clicaBotaoNaoAtivarBiometria() {
        try {
            MobileElement botaoNaoAtivarBiometria =(MobileElement) driver.findElement(By.id("botao_nao_ativar_biometria_id")); // Altere pelo ID correto
            botaoNaoAtivarBiometria.click();
            System.out.println("Botão 'Não ativar biometria' clicado com sucesso.");
        } catch (NoSuchElementException e) {
            System.out.println("Botão 'Não ativar biometria' não encontrado: " + e.getMessage());
        }
    }

    // Método para clicar no botão "Sair"
    public void clicaBotaoSair() {
        try {
            MobileElement botaoSair = (MobileElement)driver.findElement(By.id("botao_sair_id")); // Altere pelo ID correto
            botaoSair.click();
            System.out.println("Botão 'Sair' clicado com sucesso.");
        } catch (NoSuchElementException e) {
            System.out.println("Botão 'Sair' não encontrado: " + e.getMessage());
        }
    }

    // Método para confirmar a saída do aplicativo
    public void clicaBotaoConfirmarSair() {
        try {
            MobileElement botaoConfirmarSair =(MobileElement) driver.findElement(By.id("botao_confirmar_sair_id")); // Altere pelo ID correto
            botaoConfirmarSair.click();
            System.out.println("Botão 'Confirmar Sair' clicado com sucesso.");
        } catch (NoSuchElementException e) {
            System.out.println("Botão 'Confirmar Sair' não encontrado: " + e.getMessage());
        }
    }


    public void arrastarModalParaBaixo() throws InterruptedException {
        buscarModal();

            driver.executeScript("mobile: swipe", ImmutableMap.of(
                    "direction", "down",
                    "startX", 200,
                    "startY", 409,
                    "endX", 200,
                    "endY", 844
            ));


        Thread.sleep(500);
    }

    public void scrolAteOpcaoMock() throws InterruptedException {
        try {
            WebDriverWait espera = new WebDriverWait(driver, 10);
            espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"DADOS PESSOAIS\"]")));
        }catch (TimeoutException e){
            System.out.println("nao carregou a página");
//            MobileElement tentarNovamente = (MobileElement) driver.findElementById("TENTAR NOVAMENTE");
//            tentarNovamente.click();
            GestosEmulador.clickCoordenada(200,700);
            WebDriverWait espera = new WebDriverWait(driver, 20);
            espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"DADOS PESSOAIS\"]")));
        }
//        textoMockTokenGemalto = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Mock gemalto token\"));"));
            GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"Mock gemalto token\"]");

            botaoTogleMockTokenGemalto = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Mock gemalto token\"]");
    }

    public void clicarBotaoMockTokenGemalto() {
        botaoTogleMockTokenGemalto.click();
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void buscarBotaoBilhetes() {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Bilhetes\\nQR Code\"]")));

        botaoBilhetes = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Bilhetes\\nQR Code\"]");
    }

    public void buscarBotaoCartaoTop() {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Bilhetes\\nQR Code\"]\n")));

        botaoCartaoTop = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Bilhetes\\nQR Code\"]\n");
    }

    public void clicarBotaoCartaoTop() {
        botaoCartaoTop.click();
    }

    public void clicarBotaoBilhetes() {
        GestosEmulador.clickCoordenada(40,540);
    }

    public void clicarIconePerfil() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"\uEA27\"])[2]")));
        iconePerfil = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"\uEA27\"])[2]");
        iconePerfil.click();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("DADOS PESSOAIS")));
    }

    public void clicarPerfilSenhaDoAplicativo() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("DADOS PESSOAIS")));

        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("predicateString", "label == 'Clique para editar a senha'");
        driver.executeScript("mobile: scroll", scrollObject);

        campoSenhaDoAplicativo = (MobileElement) driver.findElementByAccessibilityId("Clique para editar a senha");
        campoSenhaDoAplicativo.click();
    }

    public void clicarBotaoModalQueroConhecer() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        By botaoModalQueroConhecerLocator = By.xpath("//android.view.ViewGroup[@content-desc=\"Botão de navegação tela de vantagens.\"]/android.view.ViewGroup");

        try {
            espera.until(ExpectedConditions.presenceOfElementLocated(botaoModalQueroConhecerLocator));
            MobileElement botaoModalQueroConhecer = (MobileElement) driver.findElement(botaoModalQueroConhecerLocator);
            botaoModalQueroConhecer.click();
            Thread.sleep(2000);
            driver.navigate().back();
            buscarMensagemBemVindo();
        } catch (TimeoutException e) {
            buscarMensagemBemVindo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public MobileElement getMsgBoaViagem() {
        return msgBoaViagem;
    }

    public PointerInput getFinger() {
        return finger;
    }

    public MobileElement getModal() {
        return modal;
    }

    public void clicarSair() {
        WebDriverWait espera = new WebDriverWait(driver, 10);

        botaoSair = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Sair do Aplicativo\"));"));

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Sair do Aplicativo\"]")));
        botaoSair = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Sair do Aplicativo\"]");
        botaoSair.click();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));
        botaoConfirmarSair = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
        botaoConfirmarSair.click();
    }

    public void deslogar() {
        clicarIconePerfil();
        clicarSair();
    }

    public void desativarBiometria() throws InterruptedException {
        clicarIconePerfil();
        clicarMenuBiometria();
        clicarSair();
    }

    public void clicarMenuBiometria() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        menuBiometria = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().resourceId(\"Autenticação biométrica\"));"));

        menuBiometria = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text=\"Autenticação biométrica\"]"));
        Thread.sleep(3000);
        menuBiometria.click();
        Thread.sleep(3000);
    }

    public void rolarScrollViewHorizontalmente() throws InterruptedException {
        MobileElement scrollView =(MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\" Bilhetes\nQR Code  Cartão\nTOP  Bilhete\nÚnico  Mapa das\nEstações  Mobilidade Barra de rolagem vertical, 2 páginas\"]/XCUIElementTypeScrollView");

        // Rolar da direita para a esquerda
        driver.executeScript("mobile: swipe", ImmutableMap.of(
                "element", ((RemoteWebElement) scrollView).getId(),
                "direction", "left"
        ));

        Thread.sleep(500);
    }


    public void clickCoordenada(int x, int y) {
        System.out.println("Clicar no ponto: (" + x + ", " + y + ")");
        Map<String, Object> params = new HashMap<>();
        params.put("x", x);
        params.put("y", y);
        driver.executeScript("mobile: tap", params); // Comando para executar o tap nas coordenadas
    }


    public void buscarMapa() {
        try {
            rolarScrollViewHorizontalmente();
            Thread.sleep(1000);
            clickCoordenada(167,546);
        }catch (Exception e){
            System.out.println("erro");
        }

    }

    public void buscarMobilidade() {
        try {
            rolarScrollViewHorizontalmente();
            Thread.sleep(1000);
            clickCoordenada(320,546);
        }catch (Exception e){
            System.out.println("erro");
        }

    }

    public void buscarDisponivelEmBreve() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Mobilidade\"]")));
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("Disponível em breve")));
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("Estamos trabalhando para oferecer a melhor experiência possível, e logo essa funcionalidade estará de volta.")));
       MobileElement home=(MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"botão voltar para home\"])[2]")));
       home.click();
    }

    public void buscarApelidoNomeSocialModificado() {
        String nomeAtualizado = PerfilDoUsuario.getNomeAtualizado();
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement apelidoNomeSocial = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Olá, " + nomeAtualizado + "!\"]")));


    }
}
