
package com.miapp.springboot.DTO;

import com.miapp.springboot.model.Avatar;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PorfolioDTO implements Serializable {
    private Long id;
    private String name;
    private String backImage;
    private String position;
    private String ubicacion;
    private String about;
    private Avatar avatar;
    private String budge;
    private List educacion;
    private List Experience;
    private List Skill;
    private List Proyectos;
    private String whatsapp;
    private String facebook;
    private String linkedin;

    public PorfolioDTO(Long id, String name, String backImage, String position, String ubicacion, String about, Avatar avatar, String budge, List educacion, List Experience, List Skill, List Proyectos, String whatsapp, String facebook, String linkedin) {
        this.id = id;
        this.name = name;
        this.backImage = backImage;
        this.position = position;
        this.ubicacion = ubicacion;
        this.about = about;
        this.avatar = avatar;
        this.budge = budge;
        this.educacion = educacion;
        this.Experience = Experience;
        this.Skill = Skill;
        this.Proyectos = Proyectos;
        this.whatsapp = whatsapp;
        this.facebook = facebook;
        this.linkedin = linkedin;
    }
    
  

    public PorfolioDTO() {
    }





     
    
}
