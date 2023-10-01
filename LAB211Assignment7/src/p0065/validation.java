package p0065;

import java.util.Scanner;

public class validation {

    private static final Scanner sc = new Scanner(System.in);

    public static String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static double getInputDouble(String nameSubject) {
        while (true) {
            try {
                System.out.print(nameSubject+" :");
                double result = Double.parseDouble(sc.nextLine());
                if (result < 0) throw new MyException(nameSubject + " is greater than equal zero");
                if (result > 10) throw new MyException(nameSubject + " is less than equal ten");
                return result;
            } catch (MyException ex) {
                System.err.println(ex.getMessage());
            }catch (NumberFormatException ex) {
                System.err.println(nameSubject + " is digit");
            }
        }
    }

    public static String checkYN(String str) {
        while (true) {
            try {
                System.out.print(str+": " );
                String result = checkInputString();
                if(result.equalsIgnoreCase("N")&&result.equalsIgnoreCase("Y")) throw new MyException("just enter N & Y");
                return result;
            } catch (MyException e) {
                System.err.println(e.getMessage());
            }catch (Exception e) {
            }
        }
    }

}
