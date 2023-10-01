/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author 84384
 */
public class BIZ extends Student{
public double account, market;  

    

//construct
    public BIZ(double account, double java) {
        this.account = account;
        this.market = market;
    }

    public BIZ(double account, double market, String id, String name, String address, String email) {
        super(id, name, address, email);
        this.account = account;
        this.market = market;
        }
//get set
    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public double getMarket() {
        return market;
    }

    public void setMarket(double market) {
        this.market = market;
    }
   
    @Override
    public double ave() {
        return (Math.ceil(((this.account*2 + this.market)/3)*100)/100);
    }

    @Override
    public String toString() {
        return super.toString()+"/" + account + "/" + market + "/1";
    }
    
}
