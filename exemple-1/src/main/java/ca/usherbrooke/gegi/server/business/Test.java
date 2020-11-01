package ca.usherbrooke.gegi.server.business;

import java.util.List;
import java.util.ArrayList;

public class Test
{

public static void main(String[]args){

    Groupe A20 = new Groupe();
    List<Etudiant> lesEtudiants = new ArrayList<Etudiant>();

    Etudiant a = new Etudiant("a");
    Etudiant b = new Etudiant("b");
    Etudiant c = new Etudiant("c");
    Etudiant d = new Etudiant("d");
    Etudiant e = new Etudiant("e");
    Etudiant f = new Etudiant("f");
    Etudiant g = new Etudiant("g");

    lesEtudiants.add(a);
    lesEtudiants.add(b);
    lesEtudiants.add(c);
    lesEtudiants.add(d);
    lesEtudiants.add(e);
    lesEtudiants.add(f);
    lesEtudiants.add(g);

    A20.setLesEtudiants(lesEtudiants);

    Local local = new Local("C1-5001");
    Place a1 = new Place(1, "");
    Place a2 = new Place(2, "");
    Place a3 = new Place(3, "");
    Place a4 = new Place(4, "");
    Place a5 = new Place(5, "");
    Place a6 = new Place(6, "");
    Place a7 = new Place(7, "");

    Place a8 = new Place(8, "");
    Place a9 = new Place(9, "");
    Place a10 = new Place(10, "");
    Place a11 = new Place(11, "");
    Place a12 = new Place(12, "");
    Place a13 = new Place(13, "");

    List<Place> placeprochesA1 = new ArrayList<Place>();
    placeprochesA1.add(a2);
    List<Place> placeprochesA2 = new ArrayList<Place>();
    placeprochesA2.add(a1);
    placeprochesA2.add(a3);
    List<Place> placeprochesA3 = new ArrayList<Place>();
    placeprochesA3.add(a2);
    placeprochesA3.add(a4);
    List<Place> placeprochesA4 = new ArrayList<Place>();
    placeprochesA4.add(a3);
    placeprochesA4.add(a5);
    List<Place> placeprochesA5 = new ArrayList<Place>();
    placeprochesA5.add(a4);
    placeprochesA5.add(a6);
    List<Place> placeprochesA6 = new ArrayList<Place>();
    placeprochesA6.add(a5);
    placeprochesA6.add(a7);
    List<Place> placeprochesA7 = new ArrayList<Place>();
    placeprochesA7.add(a6);

    List<Place> placeprochesA8 = new ArrayList<Place>();
    List<Place> placeprochesA9 = new ArrayList<Place>();
    List<Place> placeprochesA10 = new ArrayList<Place>();
    List<Place> placeprochesA11 = new ArrayList<Place>();
    List<Place> placeprochesA12 = new ArrayList<Place>();
    List<Place> placeprochesA13 = new ArrayList<Place>();



    a1.setPlacesProches(placeprochesA1);
    a2.setPlacesProches(placeprochesA2);
    a3.setPlacesProches(placeprochesA3);
    a4.setPlacesProches(placeprochesA4);
    a5.setPlacesProches(placeprochesA5);
    a6.setPlacesProches(placeprochesA6);
    a7.setPlacesProches(placeprochesA7);
    a8.setPlacesProches(placeprochesA8);
    a9.setPlacesProches(placeprochesA9);
    a10.setPlacesProches(placeprochesA10);
    a11.setPlacesProches(placeprochesA11);
    a12.setPlacesProches(placeprochesA12);
    a13.setPlacesProches(placeprochesA13);


    List<Place> lesPlaces = new ArrayList<Place>();
    lesPlaces.add(a1);
    lesPlaces.add(a2);
    lesPlaces.add(a3);
    lesPlaces.add(a4);
    lesPlaces.add(a5);
    lesPlaces.add(a6);
    lesPlaces.add(a7);
    lesPlaces.add(a8);
    lesPlaces.add(a9);
    lesPlaces.add(a10);
    lesPlaces.add(a11);
    lesPlaces.add(a12);
    lesPlaces.add(a13);



    local.setLesPlaces(lesPlaces);

    local.assignePlaces(A20);
    String s = local.toString();
    System.out.println(s);






}
}