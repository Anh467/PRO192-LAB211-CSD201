import java.util.ArrayList;

public class Manage {
    ArrayList<Write> writeArrayList = new ArrayList<>();

    public Manage() {
    }

    public Manage(ArrayList<Write> writeArrayList) {
        this.writeArrayList = writeArrayList;
    }

    public ArrayList<Write> getWriteArrayList() {
        return writeArrayList;
    }

    public void setWriteArrayList(ArrayList<Write> writeArrayList) {
        this.writeArrayList = writeArrayList;
    }

    public void add(Write write){
        writeArrayList.add(write);
    }
}
