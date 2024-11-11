package org.example;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.*;
import org.junit.Assert;

public class StepDefinitionPerfilDoUsuario {


    @Dado("que acesso a Home do aplicativo sem possuir foto de perfil")
    public void queAcessoAHomeDoAplicativoSemPossuirFotoDePerfil() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.buscarFotoDePerfil();
    }

    @E("sem ter a permissão de acesso à câmera habilitada para o aplicativo TOP")
    public void semTerAPermissãoDeAcessoÀCâmeraHabilitadaParaOAplicativoTOP() {

    }

    @Quando("clico em minha apresentação na Home")
    public void clicoEmMinhaApresentaçãoNaHome() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.perfilPelaApresentacao();
    }

    @E("clico na opção \"Editar\" em \"Foto de Perfil\"")
    public void clicoNaOpçãoEditarEmFotoDePerfil() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.buscarElementos();
        perfilDoUsuario.clickEditarFoto();
    }

    @E("seleciono a opção \"Tirar Foto\" no modal")
    public void selecionoAOpçãoTirarFotoNoModal() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.clickBotaoTirarFoto();
    }

    @E("habilito a permissão de acesso à câmera")
    public void habilitoAPermissãoDeAcessoÀCâmera() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.permitirAcessoCamera();
    }

    @E("submeto o envio de uma foto através da câmera do dispositivo,")
    public void submetoOEnvioDeUmaFotoAtravésDaCâmeraDoDispositivo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.tirarFoto();
        perfilDoUsuario.confirmarFoto();
    }

    @Então("visualizo a foto enviada na tela de perfil de usuário")
    public void visualizoAFotoEnviadaNaTelaDePerfilDeUsuário() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.verificarFotoPerfil();

        MeusBilhetes meusBilhetes = new MeusBilhetes(driver);
        System.out.println("voltar");
//        meusBilhetes.clicarSetaVoltar();

//        perfilDoUsuario.voltarHome();
        driver.navigate().back();
    }

    @E("na apresentação da Home.")
    public void naApresentaçãoDaHome() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Home home = new Home(driver);
        home.buscarFotoDePerfilAdicionada();
    }

    @E("sem ter a permissão de acesso à galeria habilitada para o aplicativo TOP")
    public void semTerAPermissãoDeAcessoÀGaleriaHabilitadaParaOAplicativoTOP() {

    }

    @E("seleciono a opção Escolher Foto no modal")
    public void selecionoAOpçãoEscolherFotoNoModal() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.clickBotaoEscolherFoto();
    }

    @E("habilito a permissão de acesso à galeria")
    public void habilitoAPermissãoDeAcessoÀGaleria() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.permitirAcessoGaleria();

    }

    @E("submeto o envio de uma foto através da galeria do dispositivo")
    public void submetoOEnvioDeUmaFotoAtravésDaGaleriaDoDispositivo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.escolherFotoGaleria();
    }

    @Dado("que acesso a Home do aplicativo tendo foto de perfil")
    public void queAcessoAHomeDoAplicativoTendoFotoDePerfil() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.buscarFotoDePerfilAdicionada();
    }

    @Dado("que acesso o perfil de usuário")
    public void queAcessoOPerfilDeUsuário() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.buscarMensagemBemVindo();
        home.perfilPelaApresentacao();
    }

    @Dado("que acesso o perfil de usuário com biometria ativa")
    public void queAcessoOPerfilDeUsuárioBiometriaAtiva() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.buscarMensagemBemVindo();
        home.perfilPelaApresentacao();
    }

    @Quando("insiro dados com mais de 2 caracteres no campo \"Apelido ou nome social\"")
    public void insiroDadosComMaisDe2CaracteresNoCampo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.buscarElementos();
        perfilDoUsuario.alterarApelidoOuNomeSocial();

    }

    @E("clico no ícone de edição para salvar")
    public void clicoNoÍconeDeEdiçãoParaSalvar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.salvarAlteracaoApelidoOuNomeSocial();
    }

    @Então("visualizo a mensagem \"Apelido atualizado com sucesso, apelidoAtualizado!\"")
    public void visualizoAMensagemApelidoAtualizadoComSucesso() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.buscarMensagemAlteracaoApelidoNomeSocial();
    }

    @E("visualizo o apelido ou nome social na Home")
    public void visualizoOApelidoOuNomeSocialNaHome() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.voltarHome();

        Home home = new Home(driver);
        home.buscarApelidoNomeSocialModificado();

    }

    @E("visualizo apelido ou nome social na área semi-logada do aplicativo")
    public void visualizoApelidoOuNomeSocialNaÁreaSemiLogadaDoAplicativo() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);

        home.deslogar();

        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarElementos();
        semiLogado.buscarApelidoNomeSocialModificado();
    }


    @Quando("clico na opção \"Senha do aplicativo\"")
    public void clicoNaOpçãoSenhaDoAplicativo() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.buscarSenhaDoAplicativo();
        perfilDoUsuario.clickSenhaDoAplicativo();
    }

    @E("insiro a senha atual correta")
    public void insiroASenhaAtualCorreta() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.inserirSenhaAtual("Teste@123");
    }

    @E("clico em \"Editar\"")
    public void clicoEmEditar() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.clickEditarSenha();
    }

    @E("insiro \"Nova senha\" e \"Confirmar nova senha\" válidas")
    public void insiroSenhaEConfirmarSenhaVálidas() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.inserirNovaSenha("Teste@1234");
        perfilDoUsuario.inserirConfirmarNovaSenha("Teste@1234");

    }

    @E("clico em \"Enviar\"")
    public void clicoEmEnviar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.enviarNovaSenha();
    }

    @Então("visualizo a mensagem de \"Senha alterada com sucesso\"")
    public void visualizoAMensagemDeSenhaAlteradaComSucesso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.buscarConfirmacaoSenhaAlteradaSucesso();
        perfilDoUsuario.buscarSenhaDoAplicativo();
    }

    @E("ao fazer um novo login, apenas a nova senha deve estar válida como credencial de acesso ao aplicativo")
    public void aoFazerUmNovoLoginApenasANovaSenhaDeveEstarVálidaComoCredencialDeAcessoAoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
