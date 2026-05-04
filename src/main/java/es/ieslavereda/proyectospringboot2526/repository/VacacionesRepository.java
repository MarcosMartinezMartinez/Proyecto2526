package es.ieslavereda.proyectospringboot2526.repository;

import es.ieslavereda.proyectospringboot2526.repository.model.Vacaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VacacionesRepository extends JpaRepository<Vacaciones, Integer> {

    List<Vacaciones> findByIdEmpleado(int idEmpleado);
}