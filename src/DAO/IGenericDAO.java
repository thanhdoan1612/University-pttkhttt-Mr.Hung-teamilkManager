package DAO;

import java.util.List;

public interface IGenericDAO<T> {
	Long save(T t);
	boolean delete(int id);
	boolean update(T t);
	List<T> findAll();
}
