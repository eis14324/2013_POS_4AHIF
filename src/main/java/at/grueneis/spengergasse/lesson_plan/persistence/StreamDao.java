package at.grueneis.spengergasse.lesson_plan.persistence;


public interface StreamDao<T> {
	Iterable<T> readAll();

	void writeAll(Iterable<T> objects);
}
