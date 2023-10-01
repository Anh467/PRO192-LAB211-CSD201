
package DTO;

public class BeeColony extends Colony implements Role{   
    private String type;
//construct

    public BeeColony(int size, String type,  String place) {
        super(size, place);
        this.type = type;
    }

    public BeeColony() {
    }

    
//    public BeeColony() {
//    }
//toString
    @Override    
    public String toString() {
        return "the colony’s type is " + this.type+ ", size is about" + super.getSize() + ", and the place is" + super.getPlace();
    }
//getter setter

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }   
//override
    @Override
    public void createWorker() {
        System.out.println("Worker bees perform all the work of the bees");
    }

    
}
