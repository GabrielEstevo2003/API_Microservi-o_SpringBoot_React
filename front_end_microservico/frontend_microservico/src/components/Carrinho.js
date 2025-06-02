import React from 'react';
import { useCarrinho } from '../contexts/CarrinhoCompra';
import { useNavigate, Link} from 'react-router-dom';
import { Container, Typography, Table, TableHead, TableRow, TableCell, TableBody, Button, Paper } from '@mui/material';

const Carrinho = () => {
  const { carrinho, removerDoCarrinho, limparCarrinho } = useCarrinho();
  const navigate = useNavigate();

  const precoTotal = carrinho.reduce((total, item) => total + item.preco * item.quantidade, 0);

  const handleFinalizar = () => {
    navigate('/finalizar');
  };

  return (
    <Container>
      <Typography variant="h4" gutterBottom>Carrinho de Compras</Typography>
      {carrinho.length === 0 ? (
        <Typography>
          O carrinho está vazio. <br></br>
          <Button>
            <Link to="/racoes">Lista de Rações</Link>
          </Button>
          
        </Typography>
          
      ) : (
        <>
          <Paper elevation={3}>
            <Table>
              <TableHead>
                <TableRow>
                  <TableCell>Nome</TableCell>
                  <TableCell>Preço</TableCell>
                  <TableCell>Quantidade</TableCell>
                  <TableCell>Ação</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {carrinho.map((item, index) => (
                  <TableRow key={index}>
                    <TableCell>{item.nome}</TableCell>
                    <TableCell>R$ {item.preco.toFixed(2)}</TableCell>
                    <TableCell>{item.quantidade}</TableCell>
                    <TableCell>
                      <Button
                        color="error"
                        onClick={() => removerDoCarrinho(item.id)}
                      >
                        Remover
                      </Button>
                    </TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </Paper>

          <Typography variant="h6" sx={{ mt: 2 }}>
            Total: R$ {precoTotal.toFixed(2)}
          </Typography>

          <Button
            variant="contained"
            color="primary"
            onClick={handleFinalizar}
            sx={{ mt: 2 }}
          >
            Finalizar Pedido
          </Button>

          <Button
            variant="outlined"
            color="secondary"
            onClick={limparCarrinho}
            sx={{ mt: 2, ml: 2 }}
          >
            Limpar Carrinho
          </Button>
          <Button>
            <Link to="/racoes">Lista de Rações</Link>
          </Button>
        </>
      )}
    </Container>
  );
};

export default Carrinho;
