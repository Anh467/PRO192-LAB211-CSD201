
package lab;

import java.util.Scanner;
public class Lesson4 {
    public static boolean check_prime(int a){
        if (a<= 1)
            return false;
        if (a== 2)
            return true;
        for(int i= 2; i*i<= a; i++)
            if(a%i== 0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        int a;
        Scanner ip= new Scanner(System.in);
        System.out.print("Enter number :");
        a= ip.nextInt();
        if(check_prime(a))
            System.out.println(a+" is prime number");
        else
            System.out.println(a+" is not prime number");
    }
}
