package ca.usherbrooke.gegi.server.business;

import java.util.ArrayList;
import java.util.List;



public class Local {
    private String LocalId;
    private List<Place> lesPlaces;

    public Local(String id){
        this.LocalId = id;
    }

    public List<Place> getLesPlaces() {
        return lesPlaces;
    }
    public void setLesPlaces(List<Place> lesPlaces) {
        this.lesPlaces = lesPlaces;
    }

    public String getLocalId() {
        return LocalId;
    }

    public void setLocalId(String localId) {
        LocalId = localId;
    }
    public List<ResultPlace> toResultPlaces(){
        List<ResultPlace> formatPlaces = new ArrayList<ResultPlace>();
        for(int i=0; i<this.lesPlaces.size();i++){
            formatPlaces.add(new ResultPlace(lesPlaces.get(i).getPlaceNumber(),lesPlaces.get(i).getCIP(), lesPlaces.get(i).getEtudiantName()));
        }
        return formatPlaces;
    }

    public boolean assignePlaces(Groupe groupe){

        int nbrEtudiant = groupe.getLesEtudiants().size();
        int etudiantAssigne =0;
        int indexPlaces = 0;

        while(etudiantAssigne < nbrEtudiant){

            if(indexPlaces== this.lesPlaces.size()){
                return false;
            }

            else if(this.lesPlaces.get(indexPlaces).isAssigner()){
                indexPlaces++;
            }

            else{
                this.lesPlaces.get(indexPlaces).setEtudiant(groupe.getLesEtudiants().get(etudiantAssigne));
                this.lesPlaces.get(indexPlaces).setAssigner(true);
                for(int i=etudiantAssigne+1; i<this.lesPlaces.size();i++){
                    if(this.lesPlaces.get(indexPlaces).getPlacesProches().isEmpty()){

                    }
                    else{
                        for(int j = 0; j< this.lesPlaces.get(indexPlaces).getPlacesProches().size();j++){
                            if(this.lesPlaces.get(i).getPlaceNumber()==this.lesPlaces.get(indexPlaces).getPlacesProches().get(j).getPlaceNumber()){
                                this.lesPlaces.get(i).setAssigner(true);
                            }
                        }
                    }
                }
                etudiantAssigne++;
                indexPlaces++;
            }
        }
        return true;
    }
}
