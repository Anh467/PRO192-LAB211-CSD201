/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package upgrade;

import hashtable.*;

/**
 *
 * @author 84384
 */
interface HashTable <K,V> {
    public int hash(K key, int i);
    public int size();
    public boolean isEmpty();
    public V remove(Comparable<K> key);
    public V get(Comparable<K> key);
    public void add(Comparable<K> key, V value);
    public void view();
    public void clear();
}
