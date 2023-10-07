// This is a Java class named StudentManagementSystemApplication.

package net.javaguides.sms;

// Import necessary classes and interfaces from Spring Boot and custom packages.
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;

// This is a Spring Boot application.
@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	// Inject a StudentRepository instance using Spring's dependency injection.
	@Autowired
	private StudentRepository studentRepository;

	// The main method that runs the Spring Boot application.
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	// This method is implemented from the CommandLineRunner interface and is executed when the application starts.
	@Override
	public void run(String... args) throws Exception {
		// Create new Student objects.
		Student student1 = new Student("RAMESH", "FEDATARE", "RAJAN@GMAIL.COM");
		studentRepository.save(student1);

		Student student2 = new Student("RAMESH1", "FEDATARE1", "RAJAN1@GMAIL.COM");
		studentRepository.save(student2);
	
		Student student3 = new Student("RAMESH2", "FEDATARE2", "RAJAN2@GMAIL.COM");
		studentRepository.save(student3);
	}
}

