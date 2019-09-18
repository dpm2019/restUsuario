package pe.upc.usuarios.controller;
import org.springframework.http.ResponseEntity;
import pe.upc.usuarios.exception.UsuarioNotFoundException;
import pe.upc.usuarios.model.Usuario;
import pe.upc.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    //Get All Usuarios
    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    //Create New Usuario
    @PostMapping("/usuarios")
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Get a Single Usuario
    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(@PathVariable(value = "id") Long usuarioId,
                                  @Valid @RequestBody Usuario usuarioDetalle) throws UsuarioNotFoundException {

        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNotFoundException(usuarioId));

    }

    //Update Usuario
    @PutMapping("/usuarios/{id}")
    public Usuario updateUsuario(@PathVariable(value = "id") Long usuarioId,
                                 @Valid @RequestBody Usuario usuarioDetalle) throws UsuarioNotFoundException {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNotFoundException(usuarioId));

        usuario.setNombres(usuarioDetalle.getNombres());
        usuario.setApellidos(usuarioDetalle.getApellidos());
        usuario.setCorreo(usuarioDetalle.getCorreo());
        usuario.setDepartamento(usuarioDetalle.getDepartamento());
        usuario.setPais(usuarioDetalle.getPais());
        usuario.setTelefono(usuarioDetalle.getTelefono());
        usuario.setToken(usuarioDetalle.getToken());

        Usuario updateUsuario = usuarioRepository.save(usuario);

        return updateUsuario;

    }

    // Delete Usuario
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable(value = "id") Long usuarioId) throws UsuarioNotFoundException{

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNotFoundException(usuarioId));

        usuarioRepository.delete(usuario);

        return ResponseEntity.ok().build();

    }

}
