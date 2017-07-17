package cl.inicia.dictionary.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	
	@RequestMapping("/")
	public String hello(){
		return "hello";
	}
	
}
