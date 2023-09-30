package ru.kurkin.entities;

import java.util.stream.IntStream;

public class Slime extends Entity{
    public Slime(int attack, int defense, int health, IntStream damage) {
        super(attack, defense, health, damage);
    }
}
