
package com.miapp.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyectos {

    
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String description;
    private String timeElapsed;
    private String link;
    private String img;
    
    
    public Proyectos() {
    }

    public Proyectos(Long id, String name, String description, String timeElapsed, String link, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeElapsed = timeElapsed;
        this.link = link;
        this.img = img;
    }

        
}
