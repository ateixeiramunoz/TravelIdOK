package com.eoi.grupo5.controladores;

import com.eoi.grupo5.modelos.Usuario;
import com.eoi.grupo5.repos.RepoUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    RepoUsuario repoUsuario;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginController(RepoUsuario repoUsuario, BCryptPasswordEncoder bCryptPasswordEncoder){

    }

    @GetMapping("/login")
    String Login(){
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String nombreUsuario, @RequestParam String password, Model model){
        Optional<Usuario> optionalUsuario = repoUsuario.findByNombreUsuario(nombreUsuario);
        if (optionalUsuario.isPresent() && optionalUsuario.get().getPassword().equals(bCryptPasswordEncoder.encode(password))){
            Usuario usuario = optionalUsuario.get();
            model.addAttribute("usuario", usuario);
            model.addAttribute("msg", "Usuario encontrado");
            return "login";
        } else {
            model.addAttribute("msg", "Usuario no encontrado");
        }
        return "redirect:/login?error=true";
    }

    @GetMapping("/registro")
    public String registroUsuario(Model modelo) {
        return "register";
    }

}
