package ca.usherbrooke.gegi.server.business;

import java.util.List;

public class Groupe {
    private String nomGroupe;
    private List<Etudiant> lesEtudiants;

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public List<Etudiant> getLesEtudiants() {
        return lesEtudiants;
    }

    public void setLesEtudiants(List<Etudiant> lesEtudiants) {
        this.lesEtudiants = lesEtudiants;
    }


}
