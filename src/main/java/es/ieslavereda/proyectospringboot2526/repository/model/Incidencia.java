package es.ieslavereda.proyectospringboot2526.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "incidencias")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidencia")
    private int idIncidencia;

    @Column(name = "id_empleado", nullable = false)
    private int idEmpleado;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String descripcion;

    public Incidencia() {
    }

    public Incidencia(int idEmpleado, String fecha, String tipo, String descripcion) {
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
