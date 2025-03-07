# language: pt
Funcionalidade: BilhetesQrCode
#MASSA CARTAO INVALIDO
  #DÉBITO - 37667124035
  # CRÉDITO - 16656110061

#  ajustar massas geral

  Cenario:01 Compra bilhete CPTM ou Metro com pagamento via pix
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opçao Comprar Bilhetes
    E adiciono "1" com a opção Metro e Trem pré selecionada
    E confirmo as seleções
    E seleciono "Talvez Mais Tarde" no modal do Super TOP
    E confirmo pix como forma de pagamento
    Então visualizo a tela de confirmação de pagamento via pix

  Cenario:02 Compra bilhete CPTM ou Metro com pagamento via cartão de crédito com o cvv preenchido incorretamente
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "16656110061", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opçao Comprar Bilhetes
    E adiciono "1" com a opção Metro e Trem pré selecionada
    E confirmo as seleções
    E seleciono "Talvez Mais Tarde" no modal do Super TOP
    E confirmo Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

  Cenario:03 Compra bilhete CPTM ou Metro com pagamento via cartão de crédito com o cvv preenchido corretamente
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opçao Comprar Bilhetes
    E adiciono "1" com a opção Metro e Trem pré selecionada
    E confirmo as seleções
    E seleciono "Talvez Mais Tarde" no modal do Super TOP
    E confirmo Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "123"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:04 Erro na compra de bilhete via cartão de débito informando o cvv incorreto
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "37667124035", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opçao Comprar Bilhetes
    E adiciono "1" com a opção Metro e Trem pré selecionada
    E confirmo as seleções
    E seleciono "Talvez Mais Tarde" no modal do Super TOP
    E confirmo Cartão de débito como forma de pagamento
    E confirmo o pagamento informando o CVV "333"
    Então visualizo a tela de Erro no pagamento

  Cenario:05 Compra de bilhete via cartão de débito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opçao Comprar Bilhetes
    E adiciono "1" com a opção Metro e Trem pré selecionada
    E confirmo as seleções
    E seleciono "Talvez Mais Tarde" no modal do Super TOP
    E confirmo Cartão de débito como forma de pagamento
    E confirmo o pagamento informando o CVV "123"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:06 Compra de bilhete CPTM, Metro com pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
    E acesso a home do aplicativo
    E eu habilito o mock do token no perfil do usuario
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opçao Comprar Bilhetes
    E adiciono "1" com a opção Metro e Trem pré selecionada
    E confirmo as seleções
    E seleciono "Talvez Mais Tarde" no modal do Super TOP
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha "1571"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:07 Erro na compra de bilhete CPTM, Metro com pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Teste123"
    E acesso a home do aplicativo
    E eu habilito o mock do token no perfil do usuario
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opçao Comprar Bilhetes
    E adiciono "1" com a opção Metro e Trem pré selecionada
    E confirmo as seleções
    E seleciono "Talvez Mais Tarde" no modal do Super TOP
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha "1111"
    Então visualizo a tela de Erro no pagamento

  Cenario:08 Remover cartão de crédito como forma de pagamento
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "16656110061", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opção Formas de Pagamento
    E clico na opção excluir cartão "crédito"
    E confirmo a exclusão
    Entao o cartão não deverá estar listado

  Cenario:09 Adicionar cartão de crédito como forma de pagamento tendo menos que 4 cartões cadastrados
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "16656110061", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de crédito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 4001 7482 7831 6091 | 01/28 | 123 | 327.721.478-86 |
    Entao visualizo a tela de Cartão cadastrado com sucesso

  Cenario:10 Cadastro de cartão de crédito inválido
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "16656110061", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de crédito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 1234 5678 9101 1123 | 03/30 | 111 | 327.721.478-86 |
    Entao visualizo a tela de falha no cadastro

  Cenario:11 Remover cartão de débito como forma de pagamento
   Dado que estou na área não logada do app
   E submeto as seguintes credenciais validas para login, cpf "37667124035", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opção Formas de Pagamento
    E clico na opção excluir cartão "débito"
    E confirmo a exclusão
    Entao o cartão não deverá estar listado

  Cenario:12 Cadastro de cartão de débito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "37667124035", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de débito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro |  4001 7482 7831 6091 | 01/28 | 123 | 327.721.478-86 |
    Entao visualizo a tela de Cartão cadastrado com sucesso

  Cenario:13 Cadastro de cartão de débito inválido
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de débito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 1234 5678 9101 1123 | 03/30 | 111 | 327.721.478-86 |
    Entao visualizo a tela de falha no cadastro

  Cenario:14 Acessar meus bilhetes offline
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E eu desligo a conexão de internet do dispositivo
    E clico na opçao Comprar Bilhetes
    E clico na opção Acessar meus bilhetes Offline
    Entao visualizo a lista de bilhetes disponiveis para uso
    E reestabeleço a conexão com a internet

  Cenario:15 Acessar minhas formas de pagamento ao reestabelecer a conexão com a internet
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E eu desligo a conexão de internet do dispositivo
    E clico na opção Formas de Pagamento
    E reestabeleço a conexão com a internet
    E clico em tentar novamente
    Entao visualizo a tela de formas de pagamento

  Cenario:16 Historico de compra de bilhete
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo
    E clico no ultimo registro de compra no historico
    Entao visualizo o modal com os detalhes da compra


