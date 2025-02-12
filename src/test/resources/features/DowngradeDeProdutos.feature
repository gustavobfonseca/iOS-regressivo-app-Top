# language: pt
Funcionalidade: Downgrade de Produtos

  #Verificar se a massa do cenário 04 está com cartão cancelado, se sim, recupere este cartão antes de executar a feature

  Cenário:01 Cancelamento de cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "53189161801", senha "Teste123"
    E acesso a home do aplicativo
    Quando que acesso o perfil de usuário
    E dou scroll até Cancelar Cartao Ou Conta Digital
    E clico em Cancelar Cartao Ou Conta Digital
    E clico em Cartao De Credito TOP
    E clico em cancelar o cartao de credito
    E clico em prosseguir com cancelamento
    Entao sou direcionado para o chatbot da Pefisa via WhatsApp

  Cenário:02 Cancelamento de conta digital
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
    E acesso a home do aplicativo
    Quando que acesso o perfil de usuário
    E dou scroll até Cancelar Cartao Ou Conta Digital
    E clico em Cancelar Cartao Ou Conta Digital
    E clico em Conta Digital
    E clico em cancelar a conta digital
    E clico em prosseguir com cancelamento de conta digital
    Entao sou direcionado para o chatbot da Pefisa via WhatsApp

  Cenário:03 Cancelamento de cartão transporte com pendências
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "90099644002", senha "Teste123"
    E acesso a home do aplicativo
    Quando que acesso o perfil de usuário
    E dou scroll até Cancelar Cartao Ou Conta Digital
    E clico em Cancelar Cartao Ou Conta Digital
    E clico em Cartao Transporte
    Entao visualizo a pendência de saldo existente

  #Recuperar cartão cancelado depois de executado esse cenário

  Cenário:04 Cancelamento de cartão transporte
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "32505664544", senha "Teste123"
    E acesso a home do aplicativo
    Quando que acesso o perfil de usuário
    E dou scroll até Cancelar Cartao Ou Conta Digital
    E clico em Cancelar Cartao Ou Conta Digital
    E clico em Cartao Transporte
    E clico em quero cancelar meu cartao TOP
    E seleciono o motivo do cancelamento
    E confirmo meus dados cadastrais
#    Esta parte do fluxo está manual devido a um erro no modal de confirmação
    E clico no botao Quero Cancelar Meu Cartao TOP
    Entao visualizo a tela de cartao cancelado com sucesso

  Cenário:05 Reportar cartão hibrido perdido ou danificado
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
    E acesso a home do aplicativo
    Quando que acesso o perfil de usuário
    E dou scroll até Cancelar Cartao Ou Conta Digital
    E clico em Cancelar Cartao Ou Conta Digital
    E clico em Reportar Cartao Perdido ou Danificado
    E clico em cancelar a cartao perdido ou danificado
    Entao sou direcionado para o chatbot da Pefisa via WhatsApp

  Cenário:06 Comunicar Perda Roubo de cartão Puro transporte
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "32505664544", senha "Teste123"
    E acesso a home do aplicativo
    Quando que acesso o perfil de usuário
    E dou scroll até Cancelar Cartao Ou Conta Digital
    E clico em Cancelar Cartao Ou Conta Digital
    E clico em Reportar Cartao Perdido ou Danificado
    E seleciono o motivo do cancelamento do puro transporte
    E confirmo meus dados cadastrais
#    Esta parte do fluxo está manual devido a um erro no modal de confirmação
    E clico no botao Quero Cancelar Meu Cartao TOP
    Entao visualizo a tela de cartao cancelado com sucesso com a opcao de solicitar a segunda via

  Cenário:07 Encerramento de cadastro com pendências
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "53189161801", senha "Teste123"
    E acesso a home do aplicativo
    E navego ate cartao de credito
    E vou ate conta digital
    E vou ate cartao TOP
    E vou ate a home
    Quando que acesso o perfil de usuário
    E dou scroll até Cancelar Cartao Ou Conta Digital
    E clico em encerrar cadastro no TOP
    Entao visualizo as pendencias antes de encerrar

#    Criar uma conta a partir do 4devs para os cenários 08 e 09
  Cenário:08 Encerramento de cadastro
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "04218095078", senha "Teste123"
    E acesso a home do aplicativo
    Quando que acesso o perfil de usuário
    E dou scroll até Cancelar Cartao Ou Conta Digital
    E clico em encerrar cadastro no TOP
    E clico em Quero cancelar meu cadastro
    E seleciono o motivo do cancelamento do cadastro
    E confirmo meus dados cadastrais
#    Esta parte do fluxo está manual devido a um erro no modal de confirmação
    E clico no botao Quero Cancelar Meu Cadastro
    Entao visualizo a tela de cancelamento efetuado com sucesso
    E ao finalizar devo ser desligado do app

  Cenario:09 login apos encerramento de cadastro
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "32241338052", senha "Teste123"
    Entao visualizo o modal de usuário bloqueado