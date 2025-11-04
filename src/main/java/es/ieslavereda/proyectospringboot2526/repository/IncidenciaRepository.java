package es.ieslavereda.proyectospringboot2526.repository;

import es.ieslavereda.proyectospringboot2526.repository.model.Incidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IncidenciaRepository {

    @Autowired
    @Qualifier("fuenteDeDatosMySQL")
    private DataSource dataSource;

    // Obtener todas las incidencias
    public List<Incidencia> getAllIncidencias() throws SQLException {
        List<Incidencia> incidencias = new ArrayList<>();
        String query = "SELECT * FROM incidencias";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                incidencias.add(new Incidencia(
                        rs.getInt("id_incidencia"),
                        rs.getInt("id_empleado"),
                        rs.getString("fecha"),
                        rs.getString("tipo"),
                        rs.getString("descripcion")
                ));
            }
        }
        return incidencias;
    }

    // Obtener una incidencia por ID
    public Incidencia getIncidencia(int idIncidencia) throws SQLException {
        Incidencia incidencia = null;
        String query = "SELECT * FROM incidencias WHERE id_incidencia = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, idIncidencia);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                incidencia = new Incidencia(
                        rs.getInt("id_incidencia"),
                        rs.getInt("id_empleado"),
                        rs.getString("fecha"),
                        rs.getString("tipo"),
                        rs.getString("descripcion")
                );
            }
        }
        return incidencia;
    }

    // Añadir una incidencia
    public Incidencia addIncidencia(Incidencia incidencia) throws SQLException {
        String query = "INSERT INTO incidencias (id_empleado, fecha, tipo, descripcion) VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, incidencia.getIdEmpleado());
            ps.setString(2, incidencia.getFecha());
            ps.setString(3, incidencia.getTipo());
            ps.setString(4, incidencia.getDescripcion());
            ps.executeUpdate();
        }
        return incidencia;
    }

    // Actualizar una incidencia
    public Incidencia updateIncidencia(Incidencia incidencia) throws SQLException {
        String query = "UPDATE incidencias SET id_empleado = ?, fecha = ?, tipo = ?, descripcion = ? WHERE id_incidencia = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, incidencia.getIdEmpleado());
            ps.setString(2, incidencia.getFecha());
            ps.setString(3, incidencia.getTipo());
            ps.setString(4, incidencia.getDescripcion());
            ps.setInt(5, incidencia.getIdIncidencia());
            ps.executeUpdate();
        }
        return incidencia;
    }

    // Eliminar una incidencia
    public Incidencia deleteIncidencia(int idIncidencia) throws SQLException {
        Incidencia incidencia = getIncidencia(idIncidencia);
        if (incidencia != null) {
            String query = "DELETE FROM incidencias WHERE id_incidencia = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, idIncidencia);
                ps.executeUpdate();
            }
        }
        return incidencia;
    }
}
