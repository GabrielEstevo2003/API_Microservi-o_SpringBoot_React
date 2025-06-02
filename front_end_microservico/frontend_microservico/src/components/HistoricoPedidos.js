import React, { useEffect, useState } from 'react';
import buscarPedidos from '../services/PedidoService';
import { Container, Typography, Paper, List,Divider } from "@mui/material";

const MeusPedidos = () => {
    const usuarioLogado = JSON.parse(localStorage.getItem('usuarioLogado'));
    const [pedidos, setPedidos] = useState([]);

    useEffect(() => {
        const fetchPedidos = async () => {
            const resultado = await buscarPedidos(usuarioLogado.id);
            console.log("Resultado da busca de pedidos:", resultado);
            setPedidos(resultado);
        };
        fetchPedidos();
    }, [usuarioLogado]);

    useEffect(() => {
        console.log("Pedidos atualizados:", pedidos);
    }, [pedidos]);
    return (
        <Container sx={{ mt: 4 }}>
            <Typography variant="h5" gutterBottom>
                Meus Pedidos
            </Typography>
            {pedidos.length === 0 ? (
                <Typography>Nenhum pedido realizado até o momento.</Typography>
            ) : (
                pedidos.map((pedido) => (
                    <Paper key={pedido.id} elevation={3} sx={{ p: 3, mb: 2, borderRadius: 2 }}>
                        <Typography variant="h6">Pedido #{pedido.id}</Typography>
                        <Typography variant="body2">
                            Data: {new Date(pedido.dtCompra).toLocaleDateString()}
                        </Typography>
                        <Typography variant="body2">
                            Total: R$ {pedido.precoTotal != null ? pedido.precoTotal.toFixed(2) : 'Indisponível'}
                        </Typography>

                        <Typography variant="subtitle1" sx={{ mt: 2 }}>Itens:</Typography>
                        <List dense>
                            {Array.isArray(pedido.idRacao) && pedido.idRacao.length > 0 ? (
                                <ul>
                                    {pedido.idRacao.map((racao, index) => (
                                        <li key={index}>
                                            {racao?.nome ?? "Nome indisponível"} - {racao?.sabor ?? "Sabor indisponível"} - R$ {racao?.preco ?? "N/A"}
                                        </li>
                                    ))}
                                </ul>
                            ) : (
                                <p>Nenhum item neste pedido.</p>
                            )}
                        </List>
                        <Divider sx={{ mt: 2 }} />
                    </Paper>
                ))
            )}
        </Container>
    );
};

export default MeusPedidos;
