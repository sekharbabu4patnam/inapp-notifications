package com.sc.ins.controller;

import com.sc.ins.dto.UserLoginDto;
import com.sc.ins.service.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserLoginController {

    @Autowired
    private UserLoginServiceImpl usersLoginService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDto usersLoginDto) {

        Long id = usersLoginDto.getUserId();

        Optional<UserLoginDto> loginResult = usersLoginService.loginWithId(id);

        if (loginResult.isEmpty()) {
            String msg = "Your account is temporarily blocked or no successful login found.\n"
                    + "Contact your branch.\n"
                    + "User Id: " + usersLoginDto.getUserId() + "\n";

            return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
        }

        UserLoginDto user = loginResult.get();
        String msg = "Login Successful:\n"
                + "User Id: " + user.getUserId() + "\n"
                + "Last Successful Login: " + user.getTimestamp() + "\n"
                + "Login Status: " + user.getStatus();

        return new ResponseEntity<>(msg, HttpStatus.OK);

    }
}
