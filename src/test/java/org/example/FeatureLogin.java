package org.example;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.example.PageObjects.EsqueciMinhaSenha;
import org.example.PageObjects.Home;
import org.example.PageObjects.Login;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

/**
 * Unit test for simple App.
 */
public class FeatureLogin
        extends TestCase
{

    public void login_com_preenchimento_correto() throws InterruptedException {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);

        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("327.721.478-86", "Devires@123");
        telaLogin.logar();

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
//        telaHome.clicarBotaoAtivarBiometria();

        telaHome.arrastarModalParaBaixo();

        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());

        assertTrue( true );
    }


    public void login_com_credenciais_invalidas() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);

        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("327.721.478-86", "SenhaIncorreta");
        telaLogin.logar();
        telaLogin.buscarModalErro();


        Assert.assertEquals("CPF e/ou senha inválidos.", telaLogin.getModalErro().getText());

    }

public void login_com_usuario_bloqueado() throws InterruptedException {
    AppiumDriver driver =  AppiumDriverConfig.Instance().driver;

    Login telaLogin = new Login(driver);

        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("73040542559", "Devires@123");
        telaLogin.logar();
        telaLogin.buscarMensagemContaBloqueada();
        Assert.assertTrue(telaLogin.getTextoModalContaBloqueada().isDisplayed());
        assertTrue( true );
    }


    public void login_atraves_esqueci_minha_senha_com_cpf_bloqueado() throws InterruptedException {
        AppiumDriver driver =  AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("73040542559", " ");
        telaLogin.clicarEsqueciMinhaSenha();

        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.buscarElementos();
        telaEsqueciminhaSenha.preencherInputCpf("73040542559");
        telaEsqueciminhaSenha.clicarBotaoConfirmar();
        telaEsqueciminhaSenha.buscarMensagemContaBloqueada();
        Assert.assertTrue(telaEsqueciminhaSenha.getTextoModalContaBloqueada().isDisplayed());
        assertTrue( true );
    }


    public void login_atraves_esqueci_minha_senha_credenciais_invalidas() throws InterruptedException {
        AppiumDriver driver =  AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.clicarEsqueciMinhaSenha();

        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciminhaSenha.buscarElementos();
        telaEsqueciminhaSenha.preencherInputCpf("12345678910");
        telaEsqueciminhaSenha.clicarBotaoConfirmar();
        telaEsqueciminhaSenha.buscarMensagemCPFInvalido();
        Assert.assertTrue(telaEsqueciminhaSenha.getMsgCPFInvalido().isDisplayed());

    }



}

