package models;

import java.util.Date;

public class User {

    protected String username;
    protected String password;
    protected long id;
    protected Date date;
    protected String about;
    protected String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAbout() {
        return about;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate() {
        return date;
    }

    public User(String username, String password, Long id, Date date, String about, String photo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.about = about;
        this.date = date;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" + "username: " + this.username + "\n" +
                "date of registration: " + this.date.toString();
    }

}