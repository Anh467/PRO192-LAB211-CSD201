
package Lab2;

//+setColour(String colour):void
//+setEnginePower(int EnginePower):void
//+setConvertible(boolean Convertible): void
//+setParkingBrakstre(boolean ParkingBrake): void
public class Car{
    private String colour;
    private int enginePower;
    private boolean convertible;
    private boolean parkingBrake;
    public Car(String colour, int enginePower, boolean convertible, boolean parkingBrake){
        this.colour= colour;
        this.enginePower= enginePower;
        this.parkingBrake= parkingBrake;
        this.convertible= convertible;
    }
    public Car(){
        
    }
    public String getColour(){
        return this.colour;
    }
    public int getEnginePower(){
        return this.enginePower;
    }
    public boolean getConvertible(){
        return this.convertible;
    }
    public boolean getParkingBrake(){
        return this.parkingBrake;
    }
    public void setColour(String colour ){
        this.colour= colour;
    }
    public void setEnginePower(int enginePower ){
        this.enginePower = enginePower;
    }
    public void setConvertible(boolean Convertible ){
        this.convertible = Convertible;
    }
    public void setParkingBrake(boolean parkingBrake ){
        this.parkingBrake =parkingBrake;
    }
    public void pressStartButton(){
        System.out.println("“You have pressed the start button");
    }
    public void pressAcceleratorButton(){
        System.out.println("You have pressed the Accelerator button");
    }
    public void output(){
        System.out.println("-Colour      : "+ this.colour);
        System.out.println("-EnginePower : "+ this.enginePower);
        System.out.println("-Convertible : "+ this.convertible);
        System.out.println("-ParkingBrake: "+ this.parkingBrake);
    }
}
