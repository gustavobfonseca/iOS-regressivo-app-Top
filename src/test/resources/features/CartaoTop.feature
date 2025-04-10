# language: pt

Funcionalidade: Cartão TOP

Cenário: 01 - Onboarding Puro Transporte
  Dado que acesso o app com uma conta nova
  Quando acesso o menu Transporte
  E clico na opção "Eu Quero" na vitrine de Puro Transporte
  E seleciono a opção Receber em casa
  Então sou direcionado para o serviço de envio de cartão da Pacman

Cenário: 02 - Onboarding Puro Transporte Sênior
  Dado que acesso o app com uma conta nova, tendo 60 anos ou mais
  Quando acesso o menu Transporte
  E clico na opção "Eu Quero" na vitrine de Puro Transporte
  E clico em "Continuar" na tela sobre direito à gratuidade
  Então visualizo apenas a opção de "Retirar em loja" como forma de recebimento do cartão

Cenario: Compra de combo de Crédito Comum + 1.000 pontos - Pagamento via PIX
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo
  Quando submeto a recarga comum informando valor entre "R$4,00" e "R$100,00"
  E seleciono Continuar compra com pontos no modal do Super TOP
  E clico em Outro valor
  E submeto o valor de R$1000
  #10 reais
  E confirmo pix como forma de pagamento
  Então visualizo a tela de confirmação de pagamento via pix

  Cenario: Compra de combo de Crédito Comum + 150 pontos - Pagamento via Cartão de Débito
    Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo com Cartão de Débito cadastrado
#    | CPF | SENHA |
#    | 016.276.920-29 | Teste123 |
    Quando submeto a recarga comum informando valor entre "R$4,00" e "R$100,00"
    E seleciono Continuar compra com pontos no modal do Super TOP
    E seleciono "150" pontos do SuperTop
    E confirmo Cartão de débito como forma de pagamento
    E confirmo o pagamento informando o CVV "123"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenário: Compra de combo de Crédito Escolar - Pagamento via Cartão de Débito - 50 pontos
    Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte Escolar" ativo e Cartão de Débito válido cadastrado
#  | CPF           | SENHA    |
#  | 365.369.350-04| Teste123 |
    Quando submeto a recarga escolar informando valor entre "R$10,00" e "R$250,00"
    E seleciono Continuar compra com pontos no modal do Super TOP
    E confirmo Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "123"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenário: 03 - Compra de Crédito Comum - Pagamento via PIX
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo
#  | CPF           | SENHA    |
#  | 519.197.408-56| Teste123 |
  Quando submeto a recarga comum informando valor entre "R$4,00" e "R$100,00"
  E seleciono "Talvez Mais Tarde" no modal do Super TOP
  E confirmo pix como forma de pagamento
  Então visualizo a tela de confirmação de pagamento via pix

#Cenário: 04 - Compra de Crédito Comum - Pagamento via Cartão de Crédito
#  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo com Cartão de Crédito cadastrado
##  | CPF           | SENHA    |
##  | 016.276.920-29| Teste123 |
#  Quando submeto a recarga comum informando valor entre "R$4,00" e "R$100,00"
#  E seleciono "Talvez Mais Tarde" no modal do Super TOP
#  E confirmo Cartão de crédito como forma de pagamento
#  E confirmo o pagamento informando o CVV "123"
#  Então visualizo a tela de Pagamento efetuado com sucesso

#Cenário: 05 - Compra de Crédito Comum - Erro no Pagamento via Cartão de Crédito cadastrado
#  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo com Cartão de Crédito cadastrado
#  E possuo Cartão de Crédito inválido cadastrado
##  | CPF           | SENHA    |
##  | 016.276.920-29| Teste123 |
#  Quando submeto a recarga comum informando valor entre "R$4,00" e "R$100,00"
#  E seleciono "Talvez Mais Tarde" no modal do Super TOP
#  E submeto a compra com cartão de crédito inválido
#  E confirmo o pagamento informando o CVV "010"
#  Então visualizo a tela de Erro no pagamento

Cenário: 06 - Compra de Crédito Comum - Pagamento via Cartão de Débito
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo com Cartão de Débito cadastrado
#  | CPF           | SENHA    |
#  | 730.889.410-03| Teste123 |
  Quando submeto a recarga comum informando valor entre "R$4,00" e "R$100,00"
  E seleciono "Talvez Mais Tarde" no modal do Super TOP
  E confirmo Cartão de débito como forma de pagamento
  E confirmo o pagamento informando o CVV "123"
  Então visualizo a tela de Pagamento efetuado com sucesso

