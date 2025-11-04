package es.ieslavereda.proyectospringboot2526.repository.model;

public class Usuario {
    private int idEmpleado;
    private String nombre;
    private String apellidos;
    private String email;
    private String contraseña;
    private String rol;
    private String fechaAlta;
    private boolean activo;
    private String tipoPuesto;

    public Usuario(int idEmpleado, String nombre, String apellidos, String email, String contraseña, String rol, String fechaAlta, boolean activo, String tipoPuesto) {
        this.idEmpleado = idEmpleado;
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

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(String tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }
}
