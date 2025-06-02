import React, { useEffect, useState } from "react";
import { apiRacao } from "../services/api";
import { Table, TableHead, TableRow, TableCell, TableBody, Paper, Container, Box, Typography, Button } from "@mui/material";
import { Link } from "react-router-dom";
import BotaoCarrinho from "./BotaoCArrinho";
import { useNavigate } from 'react-router-dom';


const ListaDeRacoes = () => {
  const [racoes, setRacoes] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    carregarRacoes();
  }, []);

  const carregarRacoes = async () => {
    try {
      const response = await apiRacao.get();
      setRacoes(response.data);
    } catch (error) {
      console.error("Erro ao carregar rações:", error);
    }
  };

  return (
    <Container sx={{ mt: 4 }}>
      <Typography variant="h5" gutterBottom>
        Lista de Rações disponíveis
      </Typography>
      <Paper elevation={3} sx={{ p: 3, borderRadius: 2 }}>
        <Box sx={{ display: 'flex', gap: 2, mb: 2 }}>
          <Button variant="outlined" onClick={() => navigate('/carrinho')}>
            Ver Carrinho
          </Button>
          <Link to="/meus-pedidos" underline="hover">
            Meus Pedidos
          </Link>
        </Box>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell><strong>Nome</strong></TableCell>
              <TableCell><strong>Preço</strong></TableCell>
              <TableCell><strong>Detalhes</strong></TableCell>
              <TableCell><strong>Ação</strong></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {racoes.map((racao) => (
              <TableRow key={racao.id}>
                <TableCell>{racao.nome}</TableCell>
                <TableCell>R$ {racao.preco.toFixed(2)}</TableCell>
                <TableCell>
                  <Link to={`/racao/${racao.id}`}>
                    Ver detalhes
                  </Link>
                </TableCell>
                <TableCell>
                  <BotaoCarrinho racao={racao} />
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </Paper>
    </Container>
  );
}

export default ListaDeRacoes;