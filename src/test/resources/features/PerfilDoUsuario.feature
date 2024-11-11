# language: pt
Funcionalidade: Perfil do usuário

  Cenário:01 Inclusão de foto de perfil via câmera
    Dado que eu acesso a tela home do aplicativo
    E não possua foto de perfil
    E sem ter a permissão de acesso à câmera habilitada para o aplicativo TOP
    Quando clico em minha apresentação na Home
    E clico na opção "Editar" em "Foto de Perfil"
    E seleciono a opção "Tirar Foto" no modal
    E habilito a permissão de acesso à câmera
    E seleciono a opção "Tirar Foto" no modal
    E submeto o envio de uma foto através da câmera do dispositivo,
    Então visualizo a foto enviada na tela de perfil de usuário
    E na apresentação da Home.

# BLOQUEADO
#  Cenário: Remoção de foto de perfil
#    Dado que acesso a Home do aplicativo tendo foto de perfil
#    Quando clico em minha apresentação na Home
#    E clico na opção "Editar" em "Foto de Perfil"
#    E seleciono a opção "Remover minha foto" no modal
#    Então minha foto é removida no perfil de usuário
#    E removida na apresentação da Home


  Cenário:02 Inclusão de foto de perfil via galeria
#    Dado que eu acesso a tela home do aplicativo
    Dado que acesso a Home do aplicativo sem possuir foto de perfil
    E sem ter a permissão de acesso à galeria habilitada para o aplicativo TOP
    Quando clico em minha apresentação na Home
    E clico na opção "Editar" em "Foto de Perfil"
    E seleciono a opção Escolher Foto no modal
    E habilito a permissão de acesso à galeria
    E submeto o envio de uma foto através da galeria do dispositivo
    Então visualizo a foto enviada na tela de perfil de usuário
    E na apresentação da Home.


  Cenário:03 Alteração de Apelido ou Nome Social
#    Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando insiro dados com mais de 2 caracteres no campo "Apelido ou nome social"
    E clico no ícone de edição para salvar
    Então visualizo a mensagem "Apelido atualizado com sucesso, apelidoAtualizado!"
    E visualizo o apelido ou nome social na Home
    E visualizo apelido ou nome social na área semi-logada do aplicativo

#teste Matheus
  Cenário: 04 Meu telefone de contato Pefisa
    Dado que acesso o perfil de usuário tendo produtos de banking ativos
    Quando clico na opção "Seus telefones de contato"
    E seleciono a opção Celular (Cadastro Conta Digital | Crédito)
    E seleciono a opção Celular (Cadastro Conta Digital | Crédito)
    Então sou direcionado para o chatbot Pefisa via WhatsApp



  Cenário: Alteração de senha com senha atual incorreta
#        Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico na opção "Senha do aplicativo"
    E insiro a senha atual incorreta
    E clico em "Editar"
    E insiro "Nova senha" e "Confirmar nova senha" válidas
    E clico em "Enviar"
    Então visualizo a mensagem de "Senha atual inválida"

  Cenário: alteração de senha com novas senhas divergentes
#        Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico na opção "Senha do aplicativo"
    E insiro a senha atual correta
    E clico em "Editar"
    E insiro "Nova senha" e "Confirmar nova senha" divergentes
    E clico em "Enviar"
    Então visualizo a mensagem "As senhas devem ser iguais" no campo "Confirmar nova senha"
    E retorno a senha para a senha alterada não atrapalhe na continuação dos outros testes do regressivo


  Cenário: Meu telefone de contato Autopass
    #        Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico na opção "Seus telefones de contato"
    E seleciono a opção "Celular (Transporte)"
    E seleciono a opção "Celular (Transporte)"
    Então sou direcionado para o atendimento Autopass via WhatsApp

  Cenário: Autenticação biométrica ativa
    #        Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário com biometria ativa
    Quando faço o logoff do app para a área semi logada
    E clico em "Entrar" na área semi logada
    Então visualizo a solicitação de biometria para login
#  Ou a solicitação de Face ID

  Cenário: Biométrica desativada
    #        Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário com biometria ativa
    Quando desabilito o Touch ID ou Face ID no campo "Autenticação biométrica"
    E faço o logoff do app para a área semi logada
    E submeto a senha correta do CPF "Teste@123"
    E clico em "Entrar" na área semi logada
    Então sou logado para a home do aplicativo com o modal de ativação de biometria


  Cenário: Termo de uso
#    Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico na opção "Termos de uso"
    Então sou direcionado para a página dos termos de uso na Central de Ajuda Autopass

  Cenário: Logout para área semi logada
#        Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico na opção "Sair do Aplicativo" confirmando o modal
    Então sou direcionado à área semi logada do aplicativo TOP

  Cenário: Central de ajuda
#            Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico no "Central de Ajuda"
#    Ou no ícone (?) no header
    Então sou direcionado para o a página inicial da Central de Ajuda Autopass

  Cenário: Alteração de senha
    Dado que eu acesso a tela home do aplicativo
    Dado que acesso o perfil de usuário
    Quando clico na opção "Senha do aplicativo"
    E insiro a senha atual correta
    E clico em "Editar"
    E insiro "Nova senha" e "Confirmar nova senha" válidas
    E clico em "Enviar"
    Então visualizo a mensagem de "Senha alterada com sucesso"
    E ao fazer um novo login, apenas a nova senha deve estar válida como credencial de acesso ao aplicativo

    Cenário: voltar senha padrao
#      Dado que eu acesso a tela home do aplicativo
      Dado que acesso o perfil de usuário
      Quando clico na opção "Senha do aplicativo"
      E insiro a senha atual alterada "Teste@1234"
      E clico em "Editar"
      E insiro Nova senha "Teste@123" e Confirmar nova senha "Teste@123"
      E clico em "Enviar"
      Então visualizo a mensagem de "Senha alterada com sucesso"





