package com.rashiddy.springcassandrademo.controllers;

import com.rashiddy.springcassandrademo.data.TutorialRequest;
import com.rashiddy.springcassandrademo.models.TutorialTable;
import com.rashiddy.springcassandrademo.services.TutorialCassandraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TutorialController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TutorialController.class);
    private TutorialCassandraService tutorialCassandraService;

    public TutorialController(TutorialCassandraService tutorialCassandraService) {
        this.tutorialCassandraService = tutorialCassandraService;
    }

    @PostMapping("/tutorials")
    public ResponseEntity<TutorialTable> saveTutorial(@RequestBody TutorialRequest tutorialRequest) {
        try {
            TutorialTable tutorialTable = tutorialCassandraService.saveTutorial(tutorialRequest);
            return new ResponseEntity<>(tutorialTable,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
