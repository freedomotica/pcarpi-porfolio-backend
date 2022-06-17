
package com.miapp.springboot.Controller;


import com.miapp.springboot.model.Avatar;
import com.miapp.springboot.service.IAvatarService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AvatarController {
    
    //Inyeccion de servicios
   
    @Autowired
    private IAvatarService avatarServ;
            
    // End ponts
     @CrossOrigin(origins = "*")
    @PostMapping ("/new/avatar")
    public void agregarAvatar(
                              @RequestParam("imagen") MultipartFile imagen
                              
    
    ) throws IOException{
        Avatar avat = new Avatar();
        avat.setName(imagen.getOriginalFilename());
        avat.setImagen(imagen.getBytes());
        
        
        avatarServ.crearAvatar(avat);
    }

    @CrossOrigin(origins = "*")
     @PutMapping ("/update/avatar/{id}")
    public Avatar updateAvatar(  @PathVariable Long id,
                                
                              @RequestParam("imagen") MultipartFile imagen
                              
    ) throws IOException{
        Avatar avatar = avatarServ.buscarAvatar(id);
        
        avatar.setName(imagen.getOriginalFilename());
        avatar.setImagen(imagen.getBytes());
        
      
        
        avatarServ.crearAvatar(avatar);
        return avatar;
    }
    @CrossOrigin(origins = "*")
    @GetMapping ("/ver/avatar")
    @ResponseBody
    public List<Avatar> verAvatar(){
        return avatarServ.verAvatar();
    }

    @CrossOrigin(origins = "*")
    @GetMapping ("/buscar/avatar/{id}")
    public Avatar BuscarAvatar(@PathVariable Long id){
        return avatarServ.buscarAvatar(id);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping ("/delete/avatar/{id}")
    public void borrarAvatar (@PathVariable Long id){
        avatarServ.borrarAvatar(id);
    }
    
    
}
