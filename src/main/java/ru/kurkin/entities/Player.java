package ru.kurkin.entities;

public class Player extends Entity{
    private final int maxHealth=health;
    private int countOfRevives=4;

    public Player(int attack, int defense, int health, int startNumber, int endNumber) {
        super(attack, defense, health, startNumber, endNumber);
    }


    @Override
    public void death() {
        super.death();
        if((countOfRevives!=0)&&(countOfRevives>0)){
            countOfRevives=countOfRevives-1;
            isAlive=true;
            health=(int)(maxHealth*0.3);
            System.out.println("Произошло воскрешение "+this.getName());
            System.out.println("Количество доступных воскрешений стало: "+countOfRevives);
        }
    }
}
