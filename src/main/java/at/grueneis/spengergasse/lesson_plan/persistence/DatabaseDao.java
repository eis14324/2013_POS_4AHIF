package at.grueneis.spengergasse.lesson_plan.persistence;

import java.util.List;

public interface DatabaseDao<T> {
	List<T> findAll();

	T findById(Long id);

	T findByName(String name);

	void save(T t);
}
