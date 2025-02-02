package tn.iit.micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import tn.iit.micro.service.cloud.proxies.CustomErrorDecoder;


@EnableFeignClients("tn.iit.micro.service.cloud.proxies")
@SpringBootApplication

public class SpringBootAppSoaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootAppSoaApplication.class, args);
	}
	@Value("${address.service.url}")
	private String addressServiceUrl;

	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder().baseUrl(addressServiceUrl).build();
		return webClient;
	}

	@Bean
	CustomErrorDecoder myCustomErrorDecoder() {
		return new CustomErrorDecoder();
	}
}
