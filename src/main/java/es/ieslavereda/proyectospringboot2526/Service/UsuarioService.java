package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.UsuarioRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TurnoService turnoService;



    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }



    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }


    public Usuario getUsuarioPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre).orElse(null);
    }



    public Usuario addUsuario(Usuario usuario) {

        Usuario u = usuarioRepository.save(usuario);

        turnoService.generarTurnosParaNuevoUsuario(u);

        return u;
    }


    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public Usuario deleteUsuarioPorNombre(String nombre) {

        Usuario usuario = getUsuarioPorNombre(nombre);

        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }

        return usuario;
    }


    public Usuario deleteUsuarioById(int id) {

        Usuario usuario = getUsuarioById(id);

        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }

        return usuario;
    }
}