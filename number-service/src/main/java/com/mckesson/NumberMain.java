package com.mckesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mckesson.MathService.Input;

@SpringBootApplication
@EnableFeignClients
public class NumberMain {

		public static void main(String[] args) {
			SpringApplication.run(NumberMain.class, args);
		}
			
	@RestController
	class ServiceInstanceRestController {

		@Autowired
		private MathService matchService;

		@PostMapping("/run")
		public Number handleOperation(@RequestBody Input input) {
			return matchService.performOperation(input);
		}
		
	}

}
