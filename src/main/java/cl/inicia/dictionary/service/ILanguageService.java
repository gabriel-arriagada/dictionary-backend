package cl.inicia.dictionary.service;

import java.util.List;

import cl.inicia.dictionary.domain.Language;

public interface ILanguageService {
	public void saveAll(List<Language> languages);
}
