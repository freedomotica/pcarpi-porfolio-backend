
package com.miapp.springboot.service;

import com.miapp.springboot.model.Experience;
import com.miapp.springboot.repository.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService {

    @Autowired
    public ExperienceRepository expRepo;
    
    @Override
    public List<Experience> verExperiences() {
        return expRepo.findAll();
    }
    @Override
    public void crearExperience(Experience exp) {
        expRepo.save(exp);
    }
    @Override
    public Experience crearExperienceAndReturn(Experience exp) {
        return expRepo.save(exp);
    }
    @Override
       public void updateExperience(Experience exp) {
           expRepo.save(exp);
       }
    @Override
    public void borrarExperience(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experience buscarExperience(Long id) {
       return expRepo.findById(id).orElse(null);
    }
    
}
