package edu.icet.crn.controller;

import edu.icet.crn.dto.Student;
import edu.icet.crn.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    final StudentService service;

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        service.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
    }
}
