package studentmanagement.studentmanagment.Service.StudentServiceImplementation;
import java.util.List;

import org.springframework.stereotype.Service;

import studentmanagement.studentmanagment.Entity.Student;
import studentmanagement.studentmanagment.Repository.StudentRepository;
import studentmanagement.studentmanagment.Service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{

	private final StudentRepository studentRepository;
	
	//Dependency injection provides the required repository to the service so it can handle database operations without creating it manually
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
		// for services to interact with repository dependency injection 
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student); // save student to database
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get(); // find student by id and return it
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student); // update student in database
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id); // delete student by id from database
	}

}