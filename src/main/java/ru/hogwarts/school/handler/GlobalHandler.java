package ru.hogwarts.school.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.hogwarts.school.exeptions.FacultyExeption;
import ru.hogwarts.school.exeptions.StudentExeption;


@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(StudentExeption.class)
    public ResponseEntity<String> handleStudentExeption(StudentExeption e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student id = " + e.getId() + "  not search");

    }

    @ExceptionHandler(FacultyExeption.class)
    public ResponseEntity<String> handleFacultytExeption(FacultyExeption e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty id = " + e.getId() + "  not search");

    }
}
