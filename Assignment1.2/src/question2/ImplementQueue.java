/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question2;

/**
 *
 * @author 84384
 */
public class ImplementQueue {
    public static void main(String[] args) {
        QueueLinkedList<Integer> queue= new QueueLinkedList<>(5);
        System.out.println("Queue is empty is "+ queue.isEmpty());
        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(4);
        queue.add(7);
        System.out.println(queue.toString());
        System.out.println("Queue is empty is "+ queue.isEmpty());
        queue.remove();
        System.out.println("After dequeue: "+queue.toString());
        System.out.println("Font: "+queue.element());
        queue.remove();
        System.out.println("Queue after remove: "+queue.toString());
    }
}
