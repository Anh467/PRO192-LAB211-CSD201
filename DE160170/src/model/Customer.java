package model;
public class Customer {
    private String CustomerID, Name, Phone;
//construct
    public Customer(String CustomerID, String Name, String Phone) {
        this.CustomerID = CustomerID;
        this.Name = Name;
        this.Phone = Phone;
    }

    public Customer() {
    }
//get set
    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
//toString

    @Override
    public String toString() {
        return "Customer{" + "CustomerID=" + CustomerID + ", Name=" + Name + ", Phone=" + Phone + '}';
    }
    
}
