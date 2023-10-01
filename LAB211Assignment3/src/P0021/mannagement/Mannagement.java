/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0021.mannagement;

import P0021.control.Valid;
import P0021.model.*;
import java.util.Scanner;
import P0021.myException.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.util.Arrays;
public class Mannagement {
    public ArrayList<Student> stdList= new ArrayList<>();
    public void readFile(String path){
        String book;
        try {
            FileReader fr= new FileReader(path);
            BufferedReader br= new BufferedReader(fr);
            while((book= br.readLine())!=null){
                String []b= book.split(",");
                b[0]= b[0].toUpperCase().trim();
                b[1]=standard(b[1].trim().toLowerCase());
                b[2]=b[2].trim();
                if(Valid.checkUnique(stdList, b[0], b[1]))
                    if(Valid.checkValid(b[2])){
                    if(Valid.checkSesCourse(stdList, b[0], Integer.parseInt(b[3].trim()), b[2])){
                        stdList.add(new Student(b[0],b[1],b[2],Integer.parseInt(b[3].trim())));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("read loi");
        }
    }
//    public ArrayList<Student> readFile( String path){
//        ArrayList<Student> stdList= new ArrayList<>();
//        String book;
//        try {
//            FileReader fr= new FileReader(path);
//            BufferedReader br= new BufferedReader(fr);
//            while((book= br.readLine())!=null){
//                //System.out.println(book);
//                String []b= book.split(",");
//                stdList.add(new Student(b[0],b[1],b[2],Integer.parseInt(b[3])));
//            }
//        } catch (Exception e) {
//        }
//        return stdList;
//    }
    //lu du lieeuj vao file
    public boolean saveString( String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for(int i=0; i< stdList.size(); i++){
                bw.newLine();    
                bw.write(stdList.get(i).getID()+", "+ stdList.get(i).getName()+", "+stdList.get(i).getCourseName()+", "+stdList.get(i).getSemester());
            }
            bw.close();
            osw.close();
            fos.close();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // lay input choice danh cho 2 lua chon
    public String getChoice(String s1, String s2, String text1, String text2){
        Scanner sc= new Scanner(System.in);
        String agree;
        //truyen s1 s2 de hien 2 lua chon
        System.out.println("Do you want to continue ("+s1+"/"+s2+")?");
        System.out.println("Choose "+s1+" to "+text1+" and " +s2+" to "+text2+".");
            //nhap lua chon cho den khi dung s2 hoac s2
            while(true){
                try {
                    agree= sc.nextLine();
                    //chi duoc chon s1 hoac s2
                    if((!agree.equalsIgnoreCase(s1))&&(!agree.equalsIgnoreCase(s2))) throw new MyException("!!!just choose '"+s1+"' or '"+s2+"'!!!");
                    else break;
                } catch(MyException e){
                    System.out.println(e.getMessage());
                }catch (Exception e) {
                }
            } 
          // khi ki tu nhap vao thoa man s1 hoac s2 thi tra ve lua chon da nhap
          return agree;
    }

    public void mainScreen(String[] option){
        //tile
        System.out.println("WELCOME TO STUDENT MANAGEMENT:");
        // xuat cac lua chon theo thu tu
        for(int i=0; i< option.length; i++)
            System.out.format("%d. %10s\n",i+1, option[i]);
        // hien lua chon
        System.out.print("(Please choose");
        for(int i=0; i< option.length-1; i++)
            System.out.format(" %d to %s,",i+1, option[i]);
        System.out.format(" %d to %s). ",option.length, option[option.length-1]);
    }
    public int getInput(){
        int input;
        Scanner sc= new Scanner(System.in);
        try {
            input= sc.nextInt();
            //neu lua chon khong co se cho nhap lai
            if((input<1)||(input>5)) throw new MyException("!!!INAPPRIOPRIATE OPTION!!!");
            else return input;
        }catch(MyException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
            //bat loi khi nhap sai dinh ang
            System.out.println("!!!INPUT WRONG FORMAT!!!");
        }
        return -1;
    }
    // chuan hoa ten hoac dinh dang
    public String standard(String name){
        // doi sang chuoi char
        char[] charArray= name.toCharArray();
        // viet hoa chu dau
        charArray[0]= Character.toUpperCase(name.charAt(0));
        int length= charArray.length;
        // chay de het chuoi, khi gap dau cach se viet hoa chu tiep theo
        for(int i=1; i< length; i++)
                if(charArray[i]==' '){
                    while(charArray[i+1]==' '){
                        for(int j=i+1; j<length-1; j++)
                            charArray[j]=charArray[j+1];
                        length-=1;
                    }
                    charArray[i+1]= Character.toUpperCase(charArray[i+1]);
                }
        // tra ve chuoi dung
        return String.valueOf(charArray).substring(0, length);
    }
    public void addStudent(){        
        Scanner sc= new Scanner(System.in);
        String ID, name,courseName;
        Check check= new Check();
        int semester;
        // nhap ten sinh vien
        System.out.println("Enter student "+(stdList.size()+1));
        ID= Valid.getInputID();
        System.out.format("     %-10s","Enter name: ");
        name= standard(sc.nextLine().trim().toLowerCase());
        //neu ID va Name khac nhau so voi du lieu da co se xuat loi
        if(Valid.checkUnique(stdList, ID, name)){
            semester= Valid.getInputSemester();
            courseName= standard(Valid.getInputCourse().trim().toLowerCase());
            // ney semester va coursename da co trong id do se xuat ra loi
            if(Valid.checkSesCourse(stdList, ID, semester, courseName))
                stdList.add(new Student(ID, name, courseName, semester));
            else System.out.println("!!!SEMESTER AND COURSENAME INAPROPRIATE!!!");
        }else System.out.println("!!!ID MUST BE UNIQUE!!!");
    }
    //tao lua chon
    public void create(){
        String agree;
        do{
            // tao 3 sinh vien 1 luc
            for(int i=0; i<3; i++)
                addStudent();
                // neu tiep tuc nha Y con muon thoat ra nhan N
                agree= getChoice("Y", "N","continute","return to main screen");
        }while(agree.equalsIgnoreCase("Y"));
    }
    public void findAndSort(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter name student need to find: ");
        // nhap ten can tim
        String nameStudent= sc.nextLine();
        // khoi tao arryList 
        ArrayList<Student> stdListFind= new ArrayList<>();
        // neu ten trong mang phu hop thi them vao thanh phan arrayList vua khoi tao
        for(int i=0; i< stdList.size(); i++)
            if(stdList.get(i).getName().toLowerCase().contains(nameStudent.toLowerCase()))
                stdListFind.add(stdList.get(i));
        // xap sep mang
        Collections.sort(stdListFind);
        System.out.println("After find and sort:");
        //Xuat ra cac thanh phan vua tim
        for(int i=0; i< stdListFind.size(); i++)
            System.out.println(stdListFind.get(i).toString());
    }
    //neu ID ton tai se xuat ra vi tri
    public int findByID(String IDStudent){
        for(int i=0; i< stdList.size(); i++)
            if(IDStudent.compareToIgnoreCase(stdList.get(i).getID())==0)
                return i;
        // khong tim thay se xuat ra -1
        return -1;
    }
    public void updateStdList(String IDStudent){
        Scanner sc= new Scanner(System.in);
        String name;
    // change name
        System.out.print("Enter name for ID "+IDStudent+": ");
        name= standard(sc.nextLine());
        int n= stdList.size();
    // thay doi cac thanh phan trong do
        for(int i=0; i< n; i++)
            if(stdList.get(i).getID().equalsIgnoreCase(IDStudent)){
                String agree, courseName;
                int semester;
                System.out.println("Course:"+stdList.get(i).getCourseName()+". Sesmester: "+stdList.get(i).getSemester());
                System.out.print("Do you update this information of "+IDStudent+": ");
                agree= getChoice("Y", "N","continute","return to main screen");
                if(agree.equalsIgnoreCase("y")){
                    stdList.remove(i);
                    i--;
                    n--;
                    while (true) {                        
                        semester= Valid.getInputSemester();
                        courseName= standard(Valid.getInputCourse().trim().toLowerCase());
                        if(Valid.checkSesCourse(stdList, IDStudent, semester, courseName)){
                            stdList.add(new Student(IDStudent, name, courseName, semester));
                            break;
                        }
                        else System.out.println("!!!SEMESTER AND COURSENAME INAPROPRIATE!!!");
                    }
                }
            }
    }
    public void modifyStudent(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter ID student need to modify: ");
        String IDStudent= sc.nextLine();
        int index= findByID(IDStudent);
        if(index==-1)
            System.out.println("We dont have ID "+IDStudent+" in data");
        else{
            String agree= getChoice("U", "D","update","delete");
            if(agree.compareToIgnoreCase("U")==0) updateStdList(IDStudent);
            else {
                    for(int i=0; i< stdList.size(); i++){
                        if(stdList.get(i).getID().equalsIgnoreCase(IDStudent)){
                            stdList.remove(i);
                            i--;
                        }
                    }
                    System.out.println("!!!DELETE SUCCESSFULL!!!");
            }
        }
    }
    public void report(){
        // khoi tao ArrayList dinh dang report
        ArrayList<Report> stdReport= new ArrayList<>();
        // them cac thanh phan vao report
        for(int i=0; i< stdList.size(); i++)
            stdReport.add(new Report(stdList.get(i).getID(), stdList.get(i).getName(), stdList.get(i).getCourseName()));
        // khoi tao map voi key la toString cua report
        Map<String, Integer> map= new HashMap<>();
       
        for(int i=0; i< stdReport.size(); i++)
            if(map.containsKey(stdReport.get(i).toString()))
                 // nhung thanh phan nao da co se lay gia tri cong them 1
                map.replace(stdReport.get(i).toString(), map.get(stdReport.get(i).toString())+1);
            // neu chua co thi se them vao voi key laf toString cua report va gia tri la 1
            else map.put(stdReport.get(i).toString(), 1);
        // xuat ra toString + gia tri value
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey().substring(entry.getKey().indexOf('|')+1)+" | "+entry.getValue());
        }
    }
}
