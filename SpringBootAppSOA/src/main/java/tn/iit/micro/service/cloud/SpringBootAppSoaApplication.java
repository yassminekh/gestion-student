package tn.iit.micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import tn.iit.micro.service.cloud.entities.Address;
import tn.iit.micro.service.cloud.entities.Student;
import tn.iit.micro.service.cloud.repository.AddressRepository;
import tn.iit.micro.service.cloud.repository.StudentRepository;

@SpringBootApplication
public class SpringBootAppSoaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringBootAppSoaApplication.class, args);
		StudentRepository studentRepo = context.getBean(StudentRepository.class);
		AddressRepository addressRepo = context.getBean(AddressRepository.class);

		Address address1 = new Address(0, "sfax", "gremda");
		address1 = addressRepo.save(address1);
		Student student1 = new Student("yassmine","kharrat","yass@gmail.com",2,address1);
		student1 = studentRepo.save(student1);
		System.out.println(student1);
		

	}

}
