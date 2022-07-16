package memento;

import java.util.ArrayList;

//Originator
public class ReadingBucket {

	ArrayList<Ebook> eBooks = new ArrayList<>();
	
	public void addEbooks(Ebook eBook) {
		eBooks.add(eBook);
	}

	public ArrayList<Ebook> geteBooks() {
		return (ArrayList)eBooks.clone();
	}
	
	@Override
	public String toString() {
		return "ReadingBucket [eBooks=" + eBooks + "]";
	}

	public BucketMemento saveReadingBucket() {
		return new BucketMemento(geteBooks());
	}
	
	public void revertReadingBucket(BucketMemento bucketMemento) {
		eBooks = bucketMemento.geteBooks();
	}
	
	static class BucketMemento{
		
		ArrayList<Ebook> eBooks;

		public BucketMemento(ArrayList<Ebook> eBooks) {
			this.eBooks = eBooks;
		}

		private ArrayList<Ebook> geteBooks() {
			return eBooks;
		}
		
		
		
	}
}
