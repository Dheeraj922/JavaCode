class Neighbor{
	public String houseOwnerName;
	public int houseNumber;
	public Neighbor next;
	public Neighbor previous;
	
	public Neighbor(String houseOwnerName, int houseNumber){
		this.houseOwnerName=houseOwnerName;
		this.houseNumber=houseNumber;
	}
	
	public void display(){
		System.out.println("Owner Name: "+houseOwnerName+" House No: "+houseNumber);
	}
	public String toString(){
		return this.houseOwnerName;
	}
}
public class DoubleEndedLinkedList {
	public Neighbor firstLink;
	public Neighbor lastLink;
	
	public void insertIntoFirstPosition(String houseOwnerName, int houseNumber){
		Neighbor newLink= new Neighbor(houseOwnerName,houseNumber);
		if(isEmpty()){
			lastLink=newLink;
		}
		else
			firstLink.previous=newLink;
		
		newLink.next=firstLink;
		firstLink=newLink;
	}
	
	public void insertIntoLastPosition(String houseOwnerName, int houseNumber){
		Neighbor newLink= new Neighbor(houseOwnerName,houseNumber);
		if(isEmpty())
			firstLink=newLink;
		else{
			lastLink.next=newLink;
			newLink.previous=lastLink;
		}
		
		lastLink=newLink;
	}
	
	public boolean insertAfterKey(String houseOwnerName, int houseNumber, int key){
		
		Neighbor newLink= new Neighbor(houseOwnerName, houseNumber);
		Neighbor currentNeighbor=firstLink;
		while(currentNeighbor.houseNumber!= key){
			currentNeighbor=currentNeighbor.next;
			if(currentNeighbor== null)
				return false;
		}
		if(currentNeighbor == lastLink){
			newLink.next=null;
			lastLink=newLink;
		}
		else{
			
			newLink.next=currentNeighbor.next;
			currentNeighbor.next.previous=newLink;
			
		}
		newLink.previous=currentNeighbor;
		currentNeighbor.next=newLink;
		return true;
	}
	
	public void insertInOrder(String houseOwnerName, int houseNumber){
		Neighbor newLink=new Neighbor(houseOwnerName, houseNumber);
		Neighbor previousNeighbor=null;
		Neighbor currentNeighbor=firstLink;
		while( (currentNeighbor != null) && (houseNumber > currentNeighbor.houseNumber)){
			previousNeighbor=currentNeighbor;
			currentNeighbor=currentNeighbor.next;
		}
		if(previousNeighbor==null){
			firstLink=newLink;
		}
		else{
			previousNeighbor.next=newLink;
			//newLink.previous=previousNeighbor;
		}
		newLink.next=currentNeighbor;
	}
	
	private boolean isEmpty() {
		
		return (firstLink==null);
	}

	public static void main(String args[]){
		
		DoubleEndedLinkedList del= new DoubleEndedLinkedList();
		/*del.insertIntoFirstPosition("Dheeraj Choudhary", 1);
		del.insertIntoFirstPosition("Neeraj Choudhary", 2);
		del.insertIntoFirstPosition("Sahil Choudhary", 3);
		del.insertIntoLastPosition("Shubam Sharma", 4);*/
		del.insertInOrder("Dheeraj Choudhary", 3);
		del.insertInOrder("Neeraj Choudhary", 2);
		del.insertInOrder("Sahil Choudhary", 1);
		del.insertInOrder("Shubam Sharma", 7);
		del.insertAfterKey("Abhishek Choudhary", 9, 2);
		del.display();
		System.out.println("\n");
		NeighborIterator iterator= new NeighborIterator(del);
		iterator.currentNeighbor.display();
		System.out.println(iterator.hasNext());
		iterator.Next();
		iterator.currentNeighbor.display();
		iterator.remove();
		iterator.currentNeighbor.display();
		
	}

	private void display() {
		Neighbor ref = firstLink;
		while(ref!=null){
			ref.display();
			System.out.println("Next Link: "+ref.next);
			ref=ref.next;
			System.out.println();
		}
		
	}

}

class NeighborIterator{
	Neighbor currentNeighbor;
	Neighbor previousNeighbor;
	DoubleEndedLinkedList theNeighbors;
	
	public NeighborIterator(DoubleEndedLinkedList theNeighbors){
		
		this.theNeighbors=theNeighbors;
		currentNeighbor=theNeighbors.firstLink;
		previousNeighbor=theNeighbors.lastLink;
		
	}
	
	public boolean hasNext(){
		if(currentNeighbor.next != null)
			return true;
		return false;
	}
	
	public Neighbor Next(){
		if(hasNext()){
			previousNeighbor=currentNeighbor;
			currentNeighbor=currentNeighbor.next;
			return currentNeighbor;
		}
		return null;
	}
	
	public void remove(){
		if(previousNeighbor==null)
			theNeighbors.firstLink=currentNeighbor.next;
		else{
			previousNeighbor.next=currentNeighbor.next;
			if(currentNeighbor.next== null){
				currentNeighbor.next=theNeighbors.firstLink;
				previousNeighbor=null;
			}
			else{
				currentNeighbor=currentNeighbor.next;
			}
				
		}
	}
}
