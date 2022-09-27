// A SUPPRIMER LORSQUE L'ON PASSE SUR LA MISE EN PLACE DE JPA CAR PLUS NECESSAIRE

//package com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.web.dao;
//
//import com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.model.Character;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class CharacterDaoIpml implements CharacterDao{
//    public static List<Character> characters = new ArrayList<>();
//
//    static {
//        characters.add(new Character(6, "Lux", "Magicien", 5, "Lux_0.jpg"));
//        characters.add(new Character(2, "Garen", "Guerrier", 9, "Garen_0.jpg"));
//        characters.add(new Character(9, "Veigar", "Magicien", 5, "Veigar_0.jpg"));
//        characters.add(new Character(10, "Morgana", "Magicien", 6, "Morgana_0.jpg"));
//        characters.add(new Character(42, "Sett", "Guerrier", 8, "Sett_0.jpg"));
//    }
//
//    @Override
//    public List<Character> findAll() {
//        return characters;
//    }
//
//    @Override
//    public Character findById(int id) {
//        for (Character product : characters){
//            if (product.getId() == id){
//                return product;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Character save(Character character) {
//        characters.add(character);
//        return character;
//    }
//}
