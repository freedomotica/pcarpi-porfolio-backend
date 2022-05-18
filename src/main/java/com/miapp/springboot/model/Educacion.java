
package com.miapp.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String school;
    private String title;
    private String career;
    private String dateStart;
    private String dateEnd;
    private String logo;
    private Integer score;

    public Educacion() {
    }
    
    
     public Educacion(Long id, String school, String title, String career, String dateStart, String dateEnd, String logo, Integer score) {
        this.id = id;
        this.school = school;
        this.title = title;
        this.career = career;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.logo = logo;
        this.score = score;
    }
   
}
