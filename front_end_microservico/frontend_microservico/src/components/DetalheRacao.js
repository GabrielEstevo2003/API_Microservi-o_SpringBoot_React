import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { apiRacao } from "../services/api";
import { Table, TableHead, TableRow, TableCell, TableBody,Box, Paper, Container, Typography, Button } from "@mui/material";
import BotaoCarrinho from "./BotaoCArrinho";
import { useNavigate } from 'react-router-dom';

const DetalheRacao = () => {
    const { id } = useParams();
    const [racao, setRacao] = useState(null);
    const navigate = useNavigate();


    useEffect(() => {
        const fetchRacao = async () => {
            try {
                const response = await apiRacao.get(`/${id}`);
                setRacao(response.data);
            } catch (error) {
                console.error("Erro ao requisitar detalhes da Ração:", error);
            }
        };

        fetchRacao();
    }, [id]);

    if (!racao) {
        return <p>Carregando...</p>;
    }
    return (
    <Container sx={{ mt: 4 }}>
      <Box sx={{ display: 'flex', gap: 2, mb: 2 }}>
        <Button variant="outlined" onClick={() => navigate('/carrinho')}>
          Ver Carrinho
        </Button>
        <Button >
            <Link to="/racoes" underline="hover">
                Rações Disponíveis
            </Link>
        </Button>
      </Box>
      <Typography variant="h5" gutterBottom>
        Detalhes da Ração: {racao.nome}
      </Typography>
      <Paper elevation={3} sx={{ p: 3, borderRadius: 2, mb: 2 }}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell><strong>Tipo</strong></TableCell>
              <TableCell><strong>Sabor</strong></TableCell>
              <TableCell><strong>Preço</strong></TableCell>
              <TableCell><strong>Peso</strong></TableCell>
              <TableCell><strong>Disponibilidade</strong></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            <TableRow>
              <TableCell>{racao.tipo}</TableCell>
              <TableCell>{racao.sabor}</TableCell>
              <TableCell>R$ {racao.preco.toFixed(2)}</TableCell>
              <TableCell>{racao.peso} kg</TableCell>
              <TableCell>{racao.disponibilidade ? "Disponível" : "Indisponível"}</TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </Paper>
      <BotaoCarrinho racao={racao} />
    </Container>
  );
}
export default DetalheRacao;
