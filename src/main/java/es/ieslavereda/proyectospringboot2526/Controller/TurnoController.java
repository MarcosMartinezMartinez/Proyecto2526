package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.Service.TurnoService;
import es.ieslavereda.proyectospringboot2526.repository.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public ResponseEntity<List<Turno>> getAllTurnos() {
        return ResponseEntity.ok(turnoService.getAllTurnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTurno(@PathVariable int id) {
        Turno turno = turnoService.getTurnoById(id);
        if (turno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turno);
    }

    // 🔥 FILTRAR TURNOS POR EMPLEADO
    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<List<Turno>> getTurnosByEmpleado(@PathVariable int idEmpleado) {
        return ResponseEntity.ok(turnoService.getTurnosByEmpleado(idEmpleado));
    }

    @PostMapping
    public ResponseEntity<Turno> addTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.addTurno(turno));
    }

    @PutMapping
    public ResponseEntity<Turno> updateTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.updateTurno(turno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurno(@PathVariable int id) {
        Turno turno = turnoService.deleteTurno(id);
        if (turno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turno);
    }
}
