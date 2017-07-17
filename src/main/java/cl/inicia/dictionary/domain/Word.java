package cl.inicia.dictionary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Word")
public class Word {

	@Id
	private int id;
	
	@Column
	private String word;
	
	@Column
	private String meaning;

	public Word() {
		// TODO Auto-generated constructor stub
	}

	public Word(int id, String word, String meaning) {
		this.id = id;
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
