/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
import java.util.ArrayList;
import model.Student;
import model.StudentBiz;
import model.StudentIT;
import io.IO;
public class main {
    public static void main(String[] args) {
        ArrayList<Student> stu= new ArrayList<>();
        stu.add(new StudentBiz("DE160170", "Nguyen Anh Viet", "Quang Ngai", "vietnade160170@fpt.edu.vn", 8, 7.8));
        IO.saveFile(stu, "C:\\Users\\84384\\Documents\\NetBeansProjects\\Assignment\\src\\source\\stu.txt");
    }
}
