# language: pt

Funcionalidade: Mobilidade
  Ref. Mobilidade > Rotas e Trajetos
  Ref. Mobilidade > Seleção de Trajeto
  Ref. Mobilidade > Encerrar Viagem
  Ref. Mobilidade > Pontos de Ônibus e Metrô
  Ref. Mobilidade > Re-centralização

#  Cenário:02 Mobilidade
#    Dado que eu acesso a tela home do aplicativo
#    Quando clico na opção Mobilidade
#    Então visualizo a tela de "Disponível em breve"


  Cenario:01 Mapa das estações
    Dado que eu acesso a tela home do aplicativo
    Quando clico na opção Mapa das estações
    Então visualizo o Mapa do Transporte Metropolitano de SP

  Cenario:02 Rotas e Trajetos
    Dado que eu acesso a tela home do aplicativo
    Quando clico na opção Mobilidade
    E seleciono a opção Rotas e Trajetos no modal
    E insiro um endereco de origem e destino
    Então visualizo a lista de opções de rotas possíveis

  Cenario:03 Seleção de Trajeto
    Dado que eu acesso a tela home do aplicativo
    E clico na opção Mobilidade
    E seleciono a opção Rotas e Trajetos no modal
    E insiro um endereco de origem e destino
    E visualizo a lista de opções de rotas possíveis
    Quando seleciono uma das rotas listadas
    E arrasto o modal para cima
    Então visualizo todo o trajeto entre meu endereço de origem até meu destino

  Cenario:04 Encerrar Viagem
    Dado que eu acesso a tela home do aplicativo
    E clico na opção Mobilidade
    E seleciono a opção Rotas e Trajetos no modal
    E insiro um endereco de origem e destino
    E visualizo a lista de opções de rotas possíveis
    Quando seleciono uma das rotas listadas
    E arrasto o modal para cima
    E visualizo todo o trajeto entre meu endereço de origem até meu destino
    E clico na opção Encerrar viagem
    Então retorno ao status inicial, limpando toda busca realizada

  Cenario:05 Pontos de Ônibus e Metrô
    Dado que eu acesso a tela home do aplicativo
    Quando clico na opção Mobilidade
    E seleciono a opção Ônibus e Metrô no modal
    Então visualizo o modal "Ônibus e metrô próximos de você" listando todos os endereços dos pontos retornados.

  Cenario:06 Re-centralização
    Dado que eu acesso a tela home do aplicativo
    E clico na opção Mobilidade
    Quando movo a posição do mapa
    E clico no botão de centralização
    Então o mapa centraliza para a minha posição atual
