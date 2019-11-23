package models;


import java.util.Date;

public class Location {
    protected long id;
    protected String title;
    protected String picture;
    protected String desc;
    protected String date;

    public Location(long id, String title, String picture, String desc, String date) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.desc = desc;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPicture() {
        return picture;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "\n"+"id: " + this.id + "\n" + "title: " + this.title + "\n" +
                "main post: " + this.desc + "\n";
    }
}