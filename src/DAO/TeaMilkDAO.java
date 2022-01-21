package DAO;

import java.util.List;

import mapper.TeaMilkMapper;
import model.Employee;
import model.TeaMilk;

public class TeaMilkDAO extends AbstractDao implements IGenericDAO<TeaMilk> {

	@Override
	public boolean add(TeaMilk t) {
		String sql = "INSERT INTO `teamilk`(`Name`, `Price`, `CategoryID`, `Unit`, `Quantity`)" + " VALUES (?,?,?,?,?)";
		return update(sql, t.getName(),t.getPrice(),t.getCategoryId(),t.getUnit(),t.getQuantity());
	}

	@Override
	public boolean delete(TeaMilk t) {
		String sql = "delete from teamilk where ID = ?";
		return update(sql, t.getId());
	}

	public boolean delete(int id) {
		String sql = "Update teamilk set `isDeleted` = 1 where `ID` = ?";
		return update(sql, id);
	}

	@Override
	public boolean update(TeaMilk t) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<TeaMilk> search(String nameSearch, String value) {
		String sql = "Select * from teamilk where " + nameSearch + " LIKE '%" + value + "%'";
		;
		return query(sql, new TeaMilkMapper());
	}

	public List<TeaMilk> findAll() {
		String sql = "Select * from teamilk where isDeleted = 0";
		return query(sql, new TeaMilkMapper());
	}

	public List<TeaMilk> findByCategoryID(int id) {
		String sql = "Select * from teamilk where categoryID = " + id;
		return query(sql, new TeaMilkMapper());

	}

	public TeaMilk findByID(int id) {
		String sql = "Select * from teamilk where ID = " + id;
		return query(sql, new TeaMilkMapper()).isEmpty() ? null:query(sql, new TeaMilkMapper()).get(0);
	}
	public static void main(String[] args) {
	
	}
}
