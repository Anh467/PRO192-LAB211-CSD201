package PE.PE1;
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
    void insert(int num)    // 2 points 
    {
        if(root== null){
            root= new Node(num); 
            return;
        }
        Node r= root;
        while (true) {            
            if(num> r.key){
                if(r.right==null) break;
                r= r.right;
                continue;
            }
            if(num< r.key){
                if(r.left==null) break;
                r= r.left;
                continue;
            }
            return;
        }
        if(num> r.key) r.right= new Node(num);
        if(num< r.key) r.left= new Node(num);
    } 
    void inorder(Node r){
        if(r== null) return;
        inorder(r.left);
        System.out.print(r.key+" ");
        inorder(r.right);
    }
    void inorder()      // 2 points
    {
        inorder(root);
    }
    public static void main(String[] args)
    {
        Q2 tree = new Q2();
        // 2 3 4 5 6 7 8
        // 2 3 4 5 6 7 8
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
