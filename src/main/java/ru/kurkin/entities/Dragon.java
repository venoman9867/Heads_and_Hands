package ru.kurkin.entities;

import java.util.stream.IntStream;

public class Dragon extends Entity{
    public Dragon(int attack, int defense, int health, IntStream damage) {
        super(attack, defense, health, damage);
    }
}
