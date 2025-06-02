import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import DetalheRacao from './components/DetalheRacao';
import ListaDeRacoes from './components/ListaRacoes';
import FinalizarPedido from './components/FinalizarCompra';
import { CarrinhoProvider } from './contexts/CarrinhoCompra';
import Carrinho from './components/Carrinho';
import MeusPedidos from './components/HistoricoPedidos';

function App() {
  return (
    <CarrinhoProvider>
      <Router>
        <Routes>
          <Route path="/" element={<LoginPage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/racoes" element={<ListaDeRacoes />} />
          <Route path="/racao/:id" element={<DetalheRacao />} />
          <Route path="/finalizar" element={<FinalizarPedido />} />
          <Route path="/carrinho" element={<Carrinho />} />
          <Route path="/meus-pedidos" element={<MeusPedidos />} />

        </Routes>
      </Router>
    </CarrinhoProvider>
  );
}

export default App;
