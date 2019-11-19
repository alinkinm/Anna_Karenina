package dao;

import models.Hero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements DAO<Hero> {

    @Override
    public Hero get(long id) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from " +
                    "hero where id=" + id + ";");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Hero(rs.getLong("id"),
                        rs.getLong("userid"), rs.getString("firstname"),
                        rs.getString("photo"), rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Hero> getAll() {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from hero;");
            ResultSet rs = stmt.executeQuery();
            List<Hero> heroes = new ArrayList<>();
            while (rs.next()) {
                heroes.add(new Hero(rs.getLong("id"),
                        rs.getLong("userid"), rs.getString("firstname"),
                        rs.getString("photo"), rs.getString("description")));
            }
            return heroes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Hero x) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into hero" +
                    " values (nextval('heroseq'), ?, ?, ?, ?);");
            statement.setLong(1, x.getUserID());
            statement.setString(2, x.getName());
            statement.setString(3, x.getPhoto());
            statement.setString(4, x.getDescription());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hero hero, String[] params) {

    }

    @Override
    public void delete(long id) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from hero" +
                    " where id =" + id + ";");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Hero> get2(long id) {
        ArrayList<Hero> heroes = new ArrayList<>();
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from " +
                    "hero where userid= ?" + ";");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                heroes.add(new Hero(rs.getLong("id"),
                        rs.getLong("userid"), rs.getString("firstname"),
                        rs.getString("photo"), rs.getString("description")));
            }
            return heroes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
