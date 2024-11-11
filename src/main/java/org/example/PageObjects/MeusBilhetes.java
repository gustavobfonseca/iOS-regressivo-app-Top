package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.view.ViewGroup[@content-desc=\"null  null no valor de 5 reais\"])[1]")));

        ultimaCompraDeBilhete = (MobileElement) driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"null  null no valor de 5 reais\"])[1]");

    }

    public void clicarUltimaCompraDeBilhete() {
        ultimaCompraDeBilhete.click();
    }

    public void buscarModalDetalhesCompra() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Detalhe da compra\"]")));

        modalDetalhesCompra = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Detalhe da compra\"]");

    }

    public void buscarCartoesEmFormasDePgto() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Crédito\"]")));

        cartaoDeCredito = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Crédito\"]");
    }

    public void buscarElementosTelaSemConexao() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Bilhete offline\"]")));

        botaoTentarNovamente = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"TENTAR NOVAMENTE\"]");
        botaoAcessarBilhetesOffline = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Bilhete offline\"]");
    }

    public void buscarMensagemListaDeBilhetes() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Estes são seus Bilhetes Digitais QR Code aceitos nas estações de Trem e Metrô de São Paulo\"]")));

        msgListaDeBilhetes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Estes são seus Bilhetes Digitais QR Code aceitos nas estações de Trem e Metrô de São Paulo\"]");

    }

    public void clicarBotaoAcessarBilhetesOffline() {
        botaoAcessarBilhetesOffline.click();
    }

    public void clicarBotaoTentarNovamente() {
        botaoTentarNovamente.click();
    }


    public void buscarBotaoComprarBilhetes() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.TextView[@text=\"\uEA45\"])[1]")));

        botaoComprarBilhetes = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@text=\"\uEA45\"])[1]");

    }

    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver, 120);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Comprar \n" +
                "Bilhetes\"]")));

        botaoComprarBilhetes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Comprar \n" +
                "Bilhetes\"]");
        botaoFormasDePagamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Formas de \n" +
                "Pagamento\"]");
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
        botaoFormasDePagamento.click();
    }

    public void buscarBotaoFormasDePagamento() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão formas de pagamento\"]")));

        botaoFormasDePagamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Formas de \n" +
                "Pagamento\"]");

    }

    public void buscarElementosTelaFalhaCadastro() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Falha no cadastro\"]")));

        msgFalhaCadastroCartao = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Falha no cadastro\"]");

    }

    public void buscarElementosFormasDePagamento() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.TextView[@text=\"\uE87A\"])[1]")));

        botaoAdicionarFormaPagamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"ADICIONAR CARTÃO\"]");
