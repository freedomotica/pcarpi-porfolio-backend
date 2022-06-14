
package com.miapp.springboot.Controller;

import com.miapp.springboot.service.FileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {
    
    @Autowired
    private FileService fileService;
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles (@RequestParam("files") List<MultipartFile> files){
        try{
            fileService.save(files);
            return ResponseEntity.status(HttpStatus.OK).body("Archivos cargados correctamente");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }
}
