package at.grueneis.spengergasse.lesson_plan;

import java.util.Collection;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class WhenWorkingWithLessonPlan {
	private TeachingUnit teachingUnit;
	private Teacher teacher;
	private SchoolClass schoolClass;
	private ClassRoom classRoom;
	private Lesson lesson;

	@Before
	public void setup() {
		teachingUnit = new TeachingUnit("POS");
		teacher = new Teacher("Joachim", "Grüneis", null,
				"grueneis@spengergasse.at");
		schoolClass = new SchoolClass("4AHIF");
		classRoom = new ClassRoom();
		lesson = new Lesson(teachingUnit, teacher, schoolClass, classRoom);
	}

	@Test
	public void buildingEmptyLessonPlan() {
		SchoolYear schoolYear = new SchoolYear();
		LessonPlan lessonPlan = new LessonPlan("Stundenplan 2013/2014",
				schoolYear, new Vector<Lesson>());
		assertThat(lessonPlan, is(notNullValue()));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void whenGettingListOfLessons() {
		// given
		SchoolYear schoolYear = new SchoolYear();
		LessonPlan lessonPlan = new LessonPlan("Stundenplan 2013/2014",
				schoolYear, new Vector<Lesson>());
		int numberOfLessonsBefore = lessonPlan.getLessons().size();

		// when
		Collection<Lesson> lessons = lessonPlan.getLessons();
		lessons.add(lesson);

		// then
	}
}
