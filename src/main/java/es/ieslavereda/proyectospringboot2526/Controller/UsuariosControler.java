package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.Service.UsuarioService;
import es.ieslavereda.proyectospringboot2526.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "usuario")
public class UsuariosControler {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<?> getAllUsuarios() {
        try {
            return new ResponseEntity<>(usuarioService.getAllUsuarios(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "{nombre}")
    public ResponseEntity<?> getUsuario(@PathVariable("nombre") String nombre) {
        try {
            return new ResponseEntity<>(usuarioService.getUsuario(nombre), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "{nombre}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("nombre") String nombre) {
        try {
            return new ResponseEntity<>(usuarioService.deleteUsuario(nombre), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) {
        try {
            return new ResponseEntity<>(usuarioService.updateUsuario(usuario), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> addUsuario(@RequestBody Usuario usuario) {
        try {
            return new ResponseEntity<>(usuarioService.addUsuario(usuario), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
