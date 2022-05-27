
package com.miapp.springboot.Controller;

import com.google.gson.Gson;
import com.miapp.springboot.JWT.JWTUtil;
import com.miapp.springboot.model.Usuario;
import com.miapp.springboot.service.IUsuarioService;
import com.miapp.springboot.utils.Encriptado;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.serializer.Serializer;
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
public class Respuesta implements Serializer {
    String token;
    String user;
    String message;

        public Respuesta(String token, String user, String message) {
            this.token = token;
            this.user = user;
            this.message = message;
        }
   
    
    public Respuesta() {
    }

        @Override
        public void serialize(Object object, OutputStream outputStream) throws IOException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
};


   // End point login
    @PostMapping ("/login")
    public Respuesta Login(@RequestBody Usuario user){
        //busco usuario en la base de datos        
        Optional<Usuario> usLog = userServ.buscaUsuarioByUser(user.getUser());
        //Objeto para armar el Json
        Respuesta responseObj = new Respuesta();
        //Fail si no existe        
        if(!usLog.isPresent()){
            responseObj.setMessage("FAIL - Usuario no encontrado");
            return responseObj;
        }
        //si exite extraigo el Usuario
        usLog.ifPresent((Usuario userLog)->{
            logUser = userLog;
        });
        
        //comparar password
            //si verify es false retorna FAIL
        if(!Encrip.Verify(logUser.getPassword(), user.getPassword())){
            responseObj.setMessage("FAIL - Contraseña no encontrada");
            return responseObj;
            
        }
        //En este punto el usuario y contraseña estan ok
        //crear token
        String token = jwtutil.create(logUser.getId().toString(), logUser.getUser());
        
        //Objeto para convertirn a Json - libreria de google
        //Gson gson = new Gson();
        responseObj.setToken(token);
        responseObj.setUser(logUser.getUser());
        //Respondo convirtiendo a Json
        //return gson.toJson(responseObj);
        return responseObj;
        
        
    }
}