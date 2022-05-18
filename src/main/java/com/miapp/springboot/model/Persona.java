
package com.miapp.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String backImage;
    private String position;
    private String ubicacion;
    private String about;

    public Persona() {
    }

    public Persona(Long id, String name, String backImage, String position, String ubicacion, String about) {
        this.id = id;
        this.name = name;
        this.backImage = backImage;
        this.position = position;
        this.ubicacion = ubicacion;
        this.about = about;
    }

    
 
   
    
}
