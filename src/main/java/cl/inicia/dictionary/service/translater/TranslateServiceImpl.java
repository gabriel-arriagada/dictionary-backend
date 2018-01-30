package cl.inicia.dictionary.service.translater;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inicia.dictionary.dto.TranslateDto;
import cl.inicia.dictionary.exceptions.MyOwnDictionaryException;

@Service
public class TranslateServiceImpl implements ITranslateService {

	@Autowired
	private TokenGenerator tokenGenerator;

	@Override
	public TranslateDto translate(String word) {
		try {
			Map<String, String> params = new LinkedHashMap<String, String>();
			params.put("client", "t");
			params.put("sl", "auto");
			params.put("tl", "es");
			params.put("hl", "es");
			params.put("dt", "at");
			params.put("dt", "bd");
			params.put("dt", "ex");
			params.put("dt", "ld");
			params.put("dt", "md");
			params.put("dt", "qca");
			params.put("dt", "rw");
			params.put("dt", "rm");
			params.put("dt", "ss");
			params.put("dt", "t");
			params.put("ie", "UTF-8");
			params.put("oe", "UTF-8");
			params.put("otf", "1");
			params.put("ssel", "0");
			params.put("tsel", "0");
			params.put("kc", "5");
			params.put("tk", tokenGenerator.token(word));
			params.put("q", word);

			String result = HttpService.get(GOOGLE_END_POINT, UrlUtils.getQueryString(params));
			System.out.println(result);
			
		} catch (IOException e) {
			new MyOwnDictionaryException(e.getMessage());
		}

		return null;
	}

}
