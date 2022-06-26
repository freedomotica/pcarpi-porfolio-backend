
package com.miapp.springboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona implements Serializable {

   
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String backImage;
    private String position;
    private String ubicacion;
    private String about;
    private String budge;
    
    private String whatsapp;
    private String facebook;
    private String linkedin;
    
    //@JsonInclude(Include.NON_NULL)
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Avatar avatar;
    
    

    public Persona() {
    }

    public Persona(Long id, String name, String backImage, String position, String ubicacion, String about, Avatar avatar, String budge, String whatsapp, String facebook, String linkedin) {
        this.id = id;
        this.name = name;
        this.backImage = backImage;
        this.position = position;
        this.ubicacion = ubicacion;
        this.about = about;
        this.avatar = avatar;
        this.budge = budge;
        this.whatsapp = whatsapp;
        this.facebook = facebook;
        this.linkedin = linkedin;
    }

 



     
}
