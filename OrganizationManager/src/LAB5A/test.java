
package LAB5A;

import LAB5A.Person;
import LAB5A.Student;
import LAB5A.Teacher;
import java.util.ArrayList;
import java.util.Collections;


public class test {
    public static void main(String[] args) {        

            ArrayList<Student> teaList = new ArrayList<Student>();
            teaList.add(new Student("Nguyen anh viet", 20,"Quuang Ngai", 2000000) );
            teaList.add(new Student("Nguyen anh viet", 21,"Quuang Ngai", 60000) );
            teaList.add(new Student("Nguyen anh viet", 22,"Quuang Ngai", 90000) );
            System.out.println("\nArray: ");  
            for (Student t : teaList) 
               System.out.println(t);
               Collections.sort(teaList);
        
            System.out.println("\nSort array: "); 
            for (Student t : teaList) 
                System.out.println(t);
    }
    
    
}
