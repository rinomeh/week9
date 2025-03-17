package main;

/**
 * Hello world!
 *
 */
public class RallyChampionship 
{
    public static void main( String[] args )
    {
        ChampionshipManager manager = ChampionshipManager.getInstance();
        ChampionshipStatistics stats = new ChampionshipStatistics();
        
        //create drivers
        RallyCar car1 = new GravelCar("Toyota", "Yaris", 605, 0.3);
        RallyCar car2 = new AsphaltCar("Hyundai", "i20", 525, 0.1);
        RallyCar car3 = new AsphaltCar("Ford", "Fiesta", 590, 0.2);
        RallyCar car4 = new GravelCar("Citroen", "C3", 605, 0.3);
        
        Driver driver1 = new Driver("Sebastian Ogier", "France", 40, car1);
        Driver driver2 = new Driver("Kalle Rovanpera", "Finland", 40, car2);
        Driver driver3 = new Driver("Ott Tanak", "Estonia", 30, car3);
        Driver driver4 = new Driver("Thiery Neuville", "Belgium", 30, car4);

        //register drivers
        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        //race1 results
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyvaskyla");
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver3, 2, 18);
        race1.recordResult(driver2, 3, 15);
        race1.recordResult(driver4, 4, 12);
        manager.addRaceResult(race1);

        //race2 results
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        race2.recordResult(driver2, 1, 25);
        race2.recordResult(driver4, 2, 18);
        race2.recordResult(driver1, 3, 15);
        race2.recordResult(driver3, 4, 12);
        manager.addRaceResult(race2);

        //print driver standings
        System.out.println("Driver Standings:");
        int position = 1;
        for (Driver driver : manager.getDriverStandings()) {
            System.out.println(position + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
            position++;
        }


        //print the championship leader
        if (manager.getLeadingDriver() != null) {
            Driver championshipLeader = manager.getLeadingDriver();
            System.out.println("\n===== CHAMPIONSHIP LEADER =====");
            System.out.println(championshipLeader.getName() + " with " + championshipLeader.getPoints() + " points");
        }

        //print championship statistics
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        int totalDrivers = manager.getTotalDrivers();
        int totalRaces = manager.getTotalRaces();
        int totalPoints = manager.getTotalChampionshipPoints();
        double averagePoints = stats.calculateAveragePointsPerDriver(manager.getDriverStandings());
        String mostSuccessfulCountry = stats.findMostSuccessfulCountry(manager.getDriverStandings());

        System.out.println("Total Drivers: " + totalDrivers);
        System.out.println("Total Races: " + totalRaces);
        System.out.printf("Average Points Per Driver: %.2f%n", averagePoints);
        System.out.println("Most Successful Country: " + mostSuccessfulCountry);
        System.out.println("Total Championship Points: " + totalPoints);


        // Print race results
        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult race : manager.getRaceResults()) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
            int racePosition = 1;
            for (Driver driver : race.getResults()) {
                int points = race.getDriverPoints(driver);
                System.out.println(" Position " + racePosition + ": " + driver.getName() + " - " + points + " points");
                racePosition++;
            }
            System.out.println("");
        }

        
        //print car performance
        //AI used to figure out the numbers needed for car performace as the UML wasnt clear in this point
        System.out.println("\n===== CAR PERFORMANCE =====");
        double gravelCarPerformance = 0.0;
        double asphaltCarPerformance = 0.0;
        int gravelCarCount = 0;
        int asphaltCarCount = 0;

        for (Driver driver : manager.getDriverStandings()) {
            RallyCar car = driver.getCar();
            if (car instanceof GravelCar) {
                gravelCarPerformance += car.calculatePerformance();
                gravelCarCount++;
            } else if (car instanceof AsphaltCar) {
                asphaltCarPerformance += car.calculatePerformance();
                asphaltCarCount++;
            }
        }
        
        if (gravelCarCount > 0) {
            gravelCarPerformance /= gravelCarCount;
        }
        if (asphaltCarCount > 0) {
            asphaltCarPerformance /= asphaltCarCount;
        }
        
        System.out.printf("Gravel Car Performance: %.1f%n", gravelCarPerformance);
        System.out.printf("Asphalt Car Performance: %.1f%n", asphaltCarPerformance);
    }
}
