package q2;
public class Q2 {
    class Node
    {
        int key;
        Node left, right; 
        public Node(int item)
        {
            key = item;
            left = right = null;
        }        
    } 
    Node root;
    
    Q2()
    {
         root = null;
    }    
    void insert(Node r, int n)    // 2 points 
    {
        if(n> r.key){
            if(r.right==null){
                r.right= new Node(n);
                return;
            }
            insert(r.right,  n);
            return;
        }
        if(n< r.key){
            if(r.left==null){
                r.left= new Node(n);
                return;
            }
            insert(r.left,  n);
            return;
        }
        System.out.println("existed");
    } 
    void insert(int n){
        if(root== null){
            root= new Node(n);
            return;
        }
        insert(root, n);
    }
    void inorder(Node r)      // 2 points
    {
        if(r== null) return;
        inorder(r.left);
        System.out.print(r.key+" ");
        inorder(r.right);
    }
    void inorder(){
        inorder(root);
    }
    public static void main(String[] args)
    {
        Q2 tree = new Q2();
        /* Create following BST
              5
           /     \
           3      7
         /  \    /  \
        2    4  6    8 */
        tree.insert(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);
        tree.inorder();
    }
    
}
