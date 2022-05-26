
package com.miapp.springboot.Controller;

import com.miapp.springboot.JWT.JWTUtil;
import com.miapp.springboot.model.Usuario;
import com.miapp.springboot.service.IUsuarioService;
import com.miapp.springboot.utils.Encriptado;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    

     //Inyeccion de servicios
    @Autowired
    private IUsuarioService UsuarioServ;
    @Autowired
    private Encriptado Encrip;
     @Autowired
    private JWTUtil jwtUtil;
    
    
    // End point Usuario
    @PostMapping ("/new/usuario")
    public String agregarUsuario(@RequestBody Usuario us, @RequestHeader(value="Authorization")String token){
        //si token valido
        if(!jwtUtil.validity(token)){return "FAIL";}
        //si el usuario ya existe
        
        Optional<Usuario> userDataBase = UsuarioServ.buscaUsuarioByUser(us.getUser());
         if(userDataBase.isPresent()){
            return "Usuario ya registrado";
         }       
        //encriptacion del password
        
        String passEncriptada;
        passEncriptada = Encrip.hash(us.getPassword());
        us.setPassword(passEncriptada);
        UsuarioServ.crearUsuario(us);
        return "OK";
    }
     
    @GetMapping ("/ver/usuario")
    @ResponseBody
    public List<Usuario> verUsuarios(@RequestHeader(value="Authorization")String token){
        //si token valido
        if(!jwtUtil.validity(token)){return new ArrayList<>();}
        //devuelvo lista de usuarios
        return UsuarioServ.verUsuarios();
    }
    @GetMapping ("/buscar/usuario/{id}")
    @ResponseBody
    public Usuario BuscarUsuario(@PathVariable Long id, @RequestHeader(value="Authorization")String token){
        if(!jwtUtil.validity(token)){return new Usuario();}
        return UsuarioServ.buscarUsuario(id);
    }
    
    @DeleteMapping ("/delete/usuario/{id}")
    public String borrarUsuario (@PathVariable Long id, @RequestHeader(value="Authorization")String token){
         //si token valido
        if(jwtUtil.validity(token)){
            UsuarioServ.borrarUsuario(id);
            return "ok";
        }else{
            return "FAIL";
        }
                
    }
      @PutMapping ("/update/usuario/{id}")
    public Usuario updatePersona(  @PathVariable Long id,
                                    @RequestBody Usuario us,
                                    @RequestHeader(value="Authorization")String token){
        if(!jwtUtil.validity(token)){return new Usuario();}
        Usuario usu = UsuarioServ.buscarUsuario(id);
        
        String passEncriptada;
        passEncriptada = Encrip.hash(us.getPassword());
        usu.setPassword(passEncriptada);
        usu.setUser(us.getUser());
                        
        UsuarioServ.crearUsuario(usu);
        return usu;
    }
}
