
package com.miapp.springboot.Controller;

import com.google.gson.Gson;
import com.miapp.springboot.JWT.JWTUtil;
import com.miapp.springboot.model.Usuario;
import com.miapp.springboot.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class Respuesta {
    String token;
    String user;

    public Respuesta() {
    }
    
};

@RestController
public class AuthController {

@Autowired
private IUsuarioService userServ;
@Autowired
private JWTUtil jwtutil;

   // End point login
    @PostMapping ("/login")
    public String Login(@RequestBody Usuario user){
        Respuesta response = new Respuesta();
        //Objeto para convertirn a Json - libreria de google
        Gson gson = new Gson();

        try{
        Usuario userLog = userServ.buscaUsuarioByUser(user.getUser());
            if(user.getUser().equals(userLog.getUser())){
                String token = jwtutil.create(userLog.getId().toString(), userLog.getUser());
                
                response.token = token;
                response.user = userLog.getUser();
                //Respondo convirtiendo a Json
                return gson.toJson(response);
            }else{
                return "FAIL";
            }
        }
        catch(Exception e){
            return "FAIL";
        }
        
        
    }
    
}
