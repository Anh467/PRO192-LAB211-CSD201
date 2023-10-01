/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package method;
import java.lang.String;
public class CodeCal {
    int k1, k2;
    int getIntStart(int i, String str){
        for(int j=i-1;j>=0;j--)
            if((str.charAt(j)=='*')||(str.charAt(j)==':')||(str.charAt(j)=='+')||(str.charAt(j)=='-'))
                if(j==0)
                    return j;
                else return j+1;
//        for(int j=i+1;j<str.length();j++)
//            if((str.charAt(j)!='+')||(str.charAt(j)!='-')||(str.charAt(j)!='*')||(str.charAt(j)!=':'))
//                return j;
        return 0;
    }
    String getStart(int i, String str){
        k1=getIntStart(i, str);
System.out.println("k1="+k1+" i="+i);
System.out.println("Str1="+str.substring(k1, i));
        return str.substring(k1, i);
    }
    int getIntEnd(int i, String str){

        for(int j=i+1;j<str.length();j++)
            if((str.charAt(j)=='*')||(str.charAt(j)==':')||(str.charAt(j)=='+')||(str.charAt(j)=='-'))
                return j-1;
        return str.length()-1;
    }
    String getEnd(int i, String str){
        k2=getIntEnd(i, str);
        return str.substring(i+1, k2+1);
    }
    String newString(int i, String str1, String str2, String str){
        
        double d1=Double.parseDouble(str1);
        
        double d2=Double.parseDouble(str2);
        double d=0;
        switch(str.charAt(i)){
            case '*': d=d1*d2;
                      break;
            case ':': d=d1/d2;
                      break;
            case '+': d=d1+d2;
                      break;
            case '-': d=d1-d2;
        }
        System.out.println("d="+d);
//String s = Double.toString(d);
        //System.out.println("str= "+str.substring(0,k1)+d+str.substring(k2+1, str.length()));
        return str.substring(0,k1)+d+str.substring(k2+1, str.length());
    }
    int find1(String str){
        for(int i=0; i< str.length();i++)
            if((str.charAt(i)=='*')||(str.charAt(i)==':'))
                return i;
        return -1;
    }
    int find2(String str){
        for(int i=1; i< str.length();i++)
            if((str.charAt(i)=='-')||(str.charAt(i)=='+'))
                return i;
        return -1;
    }
    public String calculate(String str) {
        String n1, n2, str1, str2;

        boolean bool;
    do{
        bool=false;
        System.out.println("str= "+str);
        int i =find1(str);
        if(i!=-1){
                str1= getStart(i, str);
                str2= getEnd(i, str);
                str= newString(i, str1, str2, str);
                bool=true;
        }
    }while(bool==true);
//chuẩn hóa
    do{
        bool=false;
        System.out.println("str= "+str);
        for(int i=0; i<str.length();i++)
            if((str.charAt(i)=='-')||(str.charAt(i)=='+'))
                if((str.charAt(i+1)=='-')||(str.charAt(i+1)=='+')){
                    if((str.charAt(i)=='-')&&(str.charAt(i+1)=='-'))
                        str=str.substring(0,i)+"+"+str.substring(i+2,str.length());
                    else if ((str.charAt(i)=='-')||(str.charAt(i+1)=='-'))
                        str=str.substring(0,i)+"-"+str.substring(i+2,str.length());
                    else str=str.substring(0,i)+"+"+str.substring(i+2,str.length());
                    bool=true;
                }
                    
    }while(bool==true);
//+ -
    do{
        bool=false;
        
        int i =find2(str);
        if(i!=-1){
                str1= getStart(i, str);
                str2= getEnd(i, str);
                str= newString(i, str1, str2, str);
                bool=true;
        }
    }while(bool==true);
    
 
        return str;
    }
}
