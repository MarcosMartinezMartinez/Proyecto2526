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

    @GetMapping
    public ResponseEntity<List<Fichaje>> getAllFichajes() {
        return ResponseEntity.ok(fichajeService.getAllFichajes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFichaje(@PathVariable int id) {
        Fichaje fichaje = fichajeService.getFichaje(id);
        if (fichaje == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Fichaje no encontrado");
        }
        return ResponseEntity.ok(fichaje);
    }

    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<?> getFichajesByEmpleado(@PathVariable int idEmpleado) {
        List<Fichaje> fichajes = fichajeService.getFichajesByEmpleado(idEmpleado);
        return ResponseEntity.ok(fichajes);
    }

    @PostMapping
    public ResponseEntity<Fichaje> addFichaje(@RequestBody Fichaje fichaje) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(fichajeService.addFichaje(fichaje));
    }

    @PutMapping
    public ResponseEntity<Fichaje> updateFichaje(@RequestBody Fichaje fichaje) {
        return ResponseEntity.ok(fichajeService.updateFichaje(fichaje));
    }

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
