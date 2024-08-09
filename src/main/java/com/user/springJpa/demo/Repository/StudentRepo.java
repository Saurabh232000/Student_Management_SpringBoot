package com.user.springJpa.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.springJpa.demo.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
