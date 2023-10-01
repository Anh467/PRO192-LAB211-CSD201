/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upgrade;

import hashtable.*;
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
        
//        public Node(int hashCode) {
//            this.value= null;
//            this.next= null;
//            this.hashCode= hashCode;
//        }
        public Node(K key, V value) {
            this.key= key;
            this.value= value;
            this.next= null;
        }
        public Node(K key, V value, Node<K, V> next) {
            this.key= key;
            this.value= value;
            this.next= next;
        }
        
    }
    private int size, element;
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
    public int hash(K key, int i){
        return ((i+key.hashCode()%size)%size)<0?((i+key.hashCode()%size)%size)+size:((i+key.hashCode()%size)%size);
    }
    public void doubleArray(){
        Node<K,V>[] hashEntityDraftNode= HashEntity;
        
        HashEntity= new Node[size];
        for(int i= 0; i< size; i++)
            HashEntity[i]= null;
        for(int i= 0; i< hashEntityDraftNode.length; i++){
            Node<K,V> draft= hashEntityDraftNode[i];
            while (true) {                
                if(draft==null) break;
                int getIndex= hash(draft.key, 0);

                Node<K,V> draftEnity= HashEntity[getIndex]; 
                while(draftEnity!=null)
                    draftEnity= draftEnity.next;
                Node<K,V> e=  HashEntity[getIndex];

                HashEntity[getIndex]= new Node((K)draft.key, draft.value, e);
                draft= draft.next;
            }
        } 
    }
    public void checkLoadFactor(){
        if( ((double)element/(double) size) >= loadFactor ){
            this.size= size*2;
            doubleArray();
        }
    }
//    public boolean contain(Comparable<K>  key){
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
        int getIndex= hash((K)key, 0);
        
        Node<K,V> draft= HashEntity[getIndex]; 
        while(draft!=null){
            if(key.compareTo(draft.key)==0){
                draft.value=Value;
                return;
            }
            draft= draft.next;
        }
        checkLoadFactor();
        Node<K,V> e= HashEntity[getIndex];
        HashEntity[getIndex]= new Node((K)key, Value, e);
        element++; 
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
//    public Node<K,V> remove(Node<K,V> node, Comparable<K> key){
//        if(node==null) return null;
//        if(key.compareTo(node.key)==0){
//            node= node.next;
//            element--;
//        };
//        return remove(node.next, key);
//    }
    public V remove(Comparable<K> key){
        int getIndex= hash((K)key, 0);
        
        if(HashEntity[getIndex]==null) return null;
        
        if(key.compareTo(HashEntity[getIndex].key)==0){
            V getValue= HashEntity[getIndex].value;
            HashEntity[getIndex]= HashEntity[getIndex].next;
            element--;
            doubleArray();
            return getValue;
        }
        
        Node<K,V> node= HashEntity[getIndex];
        while (node.next!=null) {      
            if(key.compareTo(node.next.key)==0){
                V getValue= node.next.value;
                node.next= node.next.next;
                element--;
                doubleArray();
                return getValue;
            }
            node= node.next;
        }
        return null;
    }
    public V getKey(Comparable<K> key){
        int getIndex= hash((K)key, 0);
        Node<K,V> node= HashEntity[getIndex];
        while (node!=null) {            
            if(key.compareTo(node.key)==0)
                return node.value;
            node= node.next;
        }
        return null;
    }
    public boolean searchKey(Comparable<K> key){
        int getIndex= hash((K)key, 0);
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
             MySeparateChaining<Integer, String > NewLinear= new MySeparateChaining(10);
//        NewLinear.add("water",100);
//        NewLinear.add("apple",5);
//        NewLinear.add("mango",24);
//        NewLinear.add("guava",13); 
//        NewLinear.add("pineapple",17);
//        NewLinear.add("strawberry",37);
//        NewLinear.view();
        NewLinear.add(1, "this");
        NewLinear.add(22,"ew");
        NewLinear.add(4,"ke"); 
        NewLinear.add(5,"hi");
        NewLinear.add(7,"he");
        NewLinear.add(3,"this");
        NewLinear.add(12,"coder");
        NewLinear.add(21,"ke");
        NewLinear.add(30,"he");
        NewLinear.view();
        NewLinear.remove(22);
//        NewLinear.add(4,"ha");
//        NewLinear.add(11,"ga");
//        NewLinear.add(13,"ni");
//        NewLinear.add(29,"ni");
//        NewLinear.add(8,"cchi");
//        System.out.println("hi");
        NewLinear.view();
//        System.out.println("size: "+ NewLinear.size());
//        System.out.println(" get key: "+ NewLinear.getKey(20));
//        System.out.println(" get key: "+ NewLinear.getKey(3));
//        System.out.println(" get key: "+ NewLinear.getKey(12));
//        System.out.println(" get key: "+ NewLinear.getKey(21));
//        System.out.println(" get key: "+ NewLinear.getKey(30));
//        System.out.println(" get key: "+ NewLinear.getKey(29));
//        System.out.println("search key");
        //test1
//        MySeparateChaining<String, Integer> MySC= new MySeparateChaining(7);
//        MySC.add("this", 1);
//        MySC.add("coder", 2);
//        MySC.add("this", 4); 
//        System.out.println("size: "+MySC.size()+" ELEMENT:"+MySC.element);
//        MySC.view();
//        MySC.add("hi", 5);
//        MySC.add("he", 7);
//        MySC.add("ha", 3);
//        MySC.add("ga", 11);
//        MySC.add("ni", 9);
//        MySC.add("chi", 8);
//        System.out.println("size: "+MySC.size()+" ELEMENT:"+MySC.element);
//        MySC.view();
//        //System.out.println("Remove: "+MySC.remove("coder"));
//        System.out.println("size: "+MySC.size()+" ELEMENT:"+MySC.element);
//        MySC.view();
//        System.out.println("getkey: "+ MySC.getKey("he"));
        //test2

    }
}
