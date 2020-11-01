package ca.usherbrooke.gegi.server.business;

import java.util.List;

public class Place {

    private int PlaceNumber;
    private String Pastille_Couleur;
    private boolean isAssigner;
    private String EtudiantName;
    private String CIP;
    private List<Place> placesProches;

    public int getPlaceNumber() {
        return PlaceNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        PlaceNumber = placeNumber;
    }

    public boolean isAssigner() {
        return isAssigner;
    }

    public void setAssigner(boolean assigner) {
        isAssigner = assigner;
    }


    public String getPastille_Couleur() {
        return Pastille_Couleur;
    }

    public void setPastille_Couleur(String pastille_Couleur) {
        Pastille_Couleur = pastille_Couleur;
    }

    public String getEtudiantName() {
        return EtudiantName;
    }

    public void setEtudiantName(String etudiantName) {
        EtudiantName = etudiantName;
    }

    public String getCIP() {
        return CIP;
    }

    public void setCIP(String CIP) {
        this.CIP = CIP;
    }



    public Place(int nom){
        PlaceNumber = nom;
        Pastille_Couleur = "White";
    }
    public Place(int nom, String couleur){
        PlaceNumber = nom;
        Pastille_Couleur = couleur;
    }


    public void setEtudiant(Etudiant etudiant) {
        this.CIP = etudiant.getCip();
        this.EtudiantName = etudiant.getName();
    }

    public List<Place> getPlacesProches() {
        return placesProches;
    }

    public void setPlacesProches(List<Place> placesProches) {
        this.placesProches = placesProches;
    }


}
