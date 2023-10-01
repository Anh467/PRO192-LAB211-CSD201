/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0012.cached;


import P0012.model.*;
public class FuMemoryCached {
    private String key;
    private Student stu;
    private long timToLive;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public long getTimToLive() {
        return timToLive;
    }

    public void setTimToLive(long timToLive) {
        this.timToLive = timToLive;
    }
    
}
