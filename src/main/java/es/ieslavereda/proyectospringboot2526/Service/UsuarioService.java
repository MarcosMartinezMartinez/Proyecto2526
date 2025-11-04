package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.UsuarioRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() throws SQLException {
        return usuarioRepository.getAllUsuarios();
    }

    public Usuario getUsuario(String nombre) throws SQLException {
        return usuarioRepository.getUsuario(nombre);
    }

    public Usuario deleteUsuario(String nombre) throws SQLException {
        return usuarioRepository.deleteUsuario(nombre);
    }

    public Usuario updateUsuario(Usuario usuario) throws SQLException {
        return usuarioRepository.updateUsuario(usuario);
    }

    public Usuario addUsuario(Usuario usuario) throws SQLException {
        return usuarioRepository.addUsuario(usuario);
    }
}
