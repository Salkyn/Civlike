package com.kronologia.civlike;

import android.content.Context;

import com.kronologia.civlike.ClassPersos.Peon;

import java.util.ArrayList;

/**
 * Created by Maxence on 27/01/2016.
 */
public class Ville {

    private ArrayList<Personnage> population;
    private Techno[] allTechnos;
    public Journal journal;
    private Ressource[] ressources;

    public Ville(int nbTech, int nbRess) {
        this.population = new ArrayList<Personnage>(); //Personne dans la ville au départ
        this.allTechnos = new Techno[nbTech];
        this.ressources = new Ressource[nbRess];
        this.journal = new Journal();
    }

    public ArrayList<Personnage> getPop() {
        return this.population;
    }

    public void majVille() {
        //Update ressources
        for(int i = 0 ; i < ressources.length ; i++) {
            ressources[i].setValue(ressources[i].getValue()+ressources[i].getTaux());
            //Check si toutes les ressources sont >=0
            if(ressources[i].getValue() < 0) {
                this.libererRessource(ressources[i]);
            }
        }

        //maj temps recherches en cours
        for(int i = 0 ; i < allTechnos.length ; i++) {
            if(allTechnos[i].isEnCours()) {
                //TODO décrémenter le temps de recherche du temps écoulé depuis la dernière maj
            }
        }

    }

    public void addPeon() {
        Peon p = new Peon();
        population.add(p);

        this.getRessourceByName("Food").upTaux(Constantes.PEON_TX_CONSO_FOOD);

        journal.addEvent(new Event("Nouveau péon", "Ajout d'un nouveau péon", journal));
    }

    public Ressource getRessourceByName(String name) {
        for(Ressource r : this.ressources) {
            if(r.name == name) { return r; }
        }

        return null;
    }

    //TODO supprime des consommateurs de r jusqu'à que sont taux soit >0
    public void libererRessource(Ressource r) {
    }

    public void setRessources(/*objet Json*/) {
        Ressource r = new Ressource("Food");
        r.unlock();
        r.setValue(100);
        ressources[0] = r;

        //TODO lire le JSON et convertir texte en Resources
    }

    public void setAllTechnos() {
        //TODO idem
    }
}
