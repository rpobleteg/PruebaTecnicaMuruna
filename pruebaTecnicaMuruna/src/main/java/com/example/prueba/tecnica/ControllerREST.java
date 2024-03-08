package com.example.prueba.tecnica;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.UUID;

import com.example.prueba.tecnica.repository.UsuarioRepository; // Importa UsuarioRepository
import com.example.prueba.tecnica.service.UserDataValidationService;
import com.example.prueba.tecnica.entity.UsuarioEntity; // Importa UsuarioEntity
import com.example.prueba.tecnica.dto.UsuarioDTO; // Importa UsuarioRepository

@RestController
public class ControllerREST {

        private final UsuarioRepository usuarioRepository;
        
        private final UserDataValidationService userDataValidationService;

    public ControllerREST(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
		this.userDataValidationService = new UserDataValidationService();
    }

    @PostMapping("/registro")
    public RegistroResponse registro(@RequestBody UsuarioDTO usuarioDTO) {
    	
    	//Validacion Email
        if (usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
            throw new RuntimeException("El correo ya registrado");
        }

            this.userDataValidationService.validateEmail(usuarioDTO.getEmail());
            
        //Validacion Contrasena 
        this.userDataValidationService.validatePassword(usuarioDTO.getPassword());
        
        String token = UUID.randomUUID().toString();

        LocalDateTime now = LocalDateTime.now();
        
        String id = UUID.randomUUID().toString();

        // Nueva entidad Usuario
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(id);
        usuarioEntity.setNombre(usuarioDTO.getNombre());
        usuarioEntity.setEmail(usuarioDTO.getEmail());
        usuarioEntity.setPassword(usuarioDTO.getPassword());
        usuarioEntity.setPhones(usuarioDTO.getPhones());
        usuarioEntity.setToken(token);
        usuarioEntity.setCreated(now);
        usuarioEntity.setModified(now);
        usuarioEntity.setLastLogin(now);
        usuarioEntity.setActive(true);

        // Save, base de datos
        usuarioRepository.save(usuarioEntity);

        RegistroResponse response = new RegistroResponse();
        
        response.setId(usuarioEntity.getId());
        response.setCreated(usuarioEntity.getCreated());
        response.setModified(usuarioEntity.getModified());
        response.setLastLogin(usuarioEntity.getLastLogin());
        response.setToken(token);
        response.setActive(usuarioEntity.isActive());

        return response;
    }
}
