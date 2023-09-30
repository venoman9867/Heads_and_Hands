package ru.kurkin.entities;

import java.util.stream.IntStream;

public class Player extends Entity{
    private final int maxHealth=health;
    private int countOfRevives=4;

    public Player(int attack, int defense, int health, IntStream damage) {
        super(attack, defense, health, damage);
    }

    @Override
    public void death() {
        super.death();
        if(countOfRevives!=0){
            countOfRevives=countOfRevives-1;
            isAlive=true;
            health=(int)(maxHealth*0.3);
            System.out.println("Произошло воскрешение "+this.getName());
            System.out.println("Количество доступных воскрешений стало: "+countOfRevives);
        }
    }
}
