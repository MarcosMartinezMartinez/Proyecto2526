package es.ieslavereda.proyectospringboot2526.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vacaciones")
public class Vacaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacacion")
    private int idVacacion;

    @Column(name = "id_empleado", nullable = false)
    private int idEmpleado;

    @Column(name = "fecha_inicio", nullable = false)
    private String fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private String fechaFin;

    @Column(name = "estado")
    private String estado; // PENDIENTE, APROBADA, RECHAZADA

    @Column(name = "observaciones")
    private String observaciones;

    public Vacaciones() {}

    public Vacaciones(int idVacacion, int idEmpleado, String fechaInicio, String fechaFin, String estado, String observaciones) {
        this.idVacacion = idVacacion;
        this.idEmpleado = idEmpleado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public int getIdVacacion() { return idVacacion; }
    public void setIdVacacion(int idVacacion) { this.idVacacion = idVacacion; }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}