package in.srikar.crud_h2.service;

import in.srikar.crud_h2.dtos.StudentRequestDto;
import in.srikar.crud_h2.dtos.StudentResponseDto;
import in.srikar.crud_h2.entities.Student;
import in.srikar.crud_h2.mappers.StudentMapper;
import in.srikar.crud_h2.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;


    public StudentService(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    //CREATE
    public StudentResponseDto create(StudentRequestDto dto){
        Student student=mapper.toEntity(dto);
        Student savedStudent= repository.save(student);
        return mapper.toResponseDto(savedStudent);
    }

    /* READ */
    public List<StudentResponseDto> read(){
        List<Student> students= repository.findAll();

        return students.stream().map(mapper::toResponseDto).toList();

    }

    /*Read By Id*/
    public StudentResponseDto read(long id){
        repository.findById(id).orElseThrow(()->new RuntimeException("Could not find id"));

        return mapper.toResponseDto(repository.getById(id));
    }

    /*Update*/
    public StudentResponseDto update(long id,StudentRequestDto dto){
        Student student=repository.findById(id).orElseThrow(()->new RuntimeException("Student Not Found"));
        student=mapper.toEntity(dto);
        student.setId(id);
        student=repository.save(student);

        return mapper.toResponseDto(student);

    }

    /*DELETE*/
    public StudentResponseDto delete(long id){

        Student student=repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student Not Found"));

        repository.deleteById(id);
        return mapper.toResponseDto(student);
    }



}
