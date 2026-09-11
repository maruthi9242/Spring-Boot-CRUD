package in.srikar.crud_h2.controller;

import in.srikar.crud_h2.dtos.StudentRequestDto;
import in.srikar.crud_h2.dtos.StudentResponseDto;
import in.srikar.crud_h2.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> create(@RequestBody StudentRequestDto dto){
         return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> read()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> read(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.read(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDto> Del(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> update(@RequestBody StudentRequestDto dto,@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,dto));

    }



}
