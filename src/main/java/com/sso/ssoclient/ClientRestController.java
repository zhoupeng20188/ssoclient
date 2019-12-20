package com.sso.ssoclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestController {

    @RequestMapping("/test123")
    public String login() {
        return "loginsddsd";
    }

    @RequestMapping("/haha")
    public String haha() {
        return "haha";
    }


}
