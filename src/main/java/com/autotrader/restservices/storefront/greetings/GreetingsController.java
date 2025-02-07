package com.autotrader.restservices.storefront.greetings;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


@RestController
public class GreetingsController {

    private static final String ALREADY_SAVED_MESSAGE = " Your name was previously saved.";

    // Simulating storage
    private static List<String> names = new ArrayList<>();

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String respondWithStandardGreeting(){
        return "Hello World - REDEPLOYED x400";
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String respondWithPersonalizedGreeting(@PathVariable("name") String name, HttpServletResponse response){
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("text/html;charset=UTF-8");

        return "Hello " + name + " World!";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String createGreeting(@RequestBody String name, HttpServletResponse response){
        response.setStatus(HttpStatus.CREATED.value());
        response.setContentType("text/html;charset=UTF-8");

        String msg = "Hello " + name + " World!";
        
        if(names.contains(name)){
            msg = msg + ALREADY_SAVED_MESSAGE;
        }
        else{
            names.add(name);
        }

        return msg;
    }

    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST})
    public String notFound404(HttpServletResponse response){
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return "404: You have reached the endpoint that handles all NOT FOUND requests. Please adjust your URL and try again.";
    }
}
