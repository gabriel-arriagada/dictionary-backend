package cl.inicia.dictionary.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Language")
@Table(name = "Language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "languageId", nullable = false)
	private int languageId;

	@Column(name = "shortName", nullable = false)
	private String shortName;

	@Column(name = "language", nullable = false, unique = true)
	private String language;
	
	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "language", cascade = CascadeType.ALL)
	private List<Word> words;

	public Language() {

	}

	public Language(String shortName, String language) {
		this.shortName = shortName;
		this.language = language;
	}

	public Language(int languageId, String language) {
		this.languageId = languageId;
		this.language = language;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}
