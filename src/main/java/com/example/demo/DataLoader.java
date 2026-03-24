
package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repo.PlayerRepository;
import com.example.demo.model.Player;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PlayerRepository repo;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(org.springframework.boot.ApplicationArguments args) {
        if (repo.findByUsername("admin") == null) {
            Player admin = new Player();
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("admin123"));
            admin.setRole("ADMIN");
            repo.save(admin);
        }
    }
}
