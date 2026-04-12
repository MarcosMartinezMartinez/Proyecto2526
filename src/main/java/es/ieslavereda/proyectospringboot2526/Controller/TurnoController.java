package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.Service.TurnoService;
import es.ieslavereda.proyectospringboot2526.repository.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
@CrossOrigin(origins = "*")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    // =========================================================
    // GET ALL
    // =========================================================

    @GetMapping
    public ResponseEntity<List<Turno>> getAllTurnos() {
        return ResponseEntity.ok(turnoService.getAllTurnos());
    }

    // =========================================================
    // GET BY ID
    // =========================================================

    @GetMapping("/{id}")
    public ResponseEntity<Turno> getTurno(@PathVariable int id) {

        Turno turno = turnoService.getTurnoById(id);

        if (turno == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(turno);
    }

    // =========================================================
    // GET BY EMPLEADO
    // =========================================================

    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<?> getTurnosByEmpleado(@PathVariable int idEmpleado) {

        try {
            List<Turno> turnos = turnoService.getTurnosByEmpleado(idEmpleado);

            return ResponseEntity
                    .ok()
                    .body(turnos);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(500)
                    .body("ERROR REAL: " + e.getMessage());
        }
    }

    // =========================================================
    // CREATE
    // =========================================================

    @PostMapping
    public ResponseEntity<Turno> addTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.addTurno(turno));
    }

    // =========================================================
    // UPDATE
    // =========================================================

    @PutMapping
    public ResponseEntity<Turno> updateTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.updateTurno(turno));
    }

    // =========================================================
    // DELETE
    // =========================================================

    @DeleteMapping("/{id}")
    public ResponseEntity<Turno> deleteTurno(@PathVariable int id) {

        Turno turno = turnoService.deleteTurno(id);

        if (turno == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(turno);
    }
}