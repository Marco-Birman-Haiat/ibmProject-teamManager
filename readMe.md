
# Desafio-ibm: team-manager

## Hospedagem Web da Aplicação

- [Frontend](https://team-manager-frontend-fd7aae.netlify.app/) - https://team-manager-frontend-fd7aae.netlify.app/
- [Backend](https://teammanager-backend-production.up.railway.app/) - https://teammanager-backend-production.up.railway.app/

## Para Rodar Localmente

#### Requisitos:
- Ter angular CLI instalado;

Se quiser executar o projeto localmente, siga os passos:

1. Clone o repositório: `git clone https://github.com/seunome/repodo-seuprojeto.git`
2. Entre no diretório do backend e realize o deploy do servidor: `mvn spring-boot:run`
3. Entre no diretório `/frontend` instale as dependências: `npm install`
4. No frontend, editar os links dos endpoints para buscar local host (descomentar e comentar linhas nos documentos team.service.ts e player.service.ts);
5. Faça o deploy do frontend em modo de desenvolvimento: ng serve

Certifique-se de substituir `seunome` e `repodo-seuprojeto` pelos valores reais relacionados ao seu projeto.

## Tecnologias

O projeto utiliza as seguintes tecnologias:

- Spring-boot;
- Spring-data-jpa, hibernate e h2;
- JUnit
- Angular;
- Bootstrap;