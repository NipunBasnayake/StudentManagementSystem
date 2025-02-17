package edu.icet.crn.service.impl;

import edu.icet.crn.dto.Student;
import edu.icet.crn.entity.StudentEntity;
import edu.icet.crn.repository.StudentRepository;
import edu.icet.crn.service.StudentService;
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
        studentEntities.forEach(studentEntity -> {
            studentArrayList.add(modelMapper.map(studentEntity, Student.class));
        });
        return studentArrayList;
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }


}
