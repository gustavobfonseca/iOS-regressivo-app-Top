package org.example.Steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.pt.E;
import org.example.AppiumDriverConfig;
import org.example.GestosEmulador;
import org.example.PageObjects.Tela;

import java.text.DecimalFormat;

public class StepDefinitionBilhetesQrCode {
    AppiumDriver driver = AppiumDriverConfig.Instance().driver;


    @E("adiciono {string} com a opção Metro e Trem pré selecionada")
    public void adicionoComAOpçãoMetroETremPréSelecionada(String arg0) {
        // Converter a string para número inteiro
        int numero = Integer.parseInt(arg0);

        // Buscar e interagir com o botão de adicionar bilhete
        Tela.buscarElementoNaTela("//XCUIElementTypeOther[@name=\"+\"]");

        for (int i = 0; i < numero; i++) {
            Tela.clicarEmElemento("//XCUIElementTypeOther[@name=\"+\"]", 20);
        }

        // Calcular o total e formatar para 2 casas decimais
        double total = 5.20 * (numero+1);
        DecimalFormat df = new DecimalFormat("0.00");
        String totalFormatado = df.format(total).replace(".", ",");

        // Buscar o elemento com o valor total atualizado
        Tela.buscarElementoNaTela("//XCUIElementTypeStaticText[@name=\"Total: R$ " + totalFormatado + "\"]", 20);
    }


    @E("confirmo as seleções")
    public void confirmoAsSeleções() {
        Tela.clicarEmElemento("(//XCUIElementTypeOther[@name=\"CONFIRMAR\"])[2]",20);
    }

    @E("seleciono {string} no modal do Super TOP")
    public void selecionoNoModalDoSuperTOP(String arg0) {
    Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name, \"Escolha quantos pontos supertroco deseja comprar\")])[3]\n");
    GestosEmulador.clickCoordenada(195,805);
    }

    @E("seleciono Continuar compra com pontos no modal do Super TOP")
    public void selecionoContinuarCompraComPontosNoModalDoSuperTOP() {
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name, \"Escolha quantos pontos supertroco deseja comprar\")])[3]\n");
        GestosEmulador.clickCoordenada(195,743);
        GestosEmulador.rolarTelaVertical();
    }

    @E("seleciono {string} pontos do SuperTop")
    public void selecionoPontos(String arg0) {
        Tela.clicarEmElemento("(//XCUIElementTypeOther[contains(@name, \""+arg0+" PONTOS\")])[last()]");
    }
}