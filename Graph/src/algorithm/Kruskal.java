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
import java.util.Map;
import model.DSCanh;
import algorithm.DSU;
public class Kruskal {
    ArrayList<DSCanh> DSCanhList= new ArrayList<>();
    int V, E;
    public void readFile(String path) {
        try {
            Path filePath= Paths.get(path);
            List<String> graphString= Files.readAllLines(filePath);
            String[] GraphElement= graphString.get(0).split(" ");
            Integer k= Integer.parseInt(GraphElement[0].trim());
            this.V = k;
            k= Integer.parseInt(GraphElement[1].trim());
            this.E= k;
            for(int i=1; i< graphString.size(); i++){
                String[] Graph= graphString.get(i).split(" ");
                DSCanhList.add(new DSCanh(Integer.parseInt(Graph[0].trim()), Integer.parseInt(Graph[1].trim()), Integer.parseInt(Graph[2].trim())));
            }
            
        } catch (Exception e) {
            System.err.println("!!!READ FAIL!!!");
        }
        System.out.println("!!!READ SUCCESSFULL!!!");
    }
    public void view(ArrayList<DSCanh> viewGraph){
        for(int i= 0; i< viewGraph.size(); i++)
            System.out.println(viewGraph.get(i).toString());
    }
    public static void main(String[] args) {
        Kruskal newGraph= new Kruskal();
    //read file
        String path= Paths.get("").toAbsolutePath().toString();
        newGraph.readFile(path+"/src/resource/DSCanh.txt");
    //xuat du lieu vua nhap
        System.out.println("V: "+newGraph.V+" E: "+newGraph.E);
        newGraph.view(newGraph.DSCanhList);
    //dua du lieu vao thuat toan DSU
        DSU dsu= new DSU(newGraph.V, newGraph.E, newGraph.DSCanhList);
    //xuat spanning tree
        System.out.println("KQ:");
        newGraph.view(dsu.getSpanningTree());
    }
}
