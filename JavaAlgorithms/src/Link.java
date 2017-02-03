public class Link{
	 static Node head;
	static  class Node{
		int data;
		Node next;
		Node(int newData){
			data=newData;
			next=null;
		}
	}
	 void pushNode(int data){
		Node node=new Node(data);
		if(head==null){
			node.next=head;
			head=node;
			return;
		}
		Node temp = head;
		while(temp.next!=null)
			temp=temp.next;
		temp.next=node;
		node.next=null;
		
	}
	 void printList(Node head){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	public static void main(String args[]){
		Link link= new Link();
		link.pushNode(1);
		link.pushNode(2);
		link.pushNode(3);
		link.pushNode(4);
		link.pushNode(5);
		link.pushNode(6);
		link.printList(head);
	}
}