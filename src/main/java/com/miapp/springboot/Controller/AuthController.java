
package com.miapp.springboot.Controller;

import com.google.gson.Gson;
import com.miapp.springboot.JWT.JWTUtil;
import com.miapp.springboot.model.Usuario;
import com.miapp.springboot.service.IUsuarioService;
import com.miapp.springboot.utils.Encriptado;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

@Autowired
private IUsuarioService userServ;
@Autowired
private JWTUtil jwtutil;
@Autowired
private Encriptado Encrip;

private Usuario logUser;

@Getter @Setter
private class Respuesta {
    String token;
    String user;
    public Respuesta(String token, String user) {
        this.token = token;
        this.user = user;
    }
    
    public Respuesta() {
    }
    
};


   // End point login
    @PostMapping ("/login")
    public String Login(@RequestBody Usuario user){
        //busco usuario en la base de datos        
        Optional<Usuario> usLog = userServ.buscaUsuarioByUser(user.getUser());
        //Fail si no existe        
        if(!usLog.isPresent()){
            return "FAIL - Usuario no encontrado";
        }
        //si exite extraigo el Usuario
        usLog.ifPresent((Usuario userLog)->{
            logUser = userLog;
        });
        
        //comparar password
            //si verify es false retorna FAIL
        if(!Encrip.Verify(logUser.getPassword(), user.getPassword())){
            return "FAIL - Contraseña no encontrada";
        }
        //En este punto el usuario y contraseña estan ok
        //crear token
        String token = jwtutil.create(logUser.getId().toString(), logUser.getUser());
        //Objeto para armar el Json
        Respuesta responseObj = new Respuesta();
        //Objeto para convertirn a Json - libreria de google
        Gson gson = new Gson();
        responseObj.setToken(token);
        responseObj.setUser(logUser.getUser());
        //Respondo convirtiendo a Json
        return gson.toJson(responseObj);
        
        
    }
}