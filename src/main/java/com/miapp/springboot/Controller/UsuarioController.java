
package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Usuario;
import com.miapp.springboot.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    

     //Inyeccion de servicios
    @Autowired
    private IUsuarioService UsuarioServ;
    
    // End point Usuario
    @PostMapping ("/new/usuario")
    public void agregarUsuario(@RequestBody Usuario us){
        UsuarioServ.crearUsuario(us);
    }
     
    @GetMapping ("/ver/usuario")
    @ResponseBody
    public List<Usuario> verUsuarios(){
        return UsuarioServ.verUsuarios();
    }
    @GetMapping ("/buscar/usuario/{id}")
    @ResponseBody
    public Usuario BuscarUsuario(@PathVariable Long id){
        return UsuarioServ.buscarUsuario(id);
    }
    
    @DeleteMapping ("/delete/usuario/{id}")
    public void borrarUsuario (@PathVariable Long id){
        UsuarioServ.borrarUsuario(id);
    }
      @PutMapping ("/update/usuario/{id}")
    public Usuario updatePersona(  @PathVariable Long id,
                                @RequestBody Usuario us){
        Usuario usu = UsuarioServ.buscarUsuario(id);
        
        usu.setPassword(us.getPassword());
        usu.setUser(us.getUser());
                        
        UsuarioServ.crearUsuario(usu);
        return usu;
    }
}
