package ca.usherbrooke.gegi.server.business;


import java.util.ArrayList;
import java.util.List;

public class Etudiant {

    private String app;
    private String cip;
    private String departement;
    private List<String> groupes;
    private String dateInscription;
    private String nom;
    private String prenom;
    private String profilId;
    private String programme;
    private String trimestreId;
    private String uniteId;
    private Integer etudiant_app_id;

    public Etudiant(int app, String cip, String departement, ArrayList<String> groupes, String dateInscription, String nom, String prenom, String profilId, String programme, String trimestreId, String uniteId) {
        //this.app = app;
        this.cip = cip;
        this.departement = departement;
        this.groupes = groupes;
        this.dateInscription = dateInscription;
        this.nom = nom;
        this.prenom = prenom;
        this.profilId = profilId;
        this.programme = programme;
        this.trimestreId = trimestreId;
        this.uniteId = uniteId;
    }

    public Etudiant(String n){
        cip = n;

    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public List<String> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<String> groupes) {
        this.groupes = groupes;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProfilId() {
        return profilId;
    }

    public void setProfilId(String profilId) {
        this.profilId = profilId;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getTrimestreId() {
        return trimestreId;
    }

    public void setTrimestreId(String trimestreId) {
        this.trimestreId = trimestreId;
    }

    public String getUniteId() {
        return uniteId;
    }

    public void setUniteId(String uniteId) {
        this.uniteId = uniteId;
    }

    public Integer getEtudiant_app_id() {
        return etudiant_app_id;
    }

    public void setEtudiant_app_id(Integer etudiant_app_id) {
        this.etudiant_app_id = etudiant_app_id;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "app='" + app + '\'' +
                ", cip='" + cip + '\'' +
                ", departement='" + departement + '\'' +
                ", groupes='" + groupes + '\'' +
                ", dateInscription='" + dateInscription + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", profilId='" + profilId + '\'' +
                ", programme='" + programme + '\'' +
                ", trimestreId='" + trimestreId + '\'' +
                ", uniteId='" + uniteId + '\'' +
                ", etudiant_app_id=" + etudiant_app_id +
                '}';
    }
}