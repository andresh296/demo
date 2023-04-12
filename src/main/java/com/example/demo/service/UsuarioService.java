package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    public List<Usuario> GetAll() {
        return usuarioRepo.findAll();
    }

    public Usuario GetById(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    public Usuario Save(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    public void Delete(Long id) {
        usuarioRepo.deleteById(id);
    }
}
