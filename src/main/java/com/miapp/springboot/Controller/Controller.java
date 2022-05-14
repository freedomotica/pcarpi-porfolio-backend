
package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Persona;
import com.miapp.springboot.service.IPersonaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Controller {
    
    @Autowired
    private IPersonaService persoServ;
     
    @PostMapping ("/new/persona")
    public void agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }
    
     @PutMapping ("/update/{id}")
    public Persona updatePersona(  @PathVariable Long id,
                                @RequestParam ("nombre")String nuevoNombre,
                                @RequestParam ("apellido")String nuevoApellido
                                ){
        Persona perso = persoServ.buscarPersona(id);
        
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        
        persoServ.crearPersona(perso);
        return perso;
    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        return persoServ.verPersonas();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona (@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
}
