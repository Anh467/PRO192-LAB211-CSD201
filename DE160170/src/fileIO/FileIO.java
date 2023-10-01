package fileIO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import model.Customer;
public class FileIO {
    public ArrayList<Customer> readFile(String path){
        ArrayList<Customer> cusList= new ArrayList<>();
        String book;
        try {
            FileReader fr= new FileReader(path);
            BufferedReader br= new BufferedReader(fr);
            while((book= br.readLine())!=null){
                //System.out.println(book);
                String []b= book.split(",");
                cusList.add(new Customer(b[0], b[1], b[2]));
            }
        } catch (Exception e) {
        }
        return cusList;
    }
}
