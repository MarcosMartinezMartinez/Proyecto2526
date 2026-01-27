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

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // ✅ Obtener un usuario por nombre
    public Usuario getUsuarioPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre).orElse(null);
    }

    // Añadir un usuario
    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar un usuario
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario por nombre
    public Usuario deleteUsuarioPorNombre(String nombre) {
        Usuario usuario = getUsuarioPorNombre(nombre);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }
        return usuario;
    }


    // Eliminar un usuario por ID
    public Usuario deleteUsuarioById(int id) {
        Usuario usuario = getUsuarioById(id);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }
        return usuario;
    }
}
