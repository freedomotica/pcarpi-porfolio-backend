
package com.miapp.springboot.service;


import com.miapp.springboot.model.Educacion;
import com.miapp.springboot.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    public EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> verEducacion() {
        return eduRepo.findAll();
    }
    @Override
    public void crearEducacion(Educacion edu) {
        eduRepo.save(edu);
    }
     @Override
    public Educacion crearEducacionAndReturn(Educacion edu) {
        return eduRepo.save(edu);
    }
    @Override
       public void updateEducacion(Educacion per) {
           eduRepo.save(per);
       }
    @Override
    public void borrarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
       return eduRepo.findById(id).orElse(null);
    }
    
}
