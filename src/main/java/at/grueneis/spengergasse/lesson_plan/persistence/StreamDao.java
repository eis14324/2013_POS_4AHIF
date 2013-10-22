package at.grueneis.spengergasse.lesson_plan.persistence;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface StreamDao<T> {
	Iterable<T> readAll(ObjectInputStream objectInputStream);

	void writeAll(ObjectOutputStream objectOutputStream, Iterable<T> objects);
}
