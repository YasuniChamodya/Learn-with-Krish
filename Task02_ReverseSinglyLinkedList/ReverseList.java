package task2;

// Write a Program to reverse a Singly Linked list without using a second data structure

public class ReverseList{
	private Node head = null;
	private Node tail = null;

	private class Node{
		String data;
		Node next;

		private Node(String data){
			this.data = data;
			this.next = null;
		}

	}
	
	// Add a node to the list
	public void addNode(String data){
		Node node = new Node(data);
		if (head == null) {
			head = node ;
			tail = node ;
		}else{
			tail.next = node ;
			tail = node ;
		}
	}

	// Display all the nodes in the list
	public void display(){
		Node current = head;
		if(current != null){
			while(current != null){
				System.out.println(current.data);
				current = current.next;
			}
		}
	}

	// Reverse from the end node
	public void reverse(){
		if(tail != null && head != null){
			Node previous = tail; 
			Node current = head;
			Node next = null;
			
			while(current != previous){
				previous.next = current;
				head = current.next;
				tail = current;
				current.next = null;
				if (next != null) {
					tail.next = next;
				}
				current = head;
				next = previous.next;
			}

		}
	}


	public static void main(String[] args) {
		
		ReverseList singliList = new ReverseList();
		
		// Adding nodes to the list
		singliList.addNode("Node A");
		singliList.addNode("Node B");
		singliList.addNode("Node C");
		singliList.addNode("Node D");
		singliList.addNode("Node E");
		
		System.out.println("Original list:");
		singliList.display(); // Display the original list
		
		System.out.println("Reversed list:");
		singliList.reverse();
		singliList.display(); // Display the reversed list
	}
}