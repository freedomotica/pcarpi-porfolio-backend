
package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Experience;
import com.miapp.springboot.service.IExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
    public Experience updatePersona(  @PathVariable Long id,
                                @RequestBody Experience expe){
        Experience exp = ExpServ.buscarExperience(id);
        
        exp.setPosition(expe.getPosition());
        exp.setCompany(expe.getCompany());
        exp.setLogo(expe.getLogo());
        exp.setMode(expe.getMode());
        exp.setDateStart(expe.getDateStart());
        exp.setDateEnd(expe.getDateEnd());
        exp.setTimeElapsed(expe.getTimeElapsed());
              
        
        ExpServ.crearExperience(exp);
        return exp;
    }
}
