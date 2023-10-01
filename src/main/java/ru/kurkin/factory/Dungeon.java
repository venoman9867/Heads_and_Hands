package ru.kurkin.factory;

import ru.kurkin.entities.Dragon;
import ru.kurkin.entities.Entity;
import ru.kurkin.entities.Skeleton;
import ru.kurkin.entities.Slime;

public class Dungeon {
    public static Entity createMonster(String entity) {
        switch (entity) {
            case "Dragon" -> {
                return new Dragon(30, 30, 500, 50,100);
            }
            case "Slime" -> {
                return new Slime(5, 1, 20, 2,4);
            }
            case "Skeleton" -> {
                return new Skeleton(5, 1, 20, 1,10);
            }
            default -> throw new IllegalArgumentException("Неизвестный тип существа");
        }
    }
}