//        botaoVoltarPagina = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"ADICIONAR FORMA DE PAGAMENTO\"]");
    }

    public void buscarLixeiraExcluirCartao() {
        WebDriverWait espera = new WebDriverWait(driver, 50);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.TextView[@text=\"\uE87A\"])[1]")));

        botaoExcluirCartaoDeCredito = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@text=\"\uE87A\"])[1]");
    }

    public void clicarLixeiraExcluirCartao() {
        botaoExcluirCartaoDeCredito.click();
    }

    public void buscarBotaoConfirmarExclusaoCartao() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para excluir o cartão\"]")));

        botaoConfirmarExclusaoCartao = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para excluir o cartão\"]");
    }

    public void clicarBotaoConfirmarExclusaoCartao() {
        botaoConfirmarExclusaoCartao.click();
    }

    public void buscarFormasDePagamento() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Crédito\"]")));

        botaoCartaoDeCreditoFormaPagto = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Crédito\"]");
        botaoCartaoDeDebitoFormaPagto = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Débito\"]");
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
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"CPTM / METRÔ\"]")));

        bilheteMetro = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"CPTM / METRÔ\"]");
    }

    public void clicarBotaoCPTM() {
        bilheteMetro.click();
    }

    public MobileElement clicarBotaoComprarBilhetes() throws InterruptedException {
        final int maxTentativas = 10;
        int tentativas = 0;

        while (tentativas < maxTentativas) {
            try {
                botaoComprarBilhetes.click();
                return botaoComprarBilhetes;
            } catch (StaleElementReferenceException e) {
                tentativas++;
                buscarElementosTentativasMaximas();
                if (tentativas == maxTentativas) {
                    throw e;
                }
            }
            throw new RuntimeException("Element not found after maximum retries");
        }
        return null;
    }


    public void buscarBotaoUnidades() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"1 unidade no valor R$5\"]")));

        botaoUnidade = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"1 unidade no valor R$5\"]");

    }

    public void clicarBotaoUnidades() {
        botaoUnidade.click();
    }

    public void buscarOpcaoCartaoDeCredito() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Crédito\"]")));

        opcaoCartaoDeCredito = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Crédito\"]");
        botaoConfirmarFormaPagamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]");
    }

    public void buscarOpcaoSaldoEmConta() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Saldo disponível\"]")));

        opcaoSaldoEmConta = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Saldo disponível\"]");
        botaoConfirmarFormaPagamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]");
    }

    public void buscarOpcaoPix() {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Pix\"]")));

        opcaoPix = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Pix\"]");
        botaoConfirmarFormaPagamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]");

    }

    public void clicarOpcaoPix() {
        opcaoPix.click();
    }


    public void clicarSaldoEmConta() {
        opcaoSaldoEmConta.click();
    }

    public void clicarOpcaoCartaoDeCredito() {
        opcaoCartaoDeCredito.click();
    }

    public void clicarBotaoConfirmarFormaPagamento() {
        botaoConfirmarFormaPagamento.click();
    }

    public void buscarElementosConfirmarCompra() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"informar cvv\"]")));

        inputCvv = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"informar cvv\"]");
        botaoConfirmarCompra = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]");
    }

    public void inserirCvv(String cvv) {
        inputCvv.sendKeys(cvv);
    }

    public void clicarBotaoConfirmarCompra() {
        botaoConfirmarCompra.click();
    }

    public void buscarMensagemCompraRealizadaComSucesso() {
        WebDriverWait espera = new WebDriverWait(driver, 50);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Sua compra foi realizada\n" +
                "com sucesso!\"]")));

        mensagemCompraRealizadaComSucesso = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Sua compra foi realizada\n" +
                "com sucesso!\"]");
    }

    public void buscarMensagemFalhaNoPagamento() {
        WebDriverWait espera = new WebDriverWait(driver, 120);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Falha no pagamento!\"]")));

        mensagemFalhaNoPagamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Falha no pagamento!\"]");
    }

    public void buscarBotaoVoltarParaHome() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"VOLTAR À PÁGINA INICIAL\"]")));

        botaoVoltarParaHome = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"VOLTAR À PÁGINA INICIAL\"]");

    }

    public void buscarBotaoVoltarParaOInicio() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Voltar para o Início\"]")));

        botaoVoltarParaHome = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Voltar para o Início\"]");

    }

    public void buscarInputSenhaSaldoEmConta() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]")));

        input0InserirSenhaSaldoEmConta = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]");
        botaoConfirmarCompra = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]");
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
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Débito\"]")));

        opcaoCartaoDebito = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Débito\"]");
        botaoConfirmarFormaPagamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]");
    }

    public void buscarElementosTelaCadastroRealizado() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Cadastro realizado com sucesso!\"]")));

        msgCadastroCartaoSucesso = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Cadastro realizado com sucesso!\"]");
        botaoVoltarParaInicio = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Voltar para o Início\"]");

    }

    public void buscarFormaDePagamentoTelaConfirmacaoPix() {
        WebDriverWait espera = new WebDriverWait(driver, 120);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Pix copia e cola\"]")));

        textoPixCopiaECola = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Pix copia e cola\"]");

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
