package com.example.Usuario.Controllers;

import com.example.Usuario.DTOs.LoginRequestDTO;
import com.example.Usuario.DTOs.UsuarioDTO;
import com.example.Usuario.Models.Usuario;
import com.example.Usuario.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("API-Microservico/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criar")
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario, @RequestParam String cep){
        Usuario novo = usuarioService.save(usuario, cep);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

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

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
