package main;

//abstract rally car class

public abstract class RallyCar {
    private String make;
    private String model;
    private int horsePower;

    //constructor
    public RallyCar(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    //getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    //abstract method to calculate performance
    public abstract double calculatePerformance();
    
}
