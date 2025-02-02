package tn.iit.micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import tn.iit.micro.service.cloud.exception.CustomErrorDecoder;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootAppSoaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootAppSoaApplication.class, args);
	}

	@Bean
	public CustomErrorDecoder mCustomErrorDecoder() {
		return new CustomErrorDecoder();
	}

}
