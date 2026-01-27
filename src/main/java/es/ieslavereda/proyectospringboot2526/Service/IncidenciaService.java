package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.IncidenciaRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Incidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    public List<Incidencia> getAllIncidencias() {
        return incidenciaRepository.findAll();
    }


    public Incidencia getIncidenciaById(int id) {
        return incidenciaRepository.findById(id).orElse(null);
    }

    public List<Incidencia> getIncidenciasByEmpleado(int idEmpleado) {
        return incidenciaRepository.findByIdEmpleado(idEmpleado);
    }

    public Incidencia addIncidencia(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    public Incidencia updateIncidencia(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    public Incidencia deleteIncidencia(int id) {
        Incidencia incidencia = incidenciaRepository.findById(id).orElse(null);
        if (incidencia != null) {
            incidenciaRepository.delete(incidencia);
        }
        return incidencia;
    }
}
