package assignmentcsd1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.lang.model.element.Element;


public class MyBinarySearchTree<E> {
    // node
   
    public class Node <E>{
        Comparable<E> infor;
        Node<E> left, right;
        int level;                  
        public Node(Comparable<E> i) {
            this.infor= i;
            this.left= null;
            this.right= null;
        }
        public Node(Comparable<E> i, Node<E> left, Node<E> right) {
            this.infor= i;
            this.left= left;
            this.right= right;
        }
        
    }
    private int size;
    private Node<E> root;
    public Node<E> add1(){
        Node<E> e= new Node(30);
        Node<E> d= new Node(12);
        Node<E> b= new Node(15,d,e);
        root= new Node(10, new Node(7,new Node(4),null),b);
        return root;
    }

//1.   boolean isEmpty() -   returns true if a tree is empty, return false otherwise.
    public boolean isEmpty(){
        if (root==null) return true;
        return false;
    }
//2.   void clear() - clears a tree.
    public void clear(){
        root= null;
    }
//3.   boolean search(int x) - searchs a node having the value x. Returns true if the value x exists in the tree; otherwise, return false.
    public boolean search(Node<E> x, E find){
        boolean check= false;
        if(x!=null){
            if(x.infor.compareTo(find)==0)
                return true;
            else if(x.infor.compareTo(find)<0)
                return search(x.right, find);
            else
                return search(x.left, find);
            
        }
        return false;
    }
    public boolean search(E find){
        return search(root, find);
    }
    public Node<E> add(Node<E> r, Comparable<E> e){
        if(r==null){
            r= new Node<E>(e);
            return r;
        }
        if(e.compareTo((E) r.infor)==0)
            return r;
        if(e.compareTo((E) r.infor)>0){
            r.right= add(r.right, e);
            return r;
        }
        r.left= add(r.left, e);
        return r;
    }
    public void add(Comparable<E> e){
        root= add(root, e);
    }
//4.   void insert(int x) - checks if the value x does not exists in a tree then insert new node with value x into the tree.
    public void inSert(E x){
        if(isEmpty()){
            root= new Node((Comparable)(x));
            return;
        }
        Node p= root;
        if(!search(x))
            while (true) {                
                if(p.infor.compareTo(x)<0){
                    if(p.right==null){
                        Node<E> a= new Node((Comparable) x);
                        p.right= a;
                        return;
                    }
                    else{
                        p= p.right;
                        continue;
                    }
                }
                else if(p.infor.compareTo(x)>0){
                    if(p.left==null){
                        Node<E> a= new Node((Comparable) x);
                        p.left= a;
                        return;
                    }
                    else{
                        p= p.left;
                        continue;
                    }
                }
            }
    }
//5.   void preorder(Node p) - recursive preorder traverse of a tree.
//6.   void inorder(Node p) - recursive inorder traverse of a tree.
//7.   void postorder(Node p) - recursive postorder traverse of a tree.
    public void preorder(Node<E> x){
        if(x!=null){
            System.out.print(x.infor+" ");
            preorder(x.left);
            preorder(x.right);
        }
    }
    public void preOrder(){
        if(root!=null)
            preorder(root);
    } 
    public void inOrder(Node<E> x){
        if(x!=null){
            inOrder(x.left);
            System.out.print(x.infor+" ");
            inOrder(x.right);
        }
    }
    public void inOrder(){
        if(root!=null)
            inOrder(root);
    }
    public void postOrder(Node<E> x){
        if(x!=null){
            inOrder(x.left);
            inOrder(x.right);
            System.out.print(x.infor+" ");
        }
    }
    public void postOrder(){
        if(root!=null)
            postOrder(root);
    }
//GPT
    public void preorderGPT(Node<E> x){
        if(x!=null){
            System.out.print(x.infor+" ");
            preorderGPT(x.right);
            preorderGPT(x.left);
        }
    }
    public void preOrderGPT(){
        if(root!=null)
            preorderGPT(root);
    } 
    public void inOrderGPT(Node<E> x){
        if(x!=null){
            inOrderGPT(x.right);
            System.out.print(x.infor+" ");
            inOrderGPT(x.left);
        }
    }
    public void inOrderGPT(){
        if(root!=null)
            inOrderGPT(root);
    }
    public void postOrderGPT(Node<E> x){
        if(x!=null){
            postOrderGPT(x.right);
            postOrderGPT(x.left);
            System.out.print(x.infor+" ");
        }
    }
    public void postOrderGPT(){
        if(root!=null)
            postOrderGPT(root);
    }
//8.  int count() - counts and returns the numbers of all nodes in the tree.
    public int count(Node<E> x){
        if(x!=null)
            return 1+count(x.left)+count(x.right);
        return 0;
    }
    public int count(){
        return count(root);
    }
//9.  int min() - finds and returns the minimum value in the tree.
    public Node<E> min(Node<E> x){
        Node<E> p= root;
        while(p.left!=null)
            p= p.left;
        return p;
    }
    public E min(){
        return (E) min(root).infor;
    }
//10.  int max() - finds and returns the maximum value in the tree. 
    public Node<E> max(Node<E> x){
        Node<E> p= root;
        while(p.right!=null)
            p= p.right;
        return p;
    }
    public E max(){
        return (E) max(root).infor;
    }
//11.  int sum() - returns the sum of all values in the tree.
    public int sum(Node x){
        if(x!=null)
            return  ((int)x.infor) +sum(x.left)+sum(x.right);
        return 0;
    }
    public int sum(){
        return sum(root);
    }
//12.  int avg() - returns the average of all values in the tree.
    public int avg(){
        if(!isEmpty())
            return sum()/count();
        return 0;
    }
//13.  int leaf() - counts and returns the numbers of all the leaf nodes in the tree.
    public int leaf(Node<E> x){
        int sumLeaf= 0;
        if((x.left==null)&&(x.right==null))
            return 1;
        if(x.right!=null)
            sumLeaf=sumLeaf+ leaf(x.right);
        if(x.left!=null)
            sumLeaf=sumLeaf+ leaf(x.left);
        return sumLeaf;
    }
    public int leaf(){
        if(isEmpty()) return 0;
        return leaf(root);
    }
//14.  int degree1() - counts and returns the numbers of all nodes which have one child in the tree
    public int degree1(Node<E> x){
        if(x==null) return 0;
        if(((x.left==null)&&(x.right!=null))||((x.left!=null)&&(x.right==null)))
            return 1+ degree1(x.right)+ degree1(x.left);
        return degree1(x.right)+ degree1(x.left);
    }
    public int degree1(){
        return degree1(root);
    }
//15.  int degree2() - counts and returns the numbers of all nodes which have two child in the tree.
    public int degree2(Node<E> x){
        if(x==null) return 0;
        if((x.left!=null)&&(x.right!=null))
            return 1+ degree2(x.right)+ degree2(x.left);
        return degree2(x.right)+ degree2(x.left);
    }
    public int degree2(){
        return degree2(root);
    }
//16.  int immediate() - counts and returns the numbers of all immediate nodes in the tree.
//17.  int height() – returns height of the tree (the height of a tree with root is 1).
    public int height(Node<E> x){
        if(x== null) return 0;
        int left, right;
        left= height(x.left);
        right= height(x.right);
        return left>= right ? left+1 : right+1;
    }
    public int height(){
        if(isEmpty()) return 0;
        return height(root);
    }
    // height of value
    public int height(Node<E> x, E e){
        if(x==null) return 0;
        if(x.infor.compareTo(e)==0) return 1;
        if(x.infor.compareTo(e)>0) return height(x.left, e)+1;
        return height(x.right, e)+1;
    }
    public int height(E e){
        if(!search(e)) return -1;
        else return height(root, e);
    }
//18.  void deepth() - traverses a tree by the deepth first search.
//    public void DFS(Node<E> x){
//        if(x==null) return;
//        System.out.print(x.infor +" ");
//        DFS(x.left);
//        DFS(x.right);
//    }
//    public void DFS(){
//        DFS(root);
//    }
//    public void preorder(Node<E> x){
//        if(x!=null){
//            System.out.print(x.infor+" ");
//            preorder(x.left);
//            preorder(x.right);
//        }
//    }
//    public void preOrder(){
//        if(root!=null)
//            preorder(root);
//    } 
    public void DFS(){
        Stack<Node> newStack = new Stack<> ();
        newStack.add(root);
        do{
            Node p = newStack.pop();
            if (p!= null){
                System.out.print(p.infor+ " ");
                newStack.push(p.right) ;
                newStack.push(p.left);
            }
        }while (!newStack.isEmpty ());
    } 

//19.  void breadth() - traverses a tree by the breadth first search/level order.
//    Queue<Node>[] newQueue;
//    public void BFS(Node<E> x,int prioty){
//        newQueue[prioty].add(x);
//        if(x.left!=null)
//            BFS(x.left, prioty+1);
//        if(x.right!=null)
//            BFS(x.right, prioty+1);
//    }
//    public void BFS(){
//        if(!isEmpty()){
//            int[] j= new int[10];
//            newQueue= new LinkedList[height()];
//            for(int i= 0; i< newQueue.length; i++)
//                newQueue[i]= new LinkedList();
//            BFS(root, 0);
//            for(int i= 0; i< newQueue.length; i++)
//                while(!newQueue[i].isEmpty())
//                    System.out.print(newQueue[i].poll().infor+" ");
//        }
//    }
    
