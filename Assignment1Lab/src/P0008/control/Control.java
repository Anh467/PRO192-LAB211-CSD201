/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0008.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
/**
 *
 * @author 84384
 */
public class Control {
    public static boolean check(String []words, int i){
        return false;
    }
    public static String countWord(String str){
        String[] words = str.split("\\s");
        String string="{";
        ArrayList<String> wordArr= new ArrayList<>();
        for(int i=0; i< words.length; i++)
            wordArr.add(words[i]);
        Collections.sort(wordArr, (o1, o2) -> {
            return o1.compareTo(o2);
        });
        for(int i=0; i< wordArr.size(); i++){
            int j=1;
            if(i<wordArr.size()-1)
                while(wordArr.get(i).compareTo(wordArr.get(i+1))==0){
                    j++;
                    i++;
                }
            if(wordArr.get(i).compareTo("  ")!=0)
                string= string+ wordArr.get(i)+"="+j+",";
           // i--;
        }
        return string.substring(0, string.length()-1)+"]";
    }
    public static String countChar(String str){
        int[]a= new int[128];
        for(int i= 0; i<str.length(); i++)
            a[(int) str.charAt(i) ]++;
        String string="";
        for(int i= 1; i<128; i++)
            if(i!=32)
            if(a[i]>0)
                string= string+ ((char) i)+"="+a[i]+",";
        
        return "{"+string.substring(0, string.length()-1)+'}';
    }
    public static void count(String str){
        System.out.println(countChar(str));
        System.out.println(countWord(str));
    }
}
