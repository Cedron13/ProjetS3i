package ca.usherbrooke.gegi.server.persistence;

import ca.usherbrooke.gegi.server.business.Place;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;


import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
public interface PlaceMapper {
    List<Place> selectLocal(@Param("localid") String localId);
    List<Place> selectPlacesProches(@Param("localid") String localId, @Param("placeid") int placeId);

}
