//Sàn nguyên tố
//Tìm có bao nhiêu nguyên tố trong n
package prime;

import java.util.Scanner;

public class snt {
    public static boolean[] check= new boolean[2000];
    public static void snt(int i, int n){
        int j= 1;
        do{
            j++;
            check[j*i]= true;
        }while((i*j)<= n);
        
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n, j= 0;
        System.out.print("Enter number:");
        n= sc.nextInt();
        System.out.println("prime number");
        for(int i=2; i<= n; i++)
            if(check[i]==false){
                System.out.println(i);
                snt(i, n);
                j++;
            }
        System.out.println("number prime= "+j);
    }
}
