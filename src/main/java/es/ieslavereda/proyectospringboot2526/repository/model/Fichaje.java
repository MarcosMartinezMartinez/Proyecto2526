package es.ieslavereda.proyectospringboot2526.repository.model;

import jakarta.persistence.*;

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

    @Column(name = "id_turno", nullable = false)
    private int idTurno;

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdFichaje() {
        return idFichaje;
    }

    public void setIdFichaje(int idFichaje) {
        this.idFichaje = idFichaje;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}