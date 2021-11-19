package com.example.demokitudjahanyadik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class AdventureController {

    static Random rand = new Random();
    static Scanner in = new Scanner(System.in);


    @FXML
    //Ide írja ki az aktuális történéseket(sebződés stb...)
    public Label textaction;

    @FXML
    public void onExitButtonClick(ActionEvent event) throws IOException {
        System.exit(0);
    }
//Enemy és Jatekos élő adatok
    public static Player player = new Player();
    public static Enemy enemy = new Enemy();

    @FXML
    protected void onStartButtonClick() throws IOException {
        //Átváltja a Scene-t a harcra
        FXMLLoader fightLoader = new FXMLLoader(Adventure.class.getResource("FightScene.fxml"));
        Scene fight = new Scene(fightLoader.load(), 537, 453);
        Adventure.window.setScene(fight);

        fightsetup();
    }

    //kiiratások beallitasa
    void fightsetup(){
        //beallitja az enemy adatait a harc előtt.
        enemy.Fightsetter("Spider", 1, 2, 3);
    }

    //ATTACK BUTTON
    //Az élő adatok módosításával játszadozva íratom ki az aktuális helyzetet.
    @FXML
    public void OnAttackClick() throws IOException {

    int damage=0;
    int attack;

        //rand.nextInt((max - min) + 1) + min    (random between 2 numbers)
        attack = rand.nextInt((AdventureController.player.weaponvalmax - AdventureController.player.weaponvalmin) + 1)
                + AdventureController.player.weaponvalmin;
        enemy.enemyhealth -= attack;     //h = Enemy életereje

        if (enemy.enemyhealth > 0) {
            damage = rand.nextInt(((enemy.enemyweaponvalmax) - enemy.enemyweaponvalmin) + 1) + enemy.enemyweaponvalmin;
            AdventureController.player.health -= damage;  //Saját életerőnk//
        }


        textaction.setText("Támadásba lendülsz és a(z) " + enemy.enemyname + " felé csapsz. \n** " + attack + " sebzést okozol.**\nA " + enemy.enemyname + "visszatámad!  ** " + damage + " életerőt veszítesz.**");

    }

/* !!Ezek majd az attack után jönnének!!

    //DEFEND BUTTON
    @FXML
    public void OnDefendClick() throws IOException {
        textaction.setText("WORKS?");
    }

    //HEAL BUTTON
    @FXML
    public void OnHealClick() throws IOException {
        textaction.setText("WORKS?");
    }

    //RUN BUTTON
    @FXML
    public void OnRunClick() throws IOException {
        textaction.setText("WORKS?");
    }
*/
}