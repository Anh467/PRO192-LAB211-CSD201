package lab5;

public abstract class Student {

    private String fullName;
    private double mediumScore;
    private Address address;
    public abstract int count();
    public Student() {
    }
    
    public Student(String fullName, Address address) {
        this.fullName = fullName;
        this.address = address;
    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "fullName=" + fullName + ", address=" + address + '}';
    }

}
