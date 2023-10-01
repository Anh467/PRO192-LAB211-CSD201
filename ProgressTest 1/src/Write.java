import java.util.HashMap;

public class Write {
    private String english;
    private String vietNam;

    public Write() {
    }

    public Write(String english, String vietNam) {
        this.english = english;
        this.vietNam = vietNam;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVietNam() {
        return vietNam;
    }

    public void setVietNam(String vietNam) {
        this.vietNam = vietNam;
    }
}
