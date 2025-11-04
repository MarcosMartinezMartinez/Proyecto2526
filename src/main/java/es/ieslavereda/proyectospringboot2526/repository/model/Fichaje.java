package es.ieslavereda.proyectospringboot2526.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Fichaje {

    private int idFichaje;
    private int idEmpleado;
    private String fechaHora;
    private String tipo;

    public Fichaje(int idFichaje, int idEmpleado, String fechaHora, String tipo) {
        this.idFichaje = idFichaje;
        this.idEmpleado = idEmpleado;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
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
