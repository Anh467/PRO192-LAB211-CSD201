/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.awt.geom.Area;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

/**
 *
 * @author 84384
 */
public class sortQueue {
    public static int max(int a[]){
        int max= -100000000;
        for(int i=0; i< a.length; i++)
            if(max<a[i])
                max=a[i];
        int min= 0;
        for(int i=0; i< a.length; i++)
            if(min<a[i])
                min=a[i];
        if(String.valueOf(max).length()>String.valueOf(-1*min).length())
            return String.valueOf(max).length();
        return String.valueOf(-1*min).length();
    }
    public static void radixSprt(int a[]){
        Queue<Integer>[]q= new LinkedList[20];
        int num=1;
        int d= max(a);
        for(int i=0; i< d; i++){
            for(int j=0; j<= 19; j++)
                q[j]= new LinkedList();
            for(int k= 0; k< a.length; k++){
                if(a[k]>=0)
                    q[a[k]/num%10].add(a[k]);
                else {
                    q[10+(-a[k]/num%10)].add(a[k]);
                }
            }
            num= num*10;
            int n=0;
            for(int j=19; j>=10; j--)
                while(!q[j].isEmpty())
                    a[n++]=q[j].remove();
            for(int j=0; j<=9; j++)
                while(!q[j].isEmpty())
                    a[n++]=q[j].remove();
            System.out.println(Arrays.toString(a));
        }
        
    }
    public static void main(String[] args) {
        int[]a= {71,1,31,-20,51,-11,-110,11,31,7,20};
            radixSprt(a);
    }
}
