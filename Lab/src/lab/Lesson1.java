
package lab;

import java.util.Scanner;

public class Lesson1 {
    static String student_name;

    public static String upper_name(String student_name){
        student_name= student_name.trim();
        char[] student_draft= student_name.toCharArray();
        student_draft[0]= Character.toUpperCase(student_draft[0]);
        for(int i= 1; i<student_name.length(); i++){
            if (student_draft[i]== ' '){
                student_draft[i+1]= Character.toUpperCase(student_draft[i+1]);
            }
        }
        student_name= String.valueOf(student_draft);
        return student_name;
    }
    public static void main(String[] args) {
        float student_score;
        Scanner ip= new Scanner(System.in);
        System.out.print("Enter student name: ");
        student_name= ip.nextLine();
        System.out.print("Enter average score: ");
        student_score= ip.nextFloat();
        //student_name= upper_name(student_name);
        System.out.format("<<%s>><<%.3f>>\n",student_name,student_score);
    }
}
