package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.repository.model.Fichaje;
import es.ieslavereda.proyectospringboot2526.Service.FichajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "fichaje")
public class FichajeController {

    @Autowired
    private FichajeService fichajeService;

    @GetMapping
    public ResponseEntity<?> getAllFichajes() {
        try {
            return new ResponseEntity<>(fichajeService.getAllFichajes(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getFichaje(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(fichajeService.getFichaje(id), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteFichaje(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(fichajeService.deleteFichaje(id), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateFichaje(@RequestBody Fichaje fichaje) {
        try {
            return new ResponseEntity<>(fichajeService.updateFichaje(fichaje), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> addFichaje(@RequestBody Fichaje fichaje) {
        try {
            return new ResponseEntity<>(fichajeService.addFichaje(fichaje), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
