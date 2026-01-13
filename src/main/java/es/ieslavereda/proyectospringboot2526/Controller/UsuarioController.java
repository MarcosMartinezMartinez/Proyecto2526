package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.Service.UsuarioService;
import es.ieslavereda.proyectospringboot2526.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    // Obtener un usuario por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> getUsuarioByNombre(@PathVariable String nombre) {
        Usuario usuario = usuarioService.getUsuarioPorNombre(nombre);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
        return ResponseEntity.ok(usuario);
    }

    // Crear un usuario
    @PostMapping
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.addUsuario(usuario));
    }

    // Actualizar un usuario
    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.updateUsuario(usuario));
    }

    // Eliminar un usuario por nombre
    @DeleteMapping("/nombre/{nombre}")
    public ResponseEntity<?> deleteUsuarioByNombre(@PathVariable String nombre) {
        Usuario usuario = usuarioService.deleteUsuarioPorNombre(nombre);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable int id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
        return ResponseEntity.ok(usuario);
    }

}
