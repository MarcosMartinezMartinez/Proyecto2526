package es.ieslavereda.proyectospringboot2526.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    private int id_turno;
    private int id_empleado;
    private String fecha_inicio;
    private String fecha_fin;
    private String tipo_turno;

    public Turno(int id_turno, int id_empleado, String fecha_inicio, String fecha_fin, String tipo_turno) {
        this.id_turno = id_turno;
        this.id_empleado = id_empleado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tipo_turno = tipo_turno;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getTipo_turno() {
        return tipo_turno;
    }

    public void setTipo_turno(String tipo_turno) {
        this.tipo_turno = tipo_turno;
    }
}
