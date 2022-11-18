package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exeptions.StudentExeption;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;


@Service
public class StudentService {
    private final HashMap<Long, Student> studentsMap = new HashMap<>();
    private Long idGenerator = 1L;

    public Student create(Student student) {
        student.setId(idGenerator++);
        studentsMap.put(student.getId(), student);
        return student;
    }

    public Student read(long id) {
        if (!studentsMap.containsKey(id)) {
            throw new StudentExeption(id);
        }
        return studentsMap.get(id);
    }

    public Student update(long id, Student student) {
        if (!studentsMap.containsKey(id)) {
            throw new StudentExeption(id);
        }
        Student oldStudent = studentsMap.get(id);
        oldStudent.setAge(student.getAge());
        oldStudent.setName(student.getName());
        studentsMap.replace(id, oldStudent);
        return oldStudent;
    }

    public Student delete(long id) {
        return studentsMap.remove(id);
    }


    public Collection<Student> findByAge(int age) {
        return studentsMap.values()
                .stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }


}
