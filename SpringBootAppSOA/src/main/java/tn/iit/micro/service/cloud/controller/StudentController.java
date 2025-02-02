package tn.iit.micro.service.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.micro.service.cloud.dto.StudentRequest;
import tn.iit.micro.service.cloud.dto.StudentResponse;
import tn.iit.micro.service.cloud.service.StudentService;

@RestController
@RequestMapping("/student/api")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public StudentResponse createStudent(@RequestBody StudentRequest student) {
		return studentService.createStudent(student);
	}
	@GetMapping("/getAllStudents") 
	public List<StudentResponse> getAll() { 
	return studentService.getAllStudents(); 
	} 
	@GetMapping("/getById/{id}") 
	// spécifier le path de la méthode qui englobe un paramètre value= "/{id}"  
	public StudentResponse getById (@PathVariable long id) { 
	return studentService.getById(id); 
	} 
	 @GetMapping("/findAll")
	    public List<StudentResponse> findAllStudents() {
	        return studentService.findAll(); // Use the new findAll method
	    }
	 @GetMapping("/{id}")
	    public StudentResponse getStudentById(@PathVariable long id) {
	        return studentService.getById(id);
	    }
}
