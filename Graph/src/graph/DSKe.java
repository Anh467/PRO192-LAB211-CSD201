/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graph;

import java.util.LinkedList;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
/**
 *
 * @author 84384
 */
public class DSKe<T> {
    private int E, V;
    public LinkedList<T>[] graph;
    public DSKe() {
    }
    public DSKe(int V) {
        this.V = V;
        graph= new LinkedList[V];
        for (int i=0; i<V; i++)
            graph[i]=new LinkedList<T>();
    }
    public void addEdge(int source, T destinate){
        graph[source].add(destinate);
    }
    public void view(){
        for(int i=0; i< graph.length; i++){
            System.out.print(i+" -> ");
            graph[i].forEach((entity)->{
                System.out.print(entity+" ");
            });
            System.out.println("");
        }
    }
    public void readFile(String path) {
        try {
            Path filePath= Paths.get(path);
            List<String> graphString= Files.readAllLines(filePath);
            for(int i=0; i< graphString.size(); i++){
                System.out.println(graphString.get(i));
            }
            Integer k= Integer.parseInt(graphString.get(0).trim());
            this.V = k;
            graph= new LinkedList[k];
            for (int i=0; i<k; i++)
                graph[i]=new LinkedList<T>();
            for(int i=1; i< graphString.size(); i++){
                String[] GraphElement= graphString.get(i).split(" ");
                for(int j=0; j< GraphElement.length;j++){
                    k= Integer.parseInt(GraphElement[j].trim());
                    graph[i-1].add((T)k);
                }
            }
            
        } catch (Exception e) {
            System.err.println("!!!READ FAIL!!!");
        }
        System.out.println("!!!READ SUCCESSFULL!!!");
    }
    public static void main(String[] args) {
        DSKe newGraph= new DSKe();
        String path= Paths.get("").toAbsolutePath().toString();
        newGraph.readFile(path+"/src/resource/DSKe.txt");
        newGraph.view();
    }
}
