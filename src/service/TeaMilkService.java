package service;

import java.util.List;

import DAO.TeaMilkDAO;
import model.TeaMilk;

public class TeaMilkService implements IGenericService<TeaMilk> {
	private TeaMilkDAO teaMilkDAO;
	public TeaMilkService() {
		this.teaMilkDAO=new TeaMilkDAO();
	}
	public List<TeaMilk> findAll(){
		return this.teaMilkDAO.findAll();
	}
	@Override
	public boolean add(TeaMilk t) {
		// TODO Auto-generated method stub
		return teaMilkDAO.add(t);
	}

	public boolean delete(TeaMilk t) {
		return teaMilkDAO.delete(t.getId());
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return teaMilkDAO.delete(id);
	}
	@Override
	public List<TeaMilk> search(String nameSearch, String value) {
		return teaMilkDAO.search(nameSearch, value);
	}
	public List<TeaMilk> findByCategoryID(int id) {
		return teaMilkDAO.findByCategoryID(id);
	}
	public TeaMilk findByID(int id) {
		return teaMilkDAO.findByID(id);
	}
	public TeaMilk findByName(String name) {
		return teaMilkDAO.findByName(name);
	}
	@Override
	public boolean update(TeaMilk t) {
		// TODO Auto-generated method stub
		return false;
	}

}
