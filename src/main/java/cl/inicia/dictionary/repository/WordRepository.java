package cl.inicia.dictionary.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.inicia.dictionary.domain.User;
import cl.inicia.dictionary.domain.Word;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
public interface WordRepository extends JpaRepository<Word, Integer>{
	/*
	 * Mirar la documentación para entender la creación de estas consultas:
	 * :D
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	 * */
	List<Word> findByUser(User user);
	
	List<Word> findByUser(User user, Pageable pageable);
}
