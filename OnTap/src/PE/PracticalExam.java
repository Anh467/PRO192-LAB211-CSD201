import java.util.*;

public class PracticalExam {
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
            Node x= new Node(newValue);
            Node p= root;
            while(p!=null){
                if(newValue> p.info){
                    if(p.right==null){
                        p.right= x;
                        return;
                    }  
                    p= p.right;
                    continue;
                }
                if(newValue== p.info){
                    System.out.println(newValue+ "is exist");
                    break;
                }
                if(p.left==null){
                    p.left= x;
                    return;
                }
                p= p.left;
            }
            root= x;
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
            if(x<= 1) return false;
            if(x== 2) return true;
            for(int i=2; i*i< x; i++)
                if(x%i==0) return false;
            return true;
        }
	private double sumOfPrime(Node r){
            if(r==null) return 0;
            if(isPrime(r.info)) return (double) r.info+ sumOfPrime(r.left)+ sumOfPrime(r.right);
            return sumOfPrime(r.left)+ sumOfPrime(r.right);
        }
	public void sumOfPrime(){
		System.out.println( "\nsum Of Prime: "+sumOfPrime(root));
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
            if(x<= 1) return false;
            int sum= 1;
            for(int i= 2; i<= x/2 ;i++)
                if(x%i==0) sum=sum+ i;
            if(sum== x)
                return true;
            return false;
        }
//remove prime
	private void removePrime(Node r) {
            if(r==null) return;
            if(isPrime(r.info))
                remove(root, r.info);
            removePrime(r.left);
            removePrime(r.right);
        }
	public void removePrime(){
		removePrime(root);
	}
//remove perfecct
        private void removePerfect(Node r) {
            if(r==null) return;
            if(isPerfect(r.info))
                remove(root, r.info);
            removePerfect(r.left);
            removePerfect(r.right);
        }
	public void removePerfect(){
		removePerfect(root);
	}

	public int countNodes(Node r) {
            if(r==null) return 0;
            return 1+ countNodes(r.left)+ countNodes(r.right);
	}
	public int countNodes() {
		return countNodes(root);
	}
	
	private int heigh(Node p){
            if(p==null) return 0;
            return 1+ Math.max(heigh(p.left), heigh(p.right));
	}
	public int heigh(){
		return heigh(root);
	}


	public static void main(String args[]) {
		PracticalExam tree=new PracticalExam();
		tree.add(28);
		tree.add(7);
		tree.add(35);
		tree.add(-9);
		tree.add(20);
		tree.add(100);
		tree.add(6);
                System.out.print("normal: ");
		tree.midOrder();
		/*
		WRITE YOU CODE HERE
		(1) -	Call function add_no_recursion
		(2) -	Call function sumOfPrime
		(3) - 	Call function removePerfect
		(4) -	Call function countNodes
		(5) - 	Call function heigh
*/	
                PracticalExam newTree=new PracticalExam();
            //(1) -	Call function add_no_recursion
                newTree.add_no_recursion(28);
                newTree.add_no_recursion(7);
		newTree.add_no_recursion(35);
		newTree.add_no_recursion(-9);
		newTree.add_no_recursion(20);
                newTree.add_no_recursion(11);
		newTree.add_no_recursion(100);
		newTree.add_no_recursion(6);
                System.out.print("\nadd no recursion: ");
		newTree.midOrder();
                System.out.println("\nheight: "+newTree.heigh());    
            //(2) -	Call function sumOfPrime
                newTree.sumOfPrime();
                System.out.print("is"+newTree.isPerfect(6));
            //(3) - 	Call function removePerfect
                newTree.removePerfect();
                System.out.print("\nafter remove: ");
                newTree.midOrder();
            //(4) -	Call function countNodes
                
                System.out.print("\ncount node: "+newTree.countNodes());
                
            //(5) - 	Call function heigh
                System.out.println("\nheight: "+newTree.heigh());
	}

}

