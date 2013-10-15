package at.grueneis.spengergasse.lesson_plan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LessonPlan {
	private final String name;
	private final SchoolYear schoolYear;
	private final List<Lesson> lessons;

	public LessonPlan(String name, SchoolYear schoolYear,
			Collection<Lesson> lessons) {
		this.name = name;
		this.schoolYear = schoolYear;
		this.lessons = new ArrayList<>();
		for (Lesson lesson : lessons)
			this.lessons.add(lesson);
	}

	public Collection<Lesson> getLessons() {
		// Collection<Lesson> returnList = new ArrayList<>();
		// for (Lesson lesson : this.lessons)
		// returnList.add(lesson);
		// return returnList;
		return Collections.unmodifiableCollection(lessons);
	}
}
