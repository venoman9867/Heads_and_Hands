package ru.kurkin.entities;

import java.util.stream.IntStream;

public class Skeleton extends Entity{

    public Skeleton(int attack, int defense, int health, IntStream damage) {
        super(attack, defense, health, damage);
    }
}
