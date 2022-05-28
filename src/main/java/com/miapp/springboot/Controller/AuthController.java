
package com.miapp.springboot.Controller;

import com.google.gson.Gson;
import com.miapp.springboot.JWT.JWTUtil;
import com.miapp.springboot.ResponseObj;
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
  @Setter @Getter
    class Payload {
        String token;
        String user;

    }
   // End point login
    @PostMapping ("/login")
    public ResponseObj Login(@RequestBody Usuario user){
        //busco usuario en la base de datos        
        Optional<Usuario> usLog = userServ.buscaUsuarioByUser(user.getUser());
        //Objeto para armar el Json
        ResponseObj responseObj = new ResponseObj();
        //Fail si no existe        
        if(!usLog.isPresent()){
            responseObj.setErrors("FAIL");
            responseObj.setMessages("Usuario no encontrado");
            return responseObj;
        }
        //si exite extraigo el Usuario
        usLog.ifPresent((Usuario userLog)->{
            logUser = userLog;
        });
        
        //comparar password
            //si verify es false retorna FAIL
        if(!Encrip.Verify(logUser.getPassword(), user.getPassword())){
            responseObj.setErrors("FAIL");
            responseObj.setMessages("Contraseña no encontrada");
            return responseObj;
            
        }
        //En este punto el usuario y contraseña estan ok
        //crear token
        String token = jwtutil.create(logUser.getId().toString(), logUser.getUser());
        
        Gson gson = new Gson();
        Payload payload = new Payload();
        payload.setToken(token);
        payload.setUser(logUser.getUser());
        
        String pay = gson.toJson(payload);
        responseObj.setPayloads(pay);
        return responseObj;
        
        
    }
}