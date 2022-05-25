
package com.miapp.springboot.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

@Service
public class Encriptado {
    
    public String hash(String word){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        return argon2.hash(1, 1024, 1, word);
        
    }
    
    public boolean Verify(String hash, String pass){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        return argon2.verify(hash, pass);
    }

    public Encriptado() {
    }
    
}
