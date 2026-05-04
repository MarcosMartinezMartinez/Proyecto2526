package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.VacacionesRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Vacaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class VacacionesService {

    @Autowired
    private VacacionesRepository vacacionesRepository;

    public List<Vacaciones> getByEmpleado(int idEmpleado) {
        return vacacionesRepository.findByIdEmpleado(idEmpleado);
    }

    public Vacaciones solicitarVacaciones(Vacaciones v) {

        LocalDate inicio = LocalDate.parse(v.getFechaInicio());
        LocalDate fin = LocalDate.parse(v.getFechaFin());
        long diasSolicitados = ChronoUnit.DAYS.between(inicio, fin) + 1;
        List<Vacaciones> existentes = vacacionesRepository.findByIdEmpleado(v.getIdEmpleado());
        long diasUsados = 0;

        for (Vacaciones vac : existentes) {
            if ("RECHAZADA".equals(vac.getEstado())) continue;

            LocalDate i = LocalDate.parse(vac.getFechaInicio());
            LocalDate f = LocalDate.parse(vac.getFechaFin());
            diasUsados += ChronoUnit.DAYS.between(i, f) + 1;
        }

        if (diasUsados + diasSolicitados > 22) {
            throw new RuntimeException("Supera el máximo de 22 días de vacaciones");
        }

        v.setEstado("PENDIENTE");

        return vacacionesRepository.save(v);
    }
}