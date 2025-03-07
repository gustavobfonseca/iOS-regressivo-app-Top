package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.example.GestosEmulador;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MeusBilhetes {
    private AppiumDriver driver;
    private MobileElement botaoComprarBilhetes;
    private MobileElement bilheteMetro;
    private MobileElement botaoUnidade;
    private MobileElement opcaoCartaoDeCredito;
    private MobileElement botaoConfirmarFormaPagamento;
    private MobileElement inputCvv;
    private MobileElement botaoConfirmarCompra;
    private MobileElement mensagemCompraRealizadaComSucesso;
    private MobileElement mensagemFalhaNoPagamento;
    private MobileElement botaoVoltarParaHome;
    private MobileElement opcaoCartaoDebito;
    private MobileElement botaoFormasDePagamento;
    private MobileElement botaoAdicionarFormaPagamento;
    private MobileElement botaoCartaoDeCreditoFormaPagto;
    private MobileElement msgCadastroCartaoSucesso;
    private MobileElement botaoVoltarParaInicio;
    private MobileElement botaoExcluirCartaoDeCredito;
    private MobileElement botaoConfirmarExclusaoCartao;
    private MobileElement botaoVoltarPagina;
    private MobileElement botaoCartaoDeDebitoFormaPagto;
    private MobileElement msgFalhaCadastroCartao;
    private MobileElement botaoAcessarBilhetesOffline;
    private MobileElement msgListaDeBilhetes;
    private MobileElement botaoTentarNovamente;
    private MobileElement cartaoDeCredito;
    private MobileElement ultimaCompraDeBilhete;
    private MobileElement modalDetalhesCompra;
    private MobileElement opcaoSaldoEmConta;
    private MobileElement input0InserirSenhaSaldoEmConta;
    private MobileElement opcaoPix;
    private MobileElement textoPixCopiaECola;
    private MobileElement qtdDeBilhetes;

    private static int numeroDeBilhetes = 0;


    public MeusBilhetes(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarUltimaCompraDeBilhete() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[contains(@name, 'Compra de Bilhete') and contains(@name, 'CPTM / Metrô')])[last()-10]\n" +
                "\n")));

        ultimaCompraDeBilhete = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[contains(@name, 'Compra de Bilhete') and contains(@name, 'CPTM / Metrô')])[last()-10]\n" +
                "\n");

    }

    public void clicarUltimaCompraDeBilhete() {
        ultimaCompraDeBilhete.click();
    }

    public void buscarModalDetalhesCompra() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[contains(@name, 'Detalhe da compra')]\n")));

        modalDetalhesCompra = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[contains(@name, 'Detalhe da compra')]\n");

    }

    public void buscarCartoesEmFormasDePgto() {
        WebDriverWait espera = new WebDriverWait(driver, 50);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"\uE98E ADICIONAR CARTÃO\"]")));

        cartaoDeCredito = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"\uE98E ADICIONAR CARTÃO\"]");
    }

    public void buscarElementosTelaSemConexao() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Bilhete offline\"]")));

        botaoTentarNovamente = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Tentar novamente\"]");
        botaoAcessarBilhetesOffline = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Bilhete offline\"]");
    }

    public void buscarMensagemListaDeBilhetes() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Estes são seus Bilhetes Digitais QR Code aceitos nas estações de Trem e Metrô de São Paulo\"]")));

        msgListaDeBilhetes = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Estes são seus Bilhetes Digitais QR Code aceitos nas estações de Trem e Metrô de São Paulo\"]");

    }

    public void clicarBotaoAcessarBilhetesOffline() {
        botaoAcessarBilhetesOffline.click();
    }

    private int tentativas = 0;

    public void clicarBotaoTentarNovamente() {
        if (tentativas >= 3) {
            System.out.println("Máximo de tentativas alcançado. Conexão não restabelecida.");
            return;
        }

        botaoTentarNovamente.click();
        tentativas++;

        try {
            WebDriverWait espera = new WebDriverWait(driver, 2);
            espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Tentar novamente\"]")));
        } catch (TimeoutException timeoutException) {
            System.out.println("Conexão não voltou, tentando novamente. Tentativa: " + tentativas);
            clicarBotaoTentarNovamente();
        }
    }



    public void buscarBotaoComprarBilhetes() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.TextView[@text=\"\uEA45\"])[1]")));

        botaoComprarBilhetes = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@text=\"\uEA45\"])[1]");

    }

    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver, 120);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Comprar Bilhetes\"]\n")));

        botaoComprarBilhetes = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Comprar Bilhetes\"]\n");
        botaoFormasDePagamento = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Formas de Pagamento\"]\n");
    }

    public MobileElement buscarElementosTentativasMaximas() {
        final int maxTentativas = 10;
        int tentativas = 0;

        while (tentativas < maxTentativas) {

            try {
                WebDriverWait espera = new WebDriverWait(driver, 120);
                espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Histórico de atividades\"]")));

                botaoComprarBilhetes = (MobileElement) driver.findElementByXPath("//*[@text=\"Comprar \n" +
                        "Bilhetes\"]");
                //botaoComprarBilhetes = (MobileElement) driver.findElementById("00000000-0000-0011-ffff-ffff00000284");
                botaoFormasDePagamento = (MobileElement) driver.findElementByXPath("//*[@text=\"Formas de \n" +
                        "Pagamento\"]");
                return botaoComprarBilhetes;
            } catch (StaleElementReferenceException e) {
                tentativas++;
                if (tentativas == maxTentativas) {
                    throw e;
                }
            }

            throw new RuntimeException("Element not found after maximum retries");
        }
        return null;
    }

    public void clicarFormasDePgto() {
        GestosEmulador.clickCoordenada(350,400);
//        botaoFormasDePagamento.click();
    }

    public void buscarBotaoFormasDePagamento() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"\uE98E ADICIONAR CARTÃO\"]")));

        botaoFormasDePagamento = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"\uE98E ADICIONAR CARTÃO\"]");

    }

    public void buscarElementosTelaFalhaCadastro() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Falha no cadastro\"]")));

        msgFalhaCadastroCartao = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Falha no cadastro\"]");

    }

    public void buscarElementosFormasDePagamento() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"\uE98E ADICIONAR CARTÃO\"]")));

        botaoAdicionarFormaPagamento = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"\uE98E ADICIONAR CARTÃO\"]");
