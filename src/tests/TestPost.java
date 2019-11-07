package tests;

import dao.PostDAO;
import models.Post;

import java.util.Date;

public class TestPost {
    public static void main(String[] args) {
        Post train = new Post(0, 5, "аня медленно подходит к" +
                " станции и загадочно смотрит " +
                "в даль",
                new Date(), 1);
        PostDAO postdao = new PostDAO();
        postdao.save(train);
        for (Post post: postdao.getAll()) {
            System.out.println(post);
        }
        System.out.println(postdao.get(2).toString());
        postdao.delete(1);
    }
}
