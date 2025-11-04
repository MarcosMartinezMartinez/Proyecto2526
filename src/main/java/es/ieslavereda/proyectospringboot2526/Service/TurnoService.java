package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.TurnoRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public List<Turno> getAllTurnos() throws SQLException {
        return turnoRepository.getAllTurnos();
    }

    public Turno getTurno(int id_turno) throws SQLException {
        return turnoRepository.getTurno(id_turno);
    }

    public Turno deleteTurno(int id_turno) throws SQLException {
        return turnoRepository.deleteTurno(id_turno);
    }

    public Turno updateTurno(Turno turno) throws SQLException {
        return turnoRepository.updateTurno(turno);
    }

    public Turno addTurno(Turno turno) throws SQLException {
        return turnoRepository.addTurno(turno);
    }
}
