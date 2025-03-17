package main;

import java.util.List;

//interface used to for RallyRaceResult
public interface RaceResult {
    public void recordResult(Driver driver, int position, int points);
    public int getDriverPoints(Driver driver);
    public List<Driver> getResults();
}
