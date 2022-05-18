
package com.miapp.springboot.service;

import com.miapp.springboot.model.Proyectos;
import java.util.List;

public interface IProyectosService {
    public List <Proyectos> verProyectos();
    public void crearProyecto (Proyectos proy);
    public void updateProyecto (Proyectos proy);
    public void borrarProyecto (Long id);
    public Proyectos buscarProyecto(Long id);
}