//        botaoVoltarPagina = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"ADICIONAR FORMA DE PAGAMENTO\"]");
    }

    public void buscarLixeiraExcluirCartao() {
        WebDriverWait espera = new WebDriverWait(driver, 50);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.TextView[@text=\"\uE87A\"])[1]")));

        botaoExcluirCartaoDeCredito = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@text=\"\uE87A\"])[1]");
    }

    public void clicarLixeiraExcluirCartao(String tipo) throws InterruptedException {
//        WebDriverWait espera = new WebDriverWait(driver, 120);
//        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Outras\"]")));

        WebDriverWait espera2 = new WebDriverWait(driver, 10);

        if (tipo.equalsIgnoreCase("débito")){
            System.out.println("procurando cartao débito ");
                espera2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[contains(@name, 'Débito')])[2]")));
                MobileElement cartao = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[contains(@name, 'Débito')])[2]");
            System.out.println(
                    cartao.getLocation()
            );
            GestosEmulador.clickCoordenada(337,187);
        }

        else {
            System.out.println("procurando cartao crédito ");
            espera2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[contains(@name, 'Crédito')])[2]")));
            MobileElement cartao = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[contains(@name, 'Crédito')])[2]");

            System.out.println(
                    cartao.getLocation()
            );
            GestosEmulador.clickCoordenada(337,187);
        }
        Thread.sleep(2000);
        GestosEmulador.clickCoordenada(350,350);
