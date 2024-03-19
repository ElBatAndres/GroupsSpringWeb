package co.edu.uptc.Project_1._V1.controllers;

import co.edu.uptc.Project_1._V1.dtos.PlaceDtos;
import co.edu.uptc.Project_1._V1.dtos.SubjectDtos;
import co.edu.uptc.Project_1._V1.models.Group;
import co.edu.uptc.Project_1._V1.models.Place;
import co.edu.uptc.Project_1._V1.models.Subject;
import co.edu.uptc.Project_1._V1.services.GroupService;
import co.edu.uptc.Project_1._V1.services.SubjectService;
import co.edu.uptc.SimpleList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${subjectPath}")
public class SubjectController {

    SubjectService subjectService = new SubjectService();
    GroupService groupService = new GroupService();

    @GetMapping("")
    public ResponseEntity<Object> getSubjects(){
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getList());
    }

    @PostMapping("")
    public ResponseEntity<Object> addSubject(@RequestBody SubjectDtos subjectDtos){
        Subject subject = SubjectDtos.fromSubjectDtos(subjectDtos);
        subjectService.addSubject(subject);
        return ResponseEntity.status(HttpStatus.OK).body(subject);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteSubject(@RequestBody SubjectDtos subjectDtos){
        Subject subject = SubjectDtos.fromSubjectDtos(subjectDtos);
        subjectService.deleteSubject(subject.getId());
        return ResponseEntity.status(HttpStatus.OK).body(subject);
    }

    @PutMapping("")
    public ResponseEntity<Object> modifySubject(@RequestBody SubjectDtos subjectDtos){
        Subject subject = SubjectDtos.fromSubjectDtos(subjectDtos);
        subjectService.modifySubject(subject);
        return ResponseEntity.status(HttpStatus.OK).body(subject);
    }

    @GetMapping("/${samePlacePath}")
    public ResponseEntity<Object> samePlaceSubjects(){
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSameSubjectsPlace(groupService.getList()));
    }

    @GetMapping("/${MoreGroupsPath}")
    public ResponseEntity<Object> subjectWithMoreGroups(){
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjectWithMoreGroups(groupService.getList()));
    }

    @GetMapping("/${sameSchedulePath}")
    public ResponseEntity<Object> sameScheduleSubjects(){
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSameScheduleSubjects(groupService.getList()));
    }

}
