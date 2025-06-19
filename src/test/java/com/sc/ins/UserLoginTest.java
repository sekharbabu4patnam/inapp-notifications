package com.sc.ins;

import com.sc.ins.entity.UserLogin;
import com.sc.ins.repository.UserLoginRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserLoginTest {

    @Autowired
    private UserLoginRepository repository;

    @Test
    public void testSaveAndFindUserLogin() {
        UserLogin login = new UserLogin();
        login.setUserId(101L);
        login.setType("login");
        login.setTimestamp(LocalDateTime.now());
        login.setStatus("SUCCESS");

        // Save entity
        UserLogin saved = repository.save(login);

        // Fetch entity
        Optional<UserLogin> found = repository.findById(saved.getNotification_id());

        // Assertions
        assertThat(found).isPresent();
        assertThat(found.get().getUserId()).isEqualTo(101L);
        assertThat(found.get().getType()).isEqualTo("login");
        assertThat(found.get().getStatus()).isEqualTo("SUCCESS");
    }
}
