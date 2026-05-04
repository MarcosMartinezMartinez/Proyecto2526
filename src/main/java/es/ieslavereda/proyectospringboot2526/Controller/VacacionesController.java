package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.Service.VacacionesService;
import es.ieslavereda.proyectospringboot2526.repository.model.Vacaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacaciones")
public class VacacionesController {

    @Autowired
    private VacacionesService vacacionesService;

    @GetMapping("/empleado/{id}")
    public ResponseEntity<List<Vacaciones>> getVacaciones(@PathVariable int id) {
        return ResponseEntity.ok(vacacionesService.getByEmpleado(id));
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Vacaciones v) {
        try {
            return ResponseEntity.ok(vacacionesService.solicitarVacaciones(v));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}