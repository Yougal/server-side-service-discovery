package com.mckesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MathServiceMain {

		public static void main(String[] args) {
			SpringApplication.run(MathServiceMain.class, args);
		}

	@RestController
	class ServiceInstanceRestController {

		@PostMapping("/operation")
		public Number handleOperation(@RequestBody Input input) {
			switch(input.operation) {
				case "-" : return input.number1-input.number2;
				case "+" : return input.number1+input.number2;
				case "*" : return input.number1*input.number2;
				case "/" : return input.number1/input.number2;
			}
			throw new RuntimeException("Invalid Operator");
		}
		
	}

	public static class Input{
		
		public int getNumber1() {
			return number1;
		}
		public void setNumber1(int number1) {
			this.number1 = number1;
		}
		public int getNumber2() {
			return number2;
		}
		public void setNumber2(int number2) {
			this.number2 = number2;
		}
		public String getOperation() {
			return operation;
		}
		public void setOperation(String operation) {
			this.operation = operation;
		}
		int number1;
		int number2;
		String operation;
		
	}
}
