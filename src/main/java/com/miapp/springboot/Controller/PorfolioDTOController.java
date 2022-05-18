
package com.miapp.springboot.Controller;

import com.miapp.springboot.DTO.PorfolioDTO;
import com.miapp.springboot.model.Educacion;
import com.miapp.springboot.model.Persona;
import com.miapp.springboot.service.IEducacionService;
import com.miapp.springboot.service.IPersonaService;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PorfolioDTOController {
    
    //Inyeccion de servicios
    @Autowired
    private IEducacionService EduServ;
    @Autowired
    private IPersonaService persoServ;
        
    @GetMapping ("/buscar/porfolio")
    @ResponseBody
    public PorfolioDTO buscarPorfolio(){
        long id = 1;
        Persona pers = persoServ.buscarPersona(id);
        List <Educacion> educ = EduServ.verEducacion();
        PorfolioDTO porfDTO = new PorfolioDTO();
        
        porfDTO.setId(pers.getId());
        porfDTO.setName(pers.getName());
        porfDTO.setAbout(pers.getAbout());
        porfDTO.setAvatar(pers.getAvatar());
        porfDTO.setBackImage(pers.getBackImage());
        porfDTO.setEducacion(educ);
        
        
        return porfDTO;
    }
    
    
}
