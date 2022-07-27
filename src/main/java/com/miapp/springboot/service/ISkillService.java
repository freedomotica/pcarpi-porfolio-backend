
package com.miapp.springboot.service;

import com.miapp.springboot.model.Skill;
import java.util.List;

public interface ISkillService {
      public List <Skill> verSkills();
    public void crearSkill (Skill exp);
    public Skill crearSkillAndReturn (Skill exp);
    public void updateSkill (Skill exp);
    public void borrarSkill (Long id);
    public Skill buscarSkill(Long id);
}
