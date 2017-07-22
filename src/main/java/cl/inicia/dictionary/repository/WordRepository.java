package cl.inicia.dictionary.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cl.inicia.dictionary.domain.User;
import cl.inicia.dictionary.domain.Word;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
public interface WordRepository extends JpaRepository<Word, Integer> {
	/*
	 * Mirar la documentación para entender la creación de estas consultas: :D
	 */
	// @formatter:off
	/* 
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	 */
	// @formatter:on

	List<Word> findByUser(User user);

	Page<Word> findByUser(User user, Pageable pageable);
}
