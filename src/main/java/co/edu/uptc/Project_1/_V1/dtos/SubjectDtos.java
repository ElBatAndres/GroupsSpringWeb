package co.edu.uptc.Project_1._V1.dtos;

import co.edu.uptc.Project_1._V1.models.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDtos {

    private String name, id;

    public static SubjectDtos fromSubject(Subject subject){
        SubjectDtos subjectDtos = new SubjectDtos();
        subjectDtos.setName(subject.getName());
        subjectDtos.setId(subject.getId());
        return subjectDtos;
    }

    public static Subject fromSubjectDtos(SubjectDtos subjectDtos){
        Subject subject = new Subject();
        subject.setName(subjectDtos.getName());
        subject.setId(subjectDtos.getId());
        return subject;
    }
}