//        botaoExcluirCartaoDeCredito.click();
    }

    public void buscarBotaoConfirmarExclusaoCartao() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para excluir o cartão\"]")));

        botaoConfirmarExclusaoCartao = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para excluir o cartão\"]");
    }

    public void clicarBotaoConfirmarExclusaoCartao() throws InterruptedException {
//        Thread.sleep(3000);
        Tela.buscarElementoNaTela("(//XCUIElementTypeOther[contains(@name, \"Deseja excluir o Cartão\")])[1]\n");
        GestosEmulador.clickCoordenada(200,700);
//        botaoConfirmarExclusaoCartao.click();
    }

    public void buscarFormasDePagamento() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"\uE8FD Crédito Mastercard, Visa, Elo, Diners e Amex\"])[2]")));

        botaoCartaoDeCreditoFormaPagto = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"\uE8FD Crédito Mastercard, Visa, Elo, Diners e Amex\"])[2]");
        botaoCartaoDeDebitoFormaPagto = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"\uE903 Débito Mastercard, Visa e Elo\"])[2]");
    }

    public void clicarBotaoCartaoDeCreditoFormaPgto() {
        botaoCartaoDeCreditoFormaPagto.click();
    }

    public void clicarBotaoCartaoDeDebitoFormaPgto() {
        botaoCartaoDeDebitoFormaPagto.click();
    }

    public void clicarBotaoAdicionarFormaPagamento() {
        botaoAdicionarFormaPagamento.click();
    }

    public void buscarBotaoCPTM() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"CPTM / METRÔ\"])[2]")));

        bilheteMetro = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"CPTM / METRÔ\"])[2]");
    }

    public void clicarBotaoCPTM() {
        bilheteMetro.click();
    }

    public void clicarBotaoComprarBilhetes() throws InterruptedException {
//        final int maxTentativas = 10;
//        int tentativas = 0;
//
//        while (tentativas < maxTentativas) {
//            try {
//                botaoComprarBilhetes.click();
//                return botaoComprarBilhetes;
//            } catch (StaleElementReferenceException e) {
//                tentativas++;
//                buscarElementosTentativasMaximas();
//                if (tentativas == maxTentativas) {
//                    throw e;
//                }
//            }
//            throw new RuntimeException("Element not found after maximum retries");
//        }
//        return null;
        GestosEmulador.clickCoordenada(90,400);
    }

// contains nao funciona 1 unidade
    public void buscarBotaoUnidades() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"1 unidade no valor R$5.2\"]")));

        botaoUnidade = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"1 unidade no valor R$5.2\"]");

    }

    public void clicarBotaoUnidades() {
        botaoUnidade.click();
    }

    public void buscarOpcaoCartaoDeCredito() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Crédito •••• 6091 \uE87A\"])[2]")));

        opcaoCartaoDeCredito = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Crédito •••• 6091 \uE87A\"])[2]");
        botaoConfirmarFormaPagamento = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Confirmar compra\"]");
    }

    public void buscarOpcaoSaldoEmConta() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[contains(@name, \"Saldo disponível\")]\n")));

        opcaoSaldoEmConta = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[contains(@name, \"Saldo disponível\")]\n");
        botaoConfirmarFormaPagamento = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Confirmar compra\"]");
    }

    public void buscarOpcaoPix() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        GestosEmulador.rolarTelaVertical("(//XCUIElementTypeOther[@name=\"Pix Copie e cole o código para pagamento\"])[2]");
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Pix Copie e cole o código para pagamento\"])[2]")));

        opcaoPix = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Pix Copie e cole o código para pagamento\"])[2]");
        botaoConfirmarFormaPagamento = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Confirmar compra\"]");

    }

    public void clicarOpcaoPix() {
        opcaoPix.click();
    }


    public void clicarSaldoEmConta() throws InterruptedException {
        System.out.println("saldo em conta");
        GestosEmulador.clickCoordenada(192,252);
        Thread.sleep(5000);
//        opcaoSaldoEmConta.click();
    }

    public void clicarOpcaoCartaoDeCredito() {
        opcaoCartaoDeCredito.click();
    }

    public void clicarBotaoConfirmarFormaPagamento() {
        botaoConfirmarFormaPagamento.click();
    }

    public void buscarElementosConfirmarCompra() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"botão confirmar\"]")));

        inputCvv = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"cvv_input\"]");
        botaoConfirmarCompra = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"botão confirmar\"]");
    }

    public void inserirCvv(String cvv) {
        driver.getKeyboard().sendKeys(cvv);
        driver.getKeyboard().sendKeys(Keys.RETURN);
        try {
            Thread.sleep(2000);
        }catch (Exception e){}
    }

    public void clicarBotaoConfirmarCompra() {
        botaoConfirmarCompra.click();
    }

    public void buscarMensagemCompraRealizadaComSucesso() {
        WebDriverWait espera = new WebDriverWait(driver, 50);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Sua compra foi realizada\n" +
                "com sucesso!\"]")));

        mensagemCompraRealizadaComSucesso = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sua compra foi realizada\n" +
                "com sucesso!\"]");
    }

    public void buscarMensagemFalhaNoPagamento() {
        WebDriverWait espera = new WebDriverWait(driver, 120);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Falha no pagamento!\"]")));

        mensagemFalhaNoPagamento = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Falha no pagamento!\"]");
    }

    public void buscarBotaoVoltarParaHome() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Botão para voltar ao início\"]")));

        botaoVoltarParaHome = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Botão para voltar ao início\"]");

    }

    public void buscarBotaoVoltarParaOInicio() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Voltar para o Início\"]")));

        botaoVoltarParaHome = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Voltar para o Início\"]");

    }

    public void buscarInputSenhaSaldoEmConta() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Botão Confirmar Pin De Pagamento\"]")));

        input0InserirSenhaSaldoEmConta = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Exibir ou ocultar inputs - eye\"])[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]");
        botaoConfirmarCompra = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Botão Confirmar Pin De Pagamento\"]");
    }

    public void clicarInput0SenhaSaldoEmConta() {
        input0InserirSenhaSaldoEmConta.click();
    }

    public void inserirSenhaConta(String input) {
        driver.getKeyboard().sendKeys(input);
    }

    public void clicarBotaoVoltarParaHome() {
        botaoVoltarParaHome.click();
    }

    public void buscarOpcaoCartaoDebito() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeOther[@name=\"Débito •••• 6091 \uE87A\"])[2]")));

        opcaoCartaoDebito = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Débito •••• 6091 \uE87A\"])[2]");
        botaoConfirmarFormaPagamento = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Confirmar compra\"]");
    }

    public void buscarElementosTelaCadastroRealizado() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Cadastro realizado com sucesso!\"]")));

        msgCadastroCartaoSucesso = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Cadastro realizado com sucesso!\"]");
