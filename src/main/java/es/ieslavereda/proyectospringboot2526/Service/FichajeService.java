package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.FichajeRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Fichaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FichajeService {

    @Autowired
    private FichajeRepository fichajeRepository;

    public List<Fichaje> getAllFichajes() throws SQLException {
        return fichajeRepository.getAllFichajes();
    }

    public Fichaje getFichaje(int idFichaje) throws SQLException {
        return fichajeRepository.getFichaje(idFichaje);
    }

    public Fichaje deleteFichaje(int idFichaje) throws SQLException {
        return fichajeRepository.deleteFichaje(idFichaje);
    }

    public Fichaje updateFichaje(Fichaje fichaje) throws SQLException {
        return fichajeRepository.updateFichaje(fichaje);
    }

    public Fichaje addFichaje(Fichaje fichaje) throws SQLException {
        return fichajeRepository.addFichaje(fichaje);
    }
}
