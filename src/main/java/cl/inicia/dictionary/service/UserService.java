package cl.inicia.dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inicia.dictionary.domain.Word;
import cl.inicia.dictionary.domain.User;
import cl.inicia.dictionary.repository.UserRepository;

@Service
public class UserService implements MasterService{
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public List<Word> getAll(String username) {
		User user = repo.findByUsername(username);
		return user.getWords();
	}

}