//        botaoVoltarParaInicio = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Voltar para o Início\"])[2]");

    }

    public void buscarFormaDePagamentoTelaConfirmacaoPix() {
        WebDriverWait espera = new WebDriverWait(driver, 120);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Pix copia e cola\"]")));

        textoPixCopiaECola = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Pix copia e cola\"]");

    }

    public int verificarQtdDeBilhete() {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para usar ticket de metrô\"][1]/android.view.ViewGroup[1]/android.widget.TextView[@index='0']")));
        qtdDeBilhetes = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para usar ticket de metrô\"][1]/android.view.ViewGroup[1]/android.widget.TextView[@index='0']");

        try {
            numeroDeBilhetes = Integer.parseInt(qtdDeBilhetes.getText());

        } catch (NumberFormatException e) {
            System.out.println("Erro: O texto não pode ser convertido para um número.");
            throw new RuntimeException("Falha na conversão de texto para número. Interrompendo o teste.");

        }

        if (numeroDeBilhetes == 0) {
            throw new RuntimeException("Não possui bilhetes Qr-code. Interrompendo o teste.");
        } else {
            System.out.println("Você possui " + numeroDeBilhetes + " bilhetes");
            return numeroDeBilhetes;
        }
    }

    public void clicarSetaVoltar() {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]")));

        MobileElement setaVoltar = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]");
        setaVoltar.click();
    }

    public void clicarBotaoVoltarParaInicio() {
        botaoVoltarParaInicio.click();
    }

    public void clicarOpcaoDebito() {
        opcaoCartaoDebito.click();
    }

    public MobileElement getMensagemCompraRealizadaComSucesso() {
        return mensagemCompraRealizadaComSucesso;
    }

    public MobileElement getMensagemFalhaNoPagamento() {
        return mensagemFalhaNoPagamento;
    }

    public MobileElement getMsgCadastroCartaoSucesso() {
        return msgCadastroCartaoSucesso;
    }

    public MobileElement getBotaoExcluirCartaoDeCredito() {
        return botaoExcluirCartaoDeCredito;
    }

    public MobileElement getMsgFalhaCadastroCartao() {
        return msgFalhaCadastroCartao;
    }

    public MobileElement getMsgListaDeBilhetes() {
        return msgListaDeBilhetes;
    }

    public MobileElement getCartaoDeCredito() {
        return cartaoDeCredito;
    }

    public MobileElement getModalDetalhesCompra() {
        return modalDetalhesCompra;
    }

    public MobileElement getTextoPixCopiaECola() {
        return textoPixCopiaECola;
    }

    public int getNumeroDeBilhetes() {
        return numeroDeBilhetes;
    }

    public void setNumeroDeBilhetes(int numeroDeBilhetes) {
        this.numeroDeBilhetes = numeroDeBilhetes;
    }
}
