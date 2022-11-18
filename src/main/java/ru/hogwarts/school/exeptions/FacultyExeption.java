package ru.hogwarts.school.exeptions;

public class FacultyExeption extends RuntimeException {
    private final long id;

    public FacultyExeption(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
