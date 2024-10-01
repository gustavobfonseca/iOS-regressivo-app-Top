package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
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
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Nome do titular\"]")));

        this.inputNomeCartao = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Nome do titular\"]");
        this.inputNumeroCartao = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Número do Cartão\"]");
        this.inputValidadeCartao = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Validade\"]");
        this.inputCvvCartao = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"CVV do Cartão\"]");
        this.inputCpfTitular = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Digite o CPF do titular\"]");
        this.botaoConfirmar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"botão confirmar\"]");

    }

    public void preencherFormularioCadastroCartao(String nomeNoCartao, String numeroCartao, String validadeCartao, String cvvCartao, String cpfTitular){
        inputNomeCartao.sendKeys(nomeNoCartao);
        inputNumeroCartao.sendKeys(numeroCartao);
        inputValidadeCartao.sendKeys(validadeCartao);
        inputCvvCartao.sendKeys(cvvCartao);
        inputCpfTitular.sendKeys(cpfTitular);
        botaoConfirmar.click();
    }
}
