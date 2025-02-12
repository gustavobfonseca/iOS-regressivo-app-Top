package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.example.AppiumDriverConfig;
import org.example.GestosEmulador;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class PerfilDoUsuario {
    private AppiumDriver driver;
    private MobileElement dadosPessoais;
    private MobileElement voltarHome;
    private MobileElement senhaDoAplicativo;
    private MobileElement telefonesContato;
    private MobileElement novaSenha;
    private MobileElement botaoSair;
    private MobileElement botaoConfirmarSair;
    private MobileElement confirmarNovaSenhaInserida;
    private MobileElement menuBiometria;
    private MobileElement botaoEditarFoto;
    private MobileElement botaoTirarFoto;
    private MobileElement tirarFoto;

    private final String[] apelidoOuNomeSocial = new String[]{"Testeap", "V8tech"};
    private static String nomeAtualizado;

    public PerfilDoUsuario(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"DADOS PESSOAIS\"]")));
        voltarHome = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"\uE82F\"])[2]");
    }

    public void clickEditarFoto() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[contains(@name, 'EDITAR')]")));

        GestosEmulador.clickCoordenada(190,295);
//        botaoEditarFoto = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[contains(@name, 'EDITAR')][last()]");
//        botaoEditarFoto.click();
    }

    public void clickBotaoTirarFoto() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        botaoTirarFoto = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Botão para abrir a câmera. Botão para escolher foto da galeria. Botão para fechar o modal ou remover foto.\"])[1]")));

// Código para realizar um toque nas coordenadas (200, 627)
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.tap(PointOption.point(200, 627)).perform();

    }

    public void permitirAcessoCamera() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement permitirAcessoCamera = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.id("OK")));
        permitirAcessoCamera.click();
    }

    public void tirarFoto() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        tirarFoto = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@resource-id=\"com.sec.android.app.camera:id/center_button\"]")));
        tirarFoto.click();
    }

    public void confirmarFoto() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement confirmarFoto = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.sec.android.app.camera:id/navigation_bar_item_small_label_view\" and @text=\"OK\"]")));
        confirmarFoto.click();
        MobileElement confirmarAjuste = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Crop\"]")));
        Thread.sleep(2000);
        confirmarAjuste.click();
    }

    public boolean verificarFotoPerfil() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        System.out.println("ta procurando a foto no perfil");
        try {
            espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"\uF1BB EDITAR\"]")));
            return true;
        }catch (RuntimeException exception){
            System.out.println(exception);
            System.out.println("nao há foto de perfil");
            return false;
        }
    }

    public void voltarHome() {
        voltarHome = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"\uE82F\"])[2]");
        voltarHome.click();
    }


    public void clickBotaoEscolherFoto() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement botaoEscolherFoto = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Botão para abrir a câmera. Botão para escolher foto da galeria. Botão para fechar o modal ou remover foto.\"])[1]")));
//        botaoEscolherFoto.click();
        GestosEmulador.clickCoordenada(210,713);
    }

    public void permitirAcessoGaleria() {
//        WebDriverWait espera = new WebDriverWait(driver, 10);
//        MobileElement permitirAcessoGaleria = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")));
//        permitirAcessoGaleria.click();
        GestosEmulador.clickCoordenada(196,711);
    }

    public void escolherFotoGaleria() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        MobileElement primeiraFoto = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Recents\"]")));
        primeiraFoto.click();
        Tela.clicarEmElemento("//XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther/XCUIElementTypeImage",20);
        Tela.clicarEmElemento("//XCUIElementTypeStaticText[@name=\"Choose\"]",20);
        Thread.sleep(2000);

    }

    public void buscarPerfilSemFoto() {

    }

    public void alterarApelidoOuNomeSocial() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement inputApelidoNomeSocial = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeTextField[@name=\"lg_nickname_input\"]")));
        String nomeAtual = inputApelidoNomeSocial.getText();
        inputApelidoNomeSocial.clear();
        inputApelidoNomeSocial.click();

        if (nomeAtual.equals(apelidoOuNomeSocial[0])) {
            inputApelidoNomeSocial.sendKeys(apelidoOuNomeSocial[1]);
            inputApelidoNomeSocial.sendKeys(Keys.RETURN);
            nomeAtualizado = apelidoOuNomeSocial[1];
        } else {
            inputApelidoNomeSocial.sendKeys(apelidoOuNomeSocial[0]);
            inputApelidoNomeSocial.sendKeys(Keys.RETURN);
            nomeAtualizado = apelidoOuNomeSocial[0];
        }
