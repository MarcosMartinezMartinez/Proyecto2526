package es.ieslavereda.proyectospringboot2526.repository;

import es.ieslavereda.proyectospringboot2526.repository.model.Fichaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FichajeRepository {

    @Autowired
    @Qualifier("fuenteDeDatosMySQL")
    private DataSource dataSource;

    // Obtener todos los fichajes
    public List<Fichaje> getAllFichajes() throws SQLException {
        List<Fichaje> fichajes = new ArrayList<>();
        String query = "SELECT * FROM fichajes";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                fichajes.add(new Fichaje(
                        resultSet.getInt("id_fichaje"),
                        resultSet.getInt("id_empleado"),
                        resultSet.getString("fecha_hora"),
                        resultSet.getString("tipo")
                ));
            }
        }
        return fichajes;
    }

    // Obtener un fichaje por id
    public Fichaje getFichaje(int idFichaje) throws SQLException {
        Fichaje fichaje = null;
        String query = "SELECT * FROM fichajes WHERE id_fichaje = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, idFichaje);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                fichaje = new Fichaje(
                        resultSet.getInt("id_fichaje"),
                        resultSet.getInt("id_empleado"),
                        resultSet.getString("fecha_hora"),
                        resultSet.getString("tipo")
                );
            }
        }
        return fichaje;
    }

    // Eliminar un fichaje
    public Fichaje deleteFichaje(int idFichaje) throws SQLException {
        Fichaje fichaje = getFichaje(idFichaje);
        if (fichaje != null) {
            String query = "DELETE FROM fichajes WHERE id_fichaje = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idFichaje);
                preparedStatement.executeUpdate();
            }
        }
        return fichaje;
    }

    // Actualizar un fichaje
    public Fichaje updateFichaje(Fichaje fichaje) throws SQLException {
        String query = "UPDATE fichajes SET id_empleado = ?, fecha_hora = ?, tipo = ? WHERE id_fichaje = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, fichaje.getIdEmpleado());
            preparedStatement.setString(2, fichaje.getFechaHora());
            preparedStatement.setString(3, fichaje.getTipo());
            preparedStatement.setInt(4, fichaje.getIdFichaje());
            preparedStatement.executeUpdate();
        }
        return fichaje;
    }

    // Añadir un nuevo fichaje
    public Fichaje addFichaje(Fichaje fichaje) throws SQLException {
        String query = "INSERT INTO fichajes (id_empleado, fecha_hora, tipo) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, fichaje.getIdEmpleado());
            preparedStatement.setString(2, fichaje.getFechaHora());
            preparedStatement.setString(3, fichaje.getTipo());
            preparedStatement.executeUpdate();
        }
        return fichaje;
    }
}
