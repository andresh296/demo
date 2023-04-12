package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> GetAll() {
        return usuarioService.GetAll();
    }

    @GetMapping("/{id}")
    public Usuario GetById(@PathVariable Long id) {
        return usuarioService.GetById(id);
    }

    @PostMapping
    public Usuario Create(@RequestBody Usuario usuario) {
        return usuarioService.Save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario Update(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioDB = usuarioService.GetById(id);
        if (usuarioDB==null) {
            return null;
        }

        usuario.setId(id);
        return usuarioService.Save(usuario);

    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id) {
        usuarioService.Delete(id);
    }

}
