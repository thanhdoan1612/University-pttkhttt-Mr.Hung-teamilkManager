package DAO;

import java.util.List;

import mapper.CategoryMapper;
import model.Category;

public class CategoryDAO extends AbstractDao implements IGenericDAO<Category> {

	@Override
	public boolean add(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Category> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

	public Category findByName(String name) {
		String sql = "select * from category where `Name` = ?";
		return query(sql, new CategoryMapper(),name).isEmpty() ? null : query(sql, new CategoryMapper(),name).get(0);
	}

	public Category findByID(int id) {
		String sql = "select * from category where `ID` = ?";
		return query(sql, new CategoryMapper(),id).isEmpty() ? null : query(sql, new CategoryMapper(),id).get(0);
	}
	public Category findByCode(String code) {
		String sql = "select * from category where `code` = ?";
		return query(sql, new CategoryMapper(),code).isEmpty() ? null : query(sql, new CategoryMapper(),code).get(0);
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long save(Category t) {
		String sql ="INSERT INTO `category`(`Name`) VALUES (?)";
		return add(sql, t.getName());
	}

}
