package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Proyectos;
import com.miapp.springboot.service.IProyectosService;
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
public class ProyectosController {
    

     //Inyeccion de servicios
    @Autowired
    private IProyectosService ProyectosServ;
    
    // End point Proyectos
    @PostMapping ("/new/proyectos")
    public void agregarProyectos(@RequestBody Proyectos Proy){
        ProyectosServ.crearProyecto(Proy);
    }
     
    @GetMapping ("/ver/proyectos")
    @ResponseBody
    public List<Proyectos> verProyectoss(){
        return ProyectosServ.verProyectos();
    }
    @GetMapping ("/buscar/proyectos/{id}")
    @ResponseBody
    public Proyectos BuscarProyectos(@PathVariable Long id){
        return ProyectosServ.buscarProyecto(id);
    }
    
    @DeleteMapping ("/delete/proyectos/{id}")
    public void borrarProyectos (@PathVariable Long id){
        ProyectosServ.borrarProyecto(id);
    }
     @PutMapping ("/update/proyectos/{id}")
    public Proyectos updatePersona(  @PathVariable Long id,
                                @RequestBody Proyectos proyect){
        Proyectos proy = ProyectosServ.buscarProyecto(id);
        
        proy.setDescription(proyect.getDescription());
        proy.setImg(proyect.getImg());
        proy.setLink(proyect.getLink());
        proy.setName(proyect.getName());
        proy.setTimeElapsed(proyect.getTimeElapsed());
                
        ProyectosServ.crearProyecto(proy);
        return proy;
    }
}