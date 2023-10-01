package P0012.fileIO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import P0012.model.Student;
public class FileIO {
    public ArrayList<Student> readFile(String path){
        ArrayList<Student> stuList= new ArrayList<>();
        String book;
        try {
            FileReader fr= new FileReader(path);
            BufferedReader br= new BufferedReader(fr);
            while((book= br.readLine())!=null){
                stuList.add(new Student(book));
            }
        } catch (Exception e) {
        }
        return stuList;
    }
}
