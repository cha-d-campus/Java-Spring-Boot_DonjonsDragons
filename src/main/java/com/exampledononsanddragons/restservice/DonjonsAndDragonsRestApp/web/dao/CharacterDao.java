package com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.web.dao;

import com.exampledononsanddragons.restservice.DonjonsAndDragonsRestApp.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterDao extends JpaRepository<Character, Integer> {
//    List<Character> findAll();
    Character findById(int id);
//    Character save(Character character);
}
