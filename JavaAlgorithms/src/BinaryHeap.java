
public class BinaryHeap {
	int heap_size;
	int capacity;
	int heap[];
	BinaryHeap(int capacity){
		heap_size=0;
		this.capacity=capacity;
		heap=new int[capacity];
	}
	
	boolean isFull(){
		return heap_size==capacity;
	}
	boolean isEmpty(){
		return heap_size==0;
	}
	int parent(int i){
		return (i-1)/2;
	}
	int lchild(int i){
		return (2*i+1);
	}
	int rchild(int i){
		return (2*i+2);
	}

}
