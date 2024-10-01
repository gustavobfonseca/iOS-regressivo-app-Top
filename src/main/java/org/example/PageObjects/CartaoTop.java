package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartaoTop {

    private AppiumDriver driver;
    private MobileElement botaoComprarCreditos;
    private MobileElement botaoComum;
    private MobileElement botaoComprarTela2;
    private MobileElement botaoCartaoDeCredito;
    private MobileElement botaoConfirmarTela3;
    private MobileElement botaoCartaoDeDebito;
    private MobileElement inputValorCredito;
    private MobileElement botaoEscolar;
    private MobileElement botaoPix;
    private MobileElement textoCopiarCodigoPix;
    private MobileElement botaoExpandirModalSaldo;
    private MobileElement botaoSaibaMaisEscolar;
    private MobileElement textoBeneficioEscolar;

    public CartaoTop(AppiumDriver driver){
        this.driver = driver;
    }

    //Tela 1 cartão top
    public void buscarBotaoComprarCreditos(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Comprar \n" +
                "Créditos\"]")));

        botaoComprarCreditos = (MobileElement) driver.findElementByXPath("//*[@text=\"Comprar \n" +
                "Créditos\"]");
    }

    public void buscarBotaoExpandirModalSaldo(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"\uE8B4\"]")));

        botaoExpandirModalSaldo = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"\uE8B4\"]");
    }

    public void buscarSaibaMaisEscolar(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Saiba mais\"]")));

        botaoSaibaMaisEscolar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Saiba mais\"]");
    }

    //Tela 2 cartão TOP
    public void buscarBotaoComum(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Comum\"]")));

        botaoComum = (MobileElement) driver.findElementByXPath("//*[@text=\"Comum\"]");
    }

    public void buscarBotaoEscolar(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Escolar\"]")));

        botaoEscolar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Escolar\"]");

    }

    public void inputarValorDeCredito(String credito){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=\"COMPRAR\"]")));

        inputValorCredito = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Informe o valor de crédito desejado\"]");
        inputValorCredito.sendKeys(credito);
        //driver.getKeyboard().sendKeys("400");
    }

    public void inputarValorDeCreditoEscolar(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=\"COMPRAR\"]")));

        inputValorCredito = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Informe o valor de crédito desejado\"]");
        inputValorCredito.sendKeys("1000");
        //driver.getKeyboard().sendKeys("400");
    }

    public void buscarBotaoComprarTela2(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=\"COMPRAR\"]")));

        botaoComprarTela2 = (MobileElement) driver.findElementByXPath("//*[@content-desc=\"COMPRAR\"]");

    }

    public void buscarTelaInformativoMeiaTarifa(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Benefício Escolar (,Meia Tarifa,)\"]")));

        textoBeneficioEscolar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Benefício Escolar (,Meia Tarifa,)\"]");

    }

    //Tela 3
    public void buscarBotaoCartaoDeCredito(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Cartão de Crédito\"]")));

        botaoCartaoDeCredito = (MobileElement) driver.findElementByXPath("//*[@text=\"Cartão de Crédito\"]");
    }

    public void buscarBotaoConfirmarTela3(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=\"CONFIRMAR\"]")));

        botaoConfirmarTela3 = (MobileElement) driver.findElementByXPath("//*[@content-desc=\"CONFIRMAR\"]");

    }

    public void buscarBotaoCartaoDeDebito(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Cartão de Débito\"]")));

        botaoCartaoDeDebito = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Cartão de Débito\"]");
    }

    public void buscarOpcaoPix(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Pix\"]")));

        botaoPix = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Pix\"]");
    }

    //Tela 4

    public void buscarTelaPix(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Copie o código Pix:\"]")));

        textoCopiarCodigoPix = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Copie o código Pix:\"]");
    }

    //Açoes de Clique
    public void clicarBotaoComprarCreditos(){
        botaoComprarCreditos.click();
    }

    public void clicarBotaoComum(){
        botaoComum.click();
    }

    public void clicarBotaoComprarTela2(){
        botaoComprarTela2.click();
    }

    public void clicarBotaoCartaoDeCredito(){
        botaoCartaoDeCredito.click();
    }

    public void clicarBotaoConfirmarTela3(){
        botaoConfirmarTela3.click();
    }

    public void clicarBotaoCartaoDeDebito(){
        botaoCartaoDeDebito.click();
    }

    public void clicarBotaoEscolar(){
        botaoEscolar.click();
    }

    public void clicarOpcaoPix(){
        botaoPix.click();
    }

    public void clicarBotaoExpandirModalSaldo(){
        botaoExpandirModalSaldo.click();
    }

    public void clicarBotaoSaibaMais(){
        botaoSaibaMaisEscolar.click();
    }

    public MobileElement getTextoCopiarCodigoPix() {
        return textoCopiarCodigoPix;
    }

    public MobileElement getTextoBeneficioEscolar() {
        return textoBeneficioEscolar;
    }
}
