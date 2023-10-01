package Lab1;
import java.util.Scanner;
public class Lab1b {
static String[] student_name= new String[150];
static String[] student_grades= new String[150];
static float[] student_mark= new float[150];
static int i, n=0;
    public static int getUserChoice(){
       Scanner ip = new Scanner(System.in);
       int choice;
       System.out.println("\n-----------------------------------------------------------");
       System.out.println("Enter name of student :");
       System.out.println("Enter mark of student :");
       System.out.println("Print out list");
       System.out.println("Grade students according to their grades");
       System.out.println("Sort the list of students in descending order by grade:");
       System.out.print("Enter your choice: ");
       choice= ip.nextInt();
       return (choice);
   } 
    public static boolean check_out(){
        Scanner ip = new Scanner(System.in);
        String str;
        System.out.print("Enter name of student who need to add mark: ");
        str= ip.nextLine();
        for(i= 1; i <= n; i++){
            if(str.equalsIgnoreCase(student_name[i]))
               return true;
        }     
        return false;
    }
    public static void add_new_student(){
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter name of student number "+(++n)+" :");
        student_name[n]= ip.nextLine();
        System.out.println("!!!add name Successfull!!");
    }
    public static void print_all_list(){
        System.out.println("Print out all information of student: ");
        for(i= 1; i<= n; i++)
        System.out.format("name : %-15s mark:%-15.3f :%-15s\n",student_name[i],student_mark[i],student_grades[i]);
    } 
    public static void type_accord_grade(){
 
        for(i= 1; i<= n; i++){
            if(student_mark[i]<5)
                student_grades[i]="Weak";
            else if(student_mark[i]<6.5 && student_mark[i]>=5)
                student_grades[i]="Average";
            else if(student_mark[i]<7.5 && student_mark[i]>=6.5)
                student_grades[i]="Good";
            else if(student_mark[i]<9 && student_mark[i]>=7.5)
                student_grades[i]="Excellent";
            else if(student_mark[i]>=9)
                student_grades[i]="Super Excellent";
        }
        System.out.println("!!!successfull!!!");
    }
    public static void swap_mark(int i, int j){
        float t;
        t= student_mark[i];
        student_mark[i]= student_mark[j];
        student_mark[j]= t;
    }
    public static void swap_name(int i, int j){
        String str;
        str= student_name[i];
        student_name[i]=student_name[j];
        student_name[j]=str;
    }
    public static void sort_accord_grade(){
        for(i= 1; i< n; i++)
            for(int j=i+1; j <=n; j++)
            {
                if(student_mark[i] < student_mark[j]){
                    swap_mark(i,j); 
                    swap_name(i,j);
                }
            }
        System.out.println("!!!Successfull!!!");
    }
    public static void main(String[] args) {
        int  getChoice;
        float mark;
        Scanner ip = new Scanner(System.in);
        do{
            getChoice= getUserChoice();
            switch(getChoice){
                case 1: add_new_student();
                        break;
                case 2: if (check_out()== false)
                            System.out.println("!!!Can't find student with that name in list!!!");
                        else {
                            do{
                                System.out.print("Enter mark :");
                                mark= ip.nextFloat();
                                if(mark<0)
                                    System.out.println("You can add negative number");
                                else{
                                    student_mark[i]= mark;
                                    System.out.println("!!!add mark for "+student_name[i]+" Successfull!!");                        
                                }

                            }while(mark<0);
                        }
                        break;
                case 3: print_all_list();
                        break;
                case 4: type_accord_grade();
                        break;
                case 5: sort_accord_grade();
                        break;
                default: System.out.println("\nbye");
            }
        }
        while((getChoice>0)&&(getChoice<6));
    }
}