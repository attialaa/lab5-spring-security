
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Player;
import com.example.demo.repo.PlayerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class AuthController {

    private final PlayerRepository repo;
    private final PasswordEncoder encoder;

    public AuthController(PlayerRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("player", new Player());
        return "register";
    }

    @PostMapping("/register")
    public String register(Player player) {
        player.setPassword(encoder.encode(player.getPassword()));
        player.setRole("PLAYER");
        repo.save(player);
        return "redirect:/login";
    }
}
