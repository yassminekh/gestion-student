package tn.iit.micro.service.cloud.proxies;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value = "SpringBootAppSOAAddress", configuration = CustomLoadBalancerConfiguration.class)
public class AdrSerLoadBalConfig {
	@LoadBalanced
	@Bean
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}
}
