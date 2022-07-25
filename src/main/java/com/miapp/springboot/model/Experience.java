
package com.miapp.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experience {
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Long id;
        
        private String position;
        private String company;
        private String mode;
        private String dateStart;
        private String dateEnd;
        private String timeElapsed;
        private String nameImagen;
        private byte [] imagen;

    public Experience() {
    }

    public Experience(Long id, String position, String company, String mode, String dateStart, String dateEnd, String timeElapsed, String nameImagen, byte[] imagen) {
        this.id = id;
        this.position = position;
        this.company = company;
        this.mode = mode;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.timeElapsed = timeElapsed;
        this.nameImagen = nameImagen;
        this.imagen = imagen;
    }

    
    
}
