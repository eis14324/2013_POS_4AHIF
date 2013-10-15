package at.grueneis.spengergasse.lesson_plan;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenCreatingALesson {
	private TeachingUnit teachingUnit;
	private Teacher teacher;
	private SchoolClass schoolClass;
	private ClassRoom classRoom;

	@Before
	public void setup() {
		teachingUnit = new TeachingUnit("POS");
		teacher = new Teacher("Joachim", "Grüneis", null,
				"grueneis@spengergasse.at");
		schoolClass = new SchoolClass("4AHIF");
		classRoom = new ClassRoom();
	}

	@Test(expected = IllegalArgumentException.class)
	public void aLessonNeedsTeachinUnit() {
		new Lesson(null, teacher, schoolClass, classRoom);
	}

	@Test(expected = IllegalArgumentException.class)
	public void aLessonNeedsTeacher() {
		new Lesson(teachingUnit, null, schoolClass, classRoom);
	}

	@Test(expected = IllegalArgumentException.class)
	public void aLessonNeedsSchoolClass() {
		new Lesson(teachingUnit, teacher, null, classRoom);
	}

	@Test(expected = IllegalArgumentException.class)
	public void aLessonNeedsClassRoom() {
		new Lesson(teachingUnit, teacher, schoolClass, null);
	}

	@Test
	public void aLessonNeedsTeacherRoomUnit() {
		// given
		// when
		Lesson lesson = new Lesson(teachingUnit, teacher, schoolClass,
				classRoom);
		// then
		assertThat(lesson.getTeacher(), is(teacher));
	}

	@Test
	public void twoLessonsAreEqualIfAllAttributesAreEqual() {
		// given
		// when
		Lesson lesson1 = new Lesson(teachingUnit, teacher, schoolClass,
				classRoom);
		Lesson lesson2 = new Lesson(teachingUnit, teacher, schoolClass,
				classRoom);
		// then
		assertThat(lesson1, is(lesson2));
	}
}
