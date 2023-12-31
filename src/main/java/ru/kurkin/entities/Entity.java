package ru.kurkin.entities;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public abstract class Entity {
    private final int attack; //1..30
    private final int defense; //1..30
    protected int health; //0..N
    private final int startNumber;
    //поля сверху и снизу диапазон значений для произвольной атаки M-N, 1-6
    private final int endNumber;
    protected boolean isAlive = true;

    public Entity(int attack, int defense, int health, int startNumber,int endNumber) {
        if((attack<=30&&attack>0)&&(defense<=30&&defense>0)&&(health>0)){
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.startNumber=startNumber;
        this.endNumber=endNumber;
        }else{
            throw new IllegalArgumentException("Плохие параметры попробуйте снова создать объект");
        }
    }

    public void attack(Entity entity) {
        System.out.println(this.getName() + " атакует " + entity.getName());
        Random random = new Random();
        int modifier = this.attack - entity.defense + 1;
        //Всегда бросается 1 кубик
        if (modifier < 0 || modifier == 0) {
            if (random.nextInt(1, 7) == 5 || random.nextInt(1, 7) == 6) {
                entity.health = entity.health - getRandomDamage();
                System.out.println("Количество хп у " + entity.getName() + " " + entity.health);
                entity.death();//проверяем умерло ли существо?
            } else {
                System.out.println("Промах!");
            }
        } else {
            for (int i = 0; i < modifier; i++) {
                if (random.nextInt(1, 7) == 5 || random.nextInt(1, 7) == 6) {
                    entity.health = entity.health - getRandomDamage();
                    System.out.println("Количество хп у " + entity.getName() + " " + entity.health);
                    entity.death();//проверяем умерло ли существо?
                    break;
                }
                if (i == modifier - 1) {
                    System.out.println("Промах");
                }
            }
        }
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    private int getRandomDamage() {
        Random random=new Random();
        IntStream attackRange=IntStream.range(startNumber,endNumber);
        List<Integer> list=attackRange.boxed().toList();
        return list.get(random.nextInt(0,list.size()));
    }

    public void death() {
        if (health == 0 || health < 0) {
            isAlive = false;
        }
        if (!isAlive) {
            System.out.println("Существо " + this.getName() + " умерло");
        }
    }
}
