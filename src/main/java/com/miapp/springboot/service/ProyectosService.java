
package com.miapp.springboot.service;

import com.miapp.springboot.model.Proyectos;
import com.miapp.springboot.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosService{
    @Autowired
    public ProyectosRepository ProyRepo;
    
    @Override
    public List<Proyectos> verProyectos() {
        return ProyRepo.findAll();
    }
    @Override
    public void crearProyecto(Proyectos edu) {
        ProyRepo.save(edu);
    }
    @Override
       public void updateProyecto(Proyectos per) {
           ProyRepo.save(per);
       }
    @Override
    public void borrarProyecto(Long id) {
        ProyRepo.deleteById(id);
    }

    @Override
    public Proyectos buscarProyecto(Long id) {
       return ProyRepo.findById(id).orElse(null);
    }
}
