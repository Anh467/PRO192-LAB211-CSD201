
package Lab1;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        String str;
        char[] chr= new char[200];
        System.out.println("Enter a string :");
        Scanner ip= new Scanner(System.in);
        str= ip.nextLine();
        System.out.println("List of words :");
        str = str.trim();
        chr= str.toCharArray();
        for(int i=0; i< str.length(); i++){   
            if (chr[i]==' '){
                System.out.print(", ");
            }
            else
                System.out.print(chr[i]);
        }
    }
}
