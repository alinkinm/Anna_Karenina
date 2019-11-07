package tests;

import dao.PostDAO;
import dao.UserDAO;
import models.Post;
import models.User;

import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        User sasha = new User("alice", "007",(long)0, new Date(), "all ok");
        dao.save(sasha);

        List<User> myusers;
        myusers = dao.getAll();
        for (User user: myusers) {
            System.out.println(user.toString());
        }

        System.out.println(dao.get(4));

        dao.delete(55);

        PostDAO postDAO = new PostDAO();

        Post mypost = new Post(0, 1, "sdfsdf", new Date(), 3);
        postDAO.save(mypost);



    }
}
