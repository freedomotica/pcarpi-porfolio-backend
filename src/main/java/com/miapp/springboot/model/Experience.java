
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
        private String logo;
        private String mode;
        private String dateStart;
        private String dateEnd;
        private String timeElapsed;

    public Experience() {
    }

    public Experience(Long id, String position, String company, String logo, String mode, String dateStart, String dateEnd, String timeElapsed) {
        this.id = id;
        this.position = position;
        this.company = company;
        this.logo = logo;
        this.mode = mode;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.timeElapsed = timeElapsed;
    }
    
}
