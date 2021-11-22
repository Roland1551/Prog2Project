package com.example.demokitudjahanyadik;

import com.example.demokitudjahanyadik.Adventure;
import com.example.demokitudjahanyadik.Enemy;
import com.example.demokitudjahanyadik.Player;
import com.example.demokitudjahanyadik.MessageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.Scene;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Scanner;


public class AdventureController {

    static Random rand = new Random();
    static Scanner in = new Scanner(System.in);


    @FXML
    //GOMBOK, LABELEK
    public Label textaction;
    public Label playername;
    public Label playerdamage;
    public Label playerhealth;
    public Label playerbandage;
    public Label playershield;
    public Label playerrunchance;
    public Button fightexit;
    public Button attackbutton;
    public Button defendbutton;
    public Button runbutton;
    public Button healbutton;
    public Button exitbutton;
    public Label enemyhealth;
    public Label enemydamage;
    public Label enemyname;

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

    void fightsetup(){
        enemy = new Enemy("Spider", 1, 2, 10);
    }

    void exitfight(){
        exitbutton.setVisible(true);
        attackbutton.setVisible(false);
        defendbutton.setVisible(false);
        runbutton.setVisible(false);
        healbutton.setVisible(false);
    }


    void textRefresh(){
        playername.setText(player.getName());
        playerhealth.setText("Életerő: "+player.remainingHealth());
        playerbandage.setText("Kötszer: "+ player.remainingBandage());
        playershield.setText("Páncél: "+ player.remainingShield()) ;
        playerrunchance.setText("Menekülés: " + player.getRunLvl() +" %");
       
      //enemyhealth.setText("Életerő: "+enemy.remainingHealth());
    }


    //ATTACK BUTTON
    @FXML
    public void OnAttackClick() throws IOException {

        int damage = 0;
        int attack = 0;

        if(player.hasBandage())
        healbutton.setVisible(true);
        defendbutton.setVisible(true);
        runbutton.setVisible(false);


            attack = player.dealDamage();
            enemy.receiveDamage(attack);

            if(enemy.isAlive()) {
                damage = enemy.dealDamage();
                player.receiveDamage(damage);
            }
            textaction.setText(MessageUtils.getAttackMessage(enemy.getName(), attack, damage));
            textRefresh();
/*
        {
            if (player.isAlive()) {
                textaction.setText(MessageUtils.getWinMessage(enemy.getName()));
            } else {
                textaction.setText(MessageUtils.getLoseMessage(enemy.getName()));

            }
            exitfight();*/
        }

   /* //DEFEND BUTTON
    @FXML
    public void OnDefendClick() throws IOException {
        textaction.setText("WORKS?");
    }*/

    //HEAL BUTTON
    @FXML
    public void OnHealClick() throws IOException {
        if(player.hasBandage()) {
            player.increaseHealth(player.getBandageLvl());
            player.decreaseBandage();
            if(player.hasBandage()==false)
                healbutton.setVisible(false);
            textaction.setText(MessageUtils.getHealMessage(player.getBandageLvl(), player.remainingBandage()));
        }
        textRefresh();
    }

    //RUN BUTTON
    @FXML
    public void OnRunClick() throws IOException {
        int damage;
        damage = enemy.dealDamage();

        if(player.Run()) {
            textaction.setText(MessageUtils.RunSuccess(enemy.getName()));
            exitfight();
        }
        else{
            textaction.setText(MessageUtils.RunFail(enemy.getName(), damage));
            player.receiveDamage(damage);
            healbutton.setVisible(true);
            defendbutton.setVisible(true);
            runbutton.setVisible(false);
        }
        textRefresh();
    }

    public void OnExitClick() throws IOException {
        FXMLLoader helloLoader = new FXMLLoader(Adventure.class.getResource("hello-view.fxml"));
        Scene hello = new Scene(helloLoader.load(), 320, 240);
        Adventure.window.setScene(hello);
    }
}