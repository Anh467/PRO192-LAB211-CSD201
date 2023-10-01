/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;
/**
 *
 * @author 84384
 */
public class FileIO {
    public static ArrayList<Book> readFile(String path){
        ArrayList<Book> bookList= new ArrayList<>();
        try {
            FileInputStream fis= new FileInputStream(path);
            InputStreamReader isr= new InputStreamReader(fis);
            BufferedReader bw= new BufferedReader(isr);
            String line= bw.readLine();
            while(line!=null){
                String ID="", name="", author="";
                int year=0;
                int count=0;
                line= line+":";               
                int k= line.indexOf(":");              
                while(k!=-1){
                    ++count;
                    switch(count){
                        case 1: ID=line.substring(0,k);
                                break;
                        case 2: name=line.substring(0,k);
                                break;
                        case 3: author=line.substring(0,k);
                                break;
                        case 4: year=Integer.parseInt(line.substring(0,k));
                                break;        
                    }
                    line= line.substring(k+1);
                    k= line.indexOf(":");
                    
                }
                bookList.add(new Book(ID, name, author, year));
                line= bw.readLine();
            }
            System.out.println("read file successfull");
        } catch (Exception e) {
            System.out.println("read file fail");
        }

        
        return bookList;
    }
}
