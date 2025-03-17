package main;

import java.util.ArrayList;
import java.util.List;

//singleton class to manage the championship
public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers;
    private static int totalRaces;

    //private constructor
    private ChampionshipManager() {
        this.totalDrivers = 0;
        this.totalRaces = 0;
        this.drivers = new ArrayList<>();
        this.races = new ArrayList<>();
    }

    //singleton instance
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }


    //getters
    public static int getTotalDrivers() {
        return totalDrivers;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

    public List<RallyRaceResult> getRaceResults() {
        return races;
    }


    //methods
    //register driver
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    //add race result
    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
    }

    //get driver standings
    //use this for when looping through the drivers since it return a list type drivers
    public List<Driver> getDriverStandings() {
            return drivers;

    }

    public static Driver getLeadingDriver(){
        Driver leadingDriver = getInstance().drivers.get(0);
        for (Driver driver : getInstance().drivers) {
            if (driver.getPoints() > leadingDriver.getPoints()) {
                leadingDriver = driver;
            }
        }
        return leadingDriver;
    }

    public static int getTotalChampionshipPoints() {
        int totalPoints = 0;
        for (Driver driver : getInstance().drivers) {
            totalPoints += driver.getPoints();
        }
        return totalPoints;
    }   


}
