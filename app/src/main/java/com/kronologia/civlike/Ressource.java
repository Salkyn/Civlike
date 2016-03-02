package com.kronologia.civlike;

/**
 * Created by Maxence on 01/02/2016.
 */
public class Ressource {

    public String name;
    private int value;
    private boolean locked;
    private int taux;

    public Ressource(String name) {
        this.name = name;
        this.value = 0; //Ressource à 0 au départ
        this.taux = 0;
        this.locked = true; //Au départ toutes les ressources sont bloquées, TODO débloquer les ressources initiales au lancement de la game
    }

    public void unlock() {
        this.locked = false;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int getTaux() {
        return this.taux;
    }

    public void upTaux(int increase) {
        this.taux += increase;
    }
}
