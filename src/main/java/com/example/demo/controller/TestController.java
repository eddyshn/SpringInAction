package com.example.demo.controller;

import com.example.demo.Ingredient;
import com.example.demo.Test;
import com.example.demo.data.IngredientRepository;
import com.example.demo.data.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path="/test",
        produces="application/json")
@CrossOrigin(origins="*")
public class TestController {

    private TestRepository tacoRepo;

    public TestController(TestRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping("/recent")
    public Iterable<Test> recentTacos() {
        Iterable<Test> xx = tacoRepo.findAll();
        for (Test ii : xx) {
            System.out.println(ii.getName());
        }
        return tacoRepo.findAll();
    }

}
