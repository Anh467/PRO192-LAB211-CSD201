/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0012.cached;
import java.util.Date;
import P0012.model.*;
public class FuCached {
    private Student stu;
    private Date date;

    public FuCached(Student stu, Date date) {
        this.stu = stu;
        this.date = date;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
