
public class Comment {
	// Properties
	private String author;
	private String datePosted;
	private String app;
	private String contents;
	
	// Constructors
	Comment(String author, String datePosted, String app, String contents) {
		this.author = author;
		this.datePosted = datePosted;
		this.app = app;
		this.contents = contents;
	}
	
	// Methods
	public void display() {
		System.out.println(author + ", " + datePosted);
		System.out.println(app);
		System.out.println(contents);
	}
	
}