//        perfilDoUsuario.clicarMenuBiometria();
        perfilDoUsuario.clicarSair();

        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarElementos();
        semiLogado.preencherSenha("Teste@1234");
        semiLogado.clicarBotaoEntrar();

//        Login telaLogin = new Login(driver);
//        telaLogin.buscarModalErro();
//        Assert.assertEquals("CPF e/ou senha inválidos.", telaLogin.getModalErro().getText());
//        telaLogin.buscarBotaoFecharModalCPFSenha();
//        telaLogin.clicarBotaoFecharModalCPFSenha();
//        semiLogado.buscarElementos();

//        semiLogado.preencherSenha("Teste@1234");
//        semiLogado.clicarBotaoEntrar();

        Home telaHome = new Home(driver);

        Thread.sleep(3000);
//        telaHome.esperarBotaoBiometria();
        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }

        telaHome.buscarMensagemBemVindo();
    }

    @E("insiro a senha atual incorreta")
    public void insiroASenhaAtualIncorreta() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.inserirSenhaAtual("SenhaIncorreta@134");
    }

    @Então("visualizo a mensagem de \"Senha atual inválida\"")
    public void visualizoAMensagemDeSenhaAtualInválida() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.buscarErroSenhaAtualInvalida();
    }

    @E("insiro \"Nova senha\" e \"Confirmar nova senha\" divergentes")
    public void insiroEDivergentes() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.inserirNovaSenha("Teste@123");
        perfilDoUsuario.inserirConfirmarNovaSenha("Diferente@123");
    }

    @Então("visualizo a mensagem \"As senhas devem ser iguais\" no campo \"Confirmar nova senha\"")
    public void visualizoAMensagemNoCampo() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.buscarMensagemValidacaosenha("As senhas devem ser iguais");
    }

    @Quando("clico na opção \"Seus telefones de contato\"")
    public void clicoNaOpçãoSeusTelefonesDeContato() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.buscarSeusTelefoneContato();
        perfilDoUsuario.clickSeusTelefonesContato();

    }

    @E("seleciono a opção \"Celular \\(Transporte)\"")
    public void selecionoAOpçãoCelularTransporte() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.clicarCelularTransporte();
    }

    @Então("sou direcionado para o atendimento Autopass via WhatsApp")
    public void souDirecionadoParaOAtendimentoAutopassViaWhatsApp() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.verificarRedirecionamentoWhatsapAtendimentoAutopass();
    }

    @E("seleciono a opção Celular \\(Cadastro Conta Digital | Crédito)")
    public void selecionoAOpçãoCelularCadastroContaDigitalCrédito() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.clicarCelularCadastroContaDigitalCredito();
    }

    @Dado("que acesso o perfil de usuário tendo produtos de banking ativos")
    public void queAcessoOPerfilDeUsuárioTendoProdutosDeBankingAtivos() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("531.891.618-01", "Devires@123");
        telaLogin.logar();

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
//        telaHome.clicarBotaoAtivarBiometria();

        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());

        telaHome.perfilPelaApresentacao();

        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.buscarElementos();
    }

    @Então("sou direcionado para o chatbot Pefisa via WhatsApp")
    public void souDirecionadoParaOChatbotPefisaViaWhatsApp() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.verificarRedirecionamentoWhatsapChatbotPefisa();
    }

    @Quando("desabilito o Touch ID ou Face ID no campo \"Autenticação biométrica\"")
    public void desabilitoOTouchIDOuFaceIDNoCampo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.buscarElementos();
        perfilDoUsuario.clicarMenuBiometria();
    }

    @Quando("clico na opção \"Termos de uso\"")
    public void clicoNaOpçãoTermoUso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.buscarElementos();
        perfilDoUsuario.clicarTermoDeUso();

    }

    @Quando("clico na opção \"Sair do Aplicativo\" confirmando o modal")
    public void clicoNaOpçãoSairDoApp() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.clicarSair();

    }

    @Quando("clico no \"Central de Ajuda\"")
    public void clicoNoÍconeCentralDeAjuda() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.buscarElementos();
        perfilDoUsuario.clicaIconeCentralAjuda();
    }

    @Então("sou direcionado para o a página inicial da Central de Ajuda Autopass")
    public void souDirecionadoParaOAPáginaInicialDaCentralDeAjudaAutopass() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.buscarTelaCentralAtendimento();
    }

    @E("insiro a senha atual alterada {string}")
    public void insiroASenhaAtualAlterada(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.inserirSenhaAtual(arg0);
    }

    @E("insiro Nova senha {string} e Confirmar nova senha {string}")
    public void insiroNovaSenhaEConfirmarNovaSenha(String arg0, String arg1) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);
        perfilDoUsuario.inserirNovaSenha(arg0);
        perfilDoUsuario.inserirConfirmarNovaSenha(arg1);
    }
}
