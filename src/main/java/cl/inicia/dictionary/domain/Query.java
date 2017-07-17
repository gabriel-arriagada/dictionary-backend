package cl.inicia.dictionary.domain;

public class Query {

	private int limit;
	private int offset;
	
	public Query() {
		// TODO Auto-generated constructor stub
	}	
	
	public Query(int limit, int offset) {
		this.limit = limit;
		this.offset = offset;
	}
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
