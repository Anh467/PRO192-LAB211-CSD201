/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0022.control;
import P0022.myException.*;
import P0022.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    //public ArrayList<Candidates> canList= new ArrayList<>();
    public Control() {
    }
//candidates
//String ID, String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType
    
    public String getInputID(ArrayList<Candidates> canList){
        Scanner sc= new Scanner(System.in);
        String ID;
        while (true) {            
            try {
                System.out.print("Enter ID: ");
                ID= sc.nextLine();
                if(!CheckValid.checkID(ID)) throw new MyException("!!!ID WRONG FORAMT, EX:DE160170!!!");
                else
                if(!CheckValid.checkUniqueID(canList, ID)) throw new MyException("!!!ID MUST BE UNIQUE!!!");
                else break; 
               
            }catch(MyException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
            }
        }
        return ID;
    }
    public String standard(String name){
        char[] charArray= name.toCharArray();
        charArray[0]= Character.toUpperCase(name.charAt(0));
        int length= charArray.length;
        for(int i=1; i< length; i++)
                if(charArray[i]==' '){
                    while(charArray[i+1]==' '){
                        for(int j=i+1; j<length-1; j++)
                            charArray[j]=charArray[j+1];
                        length-=1;
                    }
                    charArray[i+1]= Character.toUpperCase(charArray[i+1]);
                }
        return String.valueOf(charArray).substring(0, length);
    }
    public String getInputString(String str){
        Scanner sc= new Scanner(System.in);
        System.out.print(str);
        return standard(sc.nextLine().toLowerCase().trim());
    }
    public String getInputDate(String str){
        int date, month, year;
        while (true) {            
            try {
                Scanner sc= new Scanner(System.in);
                System.out.print("Enter "+str+" (date, month, year): ");
                date= sc.nextInt();
                month= sc.nextInt();
                year= sc.nextInt();
                if(!CheckValid.checkBirthDate(date, month, year)) throw new MyException("!!!INVALID DATE!!!");
                else return date+"/"+month+"/"+year;
            }catch(MyException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("!!!WRONG FORMAT, JUST ENTER INTEGER!!!");
            }
        }
    }
    public String getInputPhone(){
        Scanner sc= new Scanner(System.in);
        String phone;
        while (true) {            
            try {
                System.out.print("Enter phone: ");
                phone= sc.nextLine();
                if(!CheckValid.checkPhone(phone)) throw new MyException("!!!INVALID PHONE NUMBER!!!");
                else return phone;
            }catch(MyException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("!!!WRONG FORMAT!!!");
            }
        }
    }
    public String getInputEmail(){
        Scanner sc= new Scanner(System.in);
        String email;
        while (true) {            
            try {
                System.out.print("Enter email: ");
                email= sc.nextLine();
                if(!CheckValid.checkMail(email)) throw new MyException("!!!INVALID EMAIL!!!");
                else return email;
            }catch(MyException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("!!!WRONG FORMAT!!!");
            }
        }
    }
    public int getInputCandidateType(){
        Scanner sc= new Scanner(System.in);
        int type;
        System.out.println("0: for Experience, 1: for Fresher candidate, 2: for Intern candidate");
        while (true) {            
            try {
                System.out.print("Enter candidate type: ");
                type= sc.nextInt();
                if(!((type>=0)&&(type<=2))) throw new MyException("!!!JUST ENTER 0, 1, 2!!!");
            }catch(MyException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("!!!WRONG FORMAT, JUST ENTER INTEGER!!!");
            }
        }
    }
//experience candidate
//int ExpInYear, String ProSkill
    public int getInputExpInYear(){
        Scanner sc= new Scanner(System.in);
         int ExpInYear;
        while (true) {
            try {
                System.out.print("Enter Year of Experience : ");
                ExpInYear= sc.nextInt();
                if(!CheckValid.checkYearOfExperience(ExpInYear)) throw new MyException("!!!INAPROPRIATE INPUT [0->100]!!!");
                else return ExpInYear;
            }catch(MyException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("!!!WRONG FORMAT!!!");
            }
        }
    }
