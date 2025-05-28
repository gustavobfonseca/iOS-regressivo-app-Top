# Testes-regressivo-app-TOP
Aqui é onde iremos versionar todos os nossos testes regressivos

# Automação iOS APP TOP com Appium

Este projeto refere-se à automação de testes do aplicativo TOP para a plataforma iOS utilizando Appium. A execução é feita exclusivamente em emulador, preferencialmente no modelo iPhone 14.

## 🔧 Pré-requisitos

Certifique-se de que todos os seguintes pré-requisitos estejam instalados e configurados em seu sistema macOS:

1. **Xcode**
    - Instale via App Store.
    - Aceite os termos de licença executando:
      ```bash
      sudo xcodebuild -license
      ```
    - Verifique se o simulador iPhone está instalado.

2. **Xcode Command Line Tools**
    - Instale os comandos de linha do Xcode:
      ```bash
      xcode-select --install
      ```

3. **Java Development Kit (JDK)**
    - Baixe e instale a versão recomendada (ex: JDK 17).
    - Configure a variável de ambiente `JAVA_HOME`.

4. **Node.js e NPM**
    - Instale o Node.js e o NPM via Homebrew:
      ```bash
      brew install node
      ```

5. **Appium**
    - Instale o Appium globalmente:
      ```bash
      npm install -g appium
      ```

6. **Appium Doctor**
    - Instale o Appium Doctor para verificar a instalação:
      ```bash
      npm install -g appium-doctor
      ```

7. **Carthage**
    - Necessário para configurar o WebDriverAgent:
      ```bash
      brew install carthage
      ```

8. **Configurar o simulador iOS**
    - Use preferencialmente o simulador **iPhone 14**.
    - Verifique a versão disponível:
      ```bash
      xcrun simctl list devices
      ```
    - Inicie o simulador manualmente:
      ```bash
      open -a Simulator
      ```

## Verificação da Configuração

Execute o seguinte comando para verificar se todas as dependências estão configuradas corretamente:

```bash
appium-doctor --ios
```

## Iniciando o Servidor Appium

Você pode iniciar o servidor Appium usando a linha de comando:

```bash
appium
```

Ou utilizando o Appium Desktop, que oferece uma interface gráfica.

## Configuração do Projeto de Automação

### Dependências

Para este projeto, é utilizado Java. Use Maven ou Gradle para gerenciar as dependências do Appium. Exemplo de dependência Maven:

```xml
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>7.4.1</version>
</dependency>
```

### Execução do Script de Automação

- Inicie o simulador iPhone 14 manualmente ou via comando.
- Certifique-se de que o app **TOP.app** esteja compilado para o simulador (arquitetura x86_64 ou arm64).
- Para a execução da feature de cadastro, é necessário ter acesso à VPN da Autopass e estar com ela conectada, para que seja possível buscar os códigos gerados para os tokens SMS e E-mail.
- Certifique-se de que o servidor Appium está rodando.
- Execute o script de teste via linha de comando ou sua IDE favorita.

---

## 👤 DESENVOLVIDO POR:

Gustavo Bueno Fonseca

---

## 📝 Notas Finais

- Este documento serve como ponto de partida para configurar e realizar testes de automação do aplicativo TOP para iOS.
- Os testes devem ser executados **exclusivamente em simulador iOS**.
- Para informações adicionais, consulte a [documentação oficial do Appium](http://appium.io/docs/en/about-appium/intro/).

---

Certifique-se de ajustar caminhos de arquivos, versões de bibliotecas, e quaisquer outras configurações específicas ao seu projeto.
