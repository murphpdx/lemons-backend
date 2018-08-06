package com.lemonaide.backend.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecallController {
    @GetMapping("/all")
    public String getAll() {
        return "All car info";
    }
}
