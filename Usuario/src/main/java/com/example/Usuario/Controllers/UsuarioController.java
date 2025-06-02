package com.example.Usuario.Controllers;

import com.example.Usuario.DTOs.LoginRequestDTO;
import com.example.Usuario.DTOs.UsuarioDTO;
import com.example.Usuario.Models.Usuario;
import com.example.Usuario.Services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("API-Microservico/usuario")
@CrossOrigin(origins = "*")
@Tag(name = "Usuario", description = "Gerenciamento de Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Operation(
            summary = "Cria um Usuario",
            description = "Retorna um objeto de Usuario"
    )
    @PostMapping("/criar")
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario, @RequestParam String cep){
        Usuario novo = usuarioService.save(usuario, cep);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @Operation(
            summary = "Retorna o Login do Usuario",
            description = "Faz a autenticação dos dados do usuario para a realização do login no sistema"
    )
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        try {
            Usuario usuario = usuarioService.autenticar(loginRequest.getUsername(), loginRequest.getSenha());
            return ResponseEntity.ok(new UsuarioDTO(usuario));  // ou retornar um token
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        }
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @RequestParam String cep){
        Usuario savedUsuario = usuarioService.save(usuario, cep);
        return ResponseEntity.ok(savedUsuario);
    }
    @Operation(
            summary = "Lista de Usuarios",
            description = "Retorna uma lista de usuarios"
    )
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }
    @Operation(
            summary = "Retorno de Usuario por ID",
            description = "Retorna um Usuario com o ID especificado"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @Operation(
            summary = "Deleta um Usuario",
            description = "Deleta um Usuario"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
