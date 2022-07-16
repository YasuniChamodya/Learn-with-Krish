package memento;

public class Ebook {
	
	String bookName;

	public Ebook(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "Ebook [bookName=" + bookName + "]";
	}
	
}
