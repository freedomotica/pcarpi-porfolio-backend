
package com.miapp.springboot.DTO;

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
    private String avatar;
    private List educacion;

    public PorfolioDTO() {
    }

    public PorfolioDTO(Long id, String name, String backImage, String position, String ubicacion, String about, String avatar, List educacion) {
        this.id = id;
        this.name = name;
        this.backImage = backImage;
        this.position = position;
        this.ubicacion = ubicacion;
        this.about = about;
        this.avatar = avatar;
        this.educacion = educacion;
    }
    
    
    
}
