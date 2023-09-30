package ru.kurkin.entities;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public abstract class Entity {
    private final int attack; //1..30
    private final int defense; //1..30
    protected int health; //0..N
    private final IntStream damage; //M-N, 1-6
    protected boolean isAlive = true;

    public Entity(int attack, int defense, int health, IntStream damage) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.damage = damage;
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
        Random random = new Random();
        List<Integer> listOfDamages = damage.boxed().toList();
        return listOfDamages.get(random.nextInt(0, listOfDamages.size()));
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
