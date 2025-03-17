package main;

//Asphalt car class that extends RallyCar
public class AsphaltCar extends RallyCar{
    private double downforce;

    //constructor
    public AsphaltCar(String make, String model, int horsePower, double downforce) {
        super(make, model, horsePower);
        this.downforce = downforce;
    }

    //getter
    public double getDownforce() {
        return downforce;
    }

    //method to calculate performance
    @Override
    public double calculatePerformance() {
        return getHorsePower() * (1- downforce);
    }
    
}
