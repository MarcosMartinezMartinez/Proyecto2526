package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.repository.model.Turno;
import es.ieslavereda.proyectospringboot2526.Service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public List<Turno> getAllTurnos() throws SQLException {
        return turnoService.getAllTurnos();
    }

    @GetMapping("/{id}")
    public Turno getTurno(@PathVariable int id) throws SQLException {
        return turnoService.getTurno(id);
    }

    @DeleteMapping("/{id}")
    public Turno deleteTurno(@PathVariable int id) throws SQLException {
        return turnoService.deleteTurno(id);
    }

    @PutMapping
    public Turno updateTurno(@RequestBody Turno turno) throws SQLException {
        return turnoService.updateTurno(turno);
    }

    @PostMapping
    public Turno addTurno(@RequestBody Turno turno) throws SQLException {
        return turnoService.addTurno(turno);
    }
}
