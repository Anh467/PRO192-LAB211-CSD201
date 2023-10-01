package lab5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

////Address
        Address add1 = new Address("Viet Nam", "Buon Ma Thuot", "Krong Ana", "Hoa Dong");
        Address add2 = new Address("Viet Nam", "Da Nang", "Hoa Xuan", "Trung Luong");
        Address add3 = new Address("Viet Nam", "Da Nang", "Hai Chau", "Hoang Dieu");
        Address add4 = new Address("Viet Nam", "Da Nang", "Thanh Khe", "Tran Cao Van");
        Address add5 = new Address("Viet Nam", "Quy Nhon", "Quy Nhon", "Au Co");
        Address add6 = new Address("Viet Nam", "Da Nang", "Cam Le", "Pham Hung");
        Address add7 = new Address("Viet Nam", "Da Nang", "Hoa Xuan", "Van Tien Dung");
        Address add8 = new Address("Viet Nam", "Da Nang", "Thanh Khe", "Le Do");
        Address add9 = new Address("Viet Nam", "", "Nha Trang", "Mai Hac De");
        Address add10 = new Address("Viet Nam", "Tam Ky", "Tam Ky", "Phu Dong");

        //Student IT
        StudentIT it1 = new StudentIT("Phat", add1, 7.5, 9.2);
        StudentIT it2 = new StudentIT("Dung", add2, 8.9, 10);
        StudentIT it3 = new StudentIT("Toan", add3, 5.6, 8.8);
        StudentIT it4 = new StudentIT("Y", add4, 6.5, 7);
        StudentIT it5 = new StudentIT("Nhi", add5, 4.5, 8.8);

        //Student Biz
        StudentBiz biz1 = new StudentBiz("Tuong", add6, 7.3, 6.4);
        StudentBiz biz2 = new StudentBiz("Trung", add7, 5.5, 7.7);
        StudentBiz biz3 = new StudentBiz("Viet", add8, 9.6, 7.9);
        StudentBiz biz4 = new StudentBiz("Duy", add9, 7, 6.8);
        StudentBiz biz5 = new StudentBiz("Vuong", add10, 8.8, 9.9);

        //Student IT
        ArrayList<StudentIT> list = new ArrayList<>();
        list.add(it1);
        list.add(it2);
        list.add(it3);
        list.add(it4);
        list.add(it5);

        //Student Biz
        ArrayList<StudentBiz> list0 = new ArrayList<>();
        list0.add(biz1);
        list0.add(biz2);
        list0.add(biz3);
        list0.add(biz4);
        list0.add(biz5);
        System.out.println("Medium Score");
        for (StudentIT o : list) {
            System.out.println(o.mediumScore());
        }
        for (StudentBiz o : list0) {
            System.out.println(o.mediumScore());
        }
        System.out.println("Student Information");
        for (StudentIT o : list) {
            System.out.println(o);
        }
        for (StudentBiz o : list0) {
            System.out.println(o);
        }

        System.out.println("sort by name IT Students");
        Collections.sort(list, new Comparator<StudentIT>() {
            @Override
            public int compare(StudentIT sv1, StudentIT sv2) {
                return sv1.getFullName().compareToIgnoreCase(sv2.getFullName());
            }
        });
        for (StudentIT o : list) {
            System.out.println(o);
        }

        System.out.println("sort by name Biz Students");
        Collections.sort(list0, new Comparator<StudentBiz>() {
            @Override
            public int compare(StudentBiz sv1, StudentBiz sv2) {
                return sv1.getFullName().compareToIgnoreCase(sv2.getFullName());
            }
        });
        for (StudentBiz o : list0) {
            System.out.println(o);
        }
        System.out.println("Count students in the same city");

    }

}
