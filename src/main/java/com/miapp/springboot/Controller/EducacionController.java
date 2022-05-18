
package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Educacion;
import com.miapp.springboot.service.IEducacionService;
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
public class EducacionController {
     //Inyeccion de servicios
    @Autowired
    private IEducacionService EduServ;
    
    // End point educacion
    @PostMapping ("/new/educacion")
    public void agregarEducacion(@RequestBody Educacion edu){
        EduServ.crearEducacion(edu);
    }
     
    @GetMapping ("/ver/educacion")
    @ResponseBody
    public List<Educacion> verEducacion(){
        return EduServ.verEducacion();
    }
    @GetMapping ("/buscar/educacion/{id}")
    @ResponseBody
    public Educacion BuscarEducacion(@PathVariable Long id){
        return EduServ.buscarEducacion(id);
    }
    
    @DeleteMapping ("/delete/educacion/{id}")
    public void borrarEducacion (@PathVariable Long id){
        EduServ.borrarEducacion(id);
    }
         @PutMapping ("/update/educacion/{id}")
    public Educacion updatePersona(  @PathVariable Long id,
                                    @RequestBody Educacion educa){
        Educacion edu = EduServ.buscarEducacion(id);
        
        edu.setTitle(educa.getTitle());
        edu.setCareer(educa.getCareer());
        edu.setDateStart(educa.getDateStart());
        edu.setDateEnd(educa.getDateEnd());
        edu.setLogo(educa.getLogo());
        edu.setScore(educa.getScore());
        
               
        EduServ.crearEducacion(edu);
        return edu;
    }
}
