package es.ieslavereda.proyectospringboot2526.repository;

import es.ieslavereda.proyectospringboot2526.repository.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TurnoRepository {

    @Autowired
    @Qualifier("fuenteDeDatosMySQL")
    private DataSource dataSource;

    public List<Turno> getAllTurnos() throws SQLException {
        List<Turno> turnos = new ArrayList<>();
        String query = "SELECT * FROM turnos";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                turnos.add(new Turno(
                        resultSet.getInt("id_turno"),
                        resultSet.getInt("id_empleado"),
                        resultSet.getString("fecha_inicio"),
                        resultSet.getString("fecha_fin"),
                        resultSet.getString("tipo_turno")
                ));
            }
        }
        return turnos;
    }

    public Turno getTurno(int id_turno) throws SQLException {
        Turno turno = null;
        String query = "SELECT * FROM turnos WHERE id_turno = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id_turno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                turno = new Turno(
                        rs.getInt("id_turno"),
                        rs.getInt("id_empleado"),
                        rs.getString("fecha_inicio"),
                        rs.getString("fecha_fin"),
                        rs.getString("tipo_turno")
                );
            }
        }
        return turno;
    }

    public Turno deleteTurno(int id_turno) throws SQLException {
        Turno turno = getTurno(id_turno);
        if (turno != null) {
            String query = "DELETE FROM turnos WHERE id_turno = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement(query)) {

                ps.setInt(1, id_turno);
                ps.executeUpdate();
            }
        }
        return turno;
    }

    public Turno updateTurno(Turno turno) throws SQLException {
        String query = "UPDATE turnos SET id_empleado=?, fecha_inicio=?, fecha_fin=?, tipo_turno=? WHERE id_turno=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, turno.getId_empleado());
            ps.setString(2, turno.getFecha_inicio());
            ps.setString(3, turno.getFecha_fin());
            ps.setString(4, turno.getTipo_turno());
            ps.setInt(5, turno.getId_turno());
            ps.executeUpdate();
        }
        return turno;
    }

    public Turno addTurno(Turno turno) throws SQLException {
        String query = "INSERT INTO turnos (id_empleado, fecha_inicio, fecha_fin, tipo_turno) VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, turno.getId_empleado());
            ps.setString(2, turno.getFecha_inicio());
            ps.setString(3, turno.getFecha_fin());
            ps.setString(4, turno.getTipo_turno());
            ps.executeUpdate();
        }
        return turno;
    }
}
