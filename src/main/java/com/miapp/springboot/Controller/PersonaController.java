
package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Educacion;
import com.miapp.springboot.model.Persona;
import com.miapp.springboot.service.IEducacionService;
import com.miapp.springboot.service.IPersonaService;

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

@RestController
public class PersonaController {
    
    //Inyeccion de servicios
   
    @Autowired
    private IPersonaService persoServ;
    
    // End ponts
     
    @PostMapping ("/new/persona")
    public void agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }

    
     @PutMapping ("/update/persona/{id}")
    public Persona updatePersona(  @PathVariable Long id,
                                @RequestBody Persona pers){
        Persona perso = persoServ.buscarPersona(id);
        
        perso.setName(pers.getName());
        perso.setPosition(pers.getPosition());
        perso.setBackImage(pers.getBackImage());
        perso.setUbicacion(pers.getUbicacion());
        perso.setAbout(pers.getAbout());
        perso.setAbout(pers.getAvatar());
        
        persoServ.crearPersona(perso);
        return perso;
    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        return persoServ.verPersonas();
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/buscar/persona/{id}")
    public Persona BuscarPersona(@PathVariable Long id){
        return persoServ.buscarPersona(id);
    }
    
    @DeleteMapping ("/delete/persona/{id}")
    public void borrarPersona (@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    
}
