package at.grueneis.spengergasse.lesson_plan.persistence.file;

import at.grueneis.spengergasse.lesson_plan.domain.Teacher;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

public class TeacherDaoTest {

    private TeacherDao teacherDao;

    @Test
    public void whenWritingATeacher() {
        teacherDao = new TeacherDao("src/test/resources");
        Teacher teacher = new Teacher("Joachim", "Grüneis", new Date(), "grueneis@spengergasse.at");
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
        teacherDao.writeAll(teachers);
    }

    @Test
    public void whenReadingTeachers() {
        teacherDao = new TeacherDao("src/test/resources");
        Iterable<Teacher> teachers = teacherDao.readAll();
        System.out.println("teachers: " + teachers);
    }
}
