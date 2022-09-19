package com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.web.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CharacterController {
    @GetMapping("/Characters")
    public String listCharacters() {
        return "Un exemple de personnage !";
    }
}
