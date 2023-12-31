package j1_s_p0056;

public class History extends Worker implements Comparable<History> {
    
    private String status;
    private String date;

    public History() {
    }

    public History(String id, String name, int age, int salary, String workLocation, String status, String date) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public int compareTo(History o) {
        return this.getId().compareTo(o.getId());
    }

}
