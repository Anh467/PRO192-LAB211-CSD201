/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0055.mannagment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import P0055.model.DOCTOR;
import P0055.validate.MyException;
import P0055.validate.Validate;

/**
 *
 * @author 84384
 */
public class Mannagement {
    public Map<String, DOCTOR> doctorList= new LinkedHashMap<>();
    public void addListFromeFile(String path){
        doctorList.putAll(P0055.control.Control.readFile(path));
    }
    public String getInputString(String str){
        Scanner sc= new Scanner(System.in);
        System.out.print(str);
        return Validate.standard(sc.nextLine());
    }
    public int getInputInt(String str){
        Scanner sc= new Scanner(System.in);
        System.out.print(str);
        while (true) {            
            try {
                int num= Validate.number(sc.nextLine());
                if(num<=0) throw new MyException("!!!CANT BE 0 OR NEGATIVE!!!");
                return num;
            } catch (MyException e) {
                System.err.print(e.getMessage());
            }catch (Exception e) {
                System.err.println("!!!WRONG FORMAT!!!");
            }
        }
    }
    public String getInputCode(String str, Map<String, DOCTOR> doctorList){
        Scanner sc= new Scanner(System.in);
        while (true) {            
            try {
                System.out.print(str);
                String code= Validate.checkCode(sc.nextLine());
                if(code=="") throw new MyException("!!!WRONG FORMAT, ex: CODE 1!!!");
                if(doctorList.containsKey(code)) throw new MyException("!!!CODE ALREADY IN MAP!!!");
                return code;
            } catch (MyException e) {
                System.err.println(e.getMessage());
            }catch (Exception e) {
            }
        }
        
    }
    public void addDoctor(){
        DOCTOR doctor= new DOCTOR(doctorList);
        if(doctorList.containsKey(doctor.getCode())){
            System.out.println("!!!CODE ALREADY EXIST!!!");
            return;
        }
        doctorList.put(doctor.getCode(), doctor);
    }
    public boolean searchDoctor(String code){
        if(doctorList.containsKey(code)) return true;
       
        return false;
    }
    public void updateDoctor(String code){
        if(!searchDoctor(code)){
             System.err.println("!!!CODE DOESNT EXIST!!!");
            return;
        }
        if(Validate.checkCode(code)==""){
            System.err.println("!!!CODE WRONG FORMAT!!!");
            return;
        }
        String name= getInputString("Enter name: ");
        String Specialization= getInputString("Enter Specialization: ");
        int availability= getInputInt("Enter availability: ");
        doctorList.put(code, new DOCTOR(code, name, Specialization, availability));
        System.out.println("!!!UPDATE SUCCESSFULL!!!");
    }
    public void deleteDoctor(String code){
        if(!searchDoctor(code)){
            System.err.println("!!!CODE DOESNT EXIST!!!");
            return;
        }
        if(Validate.checkCode(code)==""){
            System.err.println("!!!CODE WRONG FORMAT!!!");
            return;
        }
        doctorList.remove(code);
        System.out.println("!!!DELETE SUCCESSFULL!!!");
    }
    public void searchDoctorInformation(String name){
        System.out.println("------- Result --------");
        System.out.format("%-10s%-20s%-20s%-30s\n","Code","Name","Specialization","availability");
        for( DOCTOR entry: doctorList.values()){
            if(entry.getName().toLowerCase().contains(name.toLowerCase()))
                entry.viewInformation();
        }
    }
}
