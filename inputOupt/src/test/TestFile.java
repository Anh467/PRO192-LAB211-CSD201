package test;

import java.util.ArrayList;

import io.FileIO;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import model.Student;

public class TestFile {
    
    public static void testJavaFile() {
        ArrayList<Student> stuList = new ArrayList<>();
        stuList.add(new Student("DE160170", "vietnade160170@gmail.com", 7.6, "Nguyen Anh Viet", "Quang Ngai", "08-07-2002", true));
        stuList.add(new Student("DE160121", "khanhnade160170@gmail.com", 9.6, "Nguyen Anh Khanh", "Quang Nam", "01-02-2002", true));
        stuList.add(new Student("De170140", "duyennade160170@gmail.com", 5.6, "Nguyen Ky Duyen", "Quang Hue", "11-05-2001", false));
        stuList.add(new Student("DE160192", "hungnade160170@gmail.com", 4.6, "Nguyen Anh Hung", "Quang Nam", "05-01-2002", true));
        stuList.add(new Student("DE120170", "ngocnade160170@gmail.com", 5.7, "Nguyen Hoang Ngoc", "Ha noi", "05-11-2002", false));
        if (FileIO.saveFile(stuList, "C:\\Users\\84384\\Documents\\NetBeansProjects\\inputOupt\\src\\file\\Student.txt"))
            System.out.println("Save file successfully.");
        else 
            System.out.println("Save file fail.");
    }
    public static void main(String[] args){
//        testJavaFile();
//        FileIO.getFile("C:\\Users\\84384\\Documents\\NetBeansProjects\\inputOupt\\src\\file\\Student.txt");
//read  
        
        ArrayList<Student> stuList1 = new ArrayList<>();
        try {
            String name="",address="", birth="", ID="", mail="";
            boolean gender=true;
            double mark;
            FileInputStream fos = new FileInputStream("C:\\Users\\84384\\Documents\\NetBeansProjects\\inputOupt\\src\\file\\Student.txt");
            InputStreamReader osw = new InputStreamReader(fos);
            BufferedReader bw = new BufferedReader(osw);
            String line= bw.readLine();
            while(line!=null){
                int count=0,i, j=0;
                for(i=0;i<line.length();i++){
                    if(line.charAt(i)=='/'){
                        count++;
//                        System.out.println("count="+count);
//                        System.out.println("name="+line.substring(j,i));
                        switch(count){
                            case 1: name= line.substring(j,i);                                   
                                    break;
                            case 2: address= line.substring(j,i);  
                                    break;
                            case 3: birth= line.substring(j,i);
                                    break;
                            case 4: gender=Boolean.parseBoolean(line.substring(j,i));    
                                    break;
                            case 5: ID= line.substring(j,i);         
                                    break;
                            case 6: mail= line.substring(j,i);                                   
                                    break;        
                        }
                        if(count==6)
                            break;
                        j= i+1;  
                    }
                }   
                mark=Double.parseDouble(line.substring(i+1,line.length()));
                stuList1.add(new Student(ID, mail, mark, name, address, birth, gender));
                
                line= bw.readLine();
            }
            
        fos.close();
        osw.close();
        bw.close();                 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        stuList1.forEach((Student t) -> {
            System.out.println(t.toString());
        });
    }
}
