package com.workintech.fswebs17d1.controller;
import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    Map<Integer, Animal> animals;
    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerFullname;

    @PostConstruct
    public void loadAll() {
        this.animals = new HashMap<>();
        this.animals.put(1, new Animal(1, "maymun"));
    }
    @GetMapping
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }
    @GetMapping("{id}")
    public Animal getAnimal(@PathVariable Integer id) {
        return animals.get(id);
    }
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        this.animals.put(animal.getId(), animal);
        return animal;
    }
    @PutMapping("{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        animal.setId(id);
        this.animals.put(id, animal);
        return animal;
    }
    @DeleteMapping("{id}")
    public void deleteAnimal(@PathVariable Integer id) {
        this.animals.remove(id);
    }
}
