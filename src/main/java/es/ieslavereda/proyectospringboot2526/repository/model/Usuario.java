package es.ieslavereda.proyectospringboot2526.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int idEmpleado;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false, unique = true)
    private String email;


    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private String rol;

    @Column(name = "fecha_alta", nullable = false)
    private String fechaAlta;

    @Column(nullable = false)
    private boolean activo;

    @Column(name = "tipo_puesto", nullable = false)
    private String tipoPuesto;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String email, String contraseña,
                   String rol, String fechaAlta, boolean activo, String tipoPuesto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contraseña = contraseña;
        this.rol = rol;
        this.fechaAlta = fechaAlta;
        this.activo = activo;
        this.tipoPuesto = tipoPuesto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getRol() {
        return rol;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getTipoPuesto() {
        return tipoPuesto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setTipoPuesto(String tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }
}
