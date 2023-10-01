
package Lab1;

import java.util.Scanner;


public class Ex2 {
    public static void main(String[] args) {
    int numRow, numColumn;
    int[][] matrix= new int[50][50];
    Scanner ip= new Scanner(System.in);
    System.out.print("Enter number of row: ");
    numRow= ip.nextInt();
    System.out.print("Enter number of column: ");
    numColumn= ip.nextInt();
    System.out.println("Number of row: "+numRow);
    System.out.println("Number of column: "+numColumn);
    for(int i=1; i<= numRow; i++)
        for(int j=1; j<= numColumn; j++){
            System.out.print("Enter maxtrix ["+i+"]["+j+"]:");
            matrix[i][j]= ip.nextInt();
        }
    
    System.out.println("The matrix:");
    for(int i=1; i<= numRow; i++){
        for(int j=1; j<= numColumn; j++)
            System.out.print(matrix[i][j]+" ");
        System.out.println();
        }
    }
}
