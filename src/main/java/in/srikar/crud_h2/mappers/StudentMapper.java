package in.srikar.crud_h2.mappers;

import in.srikar.crud_h2.dtos.StudentRequestDto;
import in.srikar.crud_h2.dtos.StudentResponseDto;
import in.srikar.crud_h2.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentRequestDto dto);

    StudentResponseDto toResponseDto(Student student);

    void UpdateStudentFromDto(StudentRequestDto dto,@MappingTarget Student Entity);

}
