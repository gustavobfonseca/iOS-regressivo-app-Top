# language: pt

Funcionalidade: TOP+ Recompensas e Vantagens

#Cenário: Modal TOP+ Recompensas
#  Dado que eu acesso a tela home do aplicativo
##  E seleciono uma das opções de biometria
#  Quando clico em "Quero Conhecer" no modal do TOP+ Recompensas
#  Entao visualizo o onboarding do TOP+ Recompensas

Cenário: Onboarding TOP+ Recompensas
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP+ Recompensas"
  Quando avanço pelas três etapas do onboarding
  Entao sou direcionado para a webview da Minu

Cenário: Pular Onboarding TOP+ Recompensas
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP+ Recompensas"
  Quando clico em "Pular" na primeira tela do onboarding
  Entao sou direcionado para a webview da Minu

Cenário: Não ver mais o Onboarding TOP+ Recompensas
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP+ Recompensas"
  Quando clico em "Não ver mais" em alguma das telas do onboarding
  E fecho a webview da Minu
  E que acesso o menu "TOP+ Recompensas"
  Entao sou direcionado para a webview da Minu

Cenário: Guia de Serviços TOP Saúde
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP Saúde"
  Quando clico na opção "Ver guia de serviços"
  Entao sou direcionado para a página "https://guiamedico.avus.com.br"

Cenário: Saiba mais sobre o TOP Saúde
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP Saúde"
  Quando clico na opção "Saiba mais sobre o TOP Saúde"
  Entao sou direcionado para a página "https://ajuda.boradetop.com.br/hc/pt-br/sections/16890580100123-TOP-Saúde"

Cenário: Contratar o TOP Saúde
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "TOP Saúde"
  Quando clico no botão "Quero Contratar"
  Entao sou direcionado para a webview da Avus

Cenário: Desconto em loja física Drogaria São Paulo
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "Drogaria São Paulo"
  Quando clico no botão "Buscar Loja"
  Entao sou direcionado para a página "https://www.drogariasaopaulo.com.br/institucional/nossas-lojas"

Cenário: Desconto pelo site da Drogaria São Paulo
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "Drogaria São Paulo"
  Quando acesso a aba "Desconto pelo site"
  E clico no botão "Ir para o site"
  Entao sou direcionado para a página "https://www.drogariasaopaulo.com.br/login"

Cenário: Personalizar Favoritos
  Dado que eu acesso a tela home do aplicativo
  E que acesso o menu "Personalizar Favoritos"
  Quando reordeno a posição dos meus benefícios
  E clico em "Confirmar"
  Entao retorno à Home com a exibição dos menus de Vantagens reordenados de acordo com a minha escolha
  E com a opção "Personalizar Favoritos" ao final da lista