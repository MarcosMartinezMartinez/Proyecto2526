package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.Service.FichajeService;
import es.ieslavereda.proyectospringboot2526.repository.model.Fichaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichaje")
public class FichajeController {

    @Autowired
    private FichajeService fichajeService;

    // Obtener todos los fichajes
    @GetMapping
    public ResponseEntity<List<Fichaje>> getAllFichajes() {
        return ResponseEntity.ok(fichajeService.getAllFichajes());
    }

    // Obtener un fichaje por id
    @GetMapping("/{id}")
    public ResponseEntity<?> getFichaje(@PathVariable int id) {
        Fichaje fichaje = fichajeService.getFichaje(id);
        if (fichaje == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Fichaje no encontrado");
        }
        return ResponseEntity.ok(fichaje);
    }

    // Obtener fichajes por empleado
    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<?> getFichajesByEmpleado(@PathVariable int idEmpleado) {
        List<Fichaje> fichajes = fichajeService.getFichajesByEmpleado(idEmpleado);
        if (fichajes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron fichajes para este empleado");
        }
        return ResponseEntity.ok(fichajes);
    }

    // Crear un fichaje
    @PostMapping
    public ResponseEntity<Fichaje> addFichaje(@RequestBody Fichaje fichaje) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(fichajeService.addFichaje(fichaje));
    }

    // Actualizar un fichaje
    @PutMapping
    public ResponseEntity<Fichaje> updateFichaje(@RequestBody Fichaje fichaje) {
        return ResponseEntity.ok(fichajeService.updateFichaje(fichaje));
    }

    // Eliminar un fichaje por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFichaje(@PathVariable int id) {
        Fichaje fichaje = fichajeService.deleteFichaje(id);
        if (fichaje == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Fichaje no encontrado");
        }
        return ResponseEntity.ok(fichaje);
    }
}
