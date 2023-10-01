package p0065;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Manager { 
    ArrayList<Student> ls= new ArrayList<>();
    public void createStudent() {
        while (true) {
            System.out.print("Name: ");
            String name = validation.checkInputString();
            System.out.print("Classes: ");
            String className = validation.checkInputString();
            double math = validation.getInputDouble("Maths");
            double chemistry = validation.getInputDouble("Chemistry");
            double physics = validation.getInputDouble("Physics");
            ls.add(new Student(name, className, math, physics, chemistry));
            if(validation.checkYN("Do you want to enter more student information?(Y/N)").equalsIgnoreCase("N"))
                break;
        }
    }

    public void displayInformationStudent() {
        for (int i=0; i< ls.size(); i++) 
            ls.get(i).view(i+1);
    }

    public HashMap<String, Double> getPercentTypeStudent(List<Student> ls) {
        HashMap<String, Double> getPercentTypeStudent = new HashMap<>();
        getPercentTypeStudent.put("A", 0.0);
        getPercentTypeStudent.put("B", 0.0);
        getPercentTypeStudent.put("C", 0.0);
        getPercentTypeStudent.put("D", 0.0);
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getType() == 'A') 
                getPercentTypeStudent.replace("A", getPercentTypeStudent.get("A")+1);
            if (ls.get(i).getType() == 'B') 
                getPercentTypeStudent.replace("B", getPercentTypeStudent.get("B")+1);
            if (ls.get(i).getType() == 'C') 
                getPercentTypeStudent.replace("C", getPercentTypeStudent.get("C")+1);
            if (ls.get(i).getType() == 'D') 
                getPercentTypeStudent.replace("D", getPercentTypeStudent.get("D")+1);
        }
        return getPercentTypeStudent;
    }

    public void display() {
        displayInformationStudent();
        HashMap<String, Double> getPercentTypeStudent = getPercentTypeStudent(ls);
        for (Map.Entry student : getPercentTypeStudent.entrySet()) {
            System.out.println(student.getKey() + " :" + student.getValue()+ "%");
        }
    }

    public void getData(){
        String path= Paths.get("").toAbsolutePath().toString();
        ls.addAll(Control.readFile(path+"/src/p0065/Student.txt"));
    }
    public void saveDate(){
        String path= Paths.get("").toAbsolutePath().toString();
        Control.saveFile(ls, path+"/src/p0065/Student.txt");
        
    }

}
