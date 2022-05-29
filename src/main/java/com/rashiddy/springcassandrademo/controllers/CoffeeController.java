package com.rashiddy.springcassandrademo.controllers;

import com.rashiddy.springcassandrademo.data.CoffeeRequest;
import com.rashiddy.springcassandrademo.models.CoffeeTypes;
import com.rashiddy.springcassandrademo.services.CoffeeService;
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
public class CoffeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeController.class);
    private CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @PostMapping("/tutorials")
    public ResponseEntity<CoffeeTypes> saveTutorial(@RequestBody CoffeeRequest coffeeRequest) {
        try {
            CoffeeTypes coffeeTypes = coffeeService.saveTutorial(coffeeRequest);
            return new ResponseEntity<>(coffeeTypes,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
