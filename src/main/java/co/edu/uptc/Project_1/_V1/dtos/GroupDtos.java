package co.edu.uptc.Project_1._V1.dtos;

import co.edu.uptc.Project_1._V1.models.Group;
import co.edu.uptc.Project_1._V1.models.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupDtos {

    private String subjectCode, placeCode;
    private List<Schedule> schedules;

    public static GroupDtos fromGroup(Group group) {
        GroupDtos groupDtos = new GroupDtos();
        groupDtos.setSubjectCode(group.getSubjectCode());
        groupDtos.setPlaceCode(group.getPlaceCode());
        groupDtos.setSchedules(group.getSchedules());
        return groupDtos;
    }

    public static Group fromGroupDtos(GroupDtos groupDtos) {
        Group group = new Group();
        group.setSubjectCode(groupDtos.getSubjectCode());
        group.setPlaceCode(groupDtos.getPlaceCode());
        group.setSchedules(groupDtos.getSchedules());
        return group;
    }
}
