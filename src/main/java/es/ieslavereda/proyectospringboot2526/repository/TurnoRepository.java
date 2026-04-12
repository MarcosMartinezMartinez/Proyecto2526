package es.ieslavereda.proyectospringboot2526.repository;

import es.ieslavereda.proyectospringboot2526.repository.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {

    List<Turno> findByIdEmpleado(int idEmpleado);

    boolean existsByIdEmpleadoAndTipoTurnoAndFechaInicioStartingWith(
            int idEmpleado,
            String tipoTurno,
            String fechaInicio
    );
}