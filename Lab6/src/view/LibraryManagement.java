/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import exception.CheckValidNum;
import model.*;
public class LibraryManagement extends Menu<String>{
    static String[] menu={"List all books","Search book","Add new Book","Exit"};
    private Libary lib= new Libary();
    public LibraryManagement(){
        super("Library Mannagement", menu);
    }
    
    @Override
    public void excute() {
        lib.readFile();
        int k=1;
        do {            
            try {
                k= super.getSelect();
                switch (k) {
                    case 1: lib.print();  break;
                    case 2: BookSearching(); break;
                    case 3: lib.insertBook(); break;
                    //default: System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("!!!Selection Wrong Format!!!");
            }
        } while ((k>0)&&(k<4));
    }
    public void BookSearching(){
        String [] mSearch={"Find by ID","Find by Title","Find by Author","Find by Year of publishing"};
        Menu bookSearching= new Menu("Book Searching", mSearch) { 
            @Override
            public void excute() {
                try {
                    int k= super.getSelect();
                    if(((k<1)||(k>4))) throw new CheckValidNum("!!!we dont have "+k+" choice!!!");
                    switch (k) {
                        case 1: lib.searchID();break;
                        case 2: lib.searchTitle();break;
                        case 3: lib.searchAuthor();break;
                        case 4: lib.searchYear();break;
                    }}
                    catch(CheckValidNum e){
                            System.out.println(e.getMessage());
                            }
                catch (Exception e) {
                    System.out.println("!!!Selection Wrong Format!!!");
                }
                
                
            }
        };
        bookSearching.excute();
    }
    
}
