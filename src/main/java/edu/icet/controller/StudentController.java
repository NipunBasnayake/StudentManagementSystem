package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin
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

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        service.updateStudent(student);
    }

    @GetMapping("/searchById/{id}")
    public Student searchById(@PathVariable Integer id) {
        return service.searchById(id);
    }

    @GetMapping("searchByName/{name}")
    public List<Student> searchByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("searchByAddress/{address}")
    public List<Student> searchByAddress(@PathVariable String address) {
        return service.findByAddress(address);
    }

    @GetMapping("searchByAge/{age}")
    public List<Student> searchByAge(@PathVariable Integer age) {
        return service.findByAge(age);
    }
}
