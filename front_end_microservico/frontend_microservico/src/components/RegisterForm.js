import { useState } from 'react';
import {apiUsuario} from '../services/api';
import { Button, TextField, Typography, Paper,Link,  Box } from "@mui/material";



export default function RegisterForm() {
  const [formData, setFormData] = useState({
  nome: '',
  email: '',
  username: '',
  senha: '',
  telefone: '',
  cep: ''
});


  const [message, setMessage] = useState('');

 const handleChange = (e) => {
  const { name, value } = e.target;
  setFormData({ ...formData, [name]: value });
};


  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await apiUsuario.post(`/criar?cep=${formData.cep}`, formData);
      setMessage('Usuário cadastrado com sucesso!');
    } catch (err) {
      setMessage('Erro no cadastro');
    }
  };

  return (
     <Paper elevation={3} sx={{ maxWidth: 400, mx: 'auto', p: 4, mt: 6 }}>
      <Typography variant="h5" gutterBottom>
        Cadastro
      </Typography>
      <Box component="form" onSubmit={handleSubmit} sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
        <TextField
          label="Nome"
          name="nome"
          value={formData.nome}
          onChange={handleChange}
          fullWidth
        />
        <TextField
          label="Email"
          name="email"
          type="email"
          value={formData.email}
          onChange={handleChange}
          fullWidth
        />
        <TextField
          label="Username"
          name="username"
          value={formData.username}
          onChange={handleChange}
          fullWidth
        />
        <TextField
          label="Senha"
          name="senha"
          type="password"
          value={formData.senha}
          onChange={handleChange}
          fullWidth
        />
        <TextField
          label="Telefone"
          name="telefone"
          value={formData.telefone}
          onChange={handleChange}
          fullWidth
        />
        <TextField
          label="CEP"
          name="cep"
          value={formData.cep}
          onChange={handleChange}
          fullWidth
        />
        <Button variant="contained" color="success" type="submit" fullWidth>
          Cadastrar
        </Button>
        {message && <Typography color="success.main">{message}</Typography>}
        <Link href="/" underline="hover" sx={{ mt: 1 }}>
          Fazer Login
        </Link>
      </Box>
    </Paper>
  );
}
