package edu.icet.crn.service;

import edu.icet.crn.dto.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    List<Student> getStudents();

    void deleteStudent(Integer id);

    void updateStudent(Student student);
}
