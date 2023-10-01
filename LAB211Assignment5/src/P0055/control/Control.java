/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0055.control;

import P0055.validate.Validate;
import P0055.validate.MyException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import P0055.model.DOCTOR;
/**
 *
 * @author 84384
 */
public class Control {
    public static Map<String,DOCTOR> readFile(String path){
        Map<String,DOCTOR> doctorList= new LinkedHashMap<>();
        try {
            Path filePath= Paths.get(path);
            List<String> doctorString= Files.readAllLines(filePath);
            for(int i=0; i< doctorString.size(); i++){
                String[] doctor= doctorString.get(i).split(";");
                if(doctorList.containsKey(doctor[0])) continue;
                if(Validate.checkCode(doctor[0])=="") continue;
                if(Validate.number(doctor[3].trim())<=0) continue;
                doctorList.put(doctor[0], new DOCTOR(doctor[0], Validate.standard(doctor[1]), Validate.standard(doctor[2]), Integer.parseInt(doctor[3].trim())));
                System.out.println("!!!ADD SUCCESSFULL "+doctor[0]+"!!!");
            }
            
        } catch (Exception e) {
            System.err.println("!!!READ FAIL!!!");
        }
        System.out.println("!!!READ SUCCESSFULL!!!");
        return doctorList;
    }
    public static boolean saveFile(String path, Map<String,DOCTOR> doctorList) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for(DOCTOR doctorInfor: doctorList.values()){
                bw.newLine();
                bw.write(doctorInfor.getCode()+", "+doctorInfor.getName()+", "+doctorInfor.getSpecialization()+", "+doctorInfor.getAvailability());
            }
            bw.close();
            osw.close();
            fos.close();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void menu(String[] option){
        System.out.println("========= "+ option[0]+" =========");
        for(int i= 1; i< option.length; i++)
            System.out.println("     "+i+". "+option[i]);
        System.out.print("Choose: ");
    }
    public static int getChoice(){
        Scanner sc= new Scanner(System.in);
        while (true) {            
            try {
                int num= Integer.parseInt(sc.nextLine());
                if((num<1)&&(num>5)) throw new MyException("!!!WE DONT HAVE THIS OPTION!!!");
                return num;
            }catch (MyException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("!!!WRONG FORMAT!!!");
            }
        }
    }
    
}
