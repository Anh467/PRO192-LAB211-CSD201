package j1_s_p0056;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    private static Scanner sc = new Scanner(System.in);
    private static Pattern pattern;
    private Matcher matcher;

    public static int inputInt(String msg, int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]. Enter again.");
            }
        }
    }
    
    public static double inputDouble(String msg, int min) {
        //loop until user input correct
        while (true) {
            try {
                System.out.print(msg);
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result <= min) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number bigger than " + min + ". Enter again.");
            }
        }
    }

    public static String inputStr(String msg) {
        while(true){
            System.out.print(msg);
            String data = sc.nextLine().trim();
            if(!data.isEmpty())
                return data;
            else
                System.out.println("Empty. Enter again.");
        }
    }

    public static String inputNonBlankStr(String msg) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (data.length() == 0);
        return data;
    }

    public static String inputPattern(String msg, String pattern) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
            if(!data.matches(pattern)){
                System.out.println("Error. Please enter right form.");
            }
        } while (!data.matches(pattern));
        return data;
    }
    
    //get worker
    public static Worker getWorker(ArrayList<Worker> wk, String id){
        for (Worker worker : wk) {
            if(worker.getId().equals(id.toUpperCase())){
                return worker;
            }
        }
        return null;
    }
    
    //check ID exist
    public static boolean CheckIdExist(ArrayList<Worker> wk, String ID) {
        for (Worker worker : wk) {
            if (worker.getId().equals(ID)) {
                return true;
            }
        }
        return false;
    } 
    
    //chuan hoa ten
    public static String makeNameRight(String s) {
        String st = s;
        st = st.trim().toLowerCase();
        st = st.replaceAll("\\s+", " ");
        String[] temp = st.split(" ");
        st = "";
        for (int i = 0; i < temp.length; i++) {
            st += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                st += " ";
            }
        }
        return st;
    }
    //check user input yes/ no
    public static boolean checkInputYN() {
        //loop until user input correct
        String result;
        do {
            result = sc.nextLine();
            //return true if user input y/Y
            if (result.toUpperCase().equals("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }while(result.toUpperCase().equals("Y") == false || result.toUpperCase().equals("N") == false );
        
        return true;
    }

}
