package dao;

import models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PostDAO implements DAO<Post> {

    @Override
    public Post get(long id) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from " +
                    "post where id=" + id + ";");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                try {
                    return new Post(rs.getLong("id"), rs.getLong("authorid"),
                            rs.getString("content"),
                            new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date")),
                            rs.getLong("locationid"), rs.getString("heroname"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Post> getAll() {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from post;");
            ResultSet rs = stmt.executeQuery();
            List<Post> posts = new ArrayList<>();
            while (rs.next()) {
                try {
                    posts.add(new Post(rs.getLong("id"), rs.getLong("authorid"),
                            rs.getString("content"),
                            new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parse(rs.getString("date")),
                            rs.getLong("locationid"), rs.getString("heroname")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return posts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Post x) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into post" +
                    " values (nextval('postseq'), ?, ?, ?, ?, ?);");
            java.util.Date uDate = x.getDate();
            DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
            statement.setLong(1, x.getAuthorID());
            statement.setString(2, x.getText());
            statement.setString(3, df.format(uDate));
            statement.setLong(4, x.getLocationID());
            statement.setString(5, x.getHeroName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Post post, String[] params) {

    }

    @Override
    public void delete(long id) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from post" +
                    " where id =" + id + ";");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int number(long authorid) {
        int k = 0;
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from " +
                    "post where authorid=?;");
            stmt.setLong(1, authorid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
               k++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return k;
    }

    public List<Post> getFromLocation(int locid) {
        try {
            Connection connection = dbl.DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from post where locationid = ?;");
            stmt.setInt(1, locid);
            ResultSet rs = stmt.executeQuery();
            List<Post> posts = new ArrayList<>();
            while (rs.next()) {
                try {
                    posts.add(new Post(rs.getLong("id"), rs.getLong("authorid"),
                            rs.getString("content"),
                            new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parse(rs.getString("date")),
                            rs.getLong("locationid"), rs.getString("heroname")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return posts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
