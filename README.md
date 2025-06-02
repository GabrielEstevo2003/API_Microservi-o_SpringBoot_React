Sistema de Gerenciamento de Pedidos e Rações composto por:

- Frontend em React.
- Backend com microserviços em Spring Boot.
- Banco de dados MySQL.

Algumas Funcionalidades do sistema:

- Cadastro de usuários.
- Listagem de rações.
- Carrinho de compras.
- Histórico de pedidos.

Oque é necessário para rodar a aplicação:
- Node.js (v16 ou superior)
- Java (JDK 17 ou superior)
- Maven
- MySQL

Backend - Microserviços Spring Boot
- Microserviço de Usuário
- Microserviço de Ração
- Microserviço de Pedido
- 
Para cada microserviço:
# Acesse a pasta do microserviço
cd backend/microservico-nome

# Compile
mvn clean install

# Rode a aplicação
mvn spring-boot:run
Por padrão, as APIs rodam nestas portas:

Usuário: http://localhost:8081

Ração: http://localhost:8082

Pedido: http://localhost:8083

Obs: Ajuste o application.properties conforme o IP ou porta do MySQL.

Frontend - React
# Acesse a pasta do frontend
cd frontend

# Instale as dependências
npm install

# Rode a aplicação
npm start

Por padrão:
http://localhost:3000

Os endpoints dos microserviços devem estar configurados corretamente no frontend (.env ou arquivo de config).

Exemplo de fluxo:
Acesse http://localhost:3000
Cadastre-se.
Veja a listagem de rações.
Adicione rações ao carrinho.
Finalize a compra.
Veja seu histórico de pedidos.

🛠️ Tecnologias usadas
React + MUI
Spring Boot
MySQL
REST APIs
Maven

Este é um projeto acadêmico com a função de desenvolver um sistema fullstack baseado no modelo de arquitetura de microserviços e comunicação Rest entre as APIs.
