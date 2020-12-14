package com.max.ekz.repos;

import com.max.ekz.Models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
