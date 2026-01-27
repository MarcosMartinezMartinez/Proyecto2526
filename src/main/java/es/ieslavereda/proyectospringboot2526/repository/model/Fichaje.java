package es.ieslavereda.proyectospringboot2526.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fichajes")
public class Fichaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fichaje")
    private int idFichaje;

    @Column(name = "id_empleado", nullable = false)
    private int idEmpleado;

    @Column(name = "fecha_hora", nullable = false)
    private String fechaHora;

    @Column(name = "tipo", nullable = false)
    private String tipo;
}

