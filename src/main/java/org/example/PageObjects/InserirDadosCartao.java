package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InserirDadosCartao {
    private AppiumDriver driver;
    private MobileElement inputNomeCartao;
    private MobileElement inputNumeroCartao;
    private MobileElement inputValidadeCartao;
    private MobileElement inputCvvCartao;
    private MobileElement inputCpfTitular;
    private MobileElement botaoConfirmar;

    public InserirDadosCartao(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeTextField[@name=\"nome_no_cartao\"]")));

        this.inputNomeCartao = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"nome_no_cartao\"]");
        this.inputNumeroCartao = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"numero_do_cartao\"]");
        this.inputValidadeCartao = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"validade_do_cartão\"]");
        this.inputCvvCartao = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"cvv_do_cartão\"]");
        this.inputCpfTitular = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"cpf_input\"]");
        this.botaoConfirmar = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"botão confirmar\"]");

    }

    public void preencherFormularioCadastroCartao(String nomeNoCartao, String numeroCartao, String validadeCartao, String cvvCartao, String cpfTitular){
        inputNomeCartao.sendKeys(nomeNoCartao);
        inputNumeroCartao.sendKeys(numeroCartao);
        inputValidadeCartao.sendKeys(validadeCartao);
        inputCvvCartao.sendKeys(cvvCartao);
        inputCpfTitular.sendKeys(cpfTitular);
        inputCpfTitular.sendKeys(Keys.RETURN);
        botaoConfirmar.click();
    }
}
