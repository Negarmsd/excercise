class BinaryTree
{


	class Node {
    		int value;
    		Node left;
    		Node right;
 
    		Node(int value) {
        		this.value = value;
        		right = null;
        		left = null;
   				 }
		}


	public static Node root;
	public BinaryTree(){
		this.root =null;
	}


	public void insert(int value){

		root=addValue(root,value);
	}


	public void displayLeft(Node root){
		if(root!=null){
			displayLeft(root.left);
			System.out.printf("\n left : %d" , root.value);
			
		}
		
	}

	public void displayRight(Node root){

		if(root!= null){
			displayRight(root.right);
			System.out.printf("\n right : %d" ,root.value);
			
		}
		


	}
	public void display(Node root){
		if(root!=null){
			display(root.right);
			System.out.printf("%d \n" ,root.value);
			display(root.left);
		}
	}




	public Node addValue(Node root, int value){
		


		Node newNode = new Node(value);
		if(root==null){
			root = newNode;
			return root;
		}


		if(root!=null){
			
			Node current=root;


			if(current.value>value){
				if(current.left != null){


					current.left = addValue(current.left, value);
					return current;
				}else current.left=newNode;
				return current;
				
			
			
			}
	
	
			if(current.value<value){
				if(current.right != null){

					
						current.right= addValue(current.right, value);
						return current;
				}else current.right= newNode;
				return current;
			}
		}
		return null;
	}
	

	public static void strict(Node root){
		boolean a =false;
		if(root!=null){
			if(root.right!=null && root.left!=null){
				System.out.println(" true");
				
			}else 
				System.out.println(" false");

		}
			//strict(root.left);
			strict(root.right);
			
	}
			



		







	public static void main (String[] args){

		BinaryTree roo= new BinaryTree();

		roo.insert(4);
		roo.insert(3);
		roo.insert(5);
	        roo.insert(8);
		roo.insert(6);
		roo.insert(7);
		roo.insert(10);
		roo.insert(12);
		roo.insert(14);
		roo.insert(1);
		roo.insert(25);
		roo.insert(9);
		roo.insert(22);
		

		//roo.displayRight(root);
		//roo.displayLeft(root);
		roo.display(root);
		strict(root);

	





	}
}
