package com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.web.controller;

import com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.model.Character;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CharacterController {
    List <Character> listCharacter = List.of(
            new Character(5, "Lux", "Magicien", 4),
            new Character(2, "Garen", "Guerrier", 9),
            new Character(9, "Veigar", "Magicien", 5),
            new Character(9, "Morgana", "Magicien", 6),
            new Character(42, "Sett", "Guerrier", 8)
    );

    @GetMapping("/characters")
    public List <Character> listCharacters() {
        return listCharacter;
    }
    @GetMapping("/characters/{id}")
    public Character displayACharacter(@PathVariable int id) {
        List<Character> characters = listCharacter
                .stream()
                .filter(x -> id == x.getId())
                .toList();
        if(characters.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(characters.size()!=1){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return characters.get(0);
    }
}
