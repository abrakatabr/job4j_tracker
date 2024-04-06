package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Student resultStudent = students.keySet()
                .stream()
                .filter(student -> student.account().equals(account))
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(resultStudent);
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> resultStudent = findByAccount(account);
        Subject resultSubject = null;
        if (resultStudent.isPresent()) {
            resultSubject = students.get(resultStudent.get())
                    .stream()
                    .filter(subject -> subject.name().equals(name))
                    .findFirst()
                    .orElse(null);
        }
        return Optional.ofNullable(resultSubject);
    }

}
