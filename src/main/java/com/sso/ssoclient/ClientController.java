package com.sso.ssoclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class ClientController {

    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;

    //    @Value("${client.resourceServerUrl}")
    String resourceServerUrl;

    @GetMapping("/hehe")
    public String hehe() {
        System.out.println("hehe in...");
        resourceServerUrl = "http://localhost:8082/ui/securedPage";
        oAuth2RestTemplate.getAccessToken();
//        ResponseEntity<String> responseEntity = oAuth2RestTemplate.getForEntity(resourceServerUrl, String.class);
        return "/index";
    }

    @GetMapping("/securedPage")
    public ModelAndView securedPage(OAuth2Authentication authentication) {
        Object principal = authentication.getUserAuthentication().getPrincipal();
        Object principal1 = authentication.getPrincipal();
        String name = authentication.getName();
        Collection<GrantedAuthority> authorities = authentication.getAuthorities();
        System.out.println("securedPage in ...");
        return new ModelAndView("securedPage").addObject("authentication", authentication);
//        return new ModelAndView("securedPage").addObject("name", name);
    }

}
