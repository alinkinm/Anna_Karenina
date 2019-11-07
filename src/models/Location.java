package models;


public class Location {
    protected long id;
    protected String title;
    protected String picture;
    protected long mainpostID;

    public Location(long id, String title, String picture, long mainpostID) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.mainpostID = mainpostID;
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

    public long getMainpostID() {
        return mainpostID;
    }

    @Override
    public String toString() {
        return "\n"+"id: " + this.id + "\n" + "title: " + this.title + "\n" +
                "main post: " + this.mainpostID + "\n";
    }
}