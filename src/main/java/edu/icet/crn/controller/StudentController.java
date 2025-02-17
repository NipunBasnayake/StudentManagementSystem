package edu.icet.crn.controller;

import edu.icet.crn.dto.Student;
import edu.icet.crn.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    final StudentService service;

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        System.out.println(student);
        service.addStudent(student);
    }

}
