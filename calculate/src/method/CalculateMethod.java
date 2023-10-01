package method;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 84384
 */
public class CalculateMethod {
// tru 2 so lon
    private static String divide(String s1, String s2, boolean check){
        if(s1=="") return "";
        
        if(compare(s1, s2)<0) 
            if(check==false) return "0";
            else return "";
        if(compare(s1, s2)==0) return "1";
        String s="";
        int i= -1;
        while(compare(s, s2)<0){
            //System.out.println(s+" "+s1+" "+s2+" "+i);
            s= s+ s1.charAt(0);
            s1= s1.substring(1);
            i++;
            //if(i>=s1.length()) break;
            //System.out.println(s+" "+s2+" compare: "+compare(s, s2));
        }
        int ss= 0;
        do{
            if(compare(s, s2)>=0){
                s= minus(s, s2);
                ss++;
                //System.out.println("ss: "+ss);
            }
        }while(compare(s, s2)>=0);
//        if(i>=s1.length()-1) s1= "";
//        else s1= s1.substring(i);
        if(ss==0) return "" ;
        return (char)(ss+48)+divide(s+s1, s2, true);
    }
    public static String divide(String s1, String s2){
        s1= Control.standardNum(s1);
        s2= Control.standardNum(s2);
        Character c1='+', c2= '+';
        if(s1.charAt(0)=='-'){
            s1= s1.substring(1);
            c1='-';
        }
        if(s2.charAt(0)=='-'){
            s2= s2.substring(1);
            c2='-';
        }
        if((c1=='-'&&c2=='-')||(c1=='+'&&c2=='+'))
            return divide(s1, s2, false);
        return '-'+divide(s1, s2, false);
    }
// so sanh 2 so lon
    private static int compare(String s1, String s2){
        if(s1.length()>s2.length()) return 1;
        if(s1.length()<s2.length()) return -1;
        return s1.compareTo(s2);
    }

//phep tru
    public static String minus(String s1, String s2, int num){
        if(compare(s1, s2)==0) return "0";
        int m= 0;
        if(s1=="" && s2=="") return "";
        int n1, n2;
        n1= s1.charAt(s1.length()-1)-48;
        if(s2.length()==0) n2= 0;
        else n2= s2.charAt(s2.length()-1)-48;
        //System.out.println(n1+" "+n2+" "+num);
        if(n1-num < n2){
            m= n1+10-num-n2;
            num= 1;
        }else{
            m= n1-num-n2;
            num= 0;
        }
        if(s1.length()<= 1)
            s1="";
        else s1= s1.substring(0, s1.length()-1);
        if(s2.length()<= 1)
            s2="";
        else s2= s2.substring(0, s2.length()-1);
        //System.out.println(n1+" "+n2+" "+m);
         
        return minus(s1, s2, num)+m;
    }
    public static String minus(String s1, String s2){
        s1= Control.standardNum(s1);
        s2= Control.standardNum(s2);
        String str="";
    //-+
        if(s1.charAt(0)=='-'&& s2.charAt(0)!='-'){
            return "-"+sum(s1.substring(1), s2);
        }
    //+-
        if(s1.charAt(0)!='-'&& s2.charAt(0)=='-'){
            return sum(s1, s2.substring(1));
        }
    //--
        if(s1.charAt(0)=='-'&& s2.charAt(0)=='-'){
            str= "-";
            if(compare(s1.substring(1), s2.substring(1))<0){
                str= "";
                String temp= s1;
                s1= s2;
                s2= temp;
            }
            
            return Control.standardNum(str+Control.standardZero(minus(s1.substring(1), s2.substring(1), 0)));
        }
    //++
        //System.out.println("hiuh");
        if(compare(s1, s2)<0){
                str="-";
                String temp= s1;
                s1= s2;
                s2= temp;
            }
            
        return str+Control.standardNum(Control.standardZero(minus(s1, s2, 0)));
    }
//phep nhan
    private static String proDuct(String s1, Character s2, int i){
        
        if(s1.length()== 0){
            if(i==0) return "";
            return ""+i;
        }
        int s= (s1.charAt(s1.length()-1)- 48)* (s2-48)+ i;
        if(s1.length()==1)
            s1= "";
        else s1= s1.substring(0, s1.length()-1);
        return proDuct(s1, s2, s/10)+s%10;
    }
    private static String proDuct(String s1, String s2,  int unit){
        if(s2=="") return  "0";
        String unti0="";
        for(int k= 0; k< unit; k++)
            unti0= unti0+"0";
        String product= proDuct(s1, s2.charAt(s2.length()-1), 0)+unti0;
        if(s2.length()==1) s2="";
        else s2= s2.substring(0, s2.length()-1);
        return sum(proDuct(s1, s2, ++unit), product);
    }
    public static String proDuct(String s1, String s2){
        s1= Control.standardNum(s1);
        s2= Control.standardNum(s2);
        String firstString;
        if((s1.charAt(0)=='-'&& s2.charAt(0)=='-')||(s1.charAt(0)!='-'&& s2.charAt(0)!='-'))
            return proDuct(s1, s2, 0);
        if(s1.charAt(0)=='-')
            return "-"+proDuct(s1.substring(1), s2, 0);
        return "-"+proDuct(s1, s2.substring(1), 0);
    }
//phep cong
    private static String  sum(String s1, String s2, int i){
        int n1, n2;
        if(s1==""&& s2==""){
            if(i!=0)
                return ""+i;
            return "";
        }
        if(s1.length()!=0)
            n1= s1.charAt(s1.length()-1)-48;
        else n1= 0;
        if(s2.length()!=0)
            n2= s2.charAt(s2.length()-1)-48;
        else n2= 0;
        int s= n1+n2+i;      
        if(s1.length()<= 1)
            s1="";
        else s1= s1.substring(0, s1.length()-1);
        if(s2.length()<= 1)
            s2="";
        else s2= s2.substring(0, s2.length()-1);
        return sum(s1, s2, s/10)+Integer.toString(s%10);
    }
    public static String sum(String s1, String s2){
        if(!Control.checkIsNum(s1)) return null;
        if(!Control.checkIsNum(s2)) return null; 
        s1= Control.standardNum(s1);
        s2= Control.standardNum(s2);
    //--
        if(s1.charAt(0)=='-'&&s2.charAt(0)=='-') return '-'+sum(s1.substring(1), s2.substring(1), 0);
    //+-
        if(s1.charAt(0)!='-'&&s2.charAt(0)=='-') return minus(s1, s2.substring(1));
    //-+
        if(s1.charAt(0)=='-'&&s2.charAt(0)!='-') return minus(s2, s1.substring(1) );
    //++
        return sum(s1, s2, 0);
    }
//phep mu
    public static String powerOf(String s, String n){
        if(n=="0" || n.charAt(0)=='-') return "1";
        return proDuct(powerOf(s, minus(n, "1")), s);  
    }
    public static void main(String[] args) {
        CalculateMethod cal= new CalculateMethod();
        System.out.println("sum: "+ cal.sum("17", "-30"));
        System.out.println("product: "+cal.proDuct("4444444444444445", "5555555555555555"));
        //5736339089664
        //5736339089664
        System.out.println("minus: "+cal.minus("18", "17" ));
        System.out.println("hi");
        System.out.println("power of: "+cal.powerOf("3", "3" ));
        System.out.println("divide of: "+cal.divide("727", "31" ));
    }
}
