package com.travelbackend.travelmanager.reposervice;

import com.travelbackend.travelmanager.entity.Users;
import com.travelbackend.travelmanager.repository.UserRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepoService{
    private final UserRepository userRepository;

    public UserRepoService(@NonNull final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<Users> findByMailIdAndPassword(String mailId,String password){
        return userRepository.getUser(mailId, password);
    }
}
