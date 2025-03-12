package desafio.itau.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TestController {
	
	@GetMapping("/hello")
	public String test() { 
		return "Olá idiota"; 
	}
	
}
