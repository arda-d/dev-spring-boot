package com.app.cruddemo;

import com.app.cruddemo.dao.AppDAO;
import com.app.cruddemo.entity.Instructor;
import com.app.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		appDAO.deleteInstructorDetailById(id);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id : " + id);
		InstructorDetail instructor = appDAO.findInstructorDetailById(id);
		Instructor instruct = appDAO.findInstructorById(id);
		System.out.println("Found instructor : " + instruct + " " + instructor);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 4;
		appDAO.deleteInstructorById(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id : " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Found instructor : " + instructor);
	}

	private void createInstructor(AppDAO appDAO) {
		//create the instructor
		Instructor temp = new Instructor("Nghia","Rampel","rampel@gmail.com");
		//create the insturctor detail
		InstructorDetail tempIns = new InstructorDetail("youtube.com/14288","Cycling");
		temp.setInstructor_detail(tempIns);

		//save the instructor

		System.out.println("Saving Instructor: " + temp);
		appDAO.save(temp);
	}
}
