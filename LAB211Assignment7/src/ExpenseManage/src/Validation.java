import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    public static final Scanner sc = new Scanner(System.in);

    public static int checkInputLimit(int min, int max){
        while (true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result<min || result> max){
                    throw new NumberFormatException();
                }
                return result;
            }catch (NumberFormatException e){
                System.err.println("Please input number in range [" +min+ "," +max+ "]");
                System.out.println("Enter again: ");
            }

        }
    }

    public static String checkDate(){
        while (true){
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyy");
                Date date = simpleDateFormat.parse(checkInputString());
                return date.toString();
            }catch (Exception e){
                System.err.println("Date to correct format(dd-MMM-yyyy)");
                System.out.println("Enter again: ");
            }
        }
    }

    public static String checkInputString(){
        while (true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.err.println("Not empty");
                System.out.println("Enter again:");
            }else {
                return result;
            }
        }
    }

    public static double checkInputDouble(){
        while (true){
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                return result;
            }catch (Exception e){
                System.err.println("Please input number double");
                System.out.println("Enter again: ");
            }
        }
    }

    public static boolean checkYN(){
        while (true){
            String input = checkInputString();
            if(input.equalsIgnoreCase("Y")) return true;
            if(input.equalsIgnoreCase("N")) return false;
            else {
                System.out.println("Input Y or N");
            }
        }
    }

    public static int checkInputInteger(){
        while (true){
            try{
                int result = Integer.parseInt(sc.nextLine());
                return result;
            }catch (Exception e){
                System.err.println("Please input number");
                System.out.println("Enter again: ");
            }
        }
    }
}
