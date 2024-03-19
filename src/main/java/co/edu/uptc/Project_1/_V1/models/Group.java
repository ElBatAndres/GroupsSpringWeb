package co.edu.uptc.Project_1._V1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    private String subjectCode, placeCode;
    private List<Schedule> Schedules;
}