    public void BFS(Node<E> x){
        if(x!=null){
            System.out.print(x.infor+" ");
            preorder(x.left);
            preorder(x.right);
        }
    }
    public void BFS(){
        if(isEmpty()) return;
        Queue<Node> newQueue= new LinkedList<>();
        newQueue.add(root);
        while(!newQueue.isEmpty()){
            Node p= newQueue.remove();
            if(p==null) continue;
            System.out.print(p.infor+" ");
            newQueue.add(p.left);
            newQueue.add(p.right);
        }
    }
//20.  int level(int x) – finds and return the level of the value x in the tree.
//    public int level(Node<E> x, E findLevel){
//        if(x==null)
//            return -1;
//        if(x.infor.compareTo(findLevel)>0)
//            return level(x.left, findLevel);
//        if(x.infor.compareTo(findLevel)<0)
//            return level(x.right, findLevel);
//        if((x.left==null)&&(x.right==null))
//            return 0;
//        if(((x.left!=null)&&(x.right==null))||((x.left==null)&&(x.right!=null)))
//            return 1;
//        return 2;
////    }
//    public int level(E x){
//        return level(root, x);
//    }
    public void level(E x){
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        root.level= 1;
        while (!q.isEmpty()) {            
            Node r= q.remove();
            if(x.equals(r.infor)){
                System.out.print(r.level);
                return;
            }
            if(r.left!=null) {
                r.left.level= r.level+1;
                q.add(r.left);
            }
            if(r.right!=null) {
                r.right.level= r.level+1;
                q.add(r.right);
            }
        }
    }
//21.  void printNodesAtLevel(int k) - listing all nodes at level k in the tree.
    public void printNodesAtLevel(Node<E> x,int level, int prioty){
        if(x==null) return;
        if(prioty== level) System.out.print(x.infor+" ");
        printNodesAtLevel(x.left, level, prioty+1);
        printNodesAtLevel(x.right, level, prioty+1);
    }
    void printNodesAtLevel(int k){
        if(!((k>0)&&(k<=height()))) return;
        printNodesAtLevel(root, k, 1);
    }
//1.  void remove(int x) - deletes a node having the value x.
//    public ArrayList<E> takeElemt(Node<E> x, E element){
//        ArrayList<E> store= new ArrayList<>();
//        if(x==null) return store;
//        if(x.infor.compareTo(element)!=0)
//            store.add((E)x.infor);
//        if(x.right!=null)
//            store.addAll(takeElemt(x.right, element));
//        if(x.right!=null)
//            store.addAll(takeElemt(x.left, element));
//       return store;
//    }
//    public void remove(E x){
//        if(isEmpty()||!search(x)) return;
//        ArrayList<E> store= takeElemt(root, x);
//        root= null;
//        for(int i=0; i< store.size(); i++)
//            inSert(store.get(i));
//    }
    public Node<E> remove(Node<E> r, Comparable<E> e){
        if(r==null)
            return r;
        if(r.infor.compareTo((E)e)>0){
            r.left= remove(r.left, e);
            
            return r;
        }
        if(r.infor.compareTo((E)e)<0){
            
            r.right= remove(r.right, e);
            return r;
        }
    //TH khong co con
        if((r.left==null)&&(r.right==null)){
            r= null;
            return r;
        }
    //th co con trai
        if((r.left!=null)&&(r.right==null)){
            r.infor= r.left.infor;
            r.left= remove(r.left, r.left.infor);
            return r;
        }
    // co con phai
        if((r.left==null)&&(r.right!=null)){
            r.infor= r.right.infor;
            r.right= remove(r.right, r.right.infor);
            return r;
        }
    // co 2 con 
        Node<E> P= r.left;
        while (P.right!=null) 
            P= P.right;
        r.infor= P.infor;
        r.left= remove(r.left, P.infor);
        return r;
    }
    public void remove(Comparable<E> e){
        root= remove(root, e);
    }
//2.  implements the tree sort.
    public void treeSort(E[] a){
        for(int i=0; i< a.length; i++)
            inSert(a[i]);
    }
//    public void func4(int n){
//        if(n==0) return;
//        func4(n/2);
//        System.out.print(n%2+" ");
//    }
    public void func4(int n){
        
        func4(n/2);
        System.out.println("1");
    }
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst= new MyBinarySearchTree();
        bst.add(10);
        bst.add(7);
        bst.add(35);
        bst.add(-9);
        bst.add(20);
        bst.add(40);
        bst.add(100);
        System.out.print("BFS: \n");
        bst.BFS();
        //bst.BFS();
        bst.remove(10);
        System.out.println("\nbst after remove: ");
        //bst.FS();
        System.out.print("\nLevel of value: ");
        bst.level(10);
        bst.func4(10);
//1.   boolean isEmpty() -   returns true if a tree is empty, return false otherwise.
//        System.out.println("Tree is empty: "+ bst.isEmpty());
//        bst.add1();
//        System.out.print("PreOrder   : ");
//            bst.preOrder();
//            System.out.print(" | ");
//            bst.preOrderGPT();
//        System.out.print("\nInOder     : ");
//            bst.inOrder();
//            System.out.print(" | ");
//            bst.inOrderGPT();
//        System.out.print("\nPostOrder  : ");
//            bst.postOrder();
//            System.out.print(" | ");
//            bst.postOrderGPT();
//        System.out.println("\ncheck: "+ bst.search(8));
//        System.out.println("Count: "+ bst.count());
//        System.out.println("min: "+bst.min());
//        System.out.println("sum: "+bst.sum());
//        bst.inSert(8);
//        bst.inSert(2);
//        bst.inSert(17);
//        bst.inSert(50);
//        System.out.println("AFrer insert: ");
//            bst.inOrder();
//        System.out.println("\nAverage of all values in the tree: "+bst.avg());
//        System.out.println("Number of leaf: "+bst.leaf());   
//        System.out.println("Number of degree 1: "+bst.degree1());   
//        System.out.println("Number of degree 2: "+bst.degree2());   
//        System.out.println("height: "+bst.height());   
//        System.out.print("DFS: ");   
//        bst.DFS();
//        System.out.print("\nBFS: ");   
//        bst.BFS();
//        System.out.println("\nFind level "+bst.level(10));
//        System.out.print("List all node at level: ");
//        bst.printNodesAtLevel(2);
//        bst.remove(50);
//        System.out.println("\nAfter remove: ");
//            bst.inOrder();
//        Integer[] a= {5,8,1,10,21,40,51};
//        MyBinarySearchTree<Integer> treeSort= new MyBinarySearchTree();
//        treeSort.treeSort(a);
//        System.out.println("sorted: ");
//        treeSort.inOrder();
    }
    
    
}
