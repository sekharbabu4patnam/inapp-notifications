package com.sc.ins.service;

import com.sc.ins.dto.UserLoginDto;
import com.sc.ins.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginServiceImpl implements UsersLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public Optional<UserLoginDto> loginWithId(Long id) {
        List<UserLoginDto> lastLogins = userLoginRepository.getLastTimeAndStatus(id);

        boolean last3Failed = lastLogins.stream()
                .limit(3)
                .allMatch(login -> "failed".equalsIgnoreCase(login.getStatus()));

        if (last3Failed && lastLogins.size() >= 3) {
            return Optional.empty();
        }

        return lastLogins.stream()
                .filter(login -> "success".equalsIgnoreCase(login.getStatus()))
                .findFirst();
    }

    // testing methods
    public Optional<UserLoginDto> checkLoginManually(List<UserLoginDto> lastLogins) {
        boolean hasSuccess = lastLogins.stream()
                .anyMatch(login -> "success".equalsIgnoreCase(login.getStatus()));
        if (hasSuccess) {
            return Optional.of(lastLogins.get(0)); // most recent login
        }
        return Optional.empty();
    }

    public boolean isBlockedManually(List<UserLoginDto> lastLogins) {
        return lastLogins.stream()
                .limit(3)
                .allMatch(login -> "failed".equalsIgnoreCase(login.getStatus()));
    }
}
