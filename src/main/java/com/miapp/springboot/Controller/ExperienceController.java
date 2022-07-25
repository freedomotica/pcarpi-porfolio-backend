
package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Experience;
import com.miapp.springboot.service.IExperienceService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class ExperienceController {
    

     //Inyeccion de servicios
    @Autowired
    private IExperienceService ExpServ;
    
    // End point experience
     @CrossOrigin(origins = "*")
    @PostMapping ("/new/experience")
    public void agregarExperience(@RequestBody Experience exp){
        ExpServ.crearExperience(exp);
    }
    
     @CrossOrigin(origins = "*")
    @GetMapping ("/ver/experience")
    @ResponseBody
    public List<Experience> verExperiences(){
        return ExpServ.verExperiences();
    }
     @CrossOrigin(origins = "*")
    @GetMapping ("/buscar/experience/{id}")
    @ResponseBody
    public Experience BuscarExperience(@PathVariable Long id){
        return ExpServ.buscarExperience(id);
    }
     @CrossOrigin(origins = "*")
    @DeleteMapping ("/delete/experience/{id}")
    public void borrarExperience (@PathVariable Long id){
        ExpServ.borrarExperience(id);
    }
     @CrossOrigin(origins = "*")
         @PutMapping ("/update/experience/{id}")
    public Experience updateExperience(  @PathVariable Long id,
                                @RequestParam
                                    String position,
                                    String company,
                                    String mode,
                                    String timeElapsed,
                                    String dateStart,
                                    String dateEnd,
                                    MultipartFile imagen
            
                                    
                                ) throws IOException{
        Experience exp = ExpServ.buscarExperience(id);
                
        exp.setPosition(position);
        exp.setCompany(company);
        exp.setMode(mode);
        exp.setDateStart(dateStart);
        exp.setDateEnd(dateEnd);
        exp.setTimeElapsed(timeElapsed);
        exp.setNameImagen(imagen.getOriginalFilename());
        exp.setImagen(imagen.getBytes());      
        
        ExpServ.crearExperience(exp);
        return exp;
    }
         
}
