package cl.inicia.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.inicia.dictionary.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
