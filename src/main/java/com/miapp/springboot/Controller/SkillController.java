package com.miapp.springboot.Controller;

import com.miapp.springboot.model.Skill;
import com.miapp.springboot.service.ISkillService;
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
public class SkillController {
    

     //Inyeccion de servicios
    @Autowired
    private ISkillService SkillServ;
    
    // End point Skill
    @CrossOrigin(origins = "*")
    @PostMapping ("/new/skill")
    public Skill agregarSkill(@RequestBody Skill Skill){
        return SkillServ.crearSkillAndReturn(Skill);
    }
    @CrossOrigin(origins = "*")
    @GetMapping ("/ver/skill")
    @ResponseBody
    public List<Skill> verSkills(){
        return SkillServ.verSkills();
    }
    @CrossOrigin(origins = "*")
    @GetMapping ("/buscar/skill/{id}")
    @ResponseBody
    public Skill BuscarSkill(@PathVariable Long id){
        return SkillServ.buscarSkill(id);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping ("/delete/skill/{id}")
    public void borrarSkill (@PathVariable Long id){
        SkillServ.borrarSkill(id);
    }
    @CrossOrigin(origins = "*")
      @PutMapping ("/update/skill/{id}")
    public Skill updatePersona(  @PathVariable Long id,
                                @RequestParam
                                        
                                    String name,
                                    Integer progress,
                                    String type,
                                    MultipartFile imagen
    
    ) throws IOException{
        Skill sklls = SkillServ.buscarSkill(id);
        try{
            sklls.setName(name);
            sklls.setProgress(progress);
            sklls.setType(type);
            sklls.setNameImagen(imagen.getOriginalFilename());
            sklls.setImagen(imagen.getBytes());  
        }
         catch(NullPointerException e){       
            sklls.setName(name);
            sklls.setProgress(progress);
            sklls.setType(type);
         }
        SkillServ.crearSkill(sklls);
        return sklls;
    }
}
