package studentmanagement.studentmanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentmanagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagmentApplication.class, args);
	}

}
// This is the main class of the application which is used to run the application. It is annotated with @SpringBootApplication which is a combination of @Configuration, @EnableAutoConfiguration and @ComponentScan annotations. It is used to enable auto-configuration and component scanning in the application. The main method is used to run the application.