Cenário: 07 - Compra de Crédito Comum - Erro no Pagamento via Cartão de Débito
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo com Cartão de Débito cadastrado
#  | CPF           | SENHA    |
#  | 730.889.410-03| Teste123 |
  Quando submeto a recarga comum informando valor entre "R$4,00" e "R$100,00"
  E seleciono "Talvez Mais Tarde" no modal do Super TOP
  E submeto a compra com cartão de débito inválido
  E confirmo o pagamento informando o CVV "001"
  Então visualizo a tela de Erro no pagamento

Cenário: 08 - Compra de Crédito Comum - Pagamento via Saldo em Conta
  Dado que tendo cartão híbrido ativo com saldo em conta eu habilito o mock do token no perfil
  E acesse o Cartao Top na Home
#  | CPF           | SENHA    | SENHA PGTO |
#  | 519.197.408-56| Teste123 | 1571       |
  Quando submeto a recarga comum informando valor entre "R$4,00" e "R$100,00"
  E seleciono "Talvez Mais Tarde" no modal do Super TOP
  E confirmo saldo disponível como forma de pagamento
  E confirmo o pagamento informando a senha "1571"
  Então visualizo a tela de Pagamento efetuado com sucesso

Cenário: 09 - Compra de Crédito Comum - Erro no Pagamento via Saldo em Conta
 Dado que tendo cartão híbrido ativo com saldo em conta eu habilito o mock do token no perfil
  E acesse o Cartao Top na Home
#  | CPF           | SENHA    | SENHA PGTO |
#  | 519.197.408-56| Teste123 | 1234       |
  Quando submeto a recarga comum informando valor entre "R$4,00" e "R$100,00"
  E seleciono "Talvez Mais Tarde" no modal do Super TOP
  E confirmo saldo disponível como forma de pagamento
  E confirmo o pagamento informando a senha "1500"
  Então visualizo a tela de Erro no pagamento

Cenário: 10 - Informativo Escolar - Meia Tarifa
  Dado que acesso o menu "Cartão TOP" tendo o produto Transporte Escolar ativo e Cartão de Crédito válido cadastrado
#  | CPF           | SENHA    |
#  | 054.540.810-51| Teste123 |
  Quando expando o modal de "Saldo"
  E clico na opção "Saiba mais" no item "Escolar"
  Então visualizo a tela informativa do benefício "Escolar (meia tarifa)"

Cenário: 11 - Direcionamento para as dúvidas sobre o benefício escolar
  Dado que acesso o menu "Cartão TOP" tendo o produto Transporte Escolar ativo e Cartão de Crédito válido cadastrado
#  | CPF           | SENHA    |
#  | 054.540.810-51| Teste123 |
  Quando expando o modal de "Saldo"
  E clico na opção "Saiba mais" no item "Escolar"
  E visualizo a tela informativa do benefício "Escolar (meia tarifa)"
  Quando clico na label de "Dúvidas sobre seu Benefício Escolar?"
  Então sou direcionado para a página "emtu.sp.gov.br/passe/indexregiao.htm"

Cenário: 12 - Compra de Crédito Escolar - Pagamento via PIX
Dado que acesso o menu "Cartão TOP" tendo o produto Transporte Escolar ativo e Cartão de Crédito válido cadastrado
#| CPF           | SENHA    |
#| 054.540.810-51| Teste123 |
  Quando submeto a recarga escolar informando valor entre "R$10,00" e "R$250,00"
  E seleciono "Talvez Mais Tarde" no modal do Super TOP
  E confirmo pix como forma de pagamento
  Então visualizo a tela de confirmação de pagamento via pix

#  Cenário: 13 - Compra de Crédito Escolar - Pagamento via Cartão de Crédito
#  Dado que acesso o menu "Cartão TOP" tendo o produto Transporte Escolar ativo e Cartão de Crédito válido cadastrado
##    | CPF           | SENHA    |
##    | 054.540.810-51| Teste123 |
#  Quando submeto a recarga escolar informando valor entre "R$10,00" e "R$250,00"
#  E seleciono "Talvez Mais Tarde" no modal do Super TOP
#  E confirmo Cartão de crédito como forma de pagamento
#  E confirmo o pagamento informando o CVV "123"
#  Então visualizo a tela de Pagamento efetuado com sucesso

#Cenário: 14 - Compra de Crédito Escolar - Erro no Pagamento via Cartão de Crédito
#  Dado que acesso o menu "Cartão TOP" tendo o produto Transporte Escolar ativo e Cartão de Crédito válido cadastrado
#  E possuo Cartão de Crédito inválido cadastrado
##  | CPF           | SENHA    |
##  | 054.540.810-51| Teste123 |
#  Quando submeto a recarga escolar informando valor entre "R$10,00" e "R$250,00"
#  E seleciono "Talvez Mais Tarde" no modal do Super TOP
#  E submeto a compra com cartão de crédito inválido
#  E confirmo o pagamento informando o CVV "010"
#  Então visualizo a tela de Erro no pagamento

