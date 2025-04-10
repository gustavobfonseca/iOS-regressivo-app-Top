# language: pt

Funcionalidade: TOP+ Recompensas e Vantagens

#Cenário: Modal TOP+ Recompensas
#  Dado que eu acesso a tela home do aplicativo
##  E seleciono uma das opções de biometria
#  Quando clico em "Quero Conhecer" no modal do TOP+ Recompensas
#  Entao visualizo o onboarding do TOP+ Recompensas

Cenário:01 Onboarding TOP+ Recompensas
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP+ Recompensas"
  Quando avanço pelas três etapas do onboarding
  Entao sou direcionado para a webview da Minu

Cenário:02 Pular Onboarding TOP+ Recompensas
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP+ Recompensas"
  Quando clico em "Pular" na primeira tela do onboarding
  Entao sou direcionado para a webview da Minu

Cenário:03 Não ver mais o Onboarding TOP+ Recompensas
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP+ Recompensas"
  Quando clico em "Não ver mais" em alguma das telas do onboarding
  E fecho a webview da Minu
  E que acesso o menu "TOP+ Recompensas"
  Entao sou direcionado para a webview da Minu

Cenário:04 Guia de Serviços TOP Saúde
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP Saúde"
  Quando clico na opção "Ver guia de serviços"
  Entao sou direcionado para a página "https://guiamedico.avus.com.br"

Cenário:05 Saiba mais sobre o TOP Saúde
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP Saúde"
  Quando clico na opção "Saiba mais sobre o TOP Saúde"
  Entao sou direcionado para a página "https://ajuda.boradetop.com.br/hc/pt-br/sections/16890580100123-TOP-Saúde"

Cenário:06 Contratar o TOP Saúde
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP Saúde"
  Quando clico no botão "Quero Contratar"
  Entao sou direcionado para a webview da Avus

Cenário:07 Desconto em loja física Drogaria São Paulo
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "Drogaria São Paulo"
  Quando clico no botão "Buscar Loja"
  Entao sou direcionado para a página "https://www.drogariasaopaulo.com.br/institucional/nossas-lojas"

Cenário:08 Desconto pelo site da Drogaria São Paulo
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "Drogaria São Paulo"
  Quando acesso a aba "Desconto pelo site"
  E clico no botão "Ir para o site"
  Entao sou direcionado para a página "https://www.drogariasaopaulo.com.br/login"

Cenário:09 Personalizar Favoritos
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "Personalizar Favoritos"
  Quando reordeno a posição dos meus benefícios
  E clico em "Confirmar"
  Entao retorno à Home com a exibição dos menus de Vantagens reordenados de acordo com a minha escolha
  E com a opção "Personalizar Favoritos" ao final da lista

  Cenário:10 SuperTOP
    Dado que eu acesso a tela home do aplicativo
    E que acesso o menu "SuperTOP"
    E clico em "Vamos lá" no modal do SuperTOP
    E pulo erro
    Quando navego até o final da tela
    Então visualizo o botão Comprar Pontos

  Cenário:11 Comprar Pontos - SuperTOP
    Dado que eu acesso a tela home do aplicativo
    E que acesso o menu "SuperTOP"
    E clico em "Vamos lá" no modal do SuperTOP
    E pulo erro
    E clico em comprar pontos
    Quando seleciono a compra de 10 pontos arrastando a barra até o máximo
    E seleciono a opção 1 chance de ganhar até R$ 500 mil
    E confirmo pix como forma de pagamento
    Então visualizo a tela de confirmação de pagamento via pix

  Cenário:12 Minhas Transações - SuperTOP
    Dado que eu acesso a tela home do aplicativo cpf "408.305.648-70 " senha "Teste123"
#    E informo as credenciais:
#      | CPF              | SENHA     |
#      | 408.305.648-70   | Teste123  |
    E que acesso o menu "SuperTOP"
    E clico em "Vamos lá" no modal do SuperTOP
    E pulo erro
    Quando clico em Minhas Transações
    E pulo erro
    Então visualizo a tela "Minhas Transações" com o botão "Comprar Pontos"

  Cenário:13 Sorteios - SuperTOP
    Dado que eu acesso a tela home do aplicativo
    E que acesso o menu "SuperTOP"
    E clico em "Vamos lá" no modal do SuperTOP
    E pulo erro
    Quando clico em Sorteios
    E pulo erro
    E navego até o final da tela
    Então visualizo o botão Comprar Pontos pelo sorteio

  Cenário:14 Vencedores - SuperTOP
    Dado que eu acesso a tela home do aplicativo
    E que acesso o menu "SuperTOP"
    E clico em "Vamos lá" no modal do SuperTOP
    E pulo erro
    Quando clico em Vencedores
    E pulo erro
    E navego até o final da tela
    Então visualizo a opção Quero saber mais
