package cl.inicia.dictionary.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import cl.inicia.dictionary.domain.Word;

public interface IWordService {
	public abstract List<Word> getAll(String username);
	public abstract List<Word> getAll(String username, Pageable pageable);
	public abstract void create(Word word);
	public abstract void delete(Word word);
}
