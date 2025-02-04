# language: pt
Funcionalidade: Bilhete Unico

  Cenario:01 Onboarding Bilhete Unico
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    Entao visualizo a tela de onboarding de Bilhete Unico

  Cenario:02 Modal Onde Encontar o Numero do Bilhete
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico em Cadasrar Bilhete Unico
    E clico em Onde Encontrar o Numero do Bilhete Unico
    Entao visualizo o modal informativo sobre a localizacao do numero do bilhete

  Cenario:03 Cadastro de Bilhete Unico
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico em Cadasrar Bilhete Unico
    E submeto as informacoes validas do bilhete
      |  numero   |  apelido  |
      | 507755490 | BU Matheus|
    Entao devo visualizar a tela do BU

  Cenario:04 Validacao de recarga
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico em Saiba Mais na tela de BU
    Entao visualizo o modal de Como Validar Sua Recarga?

  Cenario:05 Cadastro de segundo Bilhete
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico em adicionar novo cartao
    E submeto as informacoes validas do bilhete
      | numero    | apelido     |
      | 510356863 | BU Matheus 2|
    Entao visualizo a tela de bilhetes cadastrados

  Cenario:06 Cadastro de Bilhete já vinculado ao CPF
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico em adicionar novo cartao
    E submeto as informacoes validas do bilhete
      | numero    | apelido     |
      | 510356863 | BU Matheus 3|
    Entao visualizo a mensagem de Bilhete Unico ja vinculado ao seu cadastro no campo numero

  Cenario:07 Cadastro de terceiro Bilhete
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico em adicionar novo cartao
    E submeto as informacoes validas do bilhete
      | numero    | apelido     |
      | 533727865 | BU Matheus 3|
    Entao visualizo a tela de bilhetes cadastrados com os 3 bilhetes
    E o botao de cadastrar bilhete unico inativo

  Cenario:08 Edicao de bilhete
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "533727865" e nome "BU Matheus 3"
    E clico em editar bilhete unico
    E altero o apelido do cartao
    Entao visualizo a tela de visualizacao de bilhete com o nome alterado

  Cenario:09 Recarga comum
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "510356863"
    E clico em Recargar
    E clico em Comum
    E confirmo um valor entre 10 e 50
    E confirmo pix como forma de pagamento para recarga de BU
    Entao visualizo a tela de codigo pix gerado para recarga de bilhete unico podendo copiar o codigo via icone ou botao Copiar Codigo Pix

  Cenario:10 Recarga comum codigo pix expirado
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "510356863"
    E clico em Recargar
    E clico em Comum
    E confirmo um valor entre 10 e 50
    E confirmo pix como forma de pagamento para recarga de BU
    Entao visualizo a tela de codigo pix expirado depois de mais de 1 minuto e meio de espera

  Cenario:11 Recarga diaria Onibus Metro e Trem
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "510356863"
    E clico em Recargar
    E clico em Diaria
    E confirmo a opcao Onibus Metro e Trem
    E confirmo o numero de cotas entre 1 e 15
    E confirmo pix como forma de pagamento para recarga de BU
    Entao visualizo a tela de codigo pix gerado para recarga de bilhete unico podendo copiar o codigo via icone ou botao Copiar Codigo Pix

  Cenario:12 Recarga diaria Metro e Trem
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "510356863"
    E clico em Recargar
    E clico em Diaria
    E confirmo a opcao Metro e Trem
    E confirmo o numero de cotas entre 1 e 15
    E confirmo pix como forma de pagamento para recarga de BU
    Entao visualizo a tela de codigo pix gerado para recarga de bilhete unico podendo copiar o codigo via icone ou botao Copiar Codigo Pix

  Cenario:13 Recarga diaria Onibus
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "510356863"
    E clico em Recargar
    E clico em Diaria
    E confirmo a opcao onibus
    E confirmo o numero de cotas entre 1 e 15
    E confirmo pix como forma de pagamento para recarga de BU
    Entao visualizo a tela de codigo pix gerado para recarga de bilhete unico podendo copiar o codigo via icone ou botao Copiar Codigo Pix

  Cenario:14 Recarga diária codigo pix expirado
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "510356863"
    E clico em Recargar
    E clico em Diaria
    E confirmo a opcao onibus
    E confirmo o numero de cotas entre 1 e 15
    E confirmo pix como forma de pagamento para recarga de BU
    Entao visualizo a tela de codigo pix expirado depois de mais de 1 minuto e meio de espera

  Cenario:15 Recarga mensal Onibus Metro e Trem
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "510356863"
    E clico em Recargar
    E clico em Mensal
    E confirmo a opcao Onibus Metro e Trem
    E confirmo pix como forma de pagamento para recarga de BU
    Entao visualizo a tela de codigo pix gerado para recarga de bilhete unico podendo copiar o codigo via icone ou botao Copiar Codigo Pix

  Cenario:16 Recarga mensal Metro e Trem
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "510356863"
    E clico em Recargar
    E clico em Mensal
    E confirmo a opcao Metro e Trem
    E confirmo pix como forma de pagamento para recarga de BU
    Entao visualizo a tela de codigo pix gerado para recarga de bilhete unico podendo copiar o codigo via icone ou botao Copiar Codigo Pix

  Cenario:17 Recarga mensal Onibus
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "510356863"
    E clico em Recargar
    E clico em Mensal
    E confirmo a opcao onibus
    E confirmo pix como forma de pagamento para recarga de BU
    Entao visualizo a tela de codigo pix gerado para recarga de bilhete unico podendo copiar o codigo via icone ou botao Copiar Codigo Pix

  Cenario:18 Recarga Mensal codigo pix expirado
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico no bilhete unico de numero "510356863"
    E clico em Recargar
    E clico em Mensal
    E confirmo a opcao onibus
    E confirmo pix como forma de pagamento para recarga de BU
    Entao visualizo a tela de codigo pix expirado depois de mais de 1 minuto e meio de espera

  Cenario:19 Exclusão de Bilhete - 3 cadastrados
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E excluo o cartao numero "533727865" e nome "MATHEUS ESTUDANTE"
    Entao não devo visualizar o cartão numero "533727865" e o nome "MATHEUS ESTUDANTE" na lista de cartoes

  Cenario:20 Exclusão de Bilhete - 2 cadastrados
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E excluo o cartao numero "510356863" e nome "BU Matheus 2"
    Entao não devo visualizar o cartão numero "510356863" e o nome "BU Matheus 2" na lista de cartoes

  Cenario:21 Exclusão de Bilhete - 1 cadastrado
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E excluo o único cartao cadastrado
    Então visualizo a tela de - Você não possui nenhum bilhete único cadastrado.

  Cenario:22 Cadastro de BU vinculado a outro CPF
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico em Cadasrar Bilhete Unico
    E submeto as informacoes validas do bilhete
      |  numero   |  apelido  |
      | 190564755 | BU Matheus|
    Entao visualizo a mensagem de "Bilhete único já está vinculado a outro perfil.” No campo Número