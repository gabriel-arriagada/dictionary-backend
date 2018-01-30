package cl.inicia.dictionary.dto;

public class TranslateDto {

	private String word;
	private String meaning;
	private String languaje;

	public TranslateDto(String word, String meaning, String languaje) {
		super();
		this.word = word;
		this.meaning = meaning;
		this.languaje = languaje;
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

	public String getLanguaje() {
		return languaje;
	}

	public void setLanguaje(String languaje) {
		this.languaje = languaje;
	}

}
