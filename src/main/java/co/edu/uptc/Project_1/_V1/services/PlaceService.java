package co.edu.uptc.Project_1._V1.services;

import co.edu.uptc.Project_1._V1.models.Place;
import co.edu.uptc.Project_1._V1.models.Subject;
import co.edu.uptc.SimpleList;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlaceService {
    List<Place> list;

    public PlaceService(){
        list = initPlaces();
    }

    public void addPlace(Place place) {
        list.add(place);
    }

    public void deletePlace(String id) {
        boolean stop = false;
        for (int i = 0; i < list.size() && !stop; i++){
            if (list.get(i).getId().equals(id)) {
                stop = true;
                list.remove(i);
            }
        }
    }

    public void modifyPlace(Place place){
        boolean stop = false;
        for (int i = 0; i < list.size() && !stop; i++){
            if (list.get(i).getId().equals(place.getId())) {
                stop = true;
                list.set(i, place);
            }
        }

    }

    public List<Place> initPlaces(){
        List<Place> list = new SimpleList<>();
        list.add(new Place("Edificio Rafael Azula","UPTC_Suroeste","R"));
        list.add(new Place("Edificio Camilo Torres","UPTC_Centro","C"));
        list.add(new Place("Biblioteca","UPTC_Centro","Bi"));
        list.add(new Place("Edificio Administrativo","UPTC_Oeste","Ad"));
        list.add(new Place("Laboratorios","UPTC_Norte","La"));
        return list;
    }

}
