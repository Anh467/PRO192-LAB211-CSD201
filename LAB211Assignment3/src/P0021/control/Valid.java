/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0021.control;
import P0021.model.*;
import P0021.myException.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Valid {
//   public static boolean contain(ArrayList<Student> stdList, String ID){
//        for(int i=0; i< stdList.size(); i++)
//            if(ID.equalsIgnoreCase(stdList.get(i).getID()))
//                    return true;
//        return false;
//    }

//kiem tra xem ID va ten co khac nhau khong
    public static boolean checkUnique(ArrayList<Student> stdList, String ID, String name){
        for(int i=0; i< stdList.size(); i++)
            //return false khi co id va nam khac nhau
            if(ID.equalsIgnoreCase(stdList.get(i).getID())&&(!name.equalsIgnoreCase(stdList.get(i).getName())))
                return false;
        // return true cac truong hop con lai
        return true;
    }
// kiem tra 2 khoa semester va coursename co bi trung voi nhau khong
    public static boolean checkSesCourse(ArrayList<Student> stdList, String ID, int semester, String courseName){
        for(int i=0; i< stdList.size(); i++)
            if(ID.equalsIgnoreCase(stdList.get(i).getID())){
                // neu  khong thoa man tra ve false
                if(courseName.equalsIgnoreCase(stdList.get(i).getCourseName())&&(semester==stdList.get(i).getSemester()))
                    return false;
            }
        //con lai tra ve true
        return true;
    }
// lay nhap ID
    public static String getInputID(){
        Check check= new Check();
        Scanner sc= new Scanner(System.in);
        String ID;
        while(true){
            try {
                System.out.format("     %-10s","Enter ID: ");
                // nhap
                ID= sc.nextLine();
                // neu khong dung định dạng sẽ xuất lỗi và nhập lại đến khi không lỗi
                if(!check.checkID(ID)) throw new MyException("!!!ID WRONG FORMAT(ex: DE160170)!!!");
                // định dạng đúng sẽ trả về ID
                else return ID;
            } catch(MyException e){
                System.out.println(e.getMessage());
                System.out.println("Try again");
            }catch (Exception e) {
            }
        }
    }
    public static int getInputSemester(){
        Scanner sc= new Scanner(System.in);
        int semester;
        while(true){
            try {
                System.out.format("     %-10s","Enter semester: ");
                semester= Integer.parseInt(sc.nextLine());
                if(semester<1) throw new MyException("!!!SEMESTER MUS BE POSTIVE!!!");
                else return semester;
            } catch(MyException e){
                System.out.println(e.getMessage());
                System.out.println("Try again");
            }catch (Exception e) {
                System.out.println("!!!WRONG FORMAT!!!");
            }
        }
    }
    public static boolean checkValid(String course){
        if(course.equalsIgnoreCase("java")||course.equalsIgnoreCase(".net")||course.equalsIgnoreCase("C/C++"))
            return true;
        return false;
    }
    public static String getInputCourse(){
        Scanner sc= new Scanner(System.in);
        String course;
        while(true){
            System.out.format("     %-10s","Enter course: ");
            course= sc.nextLine();
            if(!checkValid(course)) System.out.println("!!!INAPPROPRIATE COURSE (Java, .Net, C/C++!!!");
            else return course;
        }
    }
}
