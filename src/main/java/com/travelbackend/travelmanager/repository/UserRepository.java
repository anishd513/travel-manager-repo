package com.travelbackend.travelmanager.repository;

import com.travelbackend.travelmanager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,String> {
    @Query(value = "select * from users where mail_id=:mailId AND password=:password",nativeQuery = true)
    Optional<Users> getUser(String mailId,String password);

}
