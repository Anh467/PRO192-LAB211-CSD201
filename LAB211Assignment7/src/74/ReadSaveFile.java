package j1.s.p0074;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class ReadSaveFile {
    public abstract boolean readFormat(List<String> line, char form);
    public boolean loadFile(String fileName,char form){
        try {
            List<String> fileText = Files.readAllLines(Paths.get(fileName));
//            for(String line: fileText){
                if (!readFormat(fileText,form)) throw new IOException("wrong format");
//            }
            return true;
        } catch (IOException e) {
            System.err.println("File not found, cannot read or write exception.");
        }
        return false;
    }
    public abstract String makeString(char form);
//    -----------------------------
    public boolean saveFile(String fileName,char form, char c){
        try {
//            Open file to save
            java.io.File file = new java.io.File(fileName);
            if (!file.exists()) file.createNewFile();
            FileWriter fr=null;
            if (c=='a') fr = new FileWriter(file, true);
            if (c=='w') fr= new FileWriter(file);
//            Read a line in arr to save
            String load = makeString(form);
            fr.write(load);
            fr.close();
            return true;
        } catch (IOException e) {
            System.err.println("File not found, cannot read or write exception.");
        }
        return false;
    }
//    ------------------------------------
    public boolean checkSomething(String something, int address, String fileName){
        try {
            List<String> fileText = Files.readAllLines(Paths.get(fileName));
            for(String line: fileText){
                int check=checkFormat(something, address, line);
                if (check==0) return false;
                if (check<0) throw new IOException("Information of File not same Format");
            }
            return true;
        } catch (IOException e) {
            System.err.println("File not found, cannot read or write exception.");
        }
        return false;
    }
    public int checkFormat(String something,int address,String line){
        return 0;
    }
}
