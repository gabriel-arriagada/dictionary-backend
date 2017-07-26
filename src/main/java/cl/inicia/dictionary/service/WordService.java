package cl.inicia.dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inicia.dictionary.domain.Language;
import cl.inicia.dictionary.domain.User;
import cl.inicia.dictionary.domain.Word;
import cl.inicia.dictionary.repository.LanguageRepository;
import cl.inicia.dictionary.repository.UserRepository;
import cl.inicia.dictionary.repository.WordRepository;

@Service
public class WordService implements IWordService{
	
	private WordRepository wordRepo;	
	private UserRepository userRepo;
	private LanguageRepository languageRepo;
	
	@Autowired
	public WordService(WordRepository wordRepo, UserRepository userRepo) {
		this.wordRepo = wordRepo;
		this.userRepo = userRepo;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Word> getAll(String username) {
		User user = userRepo.findByUsername(username);
		return wordRepo.findByUser(user);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Word> getAll(String username, Pageable pageable){
		User user = userRepo.findByUsername(username);		
		return wordRepo.findByUser(user, pageable).getContent();
	}

	@Transactional
	@Override	
	public void create(Word word){
		String shortName = word.getLanguage().getShortName();
		Language language = languageRepo.findByShortName(shortName);
		if(language == null){
			languageRepo.save(new Language(shortName, word.getLanguage().getLanguage()));
		}
		word.setUser(userRepo.findByUsername(word.getUser().getUsername()));
		word.setLanguage(language);
		wordRepo.save(word);
	}
	
	@Override
	public void delete(Word word) {		
		wordRepo.delete(word);
	}

}
