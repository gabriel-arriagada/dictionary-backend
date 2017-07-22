package cl.inicia.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.inicia.dictionary.domain.Word;
import cl.inicia.dictionary.service.MasterService;

@RestController
@RequestMapping("/words")
public class WordController {
	
	@Autowired
	@Qualifier("wordService")
	private MasterService service;
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Word>> list(OAuth2Authentication auth){
		String username = auth.getName();
		return new ResponseEntity<List<Word>>(service.getAll(username), HttpStatus.OK);
	}
	
}
