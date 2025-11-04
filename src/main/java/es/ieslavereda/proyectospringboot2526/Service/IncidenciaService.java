package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.IncidenciaRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Incidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    public List<Incidencia> getAllIncidencias() throws SQLException {
        return incidenciaRepository.getAllIncidencias();
    }

    public Incidencia getIncidencia(int idIncidencia) throws SQLException {
        return incidenciaRepository.getIncidencia(idIncidencia);
    }

    public Incidencia addIncidencia(Incidencia incidencia) throws SQLException {
        return incidenciaRepository.addIncidencia(incidencia);
    }

    public Incidencia updateIncidencia(Incidencia incidencia) throws SQLException {
        return incidenciaRepository.updateIncidencia(incidencia);
    }

    public Incidencia deleteIncidencia(int idIncidencia) throws SQLException {
        return incidenciaRepository.deleteIncidencia(idIncidencia);
    }
}
