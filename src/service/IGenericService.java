package service;

import java.util.List;

import model.Model;

public interface IGenericService<T> {
	List<T> findAll();

	boolean add(T t);

	boolean delete(int id);

	List<T> search(String nameSearch, String value);

	T findByID(int id);

	boolean update(T t);
	
	
}
