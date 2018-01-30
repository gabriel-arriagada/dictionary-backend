package cl.inicia.dictionary.service.translater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpService {

	private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36";

	public static String get(String serverUrl, String queryString) throws IOException {
		URL url = new URL(serverUrl.concat(queryString));
		URLConnection urlConnection = url.openConnection();
		urlConnection.setRequestProperty("user-agent", USER_AGENT);
		urlConnection.setRequestProperty("method", String.valueOf(Method.GET));
		InputStream inputStream = urlConnection.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		StringBuilder lines = new StringBuilder();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			lines.append(line);
		}
		bufferedReader.close();

		return lines.toString();
	}

}
