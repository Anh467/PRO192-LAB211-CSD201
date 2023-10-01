/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashtable;

import java.util.ArrayList;

/**
 *
 * @author 84384
 */
public class MySeparateChaining<K,V>{
       
    public class Node <K,V>{
        K key;
        V value;
        Node<K, V> next;
        final int hashCode;
//        public Node(int hashCode) {
//            this.value= null;
//            this.next= null;
//            this.hashCode= hashCode;
//        }
        public Node(K key, V value, int hashCode) {
            this.key= key;
            this.value= value;
            this.next= null;
            this.hashCode= hashCode;
        }
        public Node(K key, V value, Node<K, V> next, int hashCode) {
            this.key= key;
            this.value= value;
            this.next= next;
            this.hashCode= hashCode;
        }
        
    }
    private int size;
    private double loadFactor= 0.75;
    private Node<K, V>[] HashEntity;
    public MySeparateChaining() {
        this.size = 5;
        HashEntity= new Node[size];
        for(int i= 0; i< size; i++)
            HashEntity[i]= null;
    }
    public MySeparateChaining(int size) {
        this.size = size;
        HashEntity= new Node[size];
        for(int i= 0; i< size; i++)
            HashEntity[i]= null;
    }
    public int hash(K key){
        return key.hashCode()%size;
    }
//    public boolean checkExist(Comparable<K>  key){
//        int getIndex= hash((K)key);
//        System.out.println("key: "+getIndex);
//        Node<K,V> node= HashEntity[getIndex];
//        System.out.println("hi");
//        while(node!=null){
//            if(node==null) return false;
//            if(key.compareTo(node.key)==0)
//                return true;
//            node= node.next;
//        }
//        return false;
//    }
    public void clear(){
        HashEntity= new Node[size];
        for(int i= 0; i< size; i++)
            HashEntity[i]= null;
    }
    public void add(Comparable<K> key, V Value){
        //if(checkExist((Comparable<K>) key)) return;
        int getIndex= hash((K)key);
        if(HashEntity[getIndex]==null){
            HashEntity[getIndex]= new Node((K)key, Value, null, size);
            return;
        }
        Node<K,V> draft= HashEntity[getIndex];        
        while(draft.next!=null){
            if(key.compareTo(draft.key)==0){
                draft.value= Value;
                return;
            }
            draft= draft.next;
        }
        draft.next= new  Node((K)key, Value, null, size);
        
    }
    public int count(Node<K,V> r){
        if(r==null) return 0;
        return 1+ count(r.next);
    }
    public int size(){
        int numElement= 0;
        for(int i= 0; i< HashEntity.length; i++)
            numElement+= count(HashEntity[i]);
        return numElement;
    }
    public Node<K,V> remove(Node<K,V> node, Comparable<K> key){
        if(node==null) return null;
        if(key.compareTo(node.key)==0){
            node= node.next;
            
        };
        return remove(node.next, key);
    }
    public V remove(Comparable<K> key){
        int getIndex= hash((K)key);
        
        if(HashEntity[getIndex]==null) return null;
        
        if(key.compareTo(HashEntity[getIndex].key)==0){
            V getValue= HashEntity[getIndex].value;
            HashEntity[getIndex]= HashEntity[getIndex].next;
            return getValue;
        }
        
        Node<K,V> node= HashEntity[getIndex];
        while (node.next!=null) {      
            if(key.compareTo(node.next.key)==0){
                V getValue= node.next.value;
                node.next= node.next.next;
                return getValue;
            }
            node= node.next;
        }
        return null;
    }
    public V getKey(Comparable<K> key){
        int getIndex= hash((K)key);
        Node<K,V> node= HashEntity[getIndex];
        while (node!=null) {            
            if(key.compareTo(node.key)==0)
                return node.value;
            node= node.next;
        }
        return null;
    }
    public boolean searchKey(Comparable<K> key){
        int getIndex= hash((K)key);
        Node<K,V> node= HashEntity[getIndex];
        while (node!=null) {            
            if(key.compareTo(node.key)==0)
                return true;
            node= node.next;
        }
        return false;
    }
    public void view(){
        System.out.println("=======View=======");
        for(int i= 0; i< HashEntity.length; i++){
            System.out.print("a["+i+"]");
            Node<K,V> node= HashEntity[i];
            while(node!=null){
                System.out.print(" -> "+"("+node.key+", "+node.value+")");
                node= node.next;
            }
            System.out.println("");
        }
        System.out.println("---------End========");
    }
    public static void main(String[] args) {
        MySeparateChaining<String, Integer> MySC= new MySeparateChaining(10);
        MySC.add("this", 1);
        MySC.add("coder", 2);
        MySC.add("this", 4); 
        MySC.add("hi", 5);
        MySC.add("he", 7);
        MySC.add("ha", 3);
        MySC.add("ga", 11);
        MySC.add("ni", 9);
        MySC.add("chi", 8);
        System.out.println("size: "+MySC.size());
        MySC.view();
        System.out.println("remove: "+ MySC.remove("chi"));
        
        //System.out.println("Remove: "+MySC.remove("coder"));
        System.out.println("size: "+MySC.size());
        MySC.view();
        System.out.println("getkey: "+ MySC.getKey("he"));
        MySC.clear();
        MySC.view();
    }
}
