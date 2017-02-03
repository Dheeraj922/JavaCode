class Node{
	int data;
	Node lchild;
	Node rchild;
	Node(int data){
		this.data=data;
		lchild=rchild=null;
	}
	
}

class BinaryTree{
	
	Node addNode(Node root,int data){
		if(root==null){
			root=new Node(data);
			return root;
		}
		if(root.data > data)
			root.lchild=addNode(root.lchild,data);
		else
			root.rchild=addNode(root.rchild,data);
		return root;
			
	}
	void inorderTraversal(Node root){
		if(root!=null){
			inorderTraversal(root.lchild);
			System.out.print(root.data+" ");
			inorderTraversal(root.rchild);
		}
	
	}
	void preOrderTraversal(Node root){
		if(root!=null){
			System.out.print(root.data+" ");
			preOrderTraversal(root.lchild);
			preOrderTraversal(root.rchild);
		}
	
	}
	void postOrderTraversal(Node root){
		if(root!=null){
			postOrderTraversal(root.lchild);
			postOrderTraversal(root.rchild);
			System.out.print(root.data+" ");
		}
	
	}
	Node deletion(Node root,int data){
		if(root==null)
			return root;
		if(data < root.data)
			root.lchild=deletion(root.lchild,data);
		else if(data > root.data)
			root.rchild=deletion(root.rchild,data);
		else{
			if(root.lchild==null){
				return root.rchild;
				
			}
			else if(root.rchild==null){
				return root.lchild;
				
			}
			else{
				Node temp=getInorderSucc(root.rchild);
				root.data=temp.data;
				root.rchild=deletion(root.rchild,temp.data);
			}
		}
		return root;
	}
	private Node getInorderSucc(Node root) {
		while(root.lchild!=null)
			root=root.lchild;
		return root;
		
	}
	public static void main(String args[]){
		Node root=null;
		BinaryTree tree= new BinaryTree();
		root=tree.addNode(root, 4);
		root=tree.addNode(root, 1);
		root=tree.addNode(root, 2);
		root=tree.addNode(root, 3);
		root=tree.addNode(root, 5);
		root=tree.addNode(root, 6);
		root=tree.addNode(root, 7);
		tree.inorderTraversal(root);
		System.out.println();
		tree.preOrderTraversal(root);
		System.out.println();
		tree.postOrderTraversal(root);
		//After deleting the key 5 we are left with the following 
		root=tree.deletion(root, 7);
		System.out.println("\nAfter deleting node 7 we are left with the following inorderTraversal of the tree");
		tree.inorderTraversal(root);
		
		
	}
}