package com.kronologia.civlike;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Maxence on 27/01/2016.
 */
public class Event {

    private String datetime; //Utile pour l'affichage
    private long time; //Utile pour la chronologie des events en absolu

    private String titre;
    private String contenu;
    private boolean vu;

    public Event(String titre, String contenu, Journal j) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM HH:mm:ss");
        this.datetime = sdf.format(new Date());

        this.time = System.currentTimeMillis();

        this.titre = titre;
        this.contenu = contenu;
        this.vu = false;

        j.addEvent(this);
    }

    public String toString() {
        return this.titre + " (" + this.contenu + ") à " + this.datetime;
    }
}
