/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author 84384
 */
public class Ex4 {
    public static void main(String[] args) {
        Scanner ip= new Scanner(System.in);
        int n;
        System.out.println("Enter the number of array:");
        n= ip.nextInt();
        System.out.print("Array: [");
        for(int i= 1; i<=n; i++){
           if(i!= n){
                double numDraft= Math.random();
                numDraft= numDraft * 99 + 1;
                int numRandom= (int)numDraft;
                System.out.format("%d, ",numRandom);
           }
           else{
               double numDraft= Math.random();
               numDraft= numDraft * 99 + 1;
               int numRandom= (int)numDraft;
               System.out.format("%d]",numRandom);
           }
        }
    }
}
