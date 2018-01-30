package cl.inicia.dictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.inicia.dictionary.dto.TranslateDto;
import cl.inicia.dictionary.service.translater.ITranslateService;

@RestController
@RequestMapping("/translate")
public class TranslateController {
	
	@Autowired
	private ITranslateService translateService;
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<TranslateDto> translate(@RequestBody String word){
		return new ResponseEntity<TranslateDto>(translateService.translate(word), HttpStatus.OK);
	}
	
}
