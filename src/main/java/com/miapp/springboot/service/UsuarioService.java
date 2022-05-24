
package com.miapp.springboot.service;

import com.miapp.springboot.model.Usuario;
import com.miapp.springboot.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    public UsuarioRepository UsuarioRepo;
    
    @Override
    public List<Usuario> verUsuarios() {
        return UsuarioRepo.findAll();
    }
    @Override
    public void crearUsuario(Usuario edu) {
        UsuarioRepo.save(edu);
    }
    @Override
       public void updateUsuario(Usuario per) {
           UsuarioRepo.save(per);
       }
    @Override
    public void borrarUsuario(Long id) {
        UsuarioRepo.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
       return UsuarioRepo.findById(id).orElse(null);
    }    

    
    @Override
    public Usuario buscaUsuarioByUser(String user) {
        return UsuarioRepo.findByUser(user);
    }
    
}
