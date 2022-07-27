
package com.miapp.springboot.service;

import com.miapp.springboot.model.Skill;
import com.miapp.springboot.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{

    @Autowired
    public SkillRepository SkillRepo;
    
    @Override
    public List<Skill> verSkills() {
        return SkillRepo.findAll();
    }
    @Override
    public void crearSkill(Skill edu) {
        SkillRepo.save(edu);
    }
    @Override
    public Skill crearSkillAndReturn(Skill edu) {
        return SkillRepo.save(edu);
    }
    @Override
       public void updateSkill(Skill per) {
           SkillRepo.save(per);
       }
    @Override
    public void borrarSkill(Long id) {
        SkillRepo.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id) {
       return SkillRepo.findById(id).orElse(null);
    }    
}
