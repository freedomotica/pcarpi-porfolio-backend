
package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Usuario;
import com.miapp.springboot.service.IUsuarioService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
    public String agregarUsuario(@RequestBody Usuario us){
        //si el usuario ya existe
        String usu = us.getUser();
        try{
        Usuario userDataBase = UsuarioServ.buscaUsuarioByUser(us.getUser());
         if(userDataBase.getUser().equals(usu)){
            return "Usuario ya registrado";
        }
        }
        catch(Exception e){}
       
        //encriptacion del password
                
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        String hash = argon2.hash(1, 1024, 1, us.getPassword());
        us.setPassword(hash);
        UsuarioServ.crearUsuario(us);
        return "OK";
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
