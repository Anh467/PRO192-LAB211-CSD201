
package question3;
import question7.*;
import java.util.Scanner;
import java.util.Stack;
public class Palindrome  {
    public static Stack<Character> toStack(String str){
        Stack<Character> string= new Stack<>();
        for(int i=0; i< str.length(); i++)
            string.push(str.charAt(i));
        return string;
    }
    public static String reverse(Stack<Character> toStack){
        String str="";
        while(!toStack.isEmpty())
            str=str+toStack.pop();
        return str;
    }
    public static boolean check(String str1, String str2){
        return str1.equals(str2);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter String: ");
        String str=sc.nextLine();
        Stack<Character> string= toStack(str);
        String strReverse= reverse(string);
        if(check(str, strReverse))
            System.out.println("Day la chuoi doi xung");
        else System.out.println("Khong la chuoi doi xung");
    }
}
