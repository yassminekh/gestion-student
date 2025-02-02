package tn.iit.micro.service.cloud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.micro.service.cloud.dto.StudentRequest;
import tn.iit.micro.service.cloud.dto.StudentResponse;
import tn.iit.micro.service.cloud.entities.Address;
import tn.iit.micro.service.cloud.entities.Student;
import tn.iit.micro.service.cloud.repository.AddressRepository;
import tn.iit.micro.service.cloud.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private AddressRepository addressRepo;

    // Method to create a new student
    public StudentResponse createStudent(StudentRequest studentRequest) {
        // Create and save the address
        Address address = new Address(0, studentRequest.getCity(), studentRequest.getStreet());
        address = addressRepo.save(address);

        // Create and save the student
        Student studentEntity = new Student(
                studentRequest.getFirstName(),
                studentRequest.getLastName(),
                studentRequest.getEmail(),
                0, // ID will be generated by the database
                address
        );
        studentEntity = studentRepo.save(studentEntity);

        // Map the saved student entity to a StudentResponse DTO
        return new StudentResponse(studentEntity);
    }

    // Method to get all students
    public List<StudentResponse> getAllStudents() {
        // Fetch all students from the database
        List<Student> students = studentRepo.findAll();

        // Convert Student entities to StudentResponse DTOs
        return students.stream()
                .map(StudentResponse::new) // Use constructor reference
                .collect(Collectors.toList());
    }

    // Method to get a student by ID
    public StudentResponse getById(long id) {
        // Fetch the student by ID from the database
        Optional<Student> studentOptional = studentRepo.findById(id);

        // If the student exists, convert it to a StudentResponse DTO
        if (studentOptional.isPresent()) {
            return new StudentResponse(studentOptional.get());
        } else {
            // If the student does not exist, return null or throw an exception
            return null;
        }
    }
 // Method to find all students (alias for getAllStudents)
    public List<StudentResponse> findAll() {
        return getAllStudents(); // Reuse the existing method
    }
    public List<StudentResponse> findAllByCity(String city) {
        // Fetch all students from the database
        List<Student> students = studentRepo.findAll();

        // Filter students by city and map to StudentResponse DTOs
        return students.stream()
                .filter(student -> student.getAddress().getCity().equalsIgnoreCase(city))
                .map(StudentResponse::new)
                .collect(Collectors.toList());
    }
    
}