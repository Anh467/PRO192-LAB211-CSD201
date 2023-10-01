
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 84384
 */
public class KMP {
    String str, strSub;
    int[] strSubPatterm;
    public KMP(String str, String strSub) {
        this.str = str;
        this.strSub = strSub;
        createPatterm();
        implementKMP();
    }
    public void createPatterm(){
        Map<Character, Integer> mapSubChar= new HashMap<>();
        strSubPatterm= new int[strSub.length()];
        for(int i= 0; i< strSub.length(); i++)
            if(!mapSubChar.containsKey(strSub.charAt(i))){
                
                strSubPatterm[i]= -1;
                mapSubChar.put(strSub.charAt(i), i);
            }else{
                strSubPatterm[i]= mapSubChar.get(strSub.charAt(i));
                mapSubChar.put(strSub.charAt(i), i);
            }
    }
    public void implementKMP(){
        int k= 0;
        for(int i= 0; i< str.length(); i++){
            if(strSub.charAt(k)==str.charAt(i)){ 
                if(k== strSub.length()-1) {
                    System.out.println("match at: "+(i-strSub.length()+1));
                    k= 0;
                }
               ++k;
               continue;
            }
            if(k==0) continue;
            if(strSubPatterm[--k]!=-1)
                k= strSubPatterm[k];
            --i;
        }
    }
    public static void main(String[] args) {
        //ABABDABACDABABCABAB -- ABABCABAB
        //PARPARTICIPATE IN PARACHUTE -- PARTICIPATE IN PARACHUTE
        //ABABDABACDABABCABAB --  AB
        KMP kmp= new KMP("aaaaaabcb", "aaaaabc");
    }
}
