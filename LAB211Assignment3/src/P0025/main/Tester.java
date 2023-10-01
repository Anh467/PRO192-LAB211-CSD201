/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0025.main;

import java.nio.file.Paths;
import P0025.fileIO.FileIO;
import P0025.control.Control;
public class Tester {
    public static void main(String[] args) {
        Control control= new Control();
        String str= Paths.get("").toAbsolutePath().toString();
        String path=str+"/src/P0025/model/content.txt"; 
        StringBuffer content = new StringBuffer((new FileIO()).readFile(str+"/src/P0025/model/content.txt"));
        System.out.println(control.standard(content));
        (new FileIO()).saveFile(control.standard(content),str+"/src/P0025/model/saveContent.txt");
    }
}
