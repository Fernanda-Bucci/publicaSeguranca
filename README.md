"# publicaSeguranca" 

# PublicaSegurança

Este projeto é uma aplicação voltada para a segurança pública, utilizando containerização com Docker. 
O objetivo é oferecer uma solução eficiente para gerenciar e visualizar dados relevantes.

# Requisitos

- Docker
- Docker Compose
- Git

# Estrutura do Projeto

- segurancaPublica/ : Contém os arquivos de configuração do Docker e scripts necessários.
- src/: Contém o código-fonte da aplicação.
- README.md: Este arquivo.

# Inicialização do Projeto

Siga os passos abaixo para inicializar e executar o projeto:

# 1. Clone o Repositório

Clone este repositório em sua máquina local:

`bash
git clone https://github.com/Fernanda-Bucci/publicaSeguranca.git
cd publicaseguranca


# Pipeline CI/CD

Este projeto utiliza uma pipeline de CI/CD configurada no GitHub Actions para automatizar a construção e o deploy da aplicação.

# Gatilhos

A pipeline é acionada nos seguintes eventos:
- *Push* nas branches main (produção) e staging (staging).
- *Workflow Dispatch*: permite execução manual da pipeline.

# Jobs da Pipeline

1. *Integração Contínua (CI)*:
   - Realiza a construção das imagens Docker e as envia para o Docker Hub.
   - Utiliza as credenciais armazenadas como segredos (DOCKER_USER e DOCKER_PWD).

2. *Entrega Contínua (CD)*:
   - *Staging*: Realiza o deploy utilizando docker-compose.staging.yml.
   - *Produção*: Realiza o deploy utilizando docker-compose.yml.

# Segredos Necessários

Certifique-se de que os seguintes segredos estão configurados em seu repositório do GitHub:
- DOCKER_USER: Seu nome de usuário do Docker Hub.
- DOCKER_PWD: Sua senha do Docker Hub.

# Executando a Pipeline Manualmente

Para executar a pipeline manualmente, você pode ir até a aba "Actions" no GitHub, selecionar o workflow e clicar em "Run workflow".

# Exemplo de Comandos

Para acionar a pipeline, basta fazer um push nas branches:

bash
git checkout staging
git push origin staging

# Para produção
git checkout main
git push origin main
bash
Copiar código
