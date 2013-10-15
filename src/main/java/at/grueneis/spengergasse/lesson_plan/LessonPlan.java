package at.grueneis.spengergasse.lesson_plan;

import java.util.Collection;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class LessonPlan {
	private final String name;
	private final SchoolYear schoolYear;
	private final SortedSet<Lesson> lessons;

	public LessonPlan(String name, SchoolYear schoolYear,
			Collection<Lesson> lessons) {
		this.name = name;
		this.schoolYear = schoolYear;
		this.lessons = new TreeSet<>();
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
