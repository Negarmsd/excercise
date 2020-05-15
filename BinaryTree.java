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




	public Node addValue(Node root, int value){
		


		Node newNode = new Node(value);
		if(root==null){
			root = newNode;
		}


		if(root!=null){
			Node current=root;

			if(current.value>value){
				if(current.left != null){


					current.left = addValue(current.left, value);
					return current;
				}else current.left=newNode;
				
			
			
			}
	
	
			if(current.value<value){
				if(current.right != null){

					
						current.right= addValue(current.right, value);
						return current;
				}else current.right= newNode;
			}

			



			return current;
				
		}
			
			return newNode;		
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
		roo.insert(55);
		

		roo.displayRight(root);
		roo.displayLeft(root);
	





	}
}
