package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import java.time.Duration;
import java.util.Collections;

public class Tela {

    private AppiumDriver driver;

    public Tela(AppiumDriver driver) {
        this.driver = driver;
    }

    public MobileElement buscarElementoNaTela(String xPath, int tempoEspera){
        WebDriverWait espera = new WebDriverWait(driver, tempoEspera);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));

        return (MobileElement) driver.findElementByXPath(xPath);
    }

    public void clicarEmElemento(MobileElement elementoClicavel){
        elementoClicavel.click();
    }

    public void clicarEmElemento(String xpathElemento, int espera){
        MobileElement elemento = buscarElementoNaTela(xpathElemento, espera);
        elemento.click();
    }

    public void clicarEmElemento(String xPathElementoClicavel, String xPathElementoVisivel){
        int tentativas = 0;
        int tentativasMaximas = 10;

        while (tentativas <= tentativasMaximas){
            try{
                MobileElement elementoClicável = buscarElementoNaTela(xPathElementoClicavel, 5);
                elementoClicável.click();
                MobileElement elementoVisivel = buscarElementoNaTela(xPathElementoVisivel, 5);
                Thread.sleep(2000);
                Assert.isTrue(elementoVisivel.isDisplayed());
                break;
            }catch (RuntimeException e){
                tentativas++;
                if(tentativas==tentativasMaximas){
                    throw e;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void inputNoElemento(MobileElement elementoInput, String input) {
        for (char c : input.toCharArray()) {
            elementoInput.sendKeys(Character.toString(c));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        elementoInput.sendKeys(Keys.RETURN);
    }


    public void inputNoElemento(String xpathElemento, String input){
        MobileElement elemento = buscarElementoNaTela(xpathElemento, 10);
        inputNoElemento(elemento, input);
    }

    public void scrollAteElemento(String xPathElementoDeEspera, int tempoEspera, String xPathElementoBuscavel){
        WebDriverWait espera = new WebDriverWait(driver, tempoEspera);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathElementoDeEspera)));

        MobileElement elementoBuscado = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(" + xPathElementoBuscavel + ");"));

//        elementoBuscado = (MobileElement) driver.findElementByXPath(xPathElementoBuscavel);
    }

    public void arrastarParaOLado(int startX, int startY, int endX, int endY){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(new Pause(finger, Duration.ofMillis(500)));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void limparInput(String s) {
        buscarElementoNaTela(s,10);
        MobileElement input = (MobileElement) driver.findElementByXPath(s);
        input.clear();
    }
}