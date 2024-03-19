package co.edu.uptc.Project_1._V1.dtos;

import co.edu.uptc.Project_1._V1.models.Place;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceDtos {

    private String id, name, location;

    public static PlaceDtos fromPlace(Place place){
        PlaceDtos placeDtos = new PlaceDtos();
        placeDtos.setId(place.getId());
        placeDtos.setName(place.getName());
        placeDtos.setLocation(place.getLocation());
        return placeDtos;
    }

    public static Place fromPlaceDtos(PlaceDtos placeDtos){
        Place place = new Place();
        place.setId(placeDtos.getId());
        place.setName(placeDtos.getName());
        place.setLocation(placeDtos.getLocation());
        return place;
    }

}
