/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package stackandqueue;

/**
 *
 * @author 84384
 */
public interface Queue {
    public int size();
    public boolean isEmpty();
    public Object front() ;
    public void enqueue(Object o);
    public Object dequeue();
}
