import { useState } from 'react';
import { apiUsuario } from '../services/api';
import { Link, useNavigate } from 'react-router-dom';
import { Button, TextField, Typography, Paper, Box } from "@mui/material";



export default function LoginForm() {
  const [username, setUsername] = useState('');
  const [senha, setSenha] = useState('');
  const [message, setMessage] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await apiUsuario.post('/login', { username, senha });
      setMessage('Login realizado com sucesso!');
      localStorage.setItem('usuarioLogado', JSON.stringify(res.data));

      console.log(res.data);
      navigate('/racoes');
    } catch (err) {
      setMessage('Erro no login');
    }
  };

   return (
    <Paper elevation={3} sx={{ maxWidth: 400, mx: 'auto', p: 4, mt: 6 }}>
      <Typography variant="h5" gutterBottom>
        Login
      </Typography>
      <Box component="form" onSubmit={handleSubmit} sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
        <TextField
          label="Username"
          variant="outlined"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          fullWidth
        />
        <TextField
          label="Senha"
          type="password"
          variant="outlined"
          value={senha}
          onChange={(e) => setSenha(e.target.value)}
          fullWidth
        />
        <Button variant="contained" color="primary" type="submit" fullWidth>
          Entrar
        </Button>
        {message && <Typography color="error">{message}</Typography>}
        <Link href="/register" underline="hover" sx={{ mt: 1 }}>
          Criar cadastro
        </Link>
      </Box>
    </Paper>
  );
}
