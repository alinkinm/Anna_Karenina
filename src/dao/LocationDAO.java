package dao;

import models.Location;
import models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
                        rs.getString("picture"), rs.getLong("mainpostid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Location> getAll() {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from location;");
            ResultSet rs = stmt.executeQuery();
            List<Location> locations = new ArrayList<>();
            while (rs.next()) {
                locations.add(new Location(rs.getLong("id"), rs.getString("title"),
                        rs.getString("picture"), rs.getLong("mainpostid")));
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
                    " values (nextval('locationseq'), ?, ?, ?);");
            statement.setString(1, x.getTitle());
            statement.setString(2, x.getPicture());
            statement.setLong(3, x.getMainpostID());
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
