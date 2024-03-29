package com.evanco.levelupservice.controller;

import com.evanco.levelupservice.exception.NotFoundException;
import com.evanco.levelupservice.model.LevelUp;
import com.evanco.levelupservice.service.LevelUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class LevelUpController {

    // *** These routes were not cached because level up
    // *** points change too frequently

    @Autowired
    LevelUpService levelUpService;

    // handles requests to add a level up
    @RequestMapping(value = "/levelups", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public LevelUp addLevelUp(@RequestBody @Valid LevelUp levelUp) {
        return levelUpService.addLevelUp(levelUp);
    }

    // handles requests to retrieve a levelUp by levelUp id
    @RequestMapping(value = "/levelups/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public LevelUp getLevelUp(@PathVariable int id) {
        LevelUp levelUp = levelUpService.getLevelUp(id);
        if (levelUp == null)
            throw new NotFoundException("LevelUp could not be retrieved for id " + id);
        return levelUp;
    }

    // handles requests to update a levelUp with a matching id
    @RequestMapping(value = "/levelups/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLevelUp(@PathVariable int id, @RequestBody @Valid LevelUp levelUp) {
        if (levelUp.getLevelUpId() == 0)
            levelUp.setLevelUpId(id);
        if (id != levelUp.getLevelUpId()) {
            throw new IllegalArgumentException("ID on path must match the ID in the LevelUp object");
        }
        levelUpService.updateLevelUp(levelUp);
    }

    // handles requests to delete a levelUp by id
    @RequestMapping(value = "/levelups/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLevelUp(@PathVariable int id) {
        levelUpService.deleteLevelUp(id);
    }

    // handles requests to retrieve all level ups
    @RequestMapping(value = "/levelups", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<LevelUp> getAllLevelUps() {
        List<LevelUp> levelUps = levelUpService.getAllLevelUps();
        return levelUps;
    }

    // handles requests to retrieve level up points by customer id
    @RequestMapping(value = "/levelups/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Integer getLevelUpPointsByCustomerId(@PathVariable int id) {
        Integer levelUpPoints = levelUpService.getLevelUpPointsByCustomerId(id);
        if (levelUpPoints == null) {
            throw new NotFoundException("Level up points could not be retrieved for this customer.");
        }
        return levelUpPoints;
    }

}

