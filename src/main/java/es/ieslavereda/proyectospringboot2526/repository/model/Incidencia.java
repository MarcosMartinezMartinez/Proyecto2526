package es.ieslavereda.proyectospringboot2526.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Incidencia {
    private int idIncidencia;
    private int idEmpleado;
    private String fecha;
    private String tipo;
    private String descripcion;

    public Incidencia(int idIncidencia, int idEmpleado, String fecha, String tipo, String descripcion) {
        this.idIncidencia = idIncidencia;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
