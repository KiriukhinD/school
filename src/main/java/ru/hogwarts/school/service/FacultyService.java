package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exeptions.FacultyExeption;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> facultiesMap = new HashMap<>();
    private Long idGenerator = 1L;


    public Faculty create(Faculty faculty) {
        faculty.setId(idGenerator++);
        facultiesMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty read(long id) {
        if (!facultiesMap.containsKey(id)) {
            throw new FacultyExeption(id);
        }
        return facultiesMap.get(id);
    }

    public Faculty update(long id, Faculty faculty) {
        if (!facultiesMap.containsKey(id)) {
            throw new FacultyExeption(id);
        }
        Faculty oldFaculty = facultiesMap.get(id);
        oldFaculty.setName(faculty.getName());
        oldFaculty.setColor(faculty.getColor());
        facultiesMap.replace(id, oldFaculty);
        return oldFaculty;
    }

    public Faculty delete(long id) {
        return facultiesMap.remove(id);
    }

    public Collection<Faculty> findByColor(String color) {
        return facultiesMap.values()
                .stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }


}
