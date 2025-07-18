package com.example.jdbc.demo.repository;

import com.example.jdbc.demo.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository {
    List<Teacher> getAll();
    Teacher add(Teacher teacher);
    Optional<Teacher> getById(int teacherID);
    Teacher update(Teacher teacher);
    boolean delete(int teacherID);
}
