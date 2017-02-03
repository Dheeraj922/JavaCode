class QueueNode{
	int key;
	QueueNode next;
	QueueNode(int key){
		this.key=key;
		next=null;
	}
}
class Queue{
	QueueNode front, rear;
	Queue(){
		front = rear =null;
	}
	
}
public class QueueTest {
	public QueueNode createNewNode(int key){
		QueueNode node = new QueueNode(key);
		return node;
	}
	public Queue createQueue(){
		Queue q = new Queue();
		return q;
	}
	
	public void enqueue(Queue q , int key){
		QueueNode node = createNewNode(key);
		if(q.rear==null){
			q.front=q.rear=node;
			return;
		}
		q.rear.next=node;
		q.rear=node;
	}
	
	public QueueNode deQueue(Queue q){
		if(q.front == null)
			return null;
		QueueNode temp=q.front;
		q.front=q.front.next;
		if(q.front==null){
			q.rear=null;
		}
		return temp;
	}
	public void displayQueue(Queue q){
		QueueNode temp=q.front;
		while(temp!=null){
			System.out.print(temp.key+" ");
			temp=temp.next;
		}
	}
	
	public static void main(String args[]){
		Queue q=new Queue();
		QueueTest test = new QueueTest();
		test.enqueue(q, 1);
		test.enqueue(q, 2);
		test.enqueue(q, 3);
		test.enqueue(q, 4);
		test.enqueue(q, 5);
		test.displayQueue(q);
		System.out.println();
		QueueNode qu=test.deQueue(q);
		if(qu!=null)
			System.out.println("node dequeued is = "+qu.key);
		if(q.front==null)
			System.out.println("all nodes exhausted");
		test.displayQueue(q);
	}

}
