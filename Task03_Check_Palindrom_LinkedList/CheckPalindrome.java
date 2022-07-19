package palindrome;

// Task 02 - Find a given a Singly Linked List is Palindrome or not

public class CheckPalindrome{
	
	private int size = 0 ;
	private Node head = null;
	private Node tail = null;

	private class Node{
		int position;
		String data;
		Node next;

		private Node(String data){
			this.data = data;
			this.next = null;
			this.position = size - 1;
		}

	}
	
	// Add a node to the list
	public void addNode(String data){
		size++;
		Node node = new Node(data);
		if (head == null) {
			head = node ;
			tail = node ;
		}else{
			tail.next = node ;
			tail = node ;
		}
	}

	// Get the value of node
	public String getNodeValue(int position){
		Node current = head ;
		String value = null;
		if(size>position){
			if(current != null){
				while(current != null){
					if (current.position == position) {
						value = current.data;
						break;
					}else{
						current = current.next;
					}
				}
			}
		}
		return value;
	}

	// Display all the nodes in the list
	public void display(){
		Node current = head;
		if(current != null){
			System.out.print("[ ");
			while(current != null){
				System.out.print(current.data+" ");
				current = current.next;
			}
			System.out.println("]");
		}
	}

	public int size(){
		return size;
	}
	
	// Check whether palindrome
	public boolean isPalindrome(){
		boolean palindrom = false;
		if(head != null){
			for (int i = 0; i <= size/2 - 1; i++) {
				if (!getNodeValue(i).equals(getNodeValue(size-1-i))) {
					palindrom = false;
					break;
				}else{
					palindrom = true;
				}
			}
		}
		return palindrom;
	}


	public static void main(String[] args) {
		CheckPalindrome singlyList = new CheckPalindrome();
		
		// Adding nodes to the list
		singlyList.addNode("r");
		singlyList.addNode("a");
		singlyList.addNode("c");
		singlyList.addNode("e");
		singlyList.addNode("c");
		singlyList.addNode("a");
		singlyList.addNode("r");
		
		// Display the Singly Liked List
		singlyList.display();
		
		System.out.println("Is this Liked List is a Palindrome? "+singlyList.isPalindrome());
	}
}