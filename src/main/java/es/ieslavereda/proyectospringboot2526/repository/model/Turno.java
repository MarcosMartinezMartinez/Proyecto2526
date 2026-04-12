package es.ieslavereda.proyectospringboot2526.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private int idTurno;

    @Column(name = "id_empleado", nullable = false)
    private int idEmpleado;

    @Column(name = "fecha_inicio", nullable = false)
    private String fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private String fechaFin;

    @Column(name = "tipo_turno", nullable = false)
    private String tipoTurno;



    public Turno() {
    }

    public Turno(int idTurno, int idEmpleado, String fechaInicio, String fechaFin, String tipoTurno) {
        this.idTurno = idTurno;
        this.idEmpleado = idEmpleado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoTurno = tipoTurno;
    }


    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }
}