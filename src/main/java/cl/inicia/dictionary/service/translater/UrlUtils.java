package cl.inicia.dictionary.service.translater;

public class UrlUtils {
	
	private final StringBuilder queryString; 
	private char paramPrefix;
	
	public UrlUtils() {
		this.queryString = new StringBuilder();
		this.paramPrefix = '?';
	}
	
	public void addParam(Param param){
		if(this.queryString.length() > 0){
			this.paramPrefix = '&';
		}
		this.queryString.append(this.paramPrefix);
		this.queryString.append(param.getAttribute());
		this.queryString.append("=");
		this.queryString.append(param.getValue());
	}
	
	public String getQueryString(){
		return String.valueOf(this.queryString);
	}
}
