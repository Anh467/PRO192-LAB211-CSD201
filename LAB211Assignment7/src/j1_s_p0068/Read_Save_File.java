package j1_s_p0068;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Read_Save_File {

    public static void saveListIntoFile(ArrayList<Student> st) {
        int count = 0;
        if (st.isEmpty()) {
            System.err.println("Empty File!!!");
            return;
        } else {
            try {
                FileWriter fw = new FileWriter("src\\j1_s_p0068\\Student.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < st.size(); i++) {
                    bw.write(st.get(i).getName() + "," + st.get(i).getClasses() + "," + st.get(i).getMark());
                    bw.newLine();
                    count++;
                }
                bw.close();
                fw.close();
                System.err.println(count + " student are added to file.");
            } catch (Exception e) {
                System.err.println("Read file error!!");
            }
        }
    }

    public static void readFile(ArrayList<Student> st) {
        String nClass;
        String nName;
        double nMark;
        int count = 0;
        try {
            String line;
            FileReader fr = new FileReader("src\\j1_s_p0068\\Student.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(",");

                nName = Validate.makeNameRight(txt[0].trim());

                nClass = txt[1].trim().toUpperCase();

                nMark = Double.parseDouble(txt[2]);

                st.add(new Student(nName, nClass, nMark));

                count++;
            }

            if (count == 0) {
                System.err.println("Student.txt is empty.");
            } else {
                System.err.println(count + " student are added to the list.");
            }
        } catch (Exception e) {
            System.err.println("Read file error!!!.");
        }
    }
}
