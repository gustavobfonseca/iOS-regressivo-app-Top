# language: pt
Funcionalidade: Sanidade

  Cenário:01 Cadastro com sucesso
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF válido ainda não cadastrado
    E submeto os demais dados corretamente até a finalização do formulário
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email
    E clico em confirmar email
    E insiro a senha "Devires@123"
    E confirmo a nova senha "Devires@123"
    E clico em confirmar cadastrar senha
    E aceito os termos de uso e privacidade
    Entao visualizo o modal de "Cadastro realizado com sucesso".

  Cenário:02 Cadastro de usuário menor de idade
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF válido ainda não cadastrado
    E informo a data de nascimento menor que 18 anos
    E clico em "Continuar" com os demais campos preenchidos dentro dos critérios de aceite, menos a data de nascimento
    Entao visualizo a mensagem de "Não é possível cadastrar menores de idade" no campo "Data de nascimento"

  Cenario:03 Login com as credenciais validas e reseto o app
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login, cpf '13715099054' e senha 'Teste123'
    Entao acesso a home do aplicativo

  Cenario:04 Login através da recuperação de senha
    Dado que acesso a opção esqueci minha senha na área não logada
    Quando informo o seguinte CPF "13715099054" que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email
    E clico em confirmar email
    E insiro a senha "Teste123"
    E confirmo a nova senha "Teste123"
    E clico em confirmar redefinir senha
    Entao acesso a tela home do aplicativo

  Cenario:04 Login com senha antiga
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login, cpf '13715099054' e senha 'Teste123'
    Entao visualizo o modal de CPF e, ou Senha inválidos

  Cenario:04 Login com nova senha e reseto o app
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login, cpf '13715099054' e senha 'Devires@1234'
    Entao acesso a home do aplicativo
    E redefino a senha

  Cenário:05 Alteração de senha
    Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico na opção "Senha do aplicativo"
    E insiro a senha atual correta
    E clico em "Editar"
    E insiro "Nova senha" e "Confirmar nova senha" válidas
    E clico em "Enviar"
    Então visualizo a mensagem de "Senha alterada com sucesso"
    E ao fazer um novo login, apenas a nova senha deve estar válida como credencial de acesso ao aplicativo

  Cenário:05 voltar senha padrao e reseto o app
      Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico na opção "Senha do aplicativo"
    E insiro a senha atual alterada "Teste@1234"
    E clico em "Editar"
    E insiro Nova senha "Teste@123" e Confirmar nova senha "Teste@123"
    E clico em "Enviar"
    Então visualizo a mensagem de "Senha alterada com sucesso"

  Cenário:06 Termo de uso
    Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico na opção "Termos de uso"
    Então sou direcionado para a página dos termos de uso na Central de Ajuda Autopass

  Cenário:07 Logout para área semi logada e reseto o app
    Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico na opção "Sair do Aplicativo" confirmando o modal
    Então sou direcionado à área semi logada do aplicativo TOP

  Cenario:09 Compra bilhete CPTM ou Metro com pagamento via cartão de crédito com o cvv preenchido corretamente
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:10 Compra de bilhete via cartão de débito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo Cartão de débito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:11 Compra de bilhete CPTM, Metro com pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    E eu habilito o mock do token no perfil do usuario
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "7734"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:14 Remover cartão de crédito como forma de pagamento tendo menos que 3 cartões cadastrados
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico na opção excluir cartão "crédito"
    E confirmo a exclusão
    Entao o cartão não deverá estar listado

  Cenario:12 Adicionar cartão de crédito como forma de pagamento tendo menos que 3 cartõe scadastrados
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de crédito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 5555 4444 3333 1111 | 03/30 | 737 | 327.721.478-86 |
    Entao visualizo a tela de Cartão cadastrado com sucesso

  Cenario:14 Remover cartão de débito como forma de pagamento tendo menos que 3 cartões cadastrados
   Dado que estou na área não logada do app
   E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
   E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico na opção excluir cartão "débito"
    E confirmo a exclusão
    Entao o cartão não deverá estar listado

  Cenario:13 Cadastro de cartão de débito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de débito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 4000 0600 0000 0006 | 03/30 | 737 | 327.721.478-86 |
    Entao visualizo a tela de Cartão cadastrado com sucesso

  Cenario:17 Compra de crédito comum - Pagamento via pix
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto pix como forma de pagamento
    Então visualizo a tela de codigo pix gerado para pagamento

  Cenario:18 Compra de crédito comum - Pagamento via cartão de crédito

    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto a opção Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:19 Compra de crédito comum - Pagamento via cartão de débito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "32772147886", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto a opção Cartão de Débito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:20 Compra de crédito comum - Pagamento via saldo em conta e reseto o app
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    E eu habilito o mock do token no perfil do usuario
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "7734"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:27 Acessar meus bilhetes offline
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E eu desligo a conexão de internet do dispositivo
    E clico na opçao Comprar Bilhetes
    E clico na opção Acessar meus bilhetes Offline
    Entao visualizo a lista de bilhetes disponiveis para uso
    E reestabeleço a conexão com a internet

  Cenario:21 Compra de crédito escolar - Pagamento via PIX
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto pix como forma de pagamento
    Então visualizo a tela de codigo pix gerado para pagamento

  Cenario:22 Compra de crédito escolar - Pagamento via cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto a opção Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:23 Compra de crédito escolar - Erro no pagamento via cartão de débito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto a opção Cartão de Débito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

#  Cenário:25 Login com biometria
#    Dado que realizo o logout para a área semi logada do app, estando com a biometria habilitada
#    Quando clico em "Entrar" na área semi logada
#    Então visualizo a solicitação de biometria para login

  Cenário:26 Login com senha
    Dado que realizo o logout para a área semi logada do app, estando com a biometria desabilitada
    Quando submeto a senha correta do CPF
    E clico em "Entrar" na área semi logada
    Então sou logado para a home do aplicativo

  Cenário:28 Logout para a área não logada
    Dado que acesso a área semi logada do aplicativo
    Quando clico em "Trocar de conta"
    E confirmo no modal
    Então sou direcionado para a tela da área não logada

