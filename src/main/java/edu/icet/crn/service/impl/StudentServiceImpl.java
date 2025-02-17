package edu.icet.crn.service.impl;

import edu.icet.crn.dto.Student;
import edu.icet.crn.entity.StudentEntity;
import edu.icet.crn.repository.StudentRepository;
import edu.icet.crn.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
