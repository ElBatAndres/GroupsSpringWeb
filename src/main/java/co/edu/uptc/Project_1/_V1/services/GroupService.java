package co.edu.uptc.Project_1._V1.services;

import co.edu.uptc.Project_1._V1.models.Group;
import co.edu.uptc.Project_1._V1.models.Place;
import co.edu.uptc.Project_1._V1.models.Schedule;
import co.edu.uptc.Project_1._V1.models.Subject;
import co.edu.uptc.SimpleList;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupService {
    List<Group> list;

    public GroupService(){
        list = initGroups();
    }

    public void addGroup(Group group){
        list.add(group);
    }

    public void deleteGroup(Group group){
        int posSubject = posSubjectInList(group.getSubjectCode()), posPlace = posPlaceInList(group.getPlaceCode()),
                posSchedules = posSchedulesInList(group.getSchedules());
        if (posSubject != -1 && posPlace != -1 && posSchedules != -1){
            if (posSubject == posPlace && posPlace == posSchedules){
                list.remove(posPlace);
            } else {
                // mensaje no se elimino el elemento
            }
        } else {
            // mensaje no se encontro el elemento
        }
    }

    public void modifyGroup(Group group){
        int posSubject = posSubjectInList(group.getSubjectCode()), posPlace = posPlaceInList(group.getPlaceCode());
        if (posSubject != -1 && posPlace != -1)  {
            if (posSubject == posPlace){
                list.set(posPlace, group);
            } else{
                // mensaje no se modifico
            }
        } else{
            //mensaje no se encontro
        }
    }

    public int posSubjectInList(String subject){
        List<String> subjectsIdsList = getSubjectsIds();
        int posSubject = -1, cont = 0;
        for (String subjectElement : subjectsIdsList) {
            if (subject.equals(subjectElement)) {
                posSubject = cont;
            }
            cont++;
        }
        return posSubject;
    }

    public int posPlaceInList(String place){
        List<String> placeIdsList = getPlaceIds();
        int posPlace = -1, cont = 0;
        for (String placeElement : placeIdsList) {
            if (place.equals(placeElement)) {
                posPlace = cont;
            }
            cont++;
        }
        return posPlace;
    }

    public int posScheduleInList(Schedule schedule, int pos){
        int posSchedule = -1, cont = 0;
        for (Group groupElement : list) {
            if (groupElement.getSchedules().size() > pos) {
                Schedule scheduleElement = groupElement.getSchedules().get(pos);
                if (schedule.getEntryTime() == scheduleElement.getEntryTime() &&
                        schedule.getDepartureTime() == scheduleElement.getDepartureTime() &&
                        schedule.getDay().equals(scheduleElement.getDay())) {
                    posSchedule = cont;
                }
            }
            cont++;
        }
        return posSchedule;
    }

    public int posSchedulesInList(List<Schedule> schedules){
        int posSchedules = -1, cont = 0;
        List<Integer> posList = new SimpleList<>();
        for (Schedule schedule : schedules) {
            posList.add(posScheduleInList(schedule ,cont));
            cont++;
        }
        if (!posList.isEmpty()){
            int firstPos = posList.get(0);
            for (Integer posElement : posList) {
                if (firstPos == posElement) {
                    posSchedules = firstPos;
                } else {
                    posSchedules = -1;
                }
            }
        }
        return posSchedules;
    }

    public List<Group> initGroups(){
        List<Group> list = new SimpleList<>();
        List<Schedule> scheduleList = new SimpleList<>();
        scheduleList.add(new Schedule(12,16,"martes"));
        scheduleList.add(new Schedule(14,16, "jueves"));
        list.add(new Group("ProbYEst","C", scheduleList));
        scheduleList = new SimpleList<>();
        scheduleList.add(new Schedule(8,10,"lunes"));
        scheduleList.add(new Schedule(8,10, "viernes"));
        list.add(new Group("Fis3","R", scheduleList));
        scheduleList = new SimpleList<>();
        scheduleList.add(new Schedule(16,18,"martes"));
        scheduleList.add(new Schedule(16,18, "miercoles"));
        scheduleList.add(new Schedule(16,18, "jueves"));
        list.add(new Group("ExpYGeo","C", scheduleList));
        scheduleList = new SimpleList<>();
        scheduleList.add(new Schedule(18,20,"martes"));
        scheduleList.add(new Schedule(18,20, "viernes"));
        list.add(new Group("Fis1","A", scheduleList));
        scheduleList = new SimpleList<>();
        scheduleList.add(new Schedule(16,18,"martes"));
        scheduleList.add(new Schedule(16,18, "miercoles"));
        scheduleList.add(new Schedule(16,18, "jueves"));
        list.add(new Group("Cal1","R", scheduleList));
        scheduleList = new SimpleList<>();
        scheduleList.add(new Schedule(6,8,"lunes"));
        scheduleList.add(new Schedule(6,8, "martes"));
        list.add(new Group("Prog3","Bi", scheduleList));
        scheduleList = new SimpleList<>();
        scheduleList.add(new Schedule(16,18,"martes"));
        scheduleList.add(new Schedule(16,18, "miercoles"));
        scheduleList.add(new Schedule(16,20, "jueves"));
        list.add(new Group("Fis1","La", scheduleList));
        scheduleList = new SimpleList<>();
        scheduleList.add(new Schedule(6,8,"lunes"));
        scheduleList.add(new Schedule(6,8, "martes"));
        list.add(new Group("Fis3","R", scheduleList));
        return list;
    }

    public List<String> getSubjectsIds(){
        List<String> idlist = new SimpleList<>();
        for (Group group : list) {
            idlist.add(group.getSubjectCode());
        }
        return idlist;
    }

    public List<String> getPlaceIds(){
        List<String> idlist = new SimpleList<>();
        for (Group group : list) {
            idlist.add(group.getPlaceCode());
        }
        return idlist;
    }

}
