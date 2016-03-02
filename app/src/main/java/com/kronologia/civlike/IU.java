package com.kronologia.civlike;

import android.widget.TextView;

/**
 * Created by Maxence on 27/01/2016.
 */
public class IU {

    public enum EnumOccup {PEON, FERMIER};

    public Ville ville;

    public IU() {
        this.ville = new Ville(getNbTechs(), getNbRess());
    }

    public void majUI() {
        ville.majVille();
    }

    public int getNbTechs() {
        return 0;
    }

    public Journal getJournal() {
        return this.ville.journal;
    }

    public int getNbRess() { return 1; }

    public String listPersos() {
        String result = "";

        for(Personnage p : this.ville.getPop()) {
           result += (p.getOccup().name()+" ");
        }

        return result;
    }

}
