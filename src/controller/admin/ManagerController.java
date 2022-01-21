package controller.admin;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Model;
import service.IGenericService;

public abstract class ManagerController<T extends Model> {
	public final int widthLabel = 100;
	public final int heightLabel = 40;
	public final int widthField = 250;
	public final int heightField = 40;
	public String[] headerName = getHeaderName();
	public String[] listSearchName = getListSearchName();

	public IGenericService<T> iGenericService;

	public abstract String[] getHeaderName();

	public abstract String[] getListSearchName();

	public abstract void initAddView();

	

	public abstract void getAddAction();

	public DefaultTableModel getData() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(headerName);
		for (T t : iGenericService.findAll()) {
			Object[] rowData = t.toRowTable();
			defaultTableModel.addRow(rowData);
		}
		return defaultTableModel;
	}

	public DefaultTableModel getSearchData(String nameSearch, String value) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(headerName);
		for (T t : iGenericService.search(nameSearch, value)) {
			Object[] rowData = t.toRowTable();
			defaultTableModel.addRow(rowData);
		}
		return defaultTableModel;
	}

	public DefaultComboBoxModel<String> getSearchComboBoxModel() {
		DefaultComboBoxModel<String> rs = new DefaultComboBoxModel<String>(listSearchName);
		return rs;
	}

	public void addFocusAction(JTextField field, String text) {
		field.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (field.getText().isEmpty())
					field.setText(text);

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (field.getText().equals(text))
					field.setText("");

			}

		});

	}
}