//fresher candidate
// String Graduation_date, Graduation_rank, Education
    public String getInputGraduation_rank(){
        Scanner sc= new Scanner(System.in);
        String str;
        while (true) {            
            try {
                System.out.print("Enter getInputGraduation rank: ");
                str=sc.nextLine();
                if(!CheckValid.checkRankOfGraduation(str)) throw new MyException("!!!INAPPROPRIATE RANK (Excellence, Good, Fair, Poor)!!!");
                else return str;
            }catch (MyException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
            }
        }
    }
//inter candidate    
    public int getInputInt(String str){
        Scanner sc= new Scanner(System.in);
        int num;
        while (true) {            
            try {
                System.out.println("Enter "+str+": ");
                num= sc.nextInt();
                if(num<=0) throw new MyException("!!!MUST BE POSTIVE!!!");
                else return num;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
            }
        }
    }
//main screen
    public void mainScreen(String[] option){
        System.out.println(option[0]);
        for(int i=1; i< option.length-1; i++)
            System.out.format("%d. %10s\n",i, option[i]);
        System.out.print(option[option.length-1]+" ");
    }
//get choice
    public int getChocie(){
        int input;
        Scanner sc= new Scanner(System.in);
        try {
            input= sc.nextInt();
            if((input<1)||(input>5)) throw new P0021.myException.MyException("!!!INAPPRIOPRIATE OPTION!!!");
            else return input;
        }catch(P0021.myException.MyException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println("!!!INPUT WRONG FORMAT!!!");
        }
        return -1;
    }
//search function
    public void searchFunction(ArrayList<Candidates> canList){
        ArrayList<ExperienceCandidate> expCan= new ArrayList<>();
        ArrayList<FresherCandidate> freshCan= new ArrayList<>();
        ArrayList<InternCandidate> interCan= new ArrayList<>();
        for(int i=0; i< canList.size(); i++){
            if(canList.get(i) instanceof ExperienceCandidate) 
                expCan.add((ExperienceCandidate) canList.get(i));
            if(canList.get(i) instanceof FresherCandidate) 
                freshCan.add((FresherCandidate) canList.get(i));
            if(canList.get(i) instanceof InternCandidate) 
                interCan.add((InternCandidate) canList.get(i));
        }
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
            expCan.forEach((t) -> {
                System.out.println(((Candidates)t).getFirstName()+" "+((Candidates)t).getLastName());
            });
        System.out.println("============FRESHER CANDIDATE==============");
            freshCan.forEach((t) -> {
                System.out.println(((Candidates)t).getFirstName()+" "+((Candidates)t).getLastName());
            });
        System.out.println("=============INTERN CANDIDATE==============");
            interCan.forEach((t) -> {
                System.out.println(((Candidates)t).getFirstName()+" "+((Candidates)t).getLastName());
            });
        String name= getInputString("Input Candidate name (First name or Last name): ");
        System.out.println(name);
        int type= getInputInt("type of candidate");
        System.out.println("The candidates found:");
        for(int i=0; i< canList.size(); i++)
            if((canList.get(i).getCandidateType()==(type-1))&&((canList.get(i).getFirstName()+" "+canList.get(i).getLastName()).toLowerCase().contains(name.toLowerCase())))
                System.out.println(canList.get(i).toString());
    }
    public boolean check(ArrayList<String> can, String id){
        for(int i=0; i< can.size(); i++)
            if(id.equalsIgnoreCase(can.get(i)))
                return false;
        return true;
    }
    public static void main(String[] args) {
        Control control= new Control();
        ArrayList<String> can= new ArrayList<>();
        while(true){
            Scanner sc= new Scanner(System.in);
            String id= sc.nextLine();
            if(control.check(can, id)) can.add(id);
            if (id.equalsIgnoreCase("o"))
                break;
        }
        for(int i=0; i< can.size(); i++)
            System.out.println(can.get(i));
    }
}
