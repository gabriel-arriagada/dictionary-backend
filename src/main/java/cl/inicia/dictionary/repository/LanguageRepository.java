package cl.inicia.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.inicia.dictionary.domain.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>{
	public abstract Language findByShortName(String shortName);
}
