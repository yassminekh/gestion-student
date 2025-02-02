package tn.iit.micro.service.cloud.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import tn.iit.micro.service.cloud.dto.AddressRequest;
import tn.iit.micro.service.cloud.dto.AddressResponse;
import tn.iit.micro.service.cloud.dto.StudentRequest;
import tn.iit.micro.service.cloud.dto.StudentResponse;

import tn.iit.micro.service.cloud.entities.Student;
import tn.iit.micro.service.cloud.proxies.AddressProxy;
import tn.iit.micro.service.cloud.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
//	@Autowired
//	private WebClient webClient;
	
	@Autowired
	AddressProxy addressProxy;
	

	public StudentResponse createStudent(StudentRequest student) {
		AddressRequest address = new AddressRequest(student.getCity(), student.getStreet());
		AddressResponse addressResponse = addressProxy.createAddress(address); //createAddressUsingWebClient(address);

		Student studentEntity = new Student(student.getFirstName(), student.getLastName(), student.getEmail(), 0,
				addressResponse.getId());
		studentEntity = studentRepo.save(studentEntity);
		return new StudentResponse(studentEntity, addressResponse);

	}

	public StudentResponse getById(long studentId) {
		Student student = studentRepo.findById(studentId).get();
		AddressResponse addressResponse = addressProxy.getById(student.getAddressId()); //getAddressUsingWebClient(student.getAddressId());
		return new StudentResponse(student, addressResponse);
	}
	 // Récupérer tous les étudiants
	  public List<Student> getAllStudents() {
	        return studentRepo.findAll();  // Utilisation correcte de addressRepo
	    }
//	private AddressResponse createAddressUsingWebClient(AddressRequest addressRequest) {
//		return webClient.post().uri("/create").contentType(MediaType.APPLICATION_JSON).bodyValue(addressRequest).retrieve()
//				.bodyToMono(AddressResponse.class).block();
//	}
//	private AddressResponse getAddressUsingWebClient(long addressId) {
//
//		Mono<AddressResponse> addressResponse = webClient.get().uri("/getById/" + addressId).retrieve()
//				.bodyToMono(AddressResponse.class);
//
//		return addressResponse.block();
//
//	}
}
