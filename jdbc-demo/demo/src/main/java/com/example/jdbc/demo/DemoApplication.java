package com.example.jdbc.demo;

import com.example.jdbc.demo.model.Teacher;
import com.example.jdbc.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private TeacherRepository teacherRepo;

	private Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		delete();

	}

	private void displayAll() {
		List<Teacher> teachers = teacherRepo.getAll();

		for (Teacher t : teachers) {
			System.out.printf("TeacherID: %d | %s, %s %n", t.getTeacherId(), t.getLastName(), t.getFirstName());
		}
	}

	private void createTeacher() {
		Teacher teacher = new Teacher();

		System.out.print("Enter First Name: ");
		teacher.setFirstName(scanner.nextLine());

		System.out.print("Enter Last Name: ");
		teacher.setLastName(scanner.nextLine());

		teacher = teacherRepo.add(teacher);
	}

	private void getById() {
		System.out.print("Enter Teacher ID: ");
		Optional<Teacher> teacher = teacherRepo.getById(Integer.parseInt(scanner.nextLine()));

		if (teacher.isPresent()) {
			Teacher t = teacher.get();
			System.out.printf("TeacherID: %d | %s, %s %n", t.getTeacherId(), t.getLastName(), t.getFirstName());
		}
	}

	private void update() {
		Teacher teacher = new Teacher();

		System.out.print("Enter Teacher ID: ");
		teacher.setTeacherId(Integer.parseInt(scanner.nextLine()));

		System.out.print("Enter First Name: ");
		teacher.setFirstName(scanner.nextLine());

		System.out.print("Enter Last Name: ");
		teacher.setLastName(scanner.nextLine());

		teacherRepo.update(teacher);
	}

	private void delete() {
		System.out.print("Enter Teacher ID: ");
		teacherRepo.delete(Integer.parseInt(scanner.nextLine()));
	}
}
