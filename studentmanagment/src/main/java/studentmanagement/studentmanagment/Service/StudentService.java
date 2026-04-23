package studentmanagement.studentmanagment.Service;
import java.util.List;

import studentmanagement.studentmanagment.Entity.Student;


public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
//operation to be performed on student entity why it is an interface because we have different set of operations 
// what we want to perform on student entity and we want to implement those operations in service implementation class 
