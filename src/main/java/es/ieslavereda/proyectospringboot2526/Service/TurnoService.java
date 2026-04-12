package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.TurnoRepository;
import es.ieslavereda.proyectospringboot2526.repository.UsuarioRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Turno;
import es.ieslavereda.proyectospringboot2526.repository.model.Usuario;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    @PostConstruct
    public void init() {
        generarTurnosMesActual();
    }


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
        Turno t = getTurnoById(id);
        if (t != null) {
            turnoRepository.delete(t);
        }
        return t;
    }



    public void generarTurnosMesActual() {

        YearMonth mes = YearMonth.now();
        LocalDate inicio = mes.atDay(1);
        LocalDate fin = mes.atEndOfMonth();

        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario u : usuarios) {

            if ("PRODUCCIÓN".equals(u.getTipoPuesto())) {
                generarProduccion(u, inicio, fin);
            } else {
                generarOficina(u, inicio, fin);
            }
        }
    }

    // =========================================================
    // PRODUCCIÓN
    // =========================================================

    public void generarProduccion(Usuario u, LocalDate inicio, LocalDate fin) {

        int diaLaboral = 0;

        for (LocalDate fecha = inicio; !fecha.isAfter(fin); fecha = fecha.plusDays(1)) {

            if (fecha.getDayOfWeek().getValue() <= 5) {

                int bloque = (diaLaboral / 5) % 3;

                String tipo = switch (bloque) {
                    case 0 -> "MAÑANA";
                    case 1 -> "TARDE";
                    default -> "NOCHE";
                };

                if (turnoExiste(u.getIdEmpleado(), tipo, fecha)) continue;

                Turno t = new Turno();
                t.setIdEmpleado(u.getIdEmpleado());
                t.setTipoTurno(tipo);

                if (tipo.equals("MAÑANA")) {
                    t.setFechaInicio(fecha + "T06:00");
                    t.setFechaFin(fecha + "T14:00");
                } else if (tipo.equals("TARDE")) {
                    t.setFechaInicio(fecha + "T14:00");
                    t.setFechaFin(fecha + "T22:00");
                } else {
                    t.setFechaInicio(fecha + "T22:00");
                    t.setFechaFin(fecha.plusDays(1) + "T06:00");
                }

                turnoRepository.save(t);

                diaLaboral++;
            }
        }
    }


    public void generarOficina(Usuario u, LocalDate inicio, LocalDate fin) {

        for (LocalDate fecha = inicio; !fecha.isAfter(fin); fecha = fecha.plusDays(1)) {

            if (fecha.getDayOfWeek().getValue() <= 5) {

                if (turnoExiste(u.getIdEmpleado(), "OFICINA", fecha)) continue;

                Turno t = new Turno();
                t.setIdEmpleado(u.getIdEmpleado());
                t.setTipoTurno("OFICINA");
                t.setFechaInicio(fecha + "T08:00");
                t.setFechaFin(fecha + "T17:30");

                turnoRepository.save(t);
            }
        }
    }



    public void generarTurnosParaNuevoUsuario(Usuario u) {
        generarTurnosMesActual();
    }



    private boolean turnoExiste(int idEmpleado, String tipo, LocalDate fecha) {
        return turnoRepository.existsByIdEmpleadoAndTipoTurnoAndFechaInicioStartingWith(
                idEmpleado,
                tipo,
                fecha.toString()
        );
    }
}