# language: pt

Funcionalidade: Antecipação de FGTS

#  usuário híbrido 519.197.408-56
#  usuário Puro Transporte com banking cancelado  419.649.498-66
#  usuário Puro Transporte que nunca solicitou conta digital 054.540.810-51

  Cenário: Inibição da funcionalidade para usuário híbrido
#  Dado que sou usuário híbrido do app TOP
    Dado que estou na área não logada do app
    Quando submeto as seguintes credenciais validas para login, cpf "519.197.408-56", senha "Teste123"
    E acesso a home do aplicativo
    Então não visualizo o banner e botão de Antecipação de FGTS na Home após refletir a feature fala de Conta Digital

Cenário: Acesso via banner
  Dado que estou na área não logada do app
  Quando submeto as seguintes credenciais validas para login, cpf "419.649.498-66", senha "Teste123"
  E acesso a home do aplicativo
#  Dado que efetuo login sendo usuário Puro Transporte com banking cancelado
  Quando acesso o banner de antecipação de FGTS na Home
  Então sou direcionado à tela de vantagens da antecipação de FGTS

Cenário: Acesso via botão
  Dado que estou na área não logada do app
  Quando submeto as seguintes credenciais validas para login, cpf "054.540.810-51", senha "Teste123"
  E acesso a home do aplicativo
#  Dado que efetuo login sendo usuário Puro Transporte que nunca solicitou conta digital
  Quando acesso a opção "Antecipação de FGTS" na área de banking da Home
  Então sou direcionado à tela de vantagens da antecipação de FGTS

Cenário: Direcionamento à loja do app FGTS via link nos steps
  Dado que estou na área não logada do app
  Quando submeto as seguintes credenciais validas para login, cpf "419.649.498-66", senha "Teste123"
  E acesso a home do aplicativo
  Dado acesso a opção "Antecipação de FGTS" na área de banking da Home
  Quando clico no botão "Continuar" na tela de vantagens
  E clico em "Ainda não tenho o app FGTS" na tela de orientações
  Então sou direcionado à página do app FGTS na loja da plataforma utilizada (Play Store ou APP Store)

Cenário: Direcionamento à loja do app FGTS via botão
  Dado que estou na área não logada do app
  Quando submeto as seguintes credenciais validas para login, cpf "419.649.498-66", senha "Teste123"
  E acesso a home do aplicativo
  Quando acesso a opção "Antecipação de FGTS" na área de banking da Home
  Quando clico no botão "Continuar" na tela de vantagens
  E clico no botão "Acessar app FGTS" na tela de orientações
  Então sou direcionado à página do app FGTS na loja da plataforma utilizada (Play Store ou APP Store)

Cenário: Direcionamento à página da Up.p
  Dado que estou na área não logada do app
  Quando submeto as seguintes credenciais validas para login, cpf "419.649.498-66", senha "Teste123"
  E acesso a home do aplicativo
  Quando acesso a opção "Antecipação de FGTS" na área de banking da Home
  Quando clico no botão "Continuar" na tela de vantagens
  E movo o carrossel até o step 2
  E marco o checkbox da declaração de consulta ao saldo do FGTS
  E clico no botão Continuar para a contratação
  Então sou direcionado à página de simulação da Up.p via navegador do dispositivo
