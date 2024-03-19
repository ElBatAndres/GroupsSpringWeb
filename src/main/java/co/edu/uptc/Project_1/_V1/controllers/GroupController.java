package co.edu.uptc.Project_1._V1.controllers;

import co.edu.uptc.Project_1._V1.dtos.GroupDtos;
import co.edu.uptc.Project_1._V1.dtos.SubjectDtos;
import co.edu.uptc.Project_1._V1.models.Group;
import co.edu.uptc.Project_1._V1.models.Schedule;
import co.edu.uptc.Project_1._V1.models.Subject;
import co.edu.uptc.Project_1._V1.services.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${groupPath}")
public class GroupController {

    GroupService groupService = new GroupService();

    @GetMapping("")
    public ResponseEntity<Object> getPlaces(){
        return ResponseEntity.status(HttpStatus.OK).body(groupService.getList());
    }

    @PostMapping("")
    public ResponseEntity<Object> addGroup(@RequestBody GroupDtos groupDtos){
        Group group = GroupDtos.fromGroupDtos(groupDtos);
        groupService.addGroup(group);
        return ResponseEntity.status(HttpStatus.OK).body(group);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteGroup(@RequestBody GroupDtos groupDtos){
        Group group = GroupDtos.fromGroupDtos(groupDtos);
        groupService.deleteGroup(group);
        return ResponseEntity.status(HttpStatus.OK).body(group);
    }

    @PutMapping("")
    public ResponseEntity<Object> modifyGroup(@RequestBody GroupDtos groupDtos){
        Group group = GroupDtos.fromGroupDtos(groupDtos);
        groupService.modifyGroup(group);
        return ResponseEntity.status(HttpStatus.OK).body(group);
    }

}
