package com.dicka.oauth2.oauth2resourceserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/rest/hello")
public class HelloResource {

    @RequestMapping(method = RequestMethod.GET)
    public Principal getSayHello(Principal principal){
        return principal;
    }



}
