package com.example.demokitudjahanyadik;
import java.util.Random;

public class Enemy {
    private static Random random = new Random();

    private String name;     //Játékos neve
    private int minimumDamage;  //min aktuális sebzés
    private int maximumDamage;  //max aktuális sebzés
    private int health;       //Aktuális életerő

    public void receiveDamage(int damage) {
        health -= damage;
    }
    public int dealDamage() {return random.nextInt(minimumDamage, maximumDamage + 1);}
    public int getMinimumDamage() {
        return minimumDamage;
    }
    public int getMaximumDamage() {
        return maximumDamage;
    }


    public boolean isAlive() {
        return health > 0;
    }

    public Enemy(String name, int powermin, int powermax, int health) {
        this.name = name;          //Enemy name
        minimumDamage = powermin;   //Enemy min power
        maximumDamage = powermax;   //Enemy max power
        this.health = health;        //Enemy health
    }

    public Enemy() {
        this("RandomEnemy", 1, 2, 10);
    }

    public String getName() {
        return name;
    }
    public int remainingHealth() {return health;}
}