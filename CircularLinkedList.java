import java.util.Scanner;

public class CircularLinkedList{
	class Node{
		int data;
        Node next;
        public Node() {
            this.data = 0;
        }
        public Node(int data) {
            this.data = data;
        }
        public void displayNode() {
            System.out.print(data + " ");
        }
	}
	
	private Node first;
	private Node last;
	private Node current;
	private int count;
	public CircularLinkedList getCurrent;
	public CircularLinkedList()
	{
		first=null;
		last=null;
		current=null;
		count=0;
		
	}
	public boolean isEmpty() {
        return first == null;
    }
	public void step() {
        current = current.next;
    }
	public Node getCurrent() {
        return current;
    }
	 public Node getFirst() {
        return first;
    }
	 public int displayhead() {
        return first.data;
    }
	public void insert(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            first = newNode;
            current = first;
        } else {
            current.next = newNode;
        }
        newNode.next = first;
        last = newNode;
        step();
        count++;
    }
	public void delete(int x) {
        Node prev = first;
        Node curr = first.next;
        while (curr.data != x) {
            prev = curr;
            curr = curr.next;
        }
        if (count == 1) {
            first = null;
            count--;
        } else if (curr == first) {
            prev.next = curr.next;
            first = curr.next;
            count--;
        } else {
            prev.next = curr.next;
            count--;
        }
    }
	public void displayList() {
        int x = 0;
        Node printer = first;
        while (x < count) {
            printer.displayNode();
            printer = printer.next;
            x++;
        }
        System.out.println("");
    }
	public void Josephus(int count_num) {
        current = first;
        while (count > 1) {
            for (int i = 0; i < count_num; i++) {
                current = current.next;
            }
            Node n = new Node();
            n = current;
            n.displayNode();
            current = current.next;
            delete(n.data);
        }
    }
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of people in Circle:");
		int num_of_people=sc.nextInt();
		System.out.print("Enter the number using for counting off:");
		int counting_num=sc.nextInt();
		CircularLinkedList circle=new CircularLinkedList();
		for (int i = 1; i <= num_of_people; i++) {
            circle.insert(i);
        }
		System.out.print("People will be eliminated in the order :");
        circle.Josephus(counting_num);
        System.out.println();
        System.out.print("The number that will remain last is :");
        circle.displayList();
	}
}

	
