package com.kronologia.civlike;

/**
 * Created by Maxence on 27/01/2016.
 */
public class Personnage {

    private IU.EnumOccup occupation;
    private boolean vivant;
    private boolean isPeon;

    public Personnage() {
        this.occupation = IU.EnumOccup.PEON;
        this.vivant = true;
        this.isPeon = true;
    }

    public IU.EnumOccup getOccup() {
        return this.occupation;
    }

    public void changeOccup(IU.EnumOccup newOccup) {
        this.occupation = newOccup;
    }
}
