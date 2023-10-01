package P0025.fileIO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
public class FileIO {
    public StringBuffer readFile(String path){
        StringBuffer content = new StringBuffer("");
        String contentText;
        try {
            FileReader fr= new FileReader(path);
            BufferedReader br= new BufferedReader(fr);
            while((contentText= br.readLine())!=null){
                content.append(contentText);
            }
        } catch (Exception e) {
        }
        return content;
    }
    public static boolean saveFile(StringBuffer content, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(content.toString());
            bw.close();
            osw.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
