/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursion;
import java.util.Arrays;
import com.sun.source.tree.ContinueTree;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 84384
 */

public class Recursion{
// 1.   Implement the Greatest Common Divisor algorithm as recursive method GCD.
    public static int GCD(int m, int n){
        if(n==0)
            return m;
        if(n>0)
            return GCD(n , m%n);
        return 0;
    }
// 2.   Implement the recursive method power 
    public static double power(double x, int n){
        if(n<=0)
            return 1;
        return x*power(x, n-1);
    }
//3.   Implement the recursive method fact (the factorial)
    public static int fact(int n){
        if(n==1)
            return 1;
        return fact(n-1)*n;
    }
//4.   Implement recursive method fib (the fibonacci)
    public static double fib (int n){
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        return fib(n-1)+fib(n-2);
    }
//5.   Write a recursive method searching the result of the remainder of division (%) of  a and b by using the subtraction only.
    public static int remainderOfDivision(int a, int b){
        if(a-b<0) return a;
        return remainderOfDivision(a-b, b);
    }
//6.   Implement a recursive method finding the result of division (/) of  a and b by using the subtraction only.
    public static int  resultOfDivision(int a, int b){
        if(a-b<0) return 0;
        return 1+resultOfDivision(a-b, b);
    }
//7.   Implement a recursive method that computes 2n by using the sumation only.
    public static int computePowerOf2(int n){
        if(n==0) return 1;
        return computePowerOf2(n-1)+ computePowerOf2(n-1);
    }
//8.  Implement a recursive method that tranforms a number from decimal to binary, octal or hexadecimal.
    public static void decimalToN(int number, int base){
        if(number<base){
            System.out.print(number);
            return;
        }
        int n= number%base;
        String str;
        if(n>=10)
           str= Character.toString((char) (55+n));
        else str= Integer.toString(n);
        decimalToN(number/base, base);
        System.out.print(str);
    }
//9.  Implement a recursive method that reverses a number. For example: n= 1234  4321
    public static void reversesNumber(int n){
        if(n<=0) return;
        System.out.print(n%10);
        reversesNumber(n/10);
    }
//Remove the tail of recursion
// 10.Write a recursive method that computes and returns the sum of all numbers from 1 to n (sum = 1 + 2 + 3 + ... + n), with n is given as parameter. 
// de quy dau
    public static int sumNonTail(int n){
        if(n==1)
            return 1;
        return sumNonTail(n-1)+n;
    }
//7.   Write a recursive method that computes and returns the sum of all elements in an array of integer, with the array and its size are given as parameters.
    public static int findMin(int a[], int n){
        if(n==1)
            return a[0];
        return a[n-1]>findMin(a, n-1)? findMin(a, n-1): a[n-1];
    }
//7.   Write a recursive method that computes and returns the sum of all elements in an array of integer, with the array and its size are given as parameters.
    public static int findSum(int a[], int n){
        if(n==1)
            return a[0];
        return a[n-1]+findSum(a, n-1);
    }
//8.  Write a recursive method that determines whether an array of characters is a palindrome or not?. 
    public static boolean isPalindrome(char[] str, int n){
        if(n==str.length/2)
            return true;
        return (str[n-1]==str[str.length-n])&&(isPalindrome(str, n-1));
    }
//9. BINARY SEARCH: Write a recursive method that searches for a target in a sorted array using binay search algorithm, with the array and its size and the target are given as parameters.
    public static int binary(int[] a, int i, int j, int numFind){
        if(numFind == a[(i+j)/2])
            return (i+j)/2;
        else if(i<j){
            if(numFind > a[(i+j)/2]) return binary(a, ((i+j)/2) +1, j, numFind);
            else if(numFind < a[(i+j)/2]) return binary(a, i, ((i+j)/2) -1, numFind);
        } 
        return -1;
    }
// sum de quy duoi
    public static int sumTail(int n, int sum){
        if(n==1)
            return sum+1;
        return sumTail(n-1, sum+n);
    }
    public static int sumOdd(int n){
        if(n==1)
            return 1;
        if(Integer.toBinaryString(n).charAt(Integer.toBinaryString(n).length()-1)=='0')
            n=n-1;
        return n+sumOdd(n-2);
    }
    public static void main(String[] args) {
        System.out.println("Remove the tail of recursion");
        int []a= {5,8,9,11,-5,20,7};
        System.out.println("Question 10: sum first n number: "+sumNonTail(5));
        System.out.println("array: "+Arrays.toString(a));
        System.out.println("Question 6: minimun in array is: "+findMin(a, a.length));
        System.out.println("Question 7: fin sum in array is: "+findSum(a, a.length));
        String str= "aabbba";
        System.out.println("Array of character: "+str);
        System.out.println("Question 8: check array of character is palindrome or not: "+ isPalindrome(str.toCharArray(), str.length()));
        Arrays.sort(a);
        System.out.println("array: "+Arrays.toString(a));
        System.out.println("Question 9: BINARY SEARCH :"+ binary(a, 0, a.length-1, 11));
    }
}
