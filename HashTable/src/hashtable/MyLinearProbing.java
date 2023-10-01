/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashtable;

import java.util.Hashtable;
import java.util.Map;

public class MyLinearProbing<K, V> implements HashTable<K, V>{
    public class Node<K,V>{
        K key;
        V value;
        int hashCode;
        public Node(K key, V value, int hashCode){
            this.key= key;
            this.value= value;
            this.hashCode= hashCode;
        }
    }
    private int hashSize, element;
    private double loadFactor= 1;
    Node<K,V>[] hashEntity;
    public MyLinearProbing() {
        this.hashSize= 5;
        hashEntity= new Node[hashSize];
//        for(int i= 0; i< hashSize; i++)
//            hashEntity[i]= ;
//        System.out.println(hashEntity[0]);
    }
    public MyLinearProbing(int size) {
        this.hashSize= size;
        hashEntity= new Node[hashSize];
//        for(int i= 0; i< hashSize; i++)
//            hashEntity[i]= ;
//        System.out.println(hashEntity[0]);
    }
@Override
    public int hash(K key, int i){
        return (key.hashCode()+i)%hashSize;
    }
    //rehash
    public void doubleArray(){
        Node<K,V>[] hashEntityDraftNode= hashEntity;
        hashSize= hashSize*2;
        hashEntity= new Node[hashSize];
//        for(int i= 0; i< hashEntityDraftNode.length; i++)
//            hashEntity[i]= hashEntityDraftNode[i];
    for(int i= 0; i< hashEntityDraftNode.length; i++){
            int j= 0;
            if(hashEntityDraftNode[i]==null) continue;
            while (j< hashSize) {         
                if(hashEntity[hash(hashEntityDraftNode[i].key, j)]==null){
                    hashEntity[hash(hashEntityDraftNode[i].key, j)]= hashEntityDraftNode[i];
                    break;
                }
                j++;
            }
            }
    }
    public void checkLoadFactor(){
        if( ((double)element/(double) hashSize) >= loadFactor )
            doubleArray();
    }
    public boolean add(Comparable<K> key, V value, int index){
        if(hashEntity[index]==null){
            hashEntity[index]= new Node((K) key, value, index);
            ++element;
            checkLoadFactor();
            return true;
        }
        if(key.compareTo(hashEntity[index].key)==0){
            hashEntity[index].value= value;
            return true;
        }
        return false;
    }
@Override
    public void add(Comparable<K> key, V value){
        int i= 0;
        while (true) {        
            if(hashEntity[hash((K)key, i)]==null){
                hashEntity[hash((K)key, i)]= new Node((K)key, value, hash((K)key, i));
                element++;
                checkLoadFactor();
                return;
            }
            if(key.compareTo(hashEntity[hash((K)key, i)].key)==0){
                hashEntity[hash((K)key, i)].value= value;
                return;
            }
            i++;
        }
    }
@Override
    public int size() {
        return element;
    }
@Override
    public boolean isEmpty() {
        if(element==0) return true;
        return false;
    }
@Override
    public V remove(Comparable<K> key) {
        int getIndex= hash((K)key, 0);
        int i= 0;
        while (i< hashSize) {      
            if(hashEntity[hash((K)key, i)]!=null)
                if(key.compareTo(hashEntity[hash((K)key, i)].key)==0)
                    return hashEntity[i].value;
            i++;
        }
        return null;
    }
@Override
    public V get(Comparable<K> key) {
        int getIndex= hash((K)key, 0);
        int i= 0;
        System.out.print("get key: "+ key+" ");
        while (i< hashSize) {   
            System.out.print("->" + hash((K)key, i));
            if(hashEntity[hash((K)key, i)]!=null){
                 
                if(key.compareTo(hashEntity[hash((K)key, i)].key)==0)
                    return hashEntity[hash((K)key, i)].value;
            }
            i++;
        }
        return null;
    }
@Override
    public void clear() {
        hashEntity= new Node[hashSize];
    }
    public void view(){
        System.out.println("=======view=======");
        for(int i= 0; i< hashSize; i++){
            System.out.print("a["+i+"]= ");
            if(hashEntity[i]!=null)
                System.out.print(hashEntity[i].key +" -> "+hashEntity[i].value);
            System.out.println("");
        }
            System.out.println("------------------");
    }
    public static void main(String[] args) {
        //test1
        MyLinearProbing<Integer, String> NewLinear= new MyLinearProbing(9);
    
//        NewLinear.add(3,"this");
//        NewLinear.add(12,"coder");
//        NewLinear.add(21,"ke");
//        NewLinear.add(30,"he");
//        NewLinear.add(4,"ha");
//        NewLinear.add(11,"ga");
//        NewLinear.add(13,"ni");
//        NewLinear.add(8,"chi");
//        NewLinear.view();
//        System.out.println("size: "+ NewLinear.size());
//        System.out.println("\nget key: "+ NewLinear.get(3));
//        System.out.println("\nget key: "+ NewLinear.get(12));
//        System.out.println("\nget key: "+ NewLinear.get(21));
//        System.out.println("\nget key: "+ NewLinear.get(30));
        System.out.println("not prime");    
        NewLinear.add(3,"this");
        NewLinear.add(12,"coder");
        NewLinear.add(21,"ke");
        NewLinear.add(30,"he");
        NewLinear.add(4,"ha");
        NewLinear.add(11,"ga");
        NewLinear.add(13,"ni");
        NewLinear.add(29,"ni");
        NewLinear.add(8,"cchi");
//        NewLinear.add("ha", 3);
//        NewLinear.add("ga", 11);
//        NewLinear.add("ni", 9);
//        NewLinear.add("chi", 8);
        System.out.println("hi");
        NewLinear.view();
        System.out.println("size: "+ NewLinear.size());
        System.out.println(" get key: "+ NewLinear.get(20));
        System.out.println(" get key: "+ NewLinear.get(3));
        System.out.println(" get key: "+ NewLinear.get(12));
        System.out.println(" get key: "+ NewLinear.get(21));
        System.out.println(" get key: "+ NewLinear.get(30));
        System.out.println(" get key: "+ NewLinear.get(29));
        System.out.println("search key");
    //test 1
//        hash.put(1, 5);
//        hash.put(1, 7);
//        hash.put(1, 3);
//        hash.put(3, 3);
//        hash.put(2, 8);
//        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
//            Object key = entry.getKey();
//            Object val = entry.getValue();
//            System.out.println("key: "+ key+" value: "+val);
//        }  
    }
}
