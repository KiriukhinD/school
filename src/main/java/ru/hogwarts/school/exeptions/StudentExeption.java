package ru.hogwarts.school.exeptions;

public class StudentExeption extends RuntimeException {

    private final long id;

    public StudentExeption(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}
