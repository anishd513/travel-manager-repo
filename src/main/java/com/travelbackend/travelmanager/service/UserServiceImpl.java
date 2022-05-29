package com.travelbackend.travelmanager.service;

import com.travelbackend.travelmanager.dto.UserResponseDto;
import com.travelbackend.travelmanager.entity.Users;
import com.travelbackend.travelmanager.exception.ResourceNotFoundException;
import com.travelbackend.travelmanager.reposervice.UserRepoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepoService userRepoService;

    public UserServiceImpl(UserRepoService userRepoService) {
        this.userRepoService = userRepoService;
    }

    @Override
    public UserResponseDto getUser(String mailId, String password) {
        Optional<Users> userInfo = userRepoService.findByMailIdAndPassword(mailId, password);

        if (userInfo.isPresent()) {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setUserId(userInfo.get().getUserId());
            return userResponseDto;
        } else {
            throw new ResourceNotFoundException(
                    "Failed to mailId "
                            + mailId);
        }
    }
}