Cenário: 15 - Compra de Crédito Escolar - Pagamento via Cartão de Débito
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte Escolar" ativo e Cartão de Débito válido cadastrado
#  | CPF           | SENHA    |
#  | 365.369.350-04| Teste123 |
  Quando submeto a recarga escolar informando valor entre "R$10,00" e "R$250,00"
  E seleciono "Talvez Mais Tarde" no modal do Super TOP
  E confirmo Cartão de débito como forma de pagamento
  E confirmo o pagamento informando o CVV "001"
  Então visualizo a tela de Pagamento efetuado com sucesso

Cenário: 16 - Compra de Crédito Escolar - Erro no Pagamento via Cartão de Débito
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte Escolar" ativo e Cartão de Débito válido cadastrado
#| CPF           | SENHA    |
#| 365.369.350-04| Teste123 |
Quando submeto a recarga escolar informando valor entre "R$4,00" e "R$100,00"
  E seleciono "Talvez Mais Tarde" no modal do Super TOP
  E submeto a compra com cartão de débito inválido
  E confirmo o pagamento informando o CVV "001"
  Então visualizo a tela de Erro no pagamento

  #Precisa de massa com histórico
Cenário: 17 - Filtro de Histórico
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte Escolar" ativo e Cartão de Débito válido cadastrado
#E possuo registros no histórico
  Quando aplico filtros por "Período" e "Tipo de Transação"
  Então retorno à página inicial de Transporte sendo retornado apenas os registros de histórico correspondentes aos filtros aplicados

Cenário: 18 - Comunicar Perda Roubo de Cartão Híbrido
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo
#  | CPF           | SENHA    |
#  | 519.197.408-56| Teste123 |
  Quando clico no botão Comunicar Perda Roubo
  E cancelo e retorno
  E clico em Prosseguir com o cancelamento
  Então sou direcionado para o chatbot da Pefisa via WhatsApp

Cenário: 19 - Comunicar Perda Roubo de Cartão Puro Transporte
Dado que acesso o menu "Cartão TOP" tendo o produto Puro Transporte ativo
#| CPF           | SENHA    |
#| 325.056.645-44| Teste123 |
Quando clico no botão Comunicar Perda Roubo
E submeto o cancelamento
Então visualizo a tela de "Cartão cancelado com sucesso" com a opção de "Solicitar segunda via"

Cenário: 20 - Informativo Escolar Passe Livre
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo com "Passe Livre" liberado
#  | CPF           | SENHA    |
#  | 511.684.292-42| Teste123 |
  Quando expando o modal de "Benefícios" possuindo escolar
  E clico na opção "Saiba mais" no item "Passe Livre" possuindo escolar
  Então visualizo a tela informativa do benefício "Passe Livre"

Cenário: 21 - Direcionamento para as dúvidas sobre o benefício passe escolar
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo com "Passe Livre" liberado
#  | CPF           | SENHA    |
#  | 511.684.292-42| Teste123 |
  E expando o modal de "Benefícios" possuindo escolar
  E  clico na opção "Saiba mais" no item Passe Livre possuindo escolar
  E visualizo a tela informativa do benefício "Passe Livre"
  Quando clico na label de Dúvidas sobre seu Benefício Escolar?
  Então sou direcionado para a página "https://www.emtu.sp.gov.br/passe/indexregiao.htm"

Cenário: 22 - Informativo Sênior
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo com Sênior liberado
#  | CPF           | SENHA    |
#  | 799.647.710-88| Teste123 |
  Quando expando o modal de "Benefícios" possuindo senior
  E  clico na opção "Saiba mais" no item Passe Livre possuindo escolar
  Então visualizo a tela informativa do benefício Sênior

Cenário: 23 - Direcionamento para as dúvidas sobre o benefício sênior
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo com Sênior liberado
#  | CPF           | SENHA    |
#  | 799.647.710-88| Teste123 |
  E expando o modal de "Benefícios" possuindo senior
  E  clico na opção "Saiba mais" no item Passe Livre possuindo escolar
  E visualizo a tela informativa do benefício Sênior
  Quando clico no texto "Central de Ajuda" no Senior
  Então sou direcionado para a página do TOP Sênior na Central de Ajuda Autopass

Cenário: 24 - Benefício Sênior + Escolar Passe Livre
  Dado que acesso o menu "Cartão TOP" tendo o produto "Transporte" ativo com possuo os benefícios "Passe Livre" e "Sênior"
#  | CPF           | SENHA    |
#  | 0.258.833-03| Teste123 |
  Quando expando o modal de "benefícios" possuindo escolar
  Então visualizo a informação de ambos os benefícios com suas datas de validade