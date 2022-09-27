package com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.web.controller;

import com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.model.Character;
import com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.web.dao.CharacterDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;


@RestController
public class CharacterController {
//    private static List<Character> listCharacter = new ArrayList<Character>();
//
//    static {
//        listCharacter.add(new Character(6, "Lux", "Magicien", 5, "Lux_0.jpg"));
//        listCharacter.add(new Character(2, "Garen", "Guerrier", 9, "Garen_0.jpg"));
//        listCharacter.add(new Character(9, "Veigar", "Magicien", 5, "Veigar_0.jpg"));
//        listCharacter.add(new Character(10, "Morgana", "Magicien", 6, "Morgana_0.jpg"));
//        listCharacter.add(new Character(42, "Sett", "Guerrier", 8, "Sett_0.jpg"));
//    }

    private CharacterDao characterDao;

    public CharacterController(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    @GetMapping("/characters")
    public List <Character> listCharacters() {
        return characterDao.findAll();
    }

    @PostMapping(value = "/characters")
    public List<Character> saveCharacter(@RequestBody Character character) {
        int id = character.getId();
        String name = character.getName();
        String type = character.getType();
        int lifepoints = character.getLifepoints();
        String image = character.getImage();
        characterDao.findAll().add(new Character(id, name, type, lifepoints,image));
    return characterDao.findAll();
    }
    @PutMapping("/characters")
    public Character editCharacter(@RequestBody Character character) {
//        Optional <Character> characterOptional = listCharacter
//                .stream()
//                .filter(x -> character.getId() == x.getId())
//                .findFirst();

        Optional <Character> characterOptional = Optional.ofNullable(characterDao
                .findById(character.getId()));

        if(!characterOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Character characterUpdated = characterOptional.get();
        characterUpdated.setName(character.getName());
        characterUpdated.setType(character.getType());
        characterUpdated.setLifepoints(character.getLifepoints());
        characterUpdated.setImage(character.getName()+"_0.jpg");
        System.out.println(character);
        return character;
    }

    @DeleteMapping("/characters/{id}")
    public List <Character> deleteCharacter(@PathVariable int id) {
//        Character character = listCharacter
//                .stream()
//                .filter(x-> id == x.getId())
//                .findFirst()
//                .orElse(null);

        Character character = characterDao
                .findById(id);
        if(character == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        characterDao.findAll().remove(character);
        return characterDao.findAll();
    }

    @GetMapping("/characters/{id}")
    public Character displayACharacter(@PathVariable int id) {
//        List<Character> characters = listCharacter
//                .stream()
//                .filter(x -> id == x.getId())
//                .toList();
        if(characterDao.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return characterDao.findById(id);
    }

}
