package co.edu.uptc.Project_1._V1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Schedule {

    private int entryTime, departureTime;
    private String day;
}
