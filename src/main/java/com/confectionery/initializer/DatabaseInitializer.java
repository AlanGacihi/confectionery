package com.confectionery.initializer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.confectionery.model.ERole;
import com.confectionery.model.Role;
import com.confectionery.repository.RoleRepository;

@Component
@Configuration
public class DatabaseInitializer {

    private final RoleRepository roleRepository;

    public DatabaseInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Bean
    CommandLineRunner initRoles() {
        return args -> {
            if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
                roleRepository.save(new Role(ERole.ROLE_ADMIN));
            }
            if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
                roleRepository.save(new Role(ERole.ROLE_USER));
            }
            if (roleRepository.findByName(ERole.ROLE_VISITOR).isEmpty()) {
                roleRepository.save(new Role(ERole.ROLE_VISITOR));
            }
        };
    }
}
