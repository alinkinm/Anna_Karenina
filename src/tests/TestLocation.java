package tests;

import dao.LocationDAO;
import models.Location;

public class TestLocation {
    public static void main(String[] args) {
        Location train = new Location(0, "Train", "123.jpg",
                1);
        LocationDAO locationdao = new LocationDAO();
        locationdao.save(train);
        for (Location location: locationdao.getAll()) {
            System.out.println(location);
        }
        System.out.println(locationdao.get(2).toString());
        locationdao.delete(1);
    }
}
