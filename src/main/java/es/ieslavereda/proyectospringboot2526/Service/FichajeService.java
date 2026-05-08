package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.FichajeRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Fichaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichajeService {

    @Autowired
    private FichajeRepository fichajeRepository;

    public List<Fichaje> getAllFichajes() {
        return fichajeRepository.findAll();
    }

    public Fichaje getFichaje(int id) {
        Optional<Fichaje> fichaje = fichajeRepository.findById(id);
        return fichaje.orElse(null);
    }

    public List<Fichaje> getFichajesByEmpleado(int idEmpleado) {
        return fichajeRepository.findByIdEmpleado(idEmpleado);
    }

    public Fichaje addFichaje(Fichaje fichaje) {
        return fichajeRepository.save(fichaje);
    }

    public Fichaje updateFichaje(Fichaje fichaje) {
        return fichajeRepository.save(fichaje);
    }

    public Fichaje deleteFichaje(int id) {
        Fichaje fichaje = getFichaje(id);
        if (fichaje != null) {
            fichajeRepository.delete(fichaje);
        }
        return fichaje;
    }
}
