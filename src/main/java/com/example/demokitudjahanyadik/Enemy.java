package com.example.demokitudjahanyadik;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Enemy {

        public void Fightsetter(String name, int powermin, int powermax, int health) {
            enemyname = name;          //Enemy name
            enemyweaponvalmin = powermin;   //Enemy min power
            enemyweaponvalmax = powermax;   //Enemy max power
            enemyhealth = health;        //Enemy health
        }

    public String enemyname = "RandomEnemy";     //Játékos neve
    public int enemyweaponvalmin = 1;  //min aktuális sebzés
    public int enemyweaponvalmax = 2;  //max aktuális sebzés
    public int enemyhealth = 10;       //Aktuális életerő
}