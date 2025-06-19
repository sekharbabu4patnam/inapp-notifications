package com.sc.ins.service;

import com.sc.ins.dto.UserLoginDto;
import com.sc.ins.entity.UserLogin;

import java.util.Optional;

public interface UsersLoginService
{
    Optional<UserLoginDto> loginWithId(Long id);

}
