package j1.s.p0074;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    
   
    public static Double dNumber (String num){
        try {
            double n= Double.parseDouble(num);
            return n;
        } catch (NumberFormatException e) {
            return null;
        }
    }
    public static Integer iNumber (String num){
        try {
            int n= Integer.parseInt(num);
            return n;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
