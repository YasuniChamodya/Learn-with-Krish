package memento;

import java.util.Stack;

//Bucket History
public class CareTaker {

	Stack<ReadingBucket.BucketMemento> history = new Stack<>();
	
	public void save(ReadingBucket readingBucket) {
		history.push(readingBucket.saveReadingBucket());
	}
	
	public void revert(ReadingBucket readingBucket) {
		if (!history.isEmpty())
			readingBucket.revertReadingBucket(history.pop());
		else
			System.out.println("Can not revert further!");
	}
}
