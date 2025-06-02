import axios from 'axios';

const apiUsuario = axios.create({
  baseURL: 'http://localhost:8081/API-Microservico/usuario',  
});

const apiRacao = axios.create({
  baseURL: 'http://localhost:8082/API-Microservico/racao', 
});

const apiPedido = axios.create({
  baseURL: 'http://localhost:8083/API-Microservico/pedido',  
});

export {apiUsuario, apiPedido, apiRacao};