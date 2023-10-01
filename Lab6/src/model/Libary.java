/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import model.Book;
import exception.*;
import java.nio.file.Paths;
import view.*;
public class Libary {
    
    public static String str= Paths.get("").toAbsolutePath().toString();
    public static String path=str+"/src/model/lib.txt";    
    public static  ArrayList<Book> bookList= new ArrayList<>();    
    public void readFile(){
        bookList.addAll(FileIO.readFile(path));  
    }
    
    public void print(){
        bookList.forEach((t) -> {
            System.out.println(t.toString());
        });
    }
    
    public void searchID(){
        int count= 0;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter ID: ");
        String str= sc.nextLine();
        System.out.println("List of book");
        System.out.println("---------------");
        for(int i=0; i< bookList.size(); i++)
            if(str.equalsIgnoreCase(bookList.get(i).getBookID())){
                System.out.println(bookList.get(i).toString());
                count++;
            }
        System.out.println("---------------");
        if(count == 0)
            System.out.println("Non exist with ID "+str);
        else if(count ==1)
            System.out.println("Total: "+count+" book");
        else System.out.println("Total: "+count+" books");
    }
    
    public void searchYear(){
        int count= 0;
        Scanner sc= new Scanner(System.in);
        int str=0;
        while(true){
        try {
            System.out.print("Enter Year: ");
            str= sc.nextInt();
            if(str<=0) throw new CheckValidNum("!!!YEAR MUST BE POSITIVE!!!");
            if(str>2022) throw new CheckValidNum("!!!OUT OF CURRENT YEAR!!!");
            System.out.println("List of book");
            System.out.println("---------------");
            for(int i=0; i< bookList.size(); i++)
                if(str==bookList.get(i).getYear()){
                    System.out.println(bookList.get(i).toString());
                    count++;
                }
            System.out.println("---------------");
            if(count == 0)
                System.out.println("Non exist with Year "+str);
            else if(count ==1)
                System.out.println("Total: "+count+" book");
            else System.out.println("Total: "+count+" books");
            break;
        } catch(CheckValidNum e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println("Year wrong format");
        }
        }
        
    }
    
    public void searchTitle(){
        int count= 0;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Title: ");
        String str= sc.nextLine();
        System.out.println("List of book");
        System.out.println("---------------");
        for(int i=0; i< bookList.size(); i++)
            if(bookList.get(i).getBookTitle().toLowerCase().contains(str.toLowerCase())){
                System.out.println(bookList.get(i).toString());
                count++;
            }
        System.out.println("---------------");
        if(count == 0)
                System.out.println("Non exist with Title "+str);
        else if(count ==1)
            System.out.println("Total: "+count+" book");
        else System.out.println("Total: "+count+" books");
    }
    
    public void searchAuthor(){
        int count= 0;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Author: ");
        String str= sc.nextLine();
        System.out.println("List of book");
        System.out.println("---------------");
        for(int i=0; i< bookList.size(); i++)
            if(bookList.get(i).getBookAuthor().toLowerCase().contains(str.toLowerCase())){
                System.out.println(bookList.get(i).toString());
                count++;
            }
        System.out.println("---------------");
        if(count == 0) System.out.println("Non exist with Author "+str);
        else if(count == 1) System.out.println("Total: "+count+" book");
        else System.out.println("Total: "+count+" books");
    }
    
    public int findID(String ID){
        for(int i=0; i< bookList.size(); i++)
            if(ID.equalsIgnoreCase(bookList.get(i).getBookID()))
                return i;
        return -1;
    }
    
    public void insertBook(){
        String ID, author, name;
        int year;
        Method method= new Method();
        try {
            Scanner sc= new Scanner(System.in);
            while(true){
                try {
                    System.out.print("Enter ID: ");
                        ID= sc.nextLine();
                    if(method.checkID(ID.trim())==false) throw new CheckValidNum("!!!ID wrong foramt. ex ID: /B0001/");
                    break;
                } catch(CheckValidNum e){
                    System.out.println(e.getMessage());
                }catch (Exception e) {
                    System.out.println("!!!ID wrong format!!!");
                }
            }
            
            if(findID(ID)==-1){
            System.out.print("Enter author: ");
                author= sc.nextLine();
            author= method.standardStatic(author.toLowerCase());
            System.out.print("Enter name: ");
                name= sc.nextLine();
            name= method.standardStatic(name.toLowerCase());
            while(true){
                try {
                    System.out.print("Enter year: ");
                    year= Integer.parseInt(sc.nextLine());
                    if((year>2022)||(year<=0)) throw new CheckValidNum("!!!OUT OF THE CURRENT YEAR!!!");
                    break;
                }catch(CheckValidNum e){
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("year wrong format");
                }
            }
            bookList.add(new Book(ID.toUpperCase(), name, author, year));
        }
        else System.out.println("ID already exist");
        } catch (Exception e) {
        }
        
    }
    
}
