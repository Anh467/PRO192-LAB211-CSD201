/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;
import stackandqueue.*;
public class Palindome {
    public static StackLinkedList<Character> toStack(String str){
        StackLinkedList<Character> string= new StackLinkedList<>();
        for(int i=0; i< str.length(); i++)
            string.push(str.charAt(i));
        return string;
    }
    public static String reverse(StackLinkedList<Character> toStack){
        String str="";
        while(!toStack.isEmpty())
            str=str+toStack.pop();
        return str;
    }
    public static boolean check(String str1, String str2){
        return str1.equals(str2);
    }
    public static void main(String[] args) {
        String str="abc";
        StackLinkedList<Character> string= toStack(str);
        String strReverse= reverse(string);
        if(check(str, strReverse))
            System.out.println("Day la chuoi doi xung");
        else System.out.println("Khong la chuoi doi xung");
    }
}
