package com.sc.ins;

import com.sc.ins.dto.UserLoginDto;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoginDtoTest {

    @Test
    public void testAllArgsConstructorAndGetters() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        UserLoginDto dto = new UserLoginDto(123L, timestamp, "ACTIVE");

        assertEquals(123L, dto.getUserId());
        assertEquals(timestamp, dto.getTimestamp());
        assertEquals("ACTIVE", dto.getStatus());
    }

    @Test
    public void testNoArgsConstructorAndSetters() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        UserLoginDto dto = new UserLoginDto();
        dto.setUserId(456L);
        dto.setTimestamp(timestamp);
        dto.setStatus("INACTIVE");

        assertEquals(456L, dto.getUserId());
        assertEquals(timestamp, dto.getTimestamp());
        assertEquals("INACTIVE", dto.getStatus());
    }

    @Test
    public void testEqualsAndHashCode() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        UserLoginDto dto1 = new UserLoginDto(1L, timestamp, "SUCCESS");
        UserLoginDto dto2 = new UserLoginDto(1L, timestamp, "SUCCESS");

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}

