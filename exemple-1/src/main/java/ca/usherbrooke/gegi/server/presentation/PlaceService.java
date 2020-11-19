
package ca.usherbrooke.gegi.server.presentation;

        import ca.usherbrooke.gegi.server.business.*;
        import ca.usherbrooke.gegi.server.persistence.PlaceMapper;

        import javax.inject.Inject;
        import javax.servlet.http.HttpServletRequest;
        import javax.ws.rs.GET;
        import javax.ws.rs.Path;
        import javax.ws.rs.Produces;
        import javax.ws.rs.QueryParam;
        import javax.ws.rs.client.*;
        import javax.ws.rs.core.Context;
        import javax.ws.rs.core.GenericType;
        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;
        import java.util.ArrayList;
        import java.util.List;

@Path("")
public class PlaceService {

    @Context
    HttpServletRequest httpServletRequest;

    @Inject
    PlaceMapper placeMapper;

    @GET
    @Path("local")
    @Produces("application/json")
    public List<ResultPlace> getLocal(@QueryParam("localid") String localId, @QueryParam("etudiants") String etudiants, @QueryParam("disposition") int dis) {
        List<Place> lesPlaces =placeMapper.selectLocal(localId);
        for(int i=0;i<lesPlaces.size();i++){
            List<Place> placesTest= placeMapper.selectPlacesProches(localId, lesPlaces.get(i).getPlaceNumber(), dis);
            lesPlaces.get(i).setPlacesProches(placesTest);
        }
        Local local = new Local(localId);
        local.setLesPlaces(lesPlaces);
        //------------------------------------------------------------------------------
        Groupe leGroupe = new Groupe();
        List<Etudiant> lesEtudiants = new ArrayList<Etudiant>();
        String[] arrayEtudiant = etudiants.split(";");

        for(int x=0;x<arrayEtudiant.length;x++){
            lesEtudiants.add(new Etudiant(arrayEtudiant[x]));
        }


        leGroupe.setLesEtudiants(lesEtudiants);
        //------------------------------------------------------------------------------
        local.assignePlaces(leGroupe);
        return local.toResultPlaces();
    }
    @GET
    @Path("groupe")
    public String getGroupe() {


        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://zeus.gel.usherbrooke.ca:8080/ms/rest/trimestre?inscription=2017-01-01");
        Invocation.Builder  builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();

        List<Etudiant> ListEtudiants = response.readEntity(new GenericType<List<Etudiant>>(){});

        return "yes";

    }

/*
   @Produces("text/plain")
      public String getEtudiant(@QueryParam("id") Integer id) {
        System.out.println(httpServletRequest.getUserPrincipal().getName());
        List<Etudiant> etudiants = etudiantMapper.select(id);
        return etudiants.get(0).toString();
    }*/

    /*
    @GET
    @Path("insert_trimestre")
    public void insertTrimestre() {

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://zeus.gel.usherbrooke.ca:8080/ms/rest/trimestre?inscription=2017-01-01");
            Invocation.Builder  builder = target.request(MediaType.APPLICATION_JSON);
            Response response = builder.get();

            List<Trimestre> trimestres = response.readEntity(new GenericType<List<Trimestre>>(){});
            for (Trimestre trimestre : trimestres) {
               etudiantMapper.insertTrimestre(trimestre);
               System.out.println(trimestre);
            }


    } */
}
        /*
        Etudiant a = new Etudiant("a");
        a.setNom("Bob");
        Etudiant b = new Etudiant("b");
        b.setNom("Renault");
        Etudiant c = new Etudiant("c");
        c.setNom("Pierre");
        Etudiant d = new Etudiant("d");
        d.setNom("Francois");
        Etudiant e = new Etudiant("e");
        e.setNom("Alexandre");
        Etudiant f = new Etudiant("f");
        f.setNom("Tristan");
        Etudiant g = new Etudiant("g");
        g.setNom("Roger");

        lesEtudiants.add(a);
        lesEtudiants.add(b);
        lesEtudiants.add(c);
        lesEtudiants.add(d);
        lesEtudiants.add(e);
        lesEtudiants.add(f);
        lesEtudiants.add(g);*/