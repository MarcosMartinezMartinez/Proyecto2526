package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.repository.model.Incidencia;
import es.ieslavereda.proyectospringboot2526.Service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "incidencia")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    public ResponseEntity<?> getAllIncidencias() {
        try {
            return new ResponseEntity<>(incidenciaService.getAllIncidencias(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getIncidencia(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(incidenciaService.getIncidencia(id), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> addIncidencia(@RequestBody Incidencia incidencia) {
        try {
            return new ResponseEntity<>(incidenciaService.addIncidencia(incidencia), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateIncidencia(@RequestBody Incidencia incidencia) {
        try {
            return new ResponseEntity<>(incidenciaService.updateIncidencia(incidencia), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteIncidencia(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(incidenciaService.deleteIncidencia(id), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
