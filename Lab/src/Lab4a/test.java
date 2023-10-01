
package Lab4a;

import java.util.ArrayList;
import java.util.Collections;


public class test {
    public static void main(String[] args) {        

            Person p = new Student("nguyen anh viet", 23," 99 tran lu ", 10);
            System.out.println("Object p1: "+p);    
            p.doing();
       
        p = new Teacher("nguyen anh viet", 70,"99 tran lu", 20000);
        System.out.println("Object p2: "+p);
         p.doing();
         ((Teacher)p).evalue();
         ArrayList<Teacher> teaList = new ArrayList<Teacher>();
         teaList.add(new Teacher("nguyen hoang anh", 70,"99 tran lu", 2000000) );
         teaList.add(new Teacher("nguyen anh viet", 80,"99 tran lu", 60000) );
         teaList.add(new Teacher("nguyen tan ", 40,"99 tran lu", 90000) );
         System.out.println("\ntruoc khi sap xep: ");  
         for (Teacher t : teaList) 
               System.out.println(t);
//Collections.sort(teaList);
        teaList.sort((Teacher o1, Teacher o2)->{
                return Integer.compare(o1.getAge(), o2.getAge());
            });
         System.out.println("\nsau khi sap xep theo tuoi: "); 
         for (Teacher t : teaList) 
             System.out.println(t);
//sỏrt
        teaList.sort((Teacher o1, Teacher o2) -> {
            return Double.compare(o1.getSalary(), o2.getSalary());
        });
//print
        System.out.println("\nsau khi sap xep theo salary: "); 
        teaList.forEach((Teacher t) -> {
            System.out.println(t);
        });
}
}
