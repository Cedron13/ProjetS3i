package ca.usherbrooke.gegi.server.business;

public class ResultPlace {
    int placenumber;
    String cip;
    String etudiantname;
    public ResultPlace(int num, String cip, String etudiant){
        this.placenumber = num;
        this.cip = cip;
        this.etudiantname = etudiant;
    }
    public int getPlacenumber() {
        return placenumber;
    }

    public void setPlacenumber(int placenumber) {
        this.placenumber = placenumber;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getEtudiantname() {
        return etudiantname;
    }

    public void setEtudiantname(String etudiantname) {
        this.etudiantname = etudiantname;
    }




}
