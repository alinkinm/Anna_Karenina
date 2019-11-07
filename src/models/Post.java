package models;


import java.util.Date;

public class Post {
    protected long ID;
    protected long authorID;
    protected String text;
    protected Date date;
    protected long locationID;

    public Post(long ID, long authorID, String text, Date date, long locationID) {
        this.ID = ID;
        this.authorID = authorID;
        this.text = text;
        this.date = date;
        this.locationID = locationID;
    }

    public long getID() {
        return ID;
    }

    public long getAuthorID() {
        return authorID;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public long getLocationID() {
        return locationID;
    }

    @Override
    public String toString() {
        return "\n"+"id: " + this.ID + "\n" + "author: " + this.authorID + "\n" +
                "content: " + this.text+"\n"+ "date: "+this.date.toString() + "\n"+
                "what this location is: "+ this.locationID+"\n";
    }
}
