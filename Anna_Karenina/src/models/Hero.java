package models;

public class Hero {
    protected long id;
    protected long userID;
    protected String name;
    protected String photo;
    protected String description;

    public Hero(long id, long userID, String name, String photo, String description) {
        this.id = id;
        this.userID = userID;
        this.name = name;
        this.photo = photo;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "\n"+"id: " + this.id + "\n" + "userID: " + this.userID + "\n" +
                "name: " + this.name + "\n" + "decription: " + this.description+"\n";
    }
}