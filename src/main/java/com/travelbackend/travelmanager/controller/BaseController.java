package com.travelbackend.travelmanager.controller;

import com.travelbackend.travelmanager.Configuration.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ObjectInputFilter;


@RestController
public class BaseController {
    Logger logger = LogManager.getLogger(BaseController.class);
    private final Config config;
    public BaseController(Config config){
        this.config = config;
    }
    @RequestMapping(method = RequestMethod.GET,path="/")
    public String getRoot(){
        logger.info("Get Root cycle");
         return "{\n"
                + "   name : travel Manager service, \n"
                + "   env : "
                +config.getActiveProfile()
                + "\n"
                + "}";
    }
}
