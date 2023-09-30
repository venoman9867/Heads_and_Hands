package ru.kurkin.factory;

import ru.kurkin.entities.Dragon;
import ru.kurkin.entities.Entity;
import ru.kurkin.entities.Skeleton;
import ru.kurkin.entities.Slime;

import java.util.stream.IntStream;

public class Dungeon {
    public static Entity createMonster(String entity) {
        switch (entity) {
            case "Dragon" -> {
                IntStream dragonAttackRange = IntStream.range(50, 100);
                return new Dragon(30, 30, 500, dragonAttackRange);
            }
            case "Slime" -> {
                IntStream slimeAttackRange = IntStream.range(1, 4);
                return new Slime(5, 1, 20, slimeAttackRange);
            }
            case "Skeleton" -> {
                IntStream skeletonAttackRange = IntStream.range(2, 10);
                return new Skeleton(5, 1, 20, skeletonAttackRange);
            }
            default -> throw new IllegalArgumentException("Неизвестный тип существа");
        }
    }
}
