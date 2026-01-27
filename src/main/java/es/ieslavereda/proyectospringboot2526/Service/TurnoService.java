package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.TurnoRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public List<Turno> getAllTurnos() {
        return turnoRepository.findAll();
    }


    public Turno getTurnoById(int id) {
        return turnoRepository.findById(id).orElse(null);
    }

    public List<Turno> getTurnosByEmpleado(int idEmpleado) {
        return turnoRepository.findByIdEmpleado(idEmpleado);
    }

    public Turno addTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public Turno updateTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public Turno deleteTurno(int id) {
        Turno turno = getTurnoById(id);
        if (turno != null) {
            turnoRepository.delete(turno);
        }
        return turno;
    }
}
