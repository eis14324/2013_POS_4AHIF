package at.grueneis.spengergasse.lesson_plan.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.grueneis.spengergasse.lesson_plan.domain.Teacher;

public class TeacherDaoTest {
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	private TeacherDao teacherDao;

	@Before
	public void setup() throws IOException {
		teacherDao = new TeacherDao();
		objectOutputStream = new ObjectOutputStream(new FileOutputStream(
				"teachers.out"));
		objectInputStream = new ObjectInputStream(new FileInputStream(
				"teachers.in"));
	}

	@After
	public void teardown() throws IOException {
		if (objectOutputStream != null) {
			objectOutputStream.close();
		}
	}

	@Test
	public void whenWritingATeacher() {
		Teacher teacher = new Teacher("Joachim", "Grüneis", new Date(),
				"grueneis@spengergasse.at");
		ArrayList<Teacher> teachers = new ArrayList<>();
		teachers.add(teacher);
		teacherDao.writeAll(objectOutputStream, teachers);
	}

	@Test
	public void whenReadingTeachers() {
		Iterable<Teacher> teachers = teacherDao.readAll(objectInputStream);
		System.out.println("teachers: " + teachers);
	}
}
