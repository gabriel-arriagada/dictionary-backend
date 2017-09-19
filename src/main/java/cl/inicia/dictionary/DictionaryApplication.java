package cl.inicia.dictionary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import cl.inicia.dictionary.configuration.CustomUserDetails;
import cl.inicia.dictionary.domain.Language;
import cl.inicia.dictionary.domain.Role;
import cl.inicia.dictionary.domain.User;
import cl.inicia.dictionary.domain.Word;
import cl.inicia.dictionary.repository.LanguageRepository;
import cl.inicia.dictionary.repository.UserRepository;

@EnableResourceServer
@SpringBootApplication
public class DictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DictionaryApplication.class, args);
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo, LanguageRepository lRepo, PasswordEncoder encoder) throws Exception {
		if (repo.count() == 0) {
			
			Language language = new Language("en", "English");
			lRepo.save(language);
						
			String hash = encoder.encode("1234");
			User user = new User("gabo", hash, true);			
			List<Role> roles = new ArrayList<>();		
			roles.add(new Role(user, "USER"));							
			
			Language language2 = lRepo.findByShortName("en");
			
			List<Word> words = new ArrayList<>();
			words.add(new Word(language2, user, "although", "aunque", false, 0));
			words.add(new Word(language2, user, "accomplish", "realizar", false, 0));
			
			user.setWords(words);
			user.setRoles(roles);
			repo.save(user);
		}
		builder.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return new CustomUserDetails(repo.findByUsername(username));
			}
		}).passwordEncoder(encoder);
	}
}
