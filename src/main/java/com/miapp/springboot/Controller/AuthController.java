
package com.miapp.springboot.Controller;

import com.google.gson.Gson;
import com.miapp.springboot.JWT.JWTUtil;
import com.miapp.springboot.model.Usuario;
import com.miapp.springboot.service.IUsuarioService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Getter @Setter
class Respuesta {
    String token;
    String user;
    public Respuesta(String token, String user) {
        this.token = token;
        this.user = user;
    }
    
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
        
        try{
        Usuario userLog = userServ.buscaUsuarioByUser(user.getUser());
            if(user.getUser().equals(userLog.getUser())){
                String token = jwtutil.create(userLog.getId().toString(), userLog.getUser());
                Respuesta response = new Respuesta();
                //Objeto para convertirn a Json - libreria de google
                Gson gson = new Gson();        
                response.setToken(token);
                response.setUser(userLog.getUser());
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
