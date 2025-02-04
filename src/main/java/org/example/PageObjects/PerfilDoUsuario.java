package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.example.AppiumDriverConfig;
import org.example.GestosEmulador;
import org.openqa.selenium.By;
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
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"\uE88D \uF1BB EDITAR\"]")));

        botaoEditarFoto = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"\uE88D \uF1BB EDITAR\"]");
        botaoEditarFoto.click();
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
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement primeiraFoto = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]")));
        primeiraFoto.click();
        MobileElement confirmarAjuste = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Crop\"]")));
        Thread.sleep(2000);
        confirmarAjuste.click();

    }

    public void buscarPerfilSemFoto() {

    }

    public void alterarApelidoOuNomeSocial() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement inputApelidoNomeSocial = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Digite o Apelido\"]")));
        String nomeAtual = inputApelidoNomeSocial.getText();
        inputApelidoNomeSocial.clear();
        inputApelidoNomeSocial.click();

        if (nomeAtual.equals(apelidoOuNomeSocial[0])) {
            inputApelidoNomeSocial.sendKeys(apelidoOuNomeSocial[1]);
            nomeAtualizado = apelidoOuNomeSocial[1];
        } else {
            inputApelidoNomeSocial.sendKeys(apelidoOuNomeSocial[0]);
            nomeAtualizado = apelidoOuNomeSocial[0];
        }
//        Thread.sleep(2000);
    }

    public void salvarAlteracaoApelidoOuNomeSocial() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement salvarNomeApelido = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='\uE915'][@index='3']")));
        salvarNomeApelido.click();
        System.out.println("cliquei mudar nome");


    }

    public void buscarMensagemAlteracaoApelidoNomeSocial() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        String xpath = "//android.widget.TextView[@text=\"Apelido atualizado com sucesso, " + nomeAtualizado + "!\"]";
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        Thread.sleep(3000);
    }

    public static String getNomeAtualizado() {
        return nomeAtualizado;
    }

    public void buscarSenhaDoAplicativo() {
        senhaDoAplicativo = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Senha do aplicativo\"));"));
    }

    public void clickSenhaDoAplicativo() {
        senhaDoAplicativo.click();
    }


    public void inserirSenhaAtual(String senha) {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement inputSenhaAtual = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Digite a senha atual\"]")));
        inputSenhaAtual.clear();
        inputSenhaAtual.sendKeys(senha);
    }

    public void clickEditarSenha() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement editarSenha = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão EDITAR\"]/android.view.ViewGroup")));
        editarSenha.click();
    }

    public void inserirNovaSenha(String novaSenhaInserida) {
        novaSenha = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Digite a nova senha\"]"));
        novaSenha.clear();
        novaSenha.sendKeys(novaSenhaInserida);
    }

    public void inserirConfirmarNovaSenha(String confirmarNovaSenha) {
        confirmarNovaSenhaInserida = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Digite a nova senha novamente\"]"));
        confirmarNovaSenhaInserida.clear();
        confirmarNovaSenhaInserida.sendKeys(confirmarNovaSenha);
    }

    public void enviarNovaSenha() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement enviarNovaSenha = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão ENVIAR\"]/android.view.ViewGroup")));
        enviarNovaSenha.click();
    }

    public void buscarConfirmacaoSenhaAlteradaSucesso() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        MobileElement confirmarSenhaAlteradaSucesso = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Senha alterada com sucesso\"]")));
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

        botaoSair = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Sair do Aplicativo\"));"));

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Sair do Aplicativo\"]")));
        botaoSair = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Sair do Aplicativo\"]");
        botaoSair.click();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));
        botaoConfirmarSair = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
        botaoConfirmarSair.click();
    }

    public void buscarErroSenhaAtualInvalida() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        MobileElement confirmarSenhaAlteradaSucesso = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Senha atual inválida.\"]")));
    }

    public void buscarMensagemValidacaosenha(String mensagemValidacao) {
        WebDriverWait espera = new WebDriverWait(driver, 15);

        MobileElement confirmarSenhaAlteradaSucesso = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='" + mensagemValidacao + "']")));
    }

    public void buscarSeusTelefoneContato() {
        telefonesContato = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().resourceId(\"Seus telefones de contato\"));"));
    }

    public void clickSeusTelefonesContato() {
        telefonesContato.click();
    }

    public void clicarCelularTransporte() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        MobileElement celularTransporte = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Celular (Transporte)']")));
        celularTransporte.click();
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

    public void clicarCelularCadastroContaDigitalCredito() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        MobileElement celularCadastroContaDigitalCredito = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Celular (Cadastro Conta Digital/Crédito)\"]")));
        celularCadastroContaDigitalCredito.click();
    }

    public void verificarRedirecionamentoWhatsapChatbotPefisa() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.whatsapp:id/conversation_contact_name\"]")));

        MobileElement elemento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.whatsapp:id/conversation_contact_name\"]");

        if (elemento.getText().equals("chatbot Pefisa TOP")) {
            System.out.println(elemento.getText());
        } else {
            throw new AssertionError("Nome do contato não é chatbot Pefisa TOP.");
        }
    }

    public void clicarTermoDeUso() {
        MobileElement termoDeUso = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().resourceId(\"Termos de Uso\"));"));
        termoDeUso.click();
    }

    public void clicaIconeCentralAjuda() {
        MobileElement centralAjuda = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().resourceId(\"Central de Ajuda\"));"));
        centralAjuda.click();
    }

    public void buscarTelaCentralAtendimento() {
        WebDriverWait espera = new WebDriverWait(driver, 15);

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Ajuda\"]")));
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.webkit.WebView[@text=\"Bora de TOP\"]/android.view.View[4]/android.view.View")));
    }
}
