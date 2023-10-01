package p0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class manager { 
    private static void createStudent(ArrayList<Student> ls) {
        while (true) {
            System.out.println("=====Managerment Student Program=====");
            System.out.print("Name: ");
            String name = validation.checkInputString();
            System.out.print("Classes: ");
            String className = validation.checkInputString();
            System.out.print("Maths: ");
            double math = validation.checkInputMark("Maths");
            System.out.print("Chemistry: ");
            double chemistry = validation.checkInputMark("Chemistry");
            System.out.print("Physics: ");
            double physics = validation.checkInputMark("Physics");
            double average = (math + chemistry + physics) / 3;
            char type;
            if (average > 7.5) {
                type = 'A';
            } else if (average >= 6 && average <= 7.5) {
                type = 'B';
            } else if (average >= 4 && average < 6) {
                type = 'C';
            } else {
                type = 'D';
            }
            ls.add(new Student(name, className, math, physics, chemistry, average, type));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (!validation.checkYN()) {
                return;
            }
        }
    }

    private static void displayInformationStudent(ArrayList<Student> ls) {
        int i = 0;
        for (Student mem : ls) {
            System.out.println("===========Student " + (++i) + " info==============");
            System.out.println("Name: " + mem.getStudentName());
            System.out.println("Classes: " + mem.getClassName());
            System.out.println("AVG: " + mem.getAverage());
            System.out.println("Type: " + mem.getType());
        }
    }

    private static HashMap<String, Double> getPercentTypeStudent(List<Student> ls) {
        HashMap<String, Double> getPercentTypeStudent = new HashMap<>();
        int totalStudent = ls.size();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        for (int i = 0; i < totalStudent; i++) {
            if (ls.get(i).getType() == 'A') {
                typeA++;
            }
            if (ls.get(i).getType() == 'B') {
                typeB++;
            }
            if (ls.get(i).getType() == 'C') {
                typeC++;
            }
            if (ls.get(i).getType() == 'D') {
                typeD++;
            }
        }
        getPercentTypeStudent.put("A", typeA / totalStudent * 100);
        getPercentTypeStudent.put("B", typeB / totalStudent * 100);
        getPercentTypeStudent.put("C", typeC / totalStudent * 100);
        getPercentTypeStudent.put("D", typeD / totalStudent * 100);
        return getPercentTypeStudent;
    }

    private static void display() {
        ArrayList<Student> ls = new ArrayList<>();
        createStudent(ls);
        displayInformationStudent(ls);
        HashMap<String, Double> getPercentTypeStudent = getPercentTypeStudent(ls);
        for (Map.Entry student : getPercentTypeStudent.entrySet()) {
            System.out.println(student.getKey() + " :" + student.getValue() + "%");
        }
    }

    public static void main(String[] args) {
        display();
    }

}
