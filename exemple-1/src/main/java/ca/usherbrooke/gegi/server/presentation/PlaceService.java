
package ca.usherbrooke.gegi.server.presentation;

        import ca.usherbrooke.gegi.server.business.Groupe;
        import ca.usherbrooke.gegi.server.business.Local;
        import ca.usherbrooke.gegi.server.business.Place;
        import ca.usherbrooke.gegi.server.business.Etudiant;
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
    public Local getLocal(@QueryParam("localid") String localId) {
        System.out.println(localId);
        List<Place> lesPlaces =placeMapper.selectLocal(localId);
        for(int i=0;i<lesPlaces.size();i++){
            lesPlaces.get(i).setPlacesProches(placeMapper.selectPlacesProches(localId, lesPlaces.get(i).getPlaceNumber()));
        }
        Local local = new Local();
        local.setLesPlaces(lesPlaces);
        return local;
    }
   // public List<Groupe> getGroupes(@QueryParam("localid") String localId)
   /*

         select * from public.placesproches, public.places
    Where
    public.places.PlaceNumber = public.placesproches.placenumber
    AND
    public.places.LocalId = public.placesproches.localid_1
    AND
    public.places.LocalId = #{localId}


  <resultMap id="MapPlaces" type = "Place">
      <id property="nomPlace" column="placenumber"/>
      <result property="local" column= "localid"/>
      <result property="pastilleCouleur" column= "pastille_couleur"/>
      <collection property="placesProches" ofType="Place">
              <result property="nomPlace" column="placesprochesplacenumber"/>
      </collection>
  </resultMap>








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
