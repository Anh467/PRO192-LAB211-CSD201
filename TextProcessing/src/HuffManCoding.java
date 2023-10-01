
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 84384
 */
public class HuffManCoding {
    class Node{
        char data;
        int freq;
        Node left, right;

        public Node() {
        }
        public Node(char data, int freq) {
            this.data = data;
            this.freq= freq;
        }
        public Node(char data, int freq, Node left, Node right) {
            this.data = data;
            this.freq= freq;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "("+data+", "+freq+")";
        }
    }
    String str, strCode;
    Node root;
    Map<Character, Integer> mapChar= new HashMap<>();
    Map<Character, String> mapLib= new HashMap<>();
    Map<String , Character> mapCodeToChar= new HashMap<>();
    PriorityQueue<Node> prioQueueChar= new PriorityQueue<>((o1, o2) -> {
        return o1.freq- o2.freq;
    });
    public HuffManCoding() {
         mapChar.put('a', 5);
         mapChar.put('b', 9);
         mapChar.put('c', 12);
         mapChar.put('d', 13);
         mapChar.put('e', 16);
         mapChar.put('f', 45);
         putToPriotyQueue();
         linkNode();
    }
    public HuffManCoding(String str) {
        this.str = str;  
        countFreqChar();
        putToPriotyQueue();
        linkNode();
        encode();
        endcode(str);
        decode(strCode);
    }
    public void countFreqChar(){
        for(int i= 0; i< str.length(); i++)
            if(mapChar.containsKey(str.charAt(i)))
                mapChar.put(str.charAt(i), mapChar.get(str.charAt(i))+1);
            else mapChar.put(str.charAt(i), 1);
    }
    public void putToPriotyQueue(){
        for (Map.Entry<Character, Integer> entry : mapChar.entrySet()) {
            Node x= new Node(entry.getKey(), entry.getValue());
            prioQueueChar.add(x);
        }
    }
    public void linkNode(){
        while(prioQueueChar.size()!=1){
            Node left= prioQueueChar.poll();
            Node right= prioQueueChar.poll();
            prioQueueChar.add(new Node('+', left.freq+ right.freq, left, right));
        }
        root= prioQueueChar.peek();
    }
    public void inOrder(Node r){
        if(r== null) return;
        inOrder(r.left);
        System.out.println(r.toString());
        inOrder(r.right);
    }
    public void inOrder(){
        inOrder(root);
    }
    public void encode(Node r, String code){
        if(r==null) return;
        if(r.data!='+') {
            mapLib.put(r.data, code);
            mapCodeToChar.put(code, r.data);
            System.out.println(r.data+": "+code);
        }
        encode(r.left, code+"0");
        encode(r.right, code+"1");       
    }
    public void encode(){
        encode(root, "");
    }
    public void endcode(String str){
        strCode= "";
        for(int i= 0; i< str.length(); i++)
            strCode= strCode+ mapLib.get(str.charAt(i));
        System.out.println("Code: "+strCode);
    }
    public void decode(String strCode){
        String strDraft= "";
        System.out.print("decode: ");
        for(int i= 0; i< strCode.length(); i++){
            strDraft= strDraft+ strCode.charAt(i);
            if(mapCodeToChar.containsKey(strDraft)){
                System.out.print(mapCodeToChar.get(strDraft));
                strDraft= "";
            }
        }
    }
    public static void main(String[] args) {
//        HuffManCoding huffman= new HuffManCoding("hello");
//        huffman.prioQueueChar.forEach((t) -> {
//            System.out.println("key: "+t.data+ " value:: "+t.freq);
//        });
//        huffman.inOrder();
//        System.out.println("encode: ");
//        huffman.encode();
    HuffManCoding huffman= new HuffManCoding("hellooooo!!!!");
    }
}
