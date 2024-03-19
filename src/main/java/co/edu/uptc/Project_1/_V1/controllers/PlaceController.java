package co.edu.uptc.Project_1._V1.controllers;

import co.edu.uptc.Project_1._V1.dtos.GroupDtos;
import co.edu.uptc.Project_1._V1.dtos.PlaceDtos;
import co.edu.uptc.Project_1._V1.models.Group;
import co.edu.uptc.Project_1._V1.models.Place;
import co.edu.uptc.Project_1._V1.services.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/${placePath}")
public class PlaceController {

    PlaceService placeService = new PlaceService();

    @GetMapping("")
    public ResponseEntity<Object> getPlaces(){
        return ResponseEntity.status(HttpStatus.OK).body(placeService.getList());
    }

    @PostMapping("")
    public ResponseEntity<Object> addPlace(@RequestBody PlaceDtos placeDtos){
        Place place = PlaceDtos.fromPlaceDtos(placeDtos);
        placeService.addPlace(place);
        return ResponseEntity.status(HttpStatus.OK).body(placeService.getList());
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deletePlace(@RequestBody PlaceDtos placeDtos){
        Place place = PlaceDtos.fromPlaceDtos(placeDtos);
        placeService.deletePlace(place.getId());
        return ResponseEntity.status(HttpStatus.OK).body(place);
    }

    @PutMapping("")
    public ResponseEntity<Object> modifyPlace(@RequestBody PlaceDtos placeDtos){
        Place place = PlaceDtos.fromPlaceDtos(placeDtos);
        placeService.modifyPlace(place);
        return ResponseEntity.status(HttpStatus.OK).body(place);
    }

}
