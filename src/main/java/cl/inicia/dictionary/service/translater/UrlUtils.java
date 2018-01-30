package cl.inicia.dictionary.service.translater;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class UrlUtils {

	public static String getQueryString(Map<String, String> params) {
		String queryString = "?";
		Iterator<Entry<String, String>> iterator = params.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>) iterator.next();
			queryString = queryString + pair.getKey() + "=" + pair.getValue() + "&";
		}

		queryString = queryString.substring(0, queryString.length() - 2);

		return queryString;
	}

}
