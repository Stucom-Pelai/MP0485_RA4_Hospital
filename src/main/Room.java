package main;

import java.util.Random;

public class Room {
    private int number;
    private boolean bath;

    public Room(int number) {
        this.number = number;
        this.bath = new Random().nextBoolean(); // Randomly assign bath (yes/no)
    }

    public int getNumber() {
        return number;
    }

    public boolean hasBath() {
        return bath;
    }
}
