import React, { useState } from 'react';
import { apiPedido } from '../services/api';
import { Button, TextField, Container, Typography, Snackbar, Alert, Paper } from '@mui/material';
import { useCarrinho } from '../contexts/CarrinhoCompra';
import { useNavigate } from 'react-router-dom';

const FinalizarCompra = () => {
    const [cpf, setCpf] = useState('');
    const [cartao, setCartao] = useState('');
    const [mensagem, setMensagem] = useState('');
    const [open, setOpen] = useState(false);
    const { carrinho, limparCarrinho } = useCarrinho();
    const navigate = useNavigate();

    const precoTotal = carrinho.reduce(
        (total, item) => total + item.preco * item.quantidade,
        0
    );

    const itensPedido = carrinho.map(item => ({
        idRacao: item.id,
        quantidade: item.quantidade
    }));
    console.log("idsRacao:", itensPedido);

    const validarCPF = (cpf) => {
        // Simples validação de CPF: 11 dígitos
        return /^\d{11}$/.test(cpf);
    };

    const validarCartao = (cartao) => {
        // Simples validação de cartão: 16 dígitos
        return /^\d{16}$/.test(cartao);
    };

    const handleFinalizarCompra = async () => {
        if (!validarCPF(cpf)) {
            setMensagem('CPF inválido!');
            setOpen(true);
            return;
        }

        if (!validarCartao(cartao)) {
            setMensagem('Número de cartão inválido!');
            setOpen(true);
            return;
        }
        const usuarioLogado = JSON.parse(localStorage.getItem('usuarioLogado'));

        const pedido = {
            idUsuario: usuarioLogado.id,
            itens: itensPedido,
            precoTotal
        };
        console.log("Pedido:", pedido);

        try {
            const response = await apiPedido.post((''), pedido
            );
            console.log('Pedido criado:', response.data);
            console.log('Pedido criado:', pedido);

            alert('Compra realizada com sucesso!');
            limparCarrinho();
            navigate('/racoes');
        } catch (error) {
            console.error('Erro ao finalizar compra:', error);
            alert('Erro ao realizar a compra!');
        }

        setOpen(true);
    };

    return (
        <Container maxWidth="sm">
            <Typography variant="h4" gutterBottom>
                Finalizar Compra
            </Typography>
            <TextField
                label="CPF"
                fullWidth
                margin="normal"
                value={cpf}
                onChange={(e) => setCpf(e.target.value)}
            />
            <TextField
                label="Número do Cartão"
                fullWidth
                margin="normal"
                value={cartao}
                onChange={(e) => setCartao(e.target.value)}
            />
            <Paper sx={{ p: 2, mb: 2 }}>
                <Typography variant="h6">Resumo do Pedido:</Typography>
                {carrinho.map((item, idx) => (
                    <Typography key={idx}>
                        {item.nome} - {item.quantidade} x R$ {item.preco.toFixed(2)}
                    </Typography>
                ))}

                <Typography variant="h6" sx={{ mt: 2 }}>
                    Total: R$ {precoTotal.toFixed(2)}
                </Typography>
            </Paper>

            <Button
                variant="contained"
                color="primary"
                fullWidth
                onClick={handleFinalizarCompra}
                sx={{ mt: 2 }}
            >
                Finalizar Compra
            </Button>

            <Snackbar open={open} autoHideDuration={4000} onClose={() => setOpen(false)}>
                <Alert severity={mensagem.includes('sucesso') ? 'success' : 'error'}>{mensagem}</Alert>
            </Snackbar>
        </Container>
    );
};

export default FinalizarCompra;
