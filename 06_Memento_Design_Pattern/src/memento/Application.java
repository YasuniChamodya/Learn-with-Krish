package memento;

public class Application {

	public static void main(String[] args) {
		
		CareTaker caretaker = new CareTaker();
		ReadingBucket readingBucket = new ReadingBucket();
		
		readingBucket.addEbooks(new Ebook("Head First Java"));
		
		caretaker.save(readingBucket);
		System.out.println(readingBucket);
		
		readingBucket.addEbooks(new Ebook("The Design of Everyday Things"));
		
		caretaker.save(readingBucket);
		System.out.println(readingBucket);
		
		caretaker.revert(readingBucket);
		System.out.println(readingBucket);
		
		readingBucket.addEbooks(new Ebook("Design Patterns"));
		System.out.println(readingBucket);
		
		caretaker.revert(readingBucket);
		System.out.println(readingBucket);
		
	}
}
