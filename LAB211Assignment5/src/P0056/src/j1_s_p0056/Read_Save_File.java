package j1_s_p0056;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Read_Save_File {

    public static void saveListIntoFile(ArrayList<Worker> wk) {
        if (wk.isEmpty()) {
            System.err.println("Empty list.");
        } else {
            try {
                FileWriter fw = new FileWriter("src\\j1_s_p0056\\Worker.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Worker worker : wk) {
                    Worker nWk = Validate.getWorker(wk, worker.getId());
                    bw.write(nWk.toString());
                    bw.newLine();
                }
                bw.close();
                fw.close();
            } catch (Exception e) {
                System.err.println("Save file error!!!");
            }
        }
    }

    public static void readFile(ArrayList<Worker> wk) {
        String nID;
        String nName;
        int nAge;
        int nSalary;
        String nWorkLocation;
        int count = 0;
        try {
            FileReader fr = new FileReader("src\\j1_s_p0056\\Worker.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(",");

                nID = txt[0].trim().toUpperCase();

                nName = Validate.makeNameRight(txt[1].trim());

                nAge = Integer.parseInt(txt[2].trim());

                nSalary = Integer.parseInt(txt[3].trim());

                nWorkLocation = Validate.makeNameRight(txt[4].trim());

                Worker worker = new Worker(nID, nName, nAge, nSalary, nWorkLocation);
                wk.add(worker);

                count++;
            }
            if (count == 0) {
                System.err.println("Worker.txt is empty.");
                System.out.println("---------------------------------------------------------");
            } else {
                System.err.println(count + " worker are added to the list.");
                System.out.println("---------------------------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("Something has wrong.");
        }
    }
}
