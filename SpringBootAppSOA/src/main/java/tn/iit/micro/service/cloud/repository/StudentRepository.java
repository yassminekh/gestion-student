package tn.iit.micro.service.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.micro.service.cloud.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
