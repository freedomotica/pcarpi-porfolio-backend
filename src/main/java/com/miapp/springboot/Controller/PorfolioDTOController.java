
package com.miapp.springboot.Controller;

import com.miapp.springboot.DTO.PorfolioDTO;
import com.miapp.springboot.JWT.JWTUtil;
import com.miapp.springboot.model.Educacion;
import com.miapp.springboot.model.Experience;
import com.miapp.springboot.model.Persona;
import com.miapp.springboot.model.Proyectos;
import com.miapp.springboot.model.Skill;
import com.miapp.springboot.service.IEducacionService;
import com.miapp.springboot.service.IExperienceService;
import com.miapp.springboot.service.IPersonaService;
import com.miapp.springboot.service.IProyectosService;
import com.miapp.springboot.service.ISkillService;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PorfolioDTOController {
    
    //Inyeccion de servicios
    @Autowired
    private IEducacionService EduServ;
    @Autowired
    private IPersonaService persoServ;
    @Autowired
    private IExperienceService ExpServ;
    @Autowired
    private ISkillService SkillServ;
     @Autowired
    private IProyectosService ProyectosServ;
     @Autowired
    private JWTUtil jwtUtil;
        
    @GetMapping ("/buscar/porfolio")
    @ResponseBody
    public PorfolioDTO buscarPorfolio(@RequestHeader(value="Authorization")String token){
        //si token valido
        //if(!jwtUtil.validity(token)){return new PorfolioDTO();}
        
        long id = 1;
        Persona pers = persoServ.buscarPersona(id);
        List <Educacion> educ = EduServ.verEducacion();
        List <Experience> exp = ExpServ.verExperiences();
        List <Skill> skill = SkillServ.verSkills();
        List <Proyectos> proy = ProyectosServ.verProyectos();
        
        PorfolioDTO porfDTO = new PorfolioDTO();
        
        porfDTO.setId(pers.getId());
        porfDTO.setName(pers.getName());
        porfDTO.setPosition(pers.getPosition());
        porfDTO.setUbicacion(pers.getUbicacion());
        porfDTO.setAbout(pers.getAbout());
        porfDTO.setAvatar(pers.getAvatar());
        porfDTO.setBackImage(pers.getBackImage());
        porfDTO.setBudge(pers.getBudge());
        porfDTO.setEducacion(educ);
        porfDTO.setExperience(exp);
        porfDTO.setSkill(skill);
        porfDTO.setProyectos(proy);
               
        return porfDTO;
    }
    
    
}
