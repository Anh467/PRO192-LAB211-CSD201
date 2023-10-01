import java.util.*;

public class BinarySearchTree {
	//------------------------------------------------------------------
	private static class Node {
		Integer info;
		Node left, right;
		int level=1;

		public Node(Integer info) {
			this.info = info;
			this.left = null;
			this.right = null;
		}
	}
	//------------------------------------------------------------------
	private Node root=null;

	// add a specify element into binary search tree
public void add(Integer newValue) {
		root = add(root, newValue);
	}
	private Node add(Node r, Integer newValue) {
		if (r == null) 
			r= new Node(newValue);
		else 	if (newValue==r.info) 
			System.out.println(newValue+ "is exist");
		else if (newValue< r.info) 
			r.left = add(r.left, newValue);
		else r.right = add(r.right, newValue);
		return r;
	}
	
	public void add_no_recursion(Integer newValue) {
		/* 	
Q1
*/  
                if(root==null){
                    root= new Node(newValue);
                    return;
                }
                Node r= root;
                while(true){
                    if(newValue> r.info){
                        if(r.right==null){
                            r.right= new Node(newValue);
                            break;
                        }
                        r= r.right;
                        continue;
                    }
                    if(newValue< r.info){
                        if(r.left==null){
                            r.left= new Node(newValue);
                            break;
                        }
                        r= r.left;
                        continue;
                    }
                    System.out.println("mid");
                    System.out.println("existed");
                    break;
                }
	}
	// traversal in order
public void midOrder() {
		midOrder(root);
	}
	private void midOrder(Node p) {
		if (p != null) {
			midOrder(p.left);
			System.out.print(p.info + "\t");
			midOrder(p.right);
		}
	}
	
	private boolean isPrime(Integer x){
		/* 	
Q2
		*/	
                if(x<=1) return false;
                if(x==2) return true;
                for(int i= 2; i*i< x; i++)
                    if(x%i== 0) return false;
                return true;
}
	private double sumOfPrime(Node r){
		/* 	
Q3
		*/	
                if(r== null) return 0;
                if(isPrime(r.info)) return r.info+ sumOfPrime(r.left)+sumOfPrime(r.right);
                return sumOfPrime(r.left)+sumOfPrime(r.right);
}
	public void sumOfPrime(){
		System.out.println( sumOfPrime(root));
	}
	//remove a specify element in binary search tree
	private Node remove(Node r, Integer removedValue) {
		if (r == null)
			return null;
		if (removedValue<r.info) 
			r.left = remove(r.left, removedValue); 
		else 
			if (removedValue>r.info) 
				r.right = remove(r.right, removedValue); 
			else 
				if (r.left == null && r.right == null) r=null; 
				else
					if (r.left == null&& r.right!=null)
						r=r.right; 
					else{
						Node p = r.left;
						while (p.right != null) p = p.right;
						r.info = p.info;
						r.left = remove(r.left, p.info);
					}
		return r;
	}

	private boolean isPerfect(int x) {
		/* 	
Q4 
		*/	
                int sum= 0;
                for(int i=2; i<= x/2; i++)
                    if(x%i == 0)
                        sum+= i;
                return (sum+1==x);
}

	private void removePrime(Node r) {
		if(r==null) return;
                if(isPerfect(r.info)) root= remove(root, r.info);
                removePrime(r.left);
                removePrime(r.right);
                
}
	public void removePrime(){
		removePrime(root);
	}

	public int countNodes(Node r) {
		/* 	
Q6
		*/
                if(r==null) return 0;
                return 1+ countNodes(r.left)+ countNodes(r.right);
	}
	public int countNodes() {
		return countNodes(root);
	}
	
	private int heigh(Node p){
		/* 	
Q7
		*/
                if(p== null) return 0;
                return 1+ Math.max(heigh(p.left), heigh(p.right));
	}
	public int heigh(){
		return heigh(root);
	}


	public static void main(String args[]) {
		BinarySearchTree tree=new BinarySearchTree();
		tree.add(28);
		tree.add(7);
		tree.add(35);
		tree.add(-9);
		tree.add(20);
		tree.add(100);
		tree.add(6);
		tree.midOrder();
		/*
		WRITE YOU CODE HERE
		(1) -	Call function add_no_recursion
		(2) -	Call function sumOfPrime
		(3) - 	Call function removePerfect
		(4) -	Call function countNodes
		(5) - 	Call function heigh
                
*/              
                System.out.println("");
                BinarySearchTree NewTree=new BinarySearchTree();
                //(1) -	Call function add_no_recursion
                NewTree.add_no_recursion(28);
		NewTree.add_no_recursion(7);
		NewTree.add_no_recursion(35);
		NewTree.add_no_recursion(-9);
		NewTree.add_no_recursion(20);
		NewTree.add_no_recursion(100);
		NewTree.add_no_recursion(6);
		NewTree.midOrder();
                System.out.println("");
                //(2) -	Call function sumOfPrime
                NewTree.sumOfPrime();
                //(3) - 	Call function removePerfect
                NewTree.removePrime();
                NewTree.midOrder();
                //(4) -	Call function countNodes
                System.out.println("\ncount: "+NewTree.countNodes());
                //(5) - 	Call function heigh
                System.out.println("height: "+ NewTree.heigh());
	}

}
