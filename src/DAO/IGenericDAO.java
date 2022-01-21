package DAO;

import java.util.List;

public interface IGenericDAO<T> {
	boolean add(T t);
	boolean delete(T t);
	boolean delete(int id);
	boolean update(T t);
	List<T> findAll();
}
