/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

import graph.DSKe;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import model.DSCanh;
public class Prim {
    public DSKe<Integer> newDSCanh;
    ArrayList<DSCanh> DSCanhList= new ArrayList<>();
    ArrayList<DSCanh> newCanhList= new ArrayList<>();
    int[][] length;
    PriorityQueue<DSCanh> edge= new PriorityQueue<>((o1, o2) -> {
        return o1.getLength().compareTo(o2.getLength());
    });
    int V, E;
    boolean[]node;
    public void make_false(){
        node= new boolean[V];
    }
    public void readFile(String path) {
        try {
            Path filePath= Paths.get(path);
            List<String> graphString= Files.readAllLines(filePath);
            String[] GraphElement= graphString.get(0).split(" ");
            Integer k= Integer.parseInt(GraphElement[0].trim());
            this.V = k;
            k= Integer.parseInt(GraphElement[1].trim());
            this.E= k;
            length= new int[V][V];
            node= new boolean[V];
            for(int i=1; i< graphString.size(); i++){
                String[] Graph= graphString.get(i).split(" ");
                DSCanhList.add(new DSCanh(Integer.parseInt(Graph[0].trim()), Integer.parseInt(Graph[1].trim()), Integer.parseInt(Graph[2].trim())));
                length[Integer.parseInt(Graph[0].trim())][Integer.parseInt(Graph[1].trim())]=Integer.parseInt(Graph[2].trim());
                length[Integer.parseInt(Graph[1].trim())][Integer.parseInt(Graph[0].trim())]=Integer.parseInt(Graph[2].trim());
            }
            
        } catch (Exception e) {
            System.err.println("!!!READ FAIL!!!");
        }
        System.out.println("!!!READ SUCCESSFULL!!!");
    }
   
    public void addEdge(int n){
        for(int i=0; i< DSCanhList.size(); i++)
            if(((int)DSCanhList.get(i).getA())==n||((int)DSCanhList.get(i).getB())==n){
                edge.add(DSCanhList.get(i));
                edge.add(new DSCanh(DSCanhList.get(i).getB(), DSCanhList.get(i).getA(), DSCanhList.get(i).getLength()));
            }
    }
    public int sum(ArrayList<DSCanh> newDS){
        int s= 0;
        for(int i=0; i< newDS.size(); i++)
            s+=(int) newDS.get(i).getLength();
        return s;
    }
    public static void main(String[] args) {
        Prim newGraph= new Prim();
    //read file
        String path= Paths.get("").toAbsolutePath().toString();
        newGraph.readFile(path+"/src/resource/DSCanh2.txt");
        newGraph.addEdge(0);
        newGraph.node[0]=true;
        //System.out.println("1");
        while(!newGraph.edge.isEmpty()){
            DSCanh canhDon= newGraph.edge.poll();
            System.out.println(canhDon.toString());
            //System.out.println("node: "+(int)canhDon.getB());
            if(newGraph.node[(int)canhDon.getB()]==true) continue;
            System.out.println("->"+canhDon.toString());
            newGraph.addEdge((int)canhDon.getB());
            newGraph.node[(int)canhDon.getB()]= true;
            newGraph.node[(int)canhDon.getA()]= true;
            newGraph.newCanhList.add(canhDon);
        }
        System.out.println("kq: "+ newGraph.sum(newGraph.newCanhList));
        for(int i= 0; i< newGraph.newCanhList.size(); i++)
            System.out.println(newGraph.newCanhList.get(i).toString());
//        newGraph.changeToDSke(newGraph.DSCanhList);
//        newGraph.newDSCanh.view();
//        for(int i= 0; i< newGraph.V; i++){
//            for(int j= 0; j< newGraph.V; j++)
//                System.out.print(newGraph.length[i][j] +" ");
//            System.out.println("");
//        }
       //"a["+i+"]["+j+"]= "
    }
}
