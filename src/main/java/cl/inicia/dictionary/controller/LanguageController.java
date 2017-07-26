package cl.inicia.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.inicia.dictionary.domain.Language;
import cl.inicia.dictionary.service.ILanguageService;

@RestController
@RequestMapping("/language")
public class LanguageController {
		
	@Autowired
	private ILanguageService service;
	
	@RequestMapping(path = "/saveAll", method = RequestMethod.POST)
	public void saveAll(@RequestBody List<Language> languages){
		service.saveAll(languages);
	}
	
}
