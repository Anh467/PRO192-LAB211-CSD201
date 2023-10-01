/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mannger;

import DTO.BIZ;
import DTO.IT;
import DTO.Student;
import io.FileIO;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Mannger {
    private ArrayList<Student> stList= new ArrayList<>();
    public void view(){
        System.out.println("=======VIEW=======");
        stList.forEach((Student t) -> {
            System.out.println(t.toString());
        });
    }
    public void searchStudentAddress(){
        System.out.print("Enter address: ");
        Scanner sc= new Scanner(System.in);
        String address= sc.nextLine();
        for(int i=0; i< stList.size(); i++)
            if(address.equalsIgnoreCase(stList.get(i).getAddress()))
                if(i==-1)
                    System.out.println("!!!Student in list not exist in this place!!!");
                else{
                    System.out.print(stList.get(i).toString());
                    System.out.println("!!!DONE!!!");
                    }  
        }
    public int findID(){
        System.out.print("Enter ID: ");
        Scanner sc= new Scanner(System.in);
        String ID= sc.nextLine();
        for(int i=0; i< stList.size(); i++)
            if(ID.equalsIgnoreCase(stList.get(i).getId()))
                return i;
        return -1;
    }
    public void deleteStudentID(){
        int i= findID();
        if(i== -1)
            System.out.println("!!!We dont have that ID!!!");
        else{
            stList.remove(i);
            System.out.println("!!!DONE!!!");
        }
    }
    public void insert(){
        Scanner sc= new Scanner(System.in);
        int i=0;
        String name, id, address, mail;
        double mark1, mark2;
        while (true)           
            try {
            System.out.print("Enter 1 for IT, 2 for BIZ: ");
            i= Integer.parseInt(sc.nextLine());
            if((i==1)||(i==2))
               break;
            else throw new Exception("!!!Number just 1 or 2!!!");
        } catch (Exception e) {
            System.out.println("!!!WRONG FORMAT!!!");
        }
        System.out.print("Enter name: ");
            name= sc.nextLine();
        System.out.print("Enter ID: ");
            id= sc.nextLine();
        System.out.print("Enter address: ");
            address= sc.nextLine();
        System.out.print("Enter mail: ");
            mail= sc.nextLine();
        if(i==1)
            while(true)
            try {
            System.out.print("Enter mark of java: ");
                mark1= Double.parseDouble(sc.nextLine());
            System.out.print("Enter mark of css: ");
                mark2= Double.parseDouble(sc.nextLine());
            stList.add(new IT(mark2, mark1, id, name, address, mail));
            break;
            } catch (Exception e) {
                System.out.println("!!!Wrong format!!!");
            }  
        else
            while(true)
            try {
            System.out.print("Enter mark of accounting: ");
                mark1= Double.parseDouble(sc.nextLine());
            System.out.print("Enter mark of marketing: ");
                mark2= Double.parseDouble(sc.nextLine());
            stList.add(new BIZ(mark2, mark1, id, name, address, mail));
            break;
            } catch (Exception e) {
                System.out.println("!!!Wrong format!!!");
            }      
        System.out.println("!!!DONE!!!");
    }
    public void update(int i){
        String name, id, address, mail;
        double mark1, mark2;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter name: ");
            name= sc.nextLine();
        System.out.print("Enter ID: ");
            id= sc.nextLine();
        System.out.print("Enter address: ");
            address= sc.nextLine();
        System.out.print("Enter mail: ");
            mail= sc.nextLine();
            while(true)
            try {
            System.out.print("Enter mark of java: ");
                mark1= Double.parseDouble(sc.nextLine());
            System.out.print("Enter mark of css: ");
                mark2= Double.parseDouble(sc.nextLine());
            break;
            } catch (Exception e) {
                System.out.println("!!!Wrong format!!!");
            }  
        //name
        if("".equalsIgnoreCase(name)==false)
            stList.get(i).setName(name);
        //id
        if("".equalsIgnoreCase(id)==false)
            stList.get(i).setId(id);
        //address
        if("".equalsIgnoreCase(address)==false)
            stList.get(i).setAddress(address);
        //mail
        if("".equalsIgnoreCase(mail)==false)
            stList.get(i).setEmail(mail);
//mark
        if(stList.get(i) instanceof IT){
        if(mark1!=0)
            ((IT)stList.get(i)).setJava(mark1);
        if(mark2!=0)
            ((IT)stList.get(i)).setCss(mark2);
        }
        else{
        if(mark1!=0)
            ((BIZ)stList.get(i)).setAccount(mark1);
        if(mark2!=0)
            ((BIZ)stList.get(i)).setMarket(mark2);    
        }
    }
    public void updateStudent(){
        int i= findID();
        if(i==-1)
            System.out.println("!!!We dont have that ID!!!");
        else{
            update(i);
            System.out.println("!!!DONE!!!");
        }
    }
    public void sortName(){
        stList.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/LambdaBody
        });
    }
    public void listAve(){
        double n1=0, n2=0;
        Scanner sc= new Scanner(System.in);
        while (true) 
        try {
            System.out.println("enter number 1: ");
                n1= sc.nextDouble();
            System.out.println("enter number 2: ");
                n2= sc.nextDouble();
            break;
        } catch (Exception e) {
            System.out.println("!!!WRONG FORMAT!!!");
        }
        if(n1>n2){
            double d;
            d= n1;
            n1= n2;
            n2= d;
        }
        for(int i= 0; i< stList.size(); i++)
            if((stList.get(i).ave()>n1)&&(stList.get(i).ave()<n2))
                System.out.println(stList.get(i).toString());
    }
    public void topStudent(){
        int[] ii={-1,-1,-1,-1,-1};
        double[] m={0,0,0,0,0};
        for(int i=0;i<stList.size();i++){
            for(int j=0;j<5;j++){
                if(m[j]<stList.get(i).ave()){
                    for(int k=4;k>j;k--){
                        m[k]=m[k-1];
                        ii[k]=ii[k-1];
                    }
                    m[j]=stList.get(i).ave();
                    ii[j]=i;
                    break;
                }
            }
        }
        for(int j=0; j<5; j++){
            if(ii[j]!=-1)
                    System.out.println(stList.get(ii[j]).toString());
        }        
    }
    public void saveFile(){
        FileIO.saveFile(stList, "C:\\Users\\84384\\Documents\\NetBeansProjects\\AssignmentConsle\\src\\resource\\stu.txt");
    }
    public void readFile(){
        try {
            
            String ID="",name="", address="", mail="";
            double mark1= 0, mark2= 0;
            int k;
            FileInputStream fos = new FileInputStream("C:\\Users\\84384\\Documents\\NetBeansProjects\\AssignmentConsle\\src\\resource\\stu.txt");
            InputStreamReader osw = new InputStreamReader(fos);
            BufferedReader bw = new BufferedReader(osw);
            String line= bw.readLine();
            while(line!=null){
                int count=0,i, j=0;
                for(i=0;i<line.length();i++){
                    if(line.charAt(i)=='/'){
                        count++;
                        switch(count){
                            case 1: ID= line.substring(j,i);         
                                    break;
                            case 2: name= line.substring(j,i);  
                                    break;
                            case 3: address= line.substring(j,i);
                                    break;
                            case 4: mail=line.substring(j,i);    
                                    break;
                            case 5: mark1= Double.parseDouble(line.substring(j,i));         
                                    break;  
                            case 6: mark2= Double.parseDouble(line.substring(j,i));         
                                    break;         
                        }
                        if(count==6)
                            break;
                        j= i+1;  
                    }
                }   
                    k=Integer.parseInt(line.substring(i+1,line.length()));
                    if(k==1)
                        stList.add(new IT(mark2, mark1, ID, name, address, mail));
                    else stList.add(new BIZ(mark2, mark1, ID, name, address, mail));
                    line= bw.readLine();
                }
                
                
        fos.close();
        osw.close();
        bw.close();                 
        } catch (Exception e) {
            e.printStackTrace();        
    }         
    }
}