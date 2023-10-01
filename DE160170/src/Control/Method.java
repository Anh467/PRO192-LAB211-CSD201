package Control;
import java.util.regex.Pattern;
public class Method {
    Pattern patternID= Pattern.compile("^([A-Za-z]{2})([0-9]{6})?$");
    Pattern patternPhone= Pattern.compile("^([0]{1})([9]{1})([0-9]{8})?$");
    Pattern patternMail= Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    public String standard(String str){
        char[] charArray= str.toCharArray();
        charArray[0]= Character.toUpperCase(str.charAt(0));
        int length= charArray.length;
        for(int i=1; i< length; i++)
                if(charArray[i]==' '){
                    while(charArray[i+1]==' '){
                        for(int j=i+1; j<length-1; j++)
                            charArray[j]=charArray[j+1];
                        length-=1;
                    }
                    charArray[i+1]= Character.toUpperCase(charArray[i+1]);
                }
        return String.valueOf(charArray).substring(0, length);
    }
    public boolean checkID(String str){
        if(patternID.matcher(str).find())
            return true;
        return false;
    }
    
    public boolean checkMail(String str){
        if(patternMail.matcher(str).find())
            return true;
        return false;
    }
    public boolean checkPhone(String str){
        if(patternPhone.matcher(str).find())
            return true;
        return false;
    }
}
