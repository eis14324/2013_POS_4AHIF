package at.grueneis.spengergasse.lesson_plan.persistence;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.grueneis.spengergasse.lesson_plan.domain.Teacher;

public class TeacherDao implements StreamDao<Teacher> {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Iterable<Teacher> readAll(ObjectInputStream objectInputStream) {
		try {
			return (Iterable<Teacher>) objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			logger.error(e.toString());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void writeAll(ObjectOutputStream objectOutputStream,
			Iterable<Teacher> objects) {
		try {
			objectOutputStream.writeObject(objects);
		} catch (IOException e) {
			logger.error(e.toString());
			throw new RuntimeException(e);
		}
	}
}
