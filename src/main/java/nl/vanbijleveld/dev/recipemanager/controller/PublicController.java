package nl.vanbijleveld.dev.recipemanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }

}
