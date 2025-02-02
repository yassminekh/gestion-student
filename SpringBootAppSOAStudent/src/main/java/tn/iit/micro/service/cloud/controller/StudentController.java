package tn.iit.micro.service.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.micro.service.cloud.dto.StudentRequest;
import tn.iit.micro.service.cloud.dto.StudentResponse;

import tn.iit.micro.service.cloud.entities.Student;
import tn.iit.micro.service.cloud.service.StudentService;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Créer un étudiant
    @PostMapping("/create")
    public StudentResponse createStudent(@RequestBody StudentRequest student) {
        return studentService.createStudent(student);
    }

    // Récupérer un étudiant par son ID
    @GetMapping("/getById/{id}")
    public StudentResponse getStudentById(@PathVariable("id") long studentId) {
        System.out.println("*******************" + studentId);
        return studentService.getById(studentId);
    }

    // Récupérer tous les étudiants
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        
        // Vérifier si la liste est vide
        if (students.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retourne un statut 204 si aucun étudiant n'est trouvé
        }
        
        return ResponseEntity.ok(students); // Retourne un statut 200 avec la liste des étudiants
    }


    // Route de base pour vérifier si l'API est en fonctionnement
    @GetMapping("/")
    public String getBaseApi() {
        return "Student API is running";
    }
}
