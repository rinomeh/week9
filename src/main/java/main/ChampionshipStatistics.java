package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//class to calculate championship statistics
public class ChampionshipStatistics {
    
    //method to calculate the average points per driver
    public double calculateAveragePointsPerDriver(List<Driver> drivers) {
        int totalPoints = 0;
        for (Driver driver : drivers) {
            totalPoints += driver.getPoints();
        }
        return totalPoints / drivers.size();
    }

    //method to find the most successful country
    public static String findMostSuccessfulCountry(List<Driver> drivers){
        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver driver : drivers) {
            if (countryPoints.containsKey(driver.getCountry())) {
                countryPoints.put(driver.getCountry(), countryPoints.get(driver.getCountry()) + driver.getPoints());
            } else {
                countryPoints.put(driver.getCountry(), driver.getPoints());
            }
        }
        String mostSuccessfulCountry = "";
        int maxPoints = 0;
        for (String country : countryPoints.keySet()) {
            if (countryPoints.get(country) > maxPoints) {
                mostSuccessfulCountry = country;
                maxPoints = countryPoints.get(country);
            }
        }
        return mostSuccessfulCountry;
    }

    //method to get the total drivers
    public static int getTotalRacesHeld(){
        return ChampionshipManager.getTotalRaces();
    }
}
