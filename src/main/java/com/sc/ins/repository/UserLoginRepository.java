package com.sc.ins.repository;

import com.sc.ins.dto.UserLoginDto;
import com.sc.ins.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserLoginRepository extends JpaRepository<UserLogin, Long>
{
    @Query(value = "SELECT user_id, timestamp, status FROM users_logins WHERE user_id = :id ORDER BY timestamp DESC LIMIT 4", nativeQuery = true)
    List<UserLoginDto> getLastTimeAndStatus(@Param("id") Long id);
}
