package com.app.cruddemo;

import com.app.cruddemo.dao.AppDAO;
import com.app.cruddemo.entity.Course;
import com.app.cruddemo.entity.Instructor;
import com.app.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateTheInstructor(appDAO);
			//updateTheCourse(appDAO);
			//deleteInstructor(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 11;
		Course tempCourse = appDAO.findCourseById(id);
		System.out.println("Deleting the course: " +  tempCourse.getTitle());
		appDAO.deleteCourseById(id);
	}

	private void updateTheCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Finding the course by id " + id);
		Course course = appDAO.findCourseById(id);
		course.setTitle("Enjoy Simple Things");
		appDAO.update(course);
	}

	private void updateTheInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor by id " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		instructor.setLastName("TEST");
		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		//find the instructor
		Instructor temp = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("Instructor: " + temp);
		System.out.println("Instructor courses: " + temp.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with courses by id " + id);
		Instructor temp = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + temp);

		//find courses for instructor
		System.out.println("Finding instructor with courses by id " + id);
        List<Course> courses = appDAO.findCourseByInstructorId(id);
		temp.setCourses(courses);
		System.out.println("Courses: " + temp.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with courses by id " + id);
		Instructor temp = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + temp);
		System.out.println("Courses: " + temp.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		//create the instructor
		Instructor temp = new Instructor("Susan","Public","public@gmail.com");
		//create the insturctor detail
		InstructorDetail tempIns = new InstructorDetail("youtube.com/19988","Walking");
		temp.setInstructor_detail(tempIns);

		//create courses
		Course tempCourse = new Course("Java Course");
		Course tempCourse2 = new Course("Pyhton Course");

		temp.add(tempCourse);
		temp.add(tempCourse2);

		//save the instructor
		System.out.println("Saving instructor:" + temp.getInstructor_detail());
		appDAO.save(temp);
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
