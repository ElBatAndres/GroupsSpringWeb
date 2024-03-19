package co.edu.uptc.Project_1._V1.services;

import co.edu.uptc.Project_1._V1.models.Group;
import co.edu.uptc.Project_1._V1.models.Schedule;
import co.edu.uptc.Project_1._V1.models.Subject;
import co.edu.uptc.SimpleList;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectService {
    List<Subject> list;

    public SubjectService(){
        list = InitSubjects();
    }

    public void addSubject(Subject subject) {
        list.add(subject);
    }

    public void deleteSubject(String id){
        boolean stop = false;
        for (int i = 0; i < list.size() && !stop; i++){
            if (list.get(i).getId().equals(id)) {
                stop = true;
                list.remove(i);
            }
        }

    }

    public void modifySubject(Subject subject){
        boolean stop = false;
        for (int i = 0; i < list.size() && !stop; i++){
            if (list.get(i).getId().equals(subject.getId())) {
                stop = true;
                list.set(i, subject);
            }
        }

    }

    public List<Subject> getSameSubjectsPlace(List<Group> groupList){
        List<Subject> samePlaceSubjectList = new SimpleList<>();
        for (int i = 0; i < groupList.size(); i++){
            for (int j = 0; j < groupList.size(); j++){
                if (groupList.get(i).getPlaceCode().equals(groupList.get(j).getPlaceCode()) && !(i == j) &&
                        !(isInList(findSubject(groupList.get(i).getSubjectCode()).getId(), samePlaceSubjectList))){
                    if (isInList(findSubject(groupList.get(i).getSubjectCode()).getId(), samePlaceSubjectList)){
                        samePlaceSubjectList.add(findSubject(groupList.get(j).getSubjectCode()));
                    } else{
                        samePlaceSubjectList.add(findSubject(groupList.get(i).getSubjectCode()));
                    }
                }
            }
        }
        return samePlaceSubjectList;
    }

    public List<Subject> getSubjectWithMoreGroups(List<Group> groupList){
        List<Subject> subjectWithMoreGroupsList = new SimpleList<>();
        for (int i = 0; i < groupList.size(); i++){
            for (int j = 0; j < groupList.size(); j++){
                if (groupList.get(i).getSubjectCode().equals(groupList.get(j).getSubjectCode()) && !(i == j) &&
                        !(isInList(findSubject(groupList.get(i).getSubjectCode()).getId(), subjectWithMoreGroupsList))){
                    if (isInList(findSubject(groupList.get(i).getSubjectCode()).getId(), subjectWithMoreGroupsList)){
                        subjectWithMoreGroupsList.add(findSubject(groupList.get(j).getSubjectCode()));
                    } else{
                        subjectWithMoreGroupsList.add(findSubject(groupList.get(i).getSubjectCode()));
                    }
                }
            }
        }
        return subjectWithMoreGroupsList;
    }

    public List<Subject> getSameScheduleSubjects(List<Group> groupList){
        List<Subject> sameScheduleSubjects = new SimpleList<>();
        for (int i = 0; i < groupList.size(); i++){
            List<Schedule> scheduleList = groupList.get(i).getSchedules();
            if (posSchedulesInList(groupList,groupList.get(i).getSchedules(), i) &&
                    !(isInList(findSubject(groupList.get(i).getSubjectCode()).getId(), sameScheduleSubjects))) {
                sameScheduleSubjects.add(findSubject(groupList.get(i).getSubjectCode()));
            }
        }
        return sameScheduleSubjects;
    }

    public boolean posSchedulesInList(List<Group> groupList, List<Schedule> schedules,  int schedulePos){
        boolean isSchedules = true;
        int cont = 0;
        List<Boolean> isList = new SimpleList<>();
        for (Schedule schedule : schedules) {
            isList.add(posScheduleInList(groupList, schedule ,cont, schedulePos));
            cont++;
        }
        if (!isList.isEmpty()){
            for (Boolean listElement : isList) {
                if (!listElement) {
                    isSchedules = false;
                    break;
                }
            }
        }
        return isSchedules;
    }

    public boolean posScheduleInList(List<Group> groupList, Schedule schedule, int pos, int schedulePos){
        boolean isSchedule = false;
        int cont = 0;
        for (Group groupElement : groupList) {
            if (groupElement.getSchedules().size() > pos) {
                Schedule scheduleElement = groupElement.getSchedules().get(pos);
                if (schedule.getEntryTime() == scheduleElement.getEntryTime() &&
                        schedule.getDepartureTime() == scheduleElement.getDepartureTime() &&
                        schedule.getDay().equals(scheduleElement.getDay()) && cont != schedulePos) {
                    isSchedule = true;
                }
            }
            cont++;
        }
        return isSchedule;
    }

    public Subject findSubject(String id){
        Subject subject = new Subject();
        for (Subject subjectElement : list) {
            if (subjectElement.getId().equals(id)){
                subject = subjectElement;
            }
        }
        return subject;
    }

    public boolean isInList(String id, List<Subject> subjectList){
        boolean isSubject = false;
        for (Subject subjectElement : subjectList) {
            if (subjectElement.getId().equals(id)){
                isSubject = true;
            }
        }
        return isSubject;
    }

    public List<Subject> InitSubjects(){
        List<Subject> list = new SimpleList<>();
        list.add(new Subject("Calculo 1","Cal1"));
        list.add(new Subject("Fisica 1","Fis1"));
        list.add(new Subject("Fisica 3","Fis3"));
        list.add(new Subject("Programacion 3","Prog3"));
        list.add(new Subject("Probabilidad y estadistica","ProbYEst"));
        list.add(new Subject("Expresion grafica y geometria descriptiva","ExpYGeo"));
        return list;
    }

}
