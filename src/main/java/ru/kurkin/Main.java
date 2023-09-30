package ru.kurkin;

import ru.kurkin.entities.Dragon;
import ru.kurkin.entities.Player;
import ru.kurkin.entities.Skeleton;
import ru.kurkin.entities.Slime;
import ru.kurkin.factory.Dungeon;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream playerAttackRange = IntStream.range(1, 50);
        Player player = new Player(20, 15, 50, playerAttackRange);
        Slime slime = (Slime) (Dungeon.createMonster("Slime"));
        Dragon dragon = (Dragon) (Dungeon.createMonster("Dragon"));
        Skeleton skeleton = (Skeleton) (Dungeon.createMonster("Skeleton"));
        slime.attack(skeleton);
        skeleton.attack(slime);
        dragon.attack(player);
    }
}