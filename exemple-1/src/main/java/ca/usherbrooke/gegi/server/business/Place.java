package ca.usherbrooke.gegi.server.business;

import java.util.List;

public class Place {
    private int PlaceNumber;
    private String Pastille_Couleur;
    private boolean isAssigner;
    private Etudiant etudiant;
    private List<Place> placesProches;

    public Place(int nom){
        PlaceNumber = nom;
        etudiant = new Etudiant("");
        Pastille_Couleur = "White";
    }
    public Place(int nom, String couleur){
        PlaceNumber = nom;
        etudiant = new Etudiant("");
        Pastille_Couleur = couleur;
    }
    public int getPlaceNumber() {
        return PlaceNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.PlaceNumber = placeNumber;
    }

    public boolean isAssigner() {
        return isAssigner;
    }

    public void setAssigner(boolean assigner) {
        isAssigner = assigner;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public List<Place> getPlacesProches() {
        return placesProches;
    }

    public void setPlacesProches(List<Place> placesProches) {
        this.placesProches = placesProches;
    }


}
