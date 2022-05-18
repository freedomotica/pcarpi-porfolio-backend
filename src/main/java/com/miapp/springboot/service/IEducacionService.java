
package com.miapp.springboot.service;

import com.miapp.springboot.model.Educacion;
import java.util.List;


public interface IEducacionService {
    public List <Educacion> verEducacion();
    public void crearEducacion (Educacion edu);
    public void updateEducacion (Educacion edu);
    public void borrarEducacion (Long id);
    public Educacion buscarEducacion(Long id);
}
