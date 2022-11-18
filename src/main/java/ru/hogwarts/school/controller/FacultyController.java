package ru.hogwarts.school.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;


@RestController
@RequestMapping("/faculty")
public class FacultyController {
    public final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @PostMapping
    public ResponseEntity<Faculty> create(@RequestBody Faculty faculty) {
        Faculty created = facultyService.create(faculty);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("{id}")
    public Faculty read(@PathVariable long id) {
        return facultyService.read(id);

    }

    @PutMapping("/{id}")
    public Faculty update(@RequestBody long id, Faculty faculty) {
        return facultyService.update(id, faculty);

    }

    @DeleteMapping("{id}")
    public Faculty delete(@PathVariable long id) {
        return facultyService.delete(id);

    }


    @GetMapping
    public Collection<Faculty> findByColor(@RequestParam String color) {
        return facultyService.findByColor(color);
    }


}
