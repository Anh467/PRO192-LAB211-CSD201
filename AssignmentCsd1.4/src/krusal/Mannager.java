/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package krusal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author 84384
 */
public class Mannager {
    int V, E;
    ArrayList<Graph>graph= new ArrayList<>();
    public void input(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number V and number E: ");
        V= sc.nextInt();
        E= sc.nextInt();
        for(int i= 0; i< E; i++)
            graph.add(add());
    }
    public Graph add(){
        Scanner sc= new Scanner(System.in);
        int a, b, length;
        System.out.print("Enter a, b and length: ");
        a= sc.nextInt();
        b= sc.nextInt();
        length= sc.nextInt();
        return new Graph(a, b, length);
    }
    public void add1(){
        V= 6;
        E= 9;
        graph.add(new Graph(1, 2, 1));
        graph.add(new Graph(1, 3, 1));
        graph.add(new Graph(2, 4, 1));
        graph.add(new Graph(2, 3, 2));
        graph.add(new Graph(2, 5, 1));
        graph.add(new Graph(3, 5, 1));
        graph.add(new Graph(3, 6, 1));
        graph.add(new Graph(4, 5, 2));
        graph.add(new Graph(5, 6, 2));
    }
    public void view(ArrayList<Graph>viewGraph){
        for(Graph newGraph: viewGraph){
            System.out.println(newGraph.toString()+"= "+newGraph.getLength());
        }
    }
    public void sort(){
        Collections.sort(graph);
    }
    public static void main(String[] args) {
        Mannager manna= new Mannager();
        manna.add1();
        manna.sort();
        manna.view(manna.graph);
    }
}
