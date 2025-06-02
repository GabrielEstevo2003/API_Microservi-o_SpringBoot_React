import { useCarrinho } from "../contexts/CarrinhoCompra";
import { Button, Snackbar, Alert } from "@mui/material";
import { useState } from "react";

function BotaoCarrinho({ racao }) {
    const { adicionarItem } = useCarrinho();
    const [open, setOpen] = useState(false);

    const handleAdd = () => {
        adicionarItem({
            id: racao.id,
            nome: racao.nome,
            preco: racao.preco,
            quantidade: 1  
        });
        setOpen(true);
    };

    return (
        <>
            <Button variant="contained" color="primary" onClick={handleAdd}>
                Adicionar ao Carrinho
            </Button>
            <Snackbar open={open} autoHideDuration={3000} onClose={() => setOpen(false)}>
                <Alert onClose={() => setOpen(false)} severity="success" sx={{ width: '100%' }}>
                    Produto adicionado ao carrinho!
                </Alert>
            </Snackbar>
        </>
    );
}

export default BotaoCarrinho;
