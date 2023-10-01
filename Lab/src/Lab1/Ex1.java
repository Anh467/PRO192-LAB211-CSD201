
package Lab1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int numRow, numColumn;
        Scanner ip= new Scanner(System.in);
        System.out.print("Enter number of row: ");
        numRow= ip.nextInt();
        System.out.print("Enter number of column: ");
        numColumn= ip.nextInt();
        System.out.println("Number of row: "+numRow);
        System.out.println("Number of column: "+numColumn);
    }
}
