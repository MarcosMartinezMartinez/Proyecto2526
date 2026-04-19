package es.ieslavereda.proyectospringboot2526.Service;

import es.ieslavereda.proyectospringboot2526.repository.UsuarioRepository;
import es.ieslavereda.proyectospringboot2526.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario getUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // 🔐 LOGIN REAL
    public Usuario login(String email, String password) {

        Usuario u = usuarioRepository.findByEmail(email);

        if (u == null) return null;

        if (passwordEncoder.matches(password, u.getContraseña())) {
            return u;
        }

        return null;
    }

    // 🔐 CREAR USUARIO (ENCRIPTADO)
    public Usuario addUsuario(Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario updateUsuario(int id, Usuario datos) {

        Usuario u = usuarioRepository.findById(id).orElse(null);

        if (u == null) return null;

        u.setNombre(datos.getNombre());
        u.setApellidos(datos.getApellidos());
        u.setEmail(datos.getEmail());
        u.setRol(datos.getRol());
        u.setTipoPuesto(datos.getTipoPuesto());
        u.setActivo(datos.isActivo());

        if (datos.getContraseña() != null && !datos.getContraseña().isEmpty()) {
            u.setContraseña(passwordEncoder.encode(datos.getContraseña()));
        }

        return usuarioRepository.save(u);
    }
}