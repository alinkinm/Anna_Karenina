package tests;

import dao.HeroDAO;
import models.Hero;

public class TestHero {
    public static void main(String[] args) {
        Hero hero = new Hero(0, 3, "Anna", "123.jpg",
                "я Аня я жду поезд");
        HeroDAO herodao = new HeroDAO();
        herodao.save(hero);
        for (Hero myhero: herodao.getAll()) {
            System.out.println(myhero);
        }
        System.out.println(herodao.get(1).toString());
        herodao.delete(5);
    }
}
