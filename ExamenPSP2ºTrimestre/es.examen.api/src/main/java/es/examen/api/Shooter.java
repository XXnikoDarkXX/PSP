package es.examen.api;

public class Shooter {
	private String title;
	private String short_description;
	private String publisher;
	private String developer;
	
	
	
	

	public Shooter(String title, String short_description, String publisher, String developer) {
		super();
		this.title = title;
		this.short_description = short_description;
		this.publisher = publisher;
		this.developer = developer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	@Override
	public String toString() {
		return "Shooter [title=" + title + ", short_description=" + short_description + ", publisher=" + publisher
				+ ", developer=" + developer + "]";
	}


	
	

}
