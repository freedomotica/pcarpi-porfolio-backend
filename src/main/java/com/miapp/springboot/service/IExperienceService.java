
package com.miapp.springboot.service;

import com.miapp.springboot.model.Experience;
import java.util.List;


public interface IExperienceService {
    public List <Experience> verExperiences();
    public void crearExperience (Experience exp);
    public void updateExperience (Experience exp);
    public void borrarExperience (Long id);
    public Experience buscarExperience(Long id);
    public Experience crearExperienceAndReturn(Experience exp);
}
