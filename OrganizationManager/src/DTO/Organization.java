/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author 84384
 */
public abstract class Organization {
    private int size;
// construct
    public Organization() {
    }
    
    public Organization(int size) {
        this.size = size;
    }
//getter setter
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
// abstract
    public abstract void communicateByTool();
// toString

    @Override
    public String toString() {
        return "“the organization’s size is "+this.size ;
    }
    
}
