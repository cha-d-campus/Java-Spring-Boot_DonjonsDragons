package com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.web.controller;

import com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.model.Character;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;


@RestController
public class CharacterController {
    private static List<Character> listCharacter = new ArrayList<Character>();

    static {
        listCharacter.add(new Character(6, "Lux", "Magicien", 5, "Lux_0.jpg"));
        listCharacter.add(new Character(2, "Garen", "Guerrier", 9, "Garen_0.jpg"));
        listCharacter.add(new Character(9, "Veigar", "Magicien", 5, "Veigar_0.jpg"));
        listCharacter.add(new Character(10, "Morgana", "Magicien", 6, "Morgana_0.jpg"));
        listCharacter.add(new Character(42, "Sett", "Guerrier", 8, "Sett_0.jpg"));
    }

    @GetMapping("/characters")
    public List <Character> listCharacters() {
        return listCharacter;
    }

    @PostMapping("/characters")
    public List<Character> saveCharacter(@RequestBody Character character) {
        int id = character.getId();
        String name = character.getName();
        String type = character.getType();
        int lifepoints = character.getLifepoints();
        String image = character.getImage();
        listCharacter.add(new Character(id, name, type, lifepoints,image));
    return listCharacter;
    }
    @PutMapping("/characters")
    public Character editCharacter(@RequestBody Character character) {
        Optional <Character> characterOptional = listCharacter
                .stream()
                .filter(x -> character.getId() == x.getId())
                .findFirst();

        if(!characterOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Character characterUpdated = characterOptional.get();
        characterUpdated.setName(character.getName());
        characterUpdated.setType(character.getType());
        characterUpdated.setLifepoints(character.getLifepoints());
        characterUpdated.setImage(character.getImage());
        return character;
    }

    @DeleteMapping("/characters/{id}")
    public Character deleteCharacter(@PathVariable int id) {
        return
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
