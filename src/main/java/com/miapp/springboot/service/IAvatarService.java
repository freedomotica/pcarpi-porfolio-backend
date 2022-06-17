
package com.miapp.springboot.service;

import com.miapp.springboot.model.Avatar;
import java.util.List;


public interface IAvatarService {
    public List <Avatar> verAvatar();
    public void crearAvatar (Avatar edu);
    public void updateAvatar (Avatar edu);
    public void borrarAvatar (Long id);
    public Avatar buscarAvatar(Long id);
}