//        Thread.sleep(2000);
    }

    public void salvarAlteracaoApelidoOuNomeSocial() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement salvarNomeApelido = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"\uE915\"]")));
        salvarNomeApelido.click();
        System.out.println("cliquei mudar nome");


    }

    public void buscarMensagemAlteracaoApelidoNomeSocial() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        String xpath = "//XCUIElementTypeOther[contains(@name, 'Apelido atualizado com sucesso')] ";
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        Thread.sleep(3000);
    }

    public static String getNomeAtualizado() {
        return nomeAtualizado;
    }

    public void buscarSenhaDoAplicativo() {
        GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"Clique para editar a senha\"]");
    }

    public void clickSenhaDoAplicativo() {
Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Clique para editar a senha\"]",20);
    }


    public void inserirSenhaAtual(String senha) {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement inputSenhaAtual = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeSecureTextField[@name=\"lg_password_input\"]")));
        inputSenhaAtual.clear();
        inputSenhaAtual.sendKeys(senha);
        inputSenhaAtual.sendKeys(Keys.RETURN);
    }

    public void clickEditarSenha() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement editarSenha = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Botão EDITAR\"]")));
        editarSenha.click();
    }

    public void inserirNovaSenha(String novaSenhaInserida) {
        novaSenha = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"lg_new_password_input\"]"));
        novaSenha.clear();
        novaSenha.sendKeys(novaSenhaInserida);
        novaSenha.sendKeys(Keys.RETURN);
    }

    public void inserirConfirmarNovaSenha(String confirmarNovaSenha) {
        confirmarNovaSenhaInserida = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"lg_confirm_new_password_input\"]"));
        confirmarNovaSenhaInserida.clear();
        confirmarNovaSenhaInserida.sendKeys(confirmarNovaSenha);
        confirmarNovaSenhaInserida.sendKeys(Keys.RETURN);

    }

    public void enviarNovaSenha() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement enviarNovaSenha = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Botão ENVIAR\"]")));
        enviarNovaSenha.click();
    }

    public void buscarConfirmacaoSenhaAlteradaSucesso() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        MobileElement confirmarSenhaAlteradaSucesso = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[contains(@name, 'Senha alterada com sucesso')]")));
    }

    public void clicarMenuBiometria() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        menuBiometria = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().resourceId(\"Autenticação biométrica\"));"));
        menuBiometria = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text=\"Autenticação biométrica\"]"));
        Thread.sleep(3000);
        menuBiometria.click();
        Thread.sleep(3000);
    }

    public void clicarSair() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        GestosEmulador.rolarTelaVertical();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Sair do Aplicativo\"]")));
        botaoSair = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Sair do Aplicativo\"]");
        botaoSair.click();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Sair\"]")));
        botaoConfirmarSair = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sair\"]");
        botaoConfirmarSair.click();
    }

    public void buscarErroSenhaAtualInvalida() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        MobileElement confirmarSenhaAlteradaSucesso = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[contains(@name, 'Senha atual inválida')]\n")));
    }

    public void buscarMensagemValidacaosenha(String mensagemValidacao) {
        WebDriverWait espera = new WebDriverWait(driver, 15);

        MobileElement confirmarSenhaAlteradaSucesso = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[contains(@name, " + mensagemValidacao + "]")));
    }
    public void buscarMensagemValidacaosenha() {
        WebDriverWait espera = new WebDriverWait(driver, 15);

Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"error_lg_confirm_new_password_input\"]",20);
    }

    public void buscarSeusTelefoneContato() {
        GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"Seus telefones de contato\"]");
    }

    public void clickSeusTelefonesContato() {
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Seus telefones de contato\"]",20);
    }

    public void clicarCelularTransporte() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        MobileElement celularTransporte = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Editar número de mobilidade\"])[2]")));
        MobileElement celularTransportej = (MobileElement) espera.until(ExpectedConditions.elementToBeClickable(By.xpath("(//XCUIElementTypeOther[@name=\"Editar número de mobilidade\"])[2]")));
        celularTransporte.click();
//
//        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Seus telefones de contato\"]",20);
//        Thread.sleep(3000);
//        GestosEmulador.clickCoordenada(200,640);
//        GestosEmulador.clickCoordenada(200,640);
//        GestosEmulador.clickCoordenada(200,640);
    }

    public void verificarRedirecionamentoWhatsapAtendimentoAutopass() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.whatsapp:id/conversation_contact_name\"]")));

        MobileElement elemento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.whatsapp:id/conversation_contact_name\"]");

        if (elemento.getText().equals("Autopass")) {
            System.out.println(elemento.getText());
        } else {
            throw new AssertionError("Nome do contato não é Autopass.");
        }
    }

    public void clicarCelularCadastroContaDigitalCredito() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        MobileElement celularCadastroContaDigitalCredito = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Editar número de mobilidade\"])[2]")));
        MobileElement celularCadastroContaDigitalCreditoo = (MobileElement) espera.until(ExpectedConditions.elementToBeClickable(By.xpath("(//XCUIElementTypeOther[@name=\"Editar número de mobilidade\"])[2]")));
        celularCadastroContaDigitalCredito.click();

//        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Seus telefones de contato\"]",20);
//        Thread.sleep(3000);
//        GestosEmulador.clickCoordenada(200,730);
//        GestosEmulador.clickCoordenada(200,730);
//        GestosEmulador.clickCoordenada(200,730);
    }

    public void verificarRedirecionamentoWhatsapChatbotPefisa() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"OK\"]")));
        Tela.clicarEmElemento("//XCUIElementTypeStaticText[@name=\"OK\"]",20);
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Chatbot Pefisa TOP\"]",20);
    }

    public void clicarTermoDeUso() {
        GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"Termos de Uso\"]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Termos de Uso\"]",10);
    }

    public void clicaIconeCentralAjuda() {
        GestosEmulador.rolarTelaVertical("//XCUIElementTypeOther[@name=\"Central de Ajuda\"]");
        Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"Central de Ajuda\"]",10);
    }

    public void buscarTelaCentralAtendimento() {
        WebDriverWait espera = new WebDriverWait(driver, 15);

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Ajuda\"]")));
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Bora de TOP\"]")));
    }
}
