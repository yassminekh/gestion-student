package tn.iit.micro.service.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.micro.service.cloud.entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
