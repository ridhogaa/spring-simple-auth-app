package org.ergea.authapp.seeder;

import javax.transaction.Transactional;
import org.ergea.authapp.entity.User;
import org.ergea.authapp.enums.Role;
import org.ergea.authapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DatabaseSeeder implements ApplicationRunner {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments applicationArguments) {
        this.insertUser();
    }

    @Transactional
    public void insertUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("user");
        user.setPassword(encoder.encode("password"));
        user.setName("user");
        user.setRole(Role.MEMBER);
        userRepository.save(user);
    }
}
