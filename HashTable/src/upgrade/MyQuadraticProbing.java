/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upgrade;

import hashtable.*;
import java.util.Hashtable;
import java.util.Map;

public class MyQuadraticProbing<K, V> implements HashTable<K, V>{
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
    private int hashSize, element, keyPrime;;
    private double loadFactor= 0.75;
    Node<K,V>[] hashEntity;
    public MyQuadraticProbing() {
        this.hashSize= 5;
        hashEntity= new Node[hashSize];
        setKeyPrim();
    }
    public MyQuadraticProbing(int size) {
        this.hashSize= size;
        hashEntity= new Node[hashSize];
        setKeyPrim();
    }
    public void setKeyPrim(){
        int i= 0;
        while (suppport.UCLN(suppport.prime[i], hashSize)!=1)
            i++;
        keyPrime= suppport.prime[i];
    }
@Override
    public int hash(K key, int i){
        //keyPrime*
        return(i*i+key.hashCode()%hashSize)%hashSize;
    }
    public void doubleArray(){
        Node<K,V>[] hashEntityDraftNode= hashEntity;
        
        hashEntity= new Node[hashSize];
        setKeyPrim();
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
        if( ((double)element/(double) hashSize) > loadFactor ){
            hashSize= hashSize*2;
            doubleArray();
        }
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
                System.out.println(key);
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
        return (element==0);
    }
@Override
    public V remove(Comparable<K> key) {
        int getIndex= hash((K)key, 0);
        int i= 0;
        while (i< hashSize) {      
            if(hashEntity[hash((K)key, i)]!=null)
                if(key.compareTo(hashEntity[hash((K)key, i)].key)==0){
                    V value= hashEntity[hash((K)key, i)].value;
                    hashEntity[hash((K)key, i)]= null;
                    element--;
                    doubleArray();
                    return value;
                }
            i++;
        }
        return null;
    }
@Override
    public V get(Comparable<K> key) {
        int i= 0;
        System.out.print("get key: "+ key+" ");
        while (i< hashSize) {     
            System.out.print("->" + hash((K)key, i));
            if(hashEntity[hash((K)key, i)]!=null){
                
                if(key.compareTo(hashEntity[hash((K)key, i)].key)==0)
                    return hashEntity[hash((K)key, i)].value;
            }
            ++i;
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
        
//        MyLinearProbing<Integer, String> NewLinear= new MyLinearProbing(9);
//        
//        NewLinear.add(1, "this");
//        NewLinear.add(2,"coder");
//        NewLinear.add(4,"ke"); 
//        NewLinear.add(5,"hi");
//        NewLinear.add(7,"he");
//            System.out.println("prime");
//        NewLinear.add(3,"this");
//        NewLinear.add(12,"coder");
//        NewLinear.add(21,"ke");
//        NewLinear.add(30,"he");
//        NewLinear.add(4,"ha");
//        NewLinear.add(11,"ga");
//        NewLinear.add(13,"ni");
//        NewLinear.add(29,"ni");
//        NewLinear.add(8,"cchi");
////        NewLinear.add("ha", 3);
////        NewLinear.add("ga", 11);
////        NewLinear.add("ni", 9);
////        NewLinear.add("chi", 8);
//        System.out.println("hi");
//        NewLinear.view();
//        System.out.println("size: "+ NewLinear.size());
//        System.out.println(" get key: "+ NewLinear.get(20));
//        System.out.println(" get key: "+ NewLinear.get(3));
//        System.out.println(" get key: "+ NewLinear.get(12));
//        System.out.println(" get key: "+ NewLinear.get(21));
//        System.out.println(" get key: "+ NewLinear.get(30));
//        System.out.println(" get key: "+ NewLinear.get(29));
//        System.out.println("search key");
        MyQuadraticProbing<Integer, Integer> hash= new MyQuadraticProbing(10);
        hash.add(2, 5);
        hash.add(12, 7);
        hash.add(22, 4);
        hash.add(32, 5);
        hash.add(27, 11);
        hash.add(15, 13);
        hash.add(11, 8);
        //hash.add(8, 8);
        hash.view();
        System.out.println("remove: "+ hash.remove(32));
        hash.view();
        System.out.println("hi");
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
