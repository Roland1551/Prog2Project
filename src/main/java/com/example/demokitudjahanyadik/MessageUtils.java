package com.example.demokitudjahanyadik;

public class MessageUtils {
    public static String getAttackMessage(String enemyName, int attack, int damage) {
        return String.format("Támadásba lendülsz és a(z) %s felé csapsz.\n** %s sebzést okozol.**\nA(z) %s visszatámad!\n** %s életerőt veszítesz.**", enemyName, attack, enemyName, damage);
    }
    public static String getWinMessage(String enemyName) {
        return String.format("Győzelmet arattál a(z) %s felett.**", enemyName);
    }
    public static String getLoseMessage(String enemyName) {
        return String.format("**A(z) %s legyőzött. Próbáld újra!**", enemyName);
    }

    public static String getHealMessage(int healPoint, int remainingBandage) {
        return String.format("**Elhasználtál 1 kötszert, ezzel %s életerőt szereztél.\n %s db kötszered maradt.**", healPoint, remainingBandage);
    }

    public static String RunSuccess(String enemyName) {
        return ("**Sikeresen elmenekültél a(z) %s elől.**");
    }

    public static String RunFail(String enemyName, int damage) {
        return ("**Megpróbáltál elmenekülni a(z) %s elől, de sajnos nem sikerült.\n %s életerőt veszítettél.**");
    }
}
