package cl.inicia.dictionary.service.translater;

import cl.inicia.dictionary.dto.TranslateDto;

public interface ITranslateService {
	
	public static String GOOGLE_END_POINT = "https://translate.google.com/translate_a/single";
	
	public TranslateDto translate(String word);
	
}
