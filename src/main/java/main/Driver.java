package main;


//driver class
public class Driver {
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    //constructor
    public Driver(String name, String country, int points, RallyCar car) {
        this.name = name;
        this.country = country;
        this.points = points;
        this.car = car;
    }

    //getters and setter for car
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPoints() {
        return points;
    }

    public RallyCar getCar() {
        return car;
    }

    public void setCar(RallyCar car) {
        this.car = car;
    }

    //method to add points
    public void addPoints(int points) {
        this.points += points;
    }
}
