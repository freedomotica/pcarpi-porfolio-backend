
package com.miapp.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private Integer progress;
    private String type;
    private String nameImagen;
    private byte [] imagen;

    public Skill() {
    }

    public Skill(Long id, String name, Integer progress, String type, String nameImagen, byte[] imagen) {
        this.id = id;
        this.name = name;
        this.progress = progress;
        this.type = type;
        this.nameImagen = nameImagen;
        this.imagen = imagen;
    }

  

   
    
}