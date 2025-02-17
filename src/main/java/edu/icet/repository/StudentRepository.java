package edu.icet.repository;

import edu.icet.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    List<StudentEntity> findByAddress(String address);

    List<StudentEntity>  findByAge(Integer age);

    List<StudentEntity> findByName(String name);
}
