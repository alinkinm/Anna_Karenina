package dao;

import models.Hero;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {

    @Override
    public User get(long id) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from " +
                    "myuser where id= ? ;");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"),
                        rs.getString("password"), rs.getLong("id"),
                        rs.getDate("date"), rs.getString("about"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User find(String username) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from myuser where username = ?");
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"),
                        rs.getString("password"), rs.getLong("id"),
                        rs.getDate("date"), rs.getString("about"), rs.getString("photo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean usernameExist(String username) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from myuser where username = ?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from myuser;");
            ResultSet rs = stmt.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getString("username"),
                        rs.getString("password"), rs.getLong("id"), rs.getDate("date"), rs.getString("about"),
                        rs.getString("photo")));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User x) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into public.myuser values (?, ?, nextval('userseq'), ?, " +
                    "?, ?);");
            statement.setString(1, x.getUsername());
            statement.setString(2, x.getPassword());
            statement.setDate(3, new Date(x.getDate().getTime()));
            statement.setString(4, x.getAbout());
            statement.setString(5, x.getPhoto());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user, String[] params) {


    }

    @Override
    public void delete(long id) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from myuser" +
                    " where id =" + id + ";");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


