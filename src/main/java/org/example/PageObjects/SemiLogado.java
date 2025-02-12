package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SemiLogado {
    private AppiumDriver driver;
    private MobileElement inputSenha;
    private MobileElement botaoEntrar;
    private MobileElement linkTrocarDeConta;
    private MobileElement linkEsqueciMinhaSenha;
    private MobileElement iconeVisuSenha;
    private MobileElement mapa;
    private MobileElement bilhete;
    private MobileElement centralDeAjuda;


    public SemiLogado(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() {
            WebDriverWait espera = new WebDriverWait(driver, 50);
            espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeSecureTextField[@name=\"password_login_input\"]")));
            inputSenha = (MobileElement) driver.findElementByXPath("//XCUIElementTypeSecureTextField[@name=\"password_login_input\"]");
            botaoEntrar = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"signin_button\"]");
//            linkEsqueciMinhaSenha = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Esqueci minha senha.\"]");
            mapa = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"\uE989 Mapa das ,\n" +
                    ",Estações\"]");
            bilhete = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"\uE9C1 Bilhetes Offline\"]");
            centralDeAjuda = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Central de,\n" +
                    ",Ajuda\"]");
            linkTrocarDeConta = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[contains(@name, 'Trocar de conta')])[last()]\n");

    }

    public void preencherSenha(String senha) {
        buscarElementos();
        inputSenha.clear();
        inputSenha.sendKeys(senha);
        inputSenha.sendKeys(Keys.RETURN);
    }

    public void preencherSenhaPadrao() {
        inputSenha.sendKeys("Teste123");
        inputSenha.sendKeys(Keys.RETURN);
    }

    public void clicarBotaoEntrar() {

        botaoEntrar.click();
//        WebDriverWait espera = new WebDriverWait(driver, 10);
//        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup")));
//        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup")));
//
//        botaoEntrar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup");
//        botaoEntrar.click();
//        System.out.println("clicar botão de entrar na área semi logada");
    }


    public void buscarMensagemSenhaObrigatoria() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        Thread.sleep(3000);
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("android.widget.TextView[@resource-id=\"error_password_login_input\"]")));
    }

    public MobileElement getLinkEsqueciMinhaSenha() {
        return linkEsqueciMinhaSenha;
    }

    public void clicarMapaEstacao() {
        buscarElementos();
        mapa.click();
    }

    public void buscarMapa() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement mapaEstacao = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeImage")));
    }

    public void clicarBilhetes() {
        buscarElementos();
        bilhete.click();
    }

    public void buscarBilhetes() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Utilizar Bilhetes\"]")));
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"buy_tickets_button\"]")));
    }

    public void trocarDeConta() {
        linkTrocarDeConta.click();
    }

    public void confirmarTrocaDeConta() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Confirmar\"]")));

        MobileElement confirmarTroca = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Confirmar\"]");
        confirmarTroca.click();
    }

    public void clicarCentralAjuda() {
        centralDeAjuda.click();
    }

    public void buscarCentralDeAjuda() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Ajuda\"]")));
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Bora de TOP\"]")));

    }

    public void buscarApelidoNomeSocialModificado() {
        String nomeAtualizado = PerfilDoUsuario.getNomeAtualizado();
        WebDriverWait espera = new WebDriverWait(driver, 30);
        MobileElement apelidoNomeSocial = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[contains(@name, '"+nomeAtualizado+"')]\n")));


    }

    public void buscarSiteTermosUso() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement termoUso = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.android.chrome:id/url_bar\"]")));
        if (termoUso.getText().equals("ajuda.boradetop.com.br/hc/pt-br/articles/15126520483611-Termos-de-Uso-do-Aplicativo-TOP")) {
            System.out.println("url ok");
        }else {
            System.out.println("url não ok");
        }
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
    }
}
