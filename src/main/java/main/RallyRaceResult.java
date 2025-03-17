package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//class that implements race result interface
//used to store the results of a rally
public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    //constructor
    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }


    //getters
    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
    }

    public int getDriverPoints(Driver driver) {
        return results.get(driver);
    }

    
    //get results of each driver
    public List<Driver> getResults() {
        List<Driver> drivers = new ArrayList<>();
        for (Driver driver : results.keySet()) {
            drivers.add(driver);
        }
        return drivers;
    }
}
