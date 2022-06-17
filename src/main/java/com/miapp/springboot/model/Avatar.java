
package com.miapp.springboot.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Avatar implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private byte [] imagen;

    public Avatar() {
    }

    public Avatar(Long id, String name, byte[] imagen) {
        this.id = id;
        this.name = name;
        this.imagen = imagen;
    }
    
}
