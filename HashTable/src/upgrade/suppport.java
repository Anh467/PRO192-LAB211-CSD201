/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upgrade;

/**
 *
 * @author 84384
 */
public class suppport {
    public static int prime[]= {7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    public static int UCLN(int a, int b){
        if(a==b)
            return a;
        if(a>b) return UCLN(a-b, b);
        return UCLN(b-a, a);
    }
    public static void main(String[] args) {
        suppport sp= new suppport();
        System.out.println(sp.UCLN(8, 12));
    }
}
