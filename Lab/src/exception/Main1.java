package exception;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws WebAddressException {
        Scanner sc = new Scanner(System.in);
        CheckWebAddress check = new CheckWebAddress();

        System.out.print("Enter a web address: ");
        String web = sc.nextLine();

        check.checkWebAddress(web);
        System.out.print(web + " is valid.");
    }
}
