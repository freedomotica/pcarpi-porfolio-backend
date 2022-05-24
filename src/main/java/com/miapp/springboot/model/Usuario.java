
package com.miapp.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String user;
    private String password;

    public Usuario() {
    }

    public Usuario(Long id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }
    
}
