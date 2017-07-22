package cl.inicia.dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inicia.dictionary.domain.User;
import cl.inicia.dictionary.domain.Word;
import cl.inicia.dictionary.repository.UserRepository;
import cl.inicia.dictionary.repository.WordRepository;

@Service
public class WordService implements MasterService{
	
	private WordRepository wordRepo;	
	private UserRepository userRepo;
	
	@Autowired
	public WordService(WordRepository wordRepo, UserRepository userRepo) {
		this.wordRepo = wordRepo;
		this.userRepo = userRepo;
	}
	
	@Override
	public List<Word> getAll(String username) {
		User user = userRepo.findByUsername(username);
		return wordRepo.findByUser(user);
	}

}
