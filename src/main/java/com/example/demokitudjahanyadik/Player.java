package com.example.demokitudjahanyadik;
import java.util.Random;

public class Player {
    private static Random random = new Random();

    private String name="John";     //Játékos neve
    private int scrap=0;         //Barkács alapanyag
    private int health=30;       //Aktuális életerő
    private int bandage=1;       //Kötszerek száma
    private int bandagelvl=3;       //Kötszerek száma
    private int runlvl=50;         //Barkács alapanyag
    private int shieldval=0;      //Páncél védelme
    private int minimumDamage=1;  //min aktuális sebzés
    private int maximumDamage=2;  //max aktuális sebzés

    //RUN
    public void increaseRunLvl() {
        if(runlvl<100)
            runlvl+=10;}
    public int getRunLvl() {return runlvl;}
    public boolean Run(){return (random.nextInt(0,100+1)<runlvl);}

    //NAME
    public void changeName(String addname) {name=addname;}
    public String getName() {
        return name;
    }

    //DAMAGE
    public void receiveDamage(int damage) {health-=damage;}
    public int dealDamage() {return random.nextInt(minimumDamage, maximumDamage+1);}
    public void increaseDamage(int adddamage) {minimumDamage+=adddamage; maximumDamage+=adddamage;}

    //KÖTSZER
    public boolean hasBandage() {return bandage>0;}
    public void increaseBandage() {bandage++;}
    public void decreaseBandage() {bandage--;}
    public void increaseBandageLvl() {bandagelvl++;}
    public int getBandageLvl() {return bandagelvl;}
    public int remainingBandage() {return bandage;}

    //HEALTH
    public void increaseHealth(int addhealth) {health+=addhealth;}
    public void decreaseHealth(int removehealth) {health-=removehealth;}
    public int remainingHealth() {return health;}

    //SHIELD
    public void increaseShield(int addshield) {shieldval+=addshield;}
    public int remainingShield() {return shieldval;}

    //SCRAP
    public void increaseScrap(int addscrap) {scrap+=addscrap;}
    public void decreaseScrap(int removescrap) {scrap-=removescrap;}
    public int remainingScrap() {return scrap;}

    public boolean isAlive() {return health>0;}




}