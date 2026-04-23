package studentmanagement.studentmanagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import studentmanagement.studentmanagment.Entity.Student;

@Repository
public interface  StudentRepository extends JpaRepository<Student, Long> {

}
