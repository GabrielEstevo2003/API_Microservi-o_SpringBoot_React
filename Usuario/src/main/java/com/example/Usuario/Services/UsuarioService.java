package com.example.Usuario.Services;

import com.example.Usuario.DTOs.UsuarioDTO;
import com.example.Usuario.Models.Endereco;
import com.example.Usuario.Models.Usuario;
import com.example.Usuario.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ViaCepService viaCepService;

    public Usuario save(Usuario usuario, String cep){
        Endereco endereco = viaCepService.buscarEnderecoPorCEP(cep);
        usuario.setEndereco(endereco);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario autenticar(String username, String senha) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getSenha().equals(senha)) {
            throw new RuntimeException("Senha incorreta");
        }

        return usuario;
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Endereco endereco = usuario.getEndereco();
        if (endereco == null || endereco.getLocalidade() == null) {
            Endereco enderecoViaCep = viaCepService.buscarEnderecoPorCEP(endereco.getCep());

            endereco.setLocalidade(enderecoViaCep.getLocalidade());
            endereco.setUf(enderecoViaCep.getUf());
            endereco.setLogradouro(enderecoViaCep.getLogradouro());

            usuario.setEndereco(endereco);
            usuarioRepository.save(usuario);
        }

        return new UsuarioDTO(usuario);
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }
}
