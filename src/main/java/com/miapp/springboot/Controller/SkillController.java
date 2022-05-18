package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Skill;
import com.miapp.springboot.service.ISkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SkillController {
    

     //Inyeccion de servicios
    @Autowired
    private ISkillService SkillServ;
    
    // End point Skill
    @PostMapping ("/new/skill")
    public void agregarSkill(@RequestBody Skill Skill){
        SkillServ.crearSkill(Skill);
    }
     
    @GetMapping ("/ver/skill")
    @ResponseBody
    public List<Skill> verSkills(){
        return SkillServ.verSkills();
    }
    @GetMapping ("/buscar/skill/{id}")
    @ResponseBody
    public Skill BuscarSkill(@PathVariable Long id){
        return SkillServ.buscarSkill(id);
    }
    
    @DeleteMapping ("/delete/skill/{id}")
    public void borrarSkill (@PathVariable Long id){
        SkillServ.borrarSkill(id);
    }
}
