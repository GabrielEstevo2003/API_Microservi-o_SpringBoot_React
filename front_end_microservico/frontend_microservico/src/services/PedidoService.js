import { apiPedido } from "./api";
const buscarPedidos = async (idUsuario) => {
    try {
        const response = await apiPedido.get(`/usuario/${idUsuario}`);
        return response.data;
    } catch (error) {
        console.error("Erro ao buscar pedidos:", error);
        return [];
    }
};

export default buscarPedidos;