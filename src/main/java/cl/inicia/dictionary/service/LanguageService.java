package cl.inicia.dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inicia.dictionary.domain.Language;
import cl.inicia.dictionary.repository.LanguageRepository;

@Service
public class LanguageService implements ILanguageService {

	@Autowired
	private LanguageRepository repo;

	@Override
	public void saveAll(List<Language> languages) {
		for(Language l: languages){
			repo.save(l);
		}		
	}

}
