package cl.inicia.dictionary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Word")
@Table(name = "Word")
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "word", nullable = false)
	private String word;

	@Column(name = "meaning", nullable = false)
	private String meaning;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	//@JsonManagedReference
	@JsonIgnore//Decimos que no queremos incluir este objeto en el reponse JSON
	@ManyToOne
	@JoinColumn(name = "languageId")
	private Language language;

	public Word() {

	}

	public Word(String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
	}

	public Word(Language language, User user, String word, String meaning) {
		this.language = language;
		this.user = user;
		this.word = word;
		this.meaning = meaning;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}
