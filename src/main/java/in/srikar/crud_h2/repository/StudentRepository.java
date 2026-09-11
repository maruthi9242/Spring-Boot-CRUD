package in.srikar.crud_h2.repository;

import in.srikar.crud_h2.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
