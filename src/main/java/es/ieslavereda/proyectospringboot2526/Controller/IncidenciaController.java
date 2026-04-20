package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.Service.IncidenciaService;
import es.ieslavereda.proyectospringboot2526.repository.model.Incidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    public ResponseEntity<List<Incidencia>> getAllIncidencias() {
        return ResponseEntity.ok(incidenciaService.getAllIncidencias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIncidencia(@PathVariable int id) {
        Incidencia incidencia = incidenciaService.getIncidenciaById(id);
        if (incidencia == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Incidencia no encontrada");
        }
        return ResponseEntity.ok(incidencia);
    }

    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<?> getIncidenciasByEmpleado(@PathVariable int idEmpleado) {
        List<Incidencia> incidencias = incidenciaService.getIncidenciasByEmpleado(idEmpleado);
        if (incidencias.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron incidencias para este empleado");
        }
        return ResponseEntity.ok(incidencias);
    }

    @PostMapping
    public ResponseEntity<Incidencia> addIncidencia(@RequestBody Incidencia incidencia) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(incidenciaService.addIncidencia(incidencia));
    }

    @PutMapping
    public ResponseEntity<Incidencia> updateIncidencia(@RequestBody Incidencia incidencia) {
        return ResponseEntity.ok(incidenciaService.updateIncidencia(incidencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncidencia(@PathVariable int id) {
        Incidencia incidencia = incidenciaService.deleteIncidencia(id);
        if (incidencia == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Incidencia no encontrada");
        }
        return ResponseEntity.ok(incidencia);
    }

}
