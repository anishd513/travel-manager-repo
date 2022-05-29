package com.travelbackend.travelmanager.service;

import com.travelbackend.travelmanager.dto.UserResponseDto;

public interface UserService {
    public UserResponseDto getUser(String email, String password);
}
