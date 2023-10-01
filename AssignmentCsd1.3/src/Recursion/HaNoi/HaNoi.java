
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursion.HaNoi;

/**
 *
 * @author 84384
 */
public class HaNoi {
    public static void ThapHaNoi(int n, char a, char b, char c){
        if(n==1) System.out.println(a+" -> "+b);
        else{
            ThapHaNoi(n-1, a, c, b);
            ThapHaNoi(1, a, b, c);
            ThapHaNoi(n-1 , c, b, a);
        }
    }
    public static void ThapSaiGon(int n, char a, char b, char c, char d){
        if(n<=0) System.out.print("");
        else
        if(n==1) System.out.println(a+" -> "+d);
        else{
            ThapSaiGon(n/2, a, d, c, b);
            ThapSaiGon(n-n/2-1, a, b, d, c);
            ThapSaiGon(1, a, b, c, d);
            ThapSaiGon(n-n/2-1, c, b, a, d);
            ThapSaiGon(n/2, b, a, c, d);
        }
    }
    public static void main(String[] args) {
        System.out.println("Thap ha noi:");
        ThapHaNoi(3, 'A','B', 'C');
         System.out.println("Thap sai gon:");
        ThapSaiGon(5, 'A','B', 'C', 'D');
    }
}
