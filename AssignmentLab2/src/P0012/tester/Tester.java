/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0012.tester;

/**
 *
 * @author 84384
 */
import P0012.model.*;
import P0012.fileIO.FileIO;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import P0012.cached.*;
import java.util.Date;
import com.sun.jdi.Value;
public class Tester {
    public static ArrayList<Student> stuList= new ArrayList<>();
   
    //public static ArrayList<FuCached> fuCached= new ArrayList<>();
    public static Map<String, FuCached> map= new HashMap<>();
    public static void readFile(){
        String str= Paths.get("").toAbsolutePath().toString();
        String path=str+"/src/P0012/model/student.txt"; 
        FileIO fileIO= new FileIO();
        stuList= fileIO.readFile(path);
    }
    public static boolean putObject(String key, Student stu, long timeToLive){
        Date date= new Date();
        date.setTime(timeToLive+System.currentTimeMillis());
        map.put(key, new FuCached(stu, date));
            return true;
    }
    public static Object getObject(String key){
           FuCached vaule= map.get(key);
           if(System.currentTimeMillis()<vaule.getDate().getTime())
               return vaule.getStu();
           else map.remove(key);
           return null;
    }
    public static boolean clean(String key){
        map.remove(key);
        return true;
    }
    public static boolean cleanCall(String key){
        for(int i= 0; i< map.size(); i++)
            map.remove(key);
        return true;
    }

    /**
     *
     * @return
     */
    public static String view(){
        String str="";
        for (Map.Entry<String, FuCached> entry : map.entrySet()) {
            if(entry.getKey()!= null)
            str+=str+entry.getKey()+"="+ getObject(entry.getKey())+"\n";
        }
        return str;
    }
    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        readFile();
        int j= -2;
        for(int i=0; i< stuList.size(); i++){
            j++;
            putObject(Integer.toString(i), stuList.get(i), j*100);
        }
        System.out.println(view());    
        
    }
}
