package P0022.fileIO;
import P0021.model.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import P0022.model.*;
public class FileIO {
    public ArrayList<Candidates> readFile(ArrayList<Candidates> stdFile, String path){
        ArrayList<Candidates> stdList= new ArrayList<>();
        String book;
        try {
            FileReader fr= new FileReader(path);
            BufferedReader br= new BufferedReader(fr);
            while((book= br.readLine())!=null){
                //System.out.println(book);
                String []b= book.split(",");
                switch(b[0]){
                    case "0": stdFile.add(new Candidates(book, path, path, path, book, book, path, 0));
                }
                
            }
        } catch (Exception e) {
        }
        return stdList;
    }
}
