
package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Educacion;
import com.miapp.springboot.service.IEducacionService;
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
public class EducacionController {
     //Inyeccion de servicios
    @Autowired
    private IEducacionService EduServ;
    
    // End point educacion
    @CrossOrigin(origins = "*")
    @PostMapping ("/new/educacion")
    public Educacion agregarEducacion(@RequestBody Educacion edu){
       return EduServ.crearEducacionAndReturn(edu);
    }
     @CrossOrigin(origins = "*")
    @GetMapping ("/ver/educacion")
    @ResponseBody
    public List<Educacion> verEducacion(){
        return EduServ.verEducacion();
    }
    @CrossOrigin(origins = "*")
    @GetMapping ("/buscar/educacion/{id}")
    @ResponseBody
    public Educacion BuscarEducacion(@PathVariable Long id){
        return EduServ.buscarEducacion(id);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping ("/delete/educacion/{id}")
    public void borrarEducacion (@PathVariable Long id){
        EduServ.borrarEducacion(id);
    }
    @CrossOrigin(origins = "*")
         @PutMapping ("/update/educacion/{id}")
    public Educacion updatePersona(  @PathVariable Long id,
                                    @RequestParam
                                            
                                            String school,
                                            String title,
                                            String career,
                                            String dateStart,
                                            String dateEnd,
                                            Integer score,
                                            MultipartFile imagen
    ) throws IOException{
        Educacion edu = EduServ.buscarEducacion(id);
        try{
            edu.setSchool(school);
            edu.setTitle(title);
            edu.setCareer(career);
            edu.setDateStart(dateStart);
            edu.setDateEnd(dateEnd);
            edu.setScore(score);
            edu.setNameImagen(imagen.getOriginalFilename());
            edu.setImagen(imagen.getBytes());  
        }
        catch(NullPointerException e){
            edu.setSchool(school);
            edu.setTitle(title);
            edu.setCareer(career);
            edu.setDateStart(dateStart);
            edu.setDateEnd(dateEnd);
            edu.setScore(score);
        
        }
               
        EduServ.crearEducacion(edu);
        return edu;
    }
}
