package dao;

import models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements DAO<Location> {

    @Override
    public Location get(long id) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from " +
                    "location where id=" + id + ";");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Location(rs.getLong("id"), rs.getString("title"),
                        rs.getString("picture"), rs.getString("description"), rs.getString("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Location> getAll() {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from location;");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Location> locations = new ArrayList<>();
            while (rs.next()) {
                locations.add(new Location(rs.getLong("id"), rs.getString("title"),
                        rs.getString("picture"), rs.getString("description"),
                        rs.getString("date")));
            }
            return locations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Location x) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into location" +
                    " values (nextval('locationseq'), ?, ?, ?,?);");
            statement.setString(1, x.getTitle());
            statement.setString(2, x.getPicture());
            statement.setString(3, x.getDesc());
            statement.setString(4, x.getDate());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Location location, String[] params) {

    }

    @Override
    public void delete(long id) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from location" +
                    " where id =" + id + ";");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
