package edu.icet.service.impl;

import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    final StudentRepository repository;
    final ModelMapper modelMapper;

    @Override
    public void addStudent(Student student) {
        StudentEntity studentEntity = modelMapper.map(student, StudentEntity.class);
        repository.save(studentEntity);
    }

    @Override
    public List<Student> getStudents() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        List<StudentEntity> studentEntities = repository.findAll();
        studentEntities.forEach(studentEntity -> studentArrayList.add(modelMapper.map(studentEntity, Student.class)));
        return studentArrayList;
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        repository.save(modelMapper.map(student, StudentEntity.class));
    }

    @Override
    public Student searchById(Integer id) {
        return modelMapper.map(repository.findById(id), Student.class);
    }

    @Override
    public List<Student> findByAddress(String address) {
        List<StudentEntity> studentEntityList = repository.findByAddress(address);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentEntityList.forEach(studentEntity -> studentArrayList.add(modelMapper.map(studentEntity, Student.class)));
        return studentArrayList;
    }

    @Override
    public List<Student> findByAge(Integer age) {
        List<StudentEntity> studentEntities = repository.findByAge(age);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentEntities.forEach(studentEntity -> studentArrayList.add(modelMapper.map(studentEntity, Student.class)));
        return studentArrayList;
    }

    @Override
    public List<Student> findByName(String name) {
        List<StudentEntity> studentEntities = repository.findByName(name);
        List<Student> studentArrayList = new ArrayList<>();
        studentEntities.forEach(studentEntity -> studentArrayList.add(modelMapper.map(studentEntity, Student.class)));
        return studentArrayList;
    }

}
