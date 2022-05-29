package com.travelbackend.travelmanager.controller;

import com.travelbackend.travelmanager.dto.ServiceResponse;
import com.travelbackend.travelmanager.dto.UserResponseDto;
import com.travelbackend.travelmanager.model.Error;
import com.travelbackend.travelmanager.reposervice.EventRepoService;
import com.travelbackend.travelmanager.repository.EventRepository;
import com.travelbackend.travelmanager.repository.UserRepository;
import com.travelbackend.travelmanager.service.UserService;
import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    Logger logger = LogManager.getLogger(UserController.class);
    private UserService userService;
    private UserRepository userRepository;
    private EventRepoService eventRepoService;

    public UserController(@NonNull UserService userService, @NonNull UserRepository userRepository,@NonNull EventRepoService eventRepoService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.eventRepoService =eventRepoService;
    }

    @GetMapping("/")
    public String showPage(Model model,@RequestParam(defaultValue="0")int page,String eventId) {
        model.addAttribute("data",eventRepoService.findByEvent(eventId));
        return "login";
    }

    @GetMapping("/login")
    public String getUserLogin(Model model,@RequestParam(defaultValue="0")int page) {
//        model.addAttribute("data",getUser( mailId, password) );
        return "login";
    }

    @GetMapping(value = "/travel/login/mail/{mailId}/password/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<UserResponseDto>> getUser(
            @PathVariable(name = "mailId") String mailId,
            @PathVariable(name = "password") String password
    ) {
        logger.info("GET user");
        ServiceResponse<UserResponseDto> response = new ServiceResponse<>();
        try {
            UserResponseDto userResponseDto = userService.getUser(mailId, password);
            response.setSuccess(true);
            response.setError(null);
            response.setData(userResponseDto);
            response.setMessage("User found in data base");


        } catch (Exception ex) {
            response.setSuccess(false).setError(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage())).setMessage("mailId " + mailId + " not found ");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
