package cl.inicia.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.inicia.dictionary.domain.Word;
import cl.inicia.dictionary.service.IWordService;

@RestController
@RequestMapping("/words")
public class WordController {

	@Autowired
	private IWordService service;

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Word>> list(OAuth2Authentication auth) {
		String username = auth.getName();
		// @formatter:off
		return new ResponseEntity<List<Word>>(
				service.getAll(username, new PageRequest(0, 5)), HttpStatus.OK);
		// @formatter:on		
	}
	
	@RequestMapping(path = "/create")
	public ResponseEntity<Void> create(@RequestBody Word word, OAuth2Authentication auth){
		word.getUser().setUsername(auth.getName());
		service.create(word);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
