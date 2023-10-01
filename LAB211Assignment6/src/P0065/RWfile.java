package p0065;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RWfile {
    public static void readFile(ArrayList<Student> st) {
        String nnameStrudent;
        String nClass;
        double nmath;
        double nphysical;
        double nchemistry;
        double naverage;
        char ntype;
      

        String nManageStudent;
        int count = 0;
        try {
            FileReader fr = new FileReader("src\\p0065\\Student.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(",");
///////,,.../////
                count++;
            }
            if (count == 0) {
                System.err.println("Student.txt is empty.");
            } else {
                System.err.println(count + " Student are added to the list.");
            }
        } catch (Exception e) {
            System.err.println("Faillll.");
        }
    }
        public static void saveListIntoFile(ArrayList<Student> st) {
        if (st.isEmpty()) {
            System.err.println("Empty list.");
        } else {
            try {
                FileWriter fw = new FileWriter("src\\p0065\\Student.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Student student : st) {
            //  ...//
                    bw.newLine();
                }
                bw.close();
                fw.close();
            } catch (Exception e) {
                System.err.println("Save file error!!!");
            }
        }
    }
   
}
