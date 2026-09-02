package com.app.cruddemo;

import com.app.cruddemo.dao.StudentDAO;
import com.app.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryforStudents(studentDAO);
			//querybylastname(studentDAO);
			//updatestudent(studentDAO);
			//removestudent(studentDAO);
			//deleteall(studentDAO);
		};
	}

	private void deleteall(StudentDAO studentDAO) {
		System.out.println("Deleting all");
		int num = studentDAO.removeAll();
		System.out.println("Number of students deleted: " + num);
	}

	private void removestudent(StudentDAO studentDAO) {
		int id = 24058004;
		System.out.println("Removing student with id " + id);
		studentDAO.remove(id);

	}


	private void updatestudent(StudentDAO studentDAO) {
		int id = 24058004;
		Student student = studentDAO.findById(id);
		student.setFirstName("Johnny");
		studentDAO.update(student);
		System.out.println("Updated student: " +  student);
	}

	private void querybylastname(StudentDAO studentDAO) {
		//get a list of queries
		List<Student> students = studentDAO.findByLastName("Jack");

		//display all the queries
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void queryforStudents(StudentDAO studentDAO) {
		//get a list of queries
		List<Student> students = studentDAO.findAll();

		//display list of students
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new student");
		Student tempStudent = new Student("Duck","Quack","duckyquakcy@gmail.com");

		System.out.println("Saving student");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		System.out.println("\n Retrieving student with id: " + tempStudent.getId());
		Student student = studentDAO.findById(tempStudent.getId());
		System.out.println("Found student with id: " + student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create the students
		System.out.println("Creating Multiple Students");
		Student tempStudent1 = new Student("John","Doe","JohnDoe@gmail.com");
		Student tempStudent2 = new Student("Mary","Awera","MaryAwera@gmail.com");
		Student tempStudent3 = new Student("Jack","Jack","JackJack@gmail.com");

		//save the students
		System.out.println("Saving Multiple Students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating Student...");
		Student tempStudent = new Student("Paul","Doe","paul@doe.gmail.com");

		//save the student object
		System.out.println("Saving Student...");
		studentDAO.save(tempStudent);

		//display id of the saved object
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
	}
}
