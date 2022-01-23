package service;

import java.util.List;

import DAO.CategoryDAO;
import model.Category;

public class CategoryService  implements IGenericService<Category>{
	CategoryDAO categoryDAO;
	 public CategoryService() {
		 this.categoryDAO=new CategoryDAO();
	 }
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

	@Override
	public boolean add(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Category> search(String nameSearch, String value) {
		// TODO Auto-generated method stub
		return null;
	}
	public Category findByName(String name) {
		return categoryDAO.findByName(name);
	}
	public Category findByCode(String code) {
		return categoryDAO.findByCode(code);
	}
	@Override
	public Category findByID(int id) {
		// TODO Auto-generated method stub
		return categoryDAO.findByID(id);
	}
	@Override
	public boolean update(Category t) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
