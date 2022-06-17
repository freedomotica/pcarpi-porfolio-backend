
package com.miapp.springboot.service;

import com.miapp.springboot.model.Avatar;
import com.miapp.springboot.repository.AvatarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarService implements IAvatarService {
    
    @Autowired
    public AvatarRepository avatarRepo;
    
    @Override
    public List<Avatar> verAvatar() {
        return avatarRepo.findAll();
    }
    @Override
    public void crearAvatar(Avatar per) {
        avatarRepo.save(per);
    }
    @Override
       public void updateAvatar(Avatar per) {
           avatarRepo.save(per);
       }
    @Override
    public void borrarAvatar(Long id) {
        avatarRepo.deleteById(id);
    }

    @Override
    public Avatar buscarAvatar(Long id) {
       return avatarRepo.findById(id).orElse(null);
    }
   
}
