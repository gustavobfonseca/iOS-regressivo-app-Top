# language: pt
Funcionalidade: Área Semi Logada

  Cenário 01: Recuperação de senha
    Dado que realizo o logout para a área semi logada do app, estando com a biometria habilitada
    Dado que acesso a área semi logada do aplicativo
    Quando clico em "Esqueci minha senha."
    Quando informo o seguinte CPF "13715099054" que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email
    E clico em confirmar email
    E insiro a senha "Devires@123"
    E confirmo a nova senha "Devires@123"
    E clico em confirmar redefinir senha
    Então acesso a tela home do aplicativo

  Cenário 02: Login com biometria
    Dado que realizo o logout para a área semi logada do app, estando com a biometria habilitada
    Quando clico em "Entrar" na área semi logada
    Então visualizo a solicitação de biometria para login

  Cenário 03: Login com senha
    Dado que realizo o logout para a área semi logada do app, estando com a biometria desabilitada
    Quando submeto a senha correta do CPF
    E clico em "Entrar" na área semi logada
    Então sou logado para a home do aplicativo com o modal de ativação de biometria

  Cenário 04: Login com senha incorreta
    Dado que realizo o logout para a área semi logada do app, estando com a biometria desabilitada
    Quando submeto a senha incorreta para o CPF
    E clico em "Entrar" na área semi logada
    Então visualizo o modal de CPF e, ou senha incorretos

  Cenário 05: Logout para a área não logada
    Dado que acesso a área semi logada do aplicativo
    Quando clico em "Trocar de conta"
    E confirmo no modal
    Então sou direcionado para a tela da área não logada

  Cenário 06: Mapa das Estações
    Dado que acesso a área semi logada do aplicativo
    Quando acesso a opção Mapa das Estações
    Então visualizo o Mapa do Transporte Metropolitano de SP

  Cenário 07: Central de Ajuda
    Dado que acesso a área semi logada do aplicativo
    Quando acesso a opção "Central de Ajuda"
    Então visualizo a página inicial da Central de Ajuda Autopass

  Cenário 08: Bilhetes offline
    Dado que acesso o menu "Bilhetes QR Code" tendo bilhetes disponíveis para utilização
    E faço o logoff do app para a área semi logada
    Quando acesso a opção "Bilhetes Offline"
    Então visualizo meus bilhetes disponíveis para utilização
