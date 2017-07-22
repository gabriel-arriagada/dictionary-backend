package cl.inicia.dictionary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Word")
@Table(name = "Word")
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "word", nullable = false, unique = true)
	private String word;

	@Column(name = "meaning", nullable = false)
	private String meaning;
	
	/*Un usuario tiene muchas palabras*/
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	public Word() {
	
	}
	
	public Word(String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
	}

	public Word(User user, String word, String meaning) {
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

}
