package studentmanagement.studentmanagment.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import studentmanagement.studentmanagment.Entity.Student;
import studentmanagement.studentmanagment.Service.StudentService;


@Controller
public class StudentController {
	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService; // for controllers to interact with services dependency injection
	}
	
	// @ModelAttribute-- takes the whole data that required to create a student object and set it to the database( create and update student)
    // @PathVariable-- takes only the id of the student to be edited and set it to the database

	@GetMapping("/students") //  reads the list of students and display it to the user
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new") // displays the form to create a new student
	public String createStudentForm(Model model) { //create student form which is empty initially and then we will fill the form and submit it to the database
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	@PostMapping("/students") // saves the student to the database and shows the list of students
	public String saveStudent(@ModelAttribute("student") Student student) { 
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) { 
		model.addAttribute("student", studentService.getStudentById(id)); //shows the student details in the form that are to be edited

		return "edit_student";
	}

	@PostMapping("/students/{id}") // updates the student in the database and shows the list of students
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setName(student.getName());
		existingStudent.setCourse(student.getCourse());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students"; // after updating the student we will redirect to the list of students page	
	}
		
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students"; // after deleting the student we will redirect to the list of students page
	}
}