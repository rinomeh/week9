package main;

//Gravel car class that extends RallyCar
public class GravelCar extends RallyCar{
    private double suspensionTravel;

    //constructor
    public GravelCar(String make, String model, int horsePower, double suspensionTravel) {
        super(make, model, horsePower);
        this.suspensionTravel = suspensionTravel;
    }

    //getter
    public double getSuspensionTravel() {
        return suspensionTravel;
    }

    //method to calculate performance
    @Override
    public double calculatePerformance() {
        return getHorsePower() * (1 -suspensionTravel);
    }
    
}
