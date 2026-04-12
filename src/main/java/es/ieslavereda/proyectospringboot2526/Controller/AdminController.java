package es.ieslavereda.proyectospringboot2526.Controller;

import es.ieslavereda.proyectospringboot2526.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/admin")
    public String verAdmin(Model model) {
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "admin"; // Thymeleaf
    }
}