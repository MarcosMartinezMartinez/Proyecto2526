package es.ieslavereda.proyectospringboot2526.repository;

import es.ieslavereda.proyectospringboot2526.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    @Autowired
    @Qualifier("fuenteDeDatosMySQL")
    private DataSource dataSource;

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM empleados";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                usuarios.add(new Usuario(
                        resultSet.getInt("id_empleado"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("email"),
                        resultSet.getString("contraseña"),
                        resultSet.getString("rol"),
                        resultSet.getString("fecha_alta"),
                        resultSet.getBoolean("activo"),
                        resultSet.getString("tipo_puesto")
                ));
            }
        }
        return usuarios;
    }

    // Obtener un usuario por nombre
    public Usuario getUsuario(String nombre) throws SQLException {
        Usuario usuario = null;
        String query = "SELECT * FROM empleados WHERE nombre = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario(
                        resultSet.getInt("id_empleado"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("email"),
                        resultSet.getString("contraseña"),
                        resultSet.getString("rol"),
                        resultSet.getString("fecha_alta"),
                        resultSet.getBoolean("activo"),
                        resultSet.getString("tipo_puesto")
                );
            }
        }
        return usuario;
    }

    // Eliminar un usuario
    public Usuario deleteUsuario(String nombre) throws SQLException {
        Usuario usuario = getUsuario(nombre);
        if (usuario != null) {
            String query = "DELETE FROM empleados WHERE nombre = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, nombre);
                preparedStatement.executeUpdate();
            }
        }
        return usuario;
    }

    // Actualizar un usuario
    public Usuario updateUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE empleados SET apellidos = ?, email = ?, contraseña = ?, rol = ?, activo = ?, tipo_puesto = ? WHERE nombre = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, usuario.getApellidos());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getContraseña());
            preparedStatement.setString(4, usuario.getRol());
            preparedStatement.setBoolean(5, usuario.isActivo());
            preparedStatement.setString(6, usuario.getTipoPuesto());
            preparedStatement.setString(7, usuario.getNombre());

            preparedStatement.executeUpdate();
        }
        return usuario;
    }

    // Añadir un usuario
    public Usuario addUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO empleados (nombre, apellidos, email, contraseña, rol, fecha_alta, activo, tipo_puesto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellidos());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getContraseña());
            preparedStatement.setString(5, usuario.getRol());
            preparedStatement.setString(6, usuario.getFechaAlta());
            preparedStatement.setBoolean(7, usuario.isActivo());
            preparedStatement.setString(8, usuario.getTipoPuesto());

            preparedStatement.executeUpdate();
        }
        return usuario;
    }
}
