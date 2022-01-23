package controller.admin;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Model;
import service.IGenericService;

public abstract class ManagerController<T extends Model> {
	public String[] headerName;
	public String[] listSearchName;
	public int id;

	public IGenericService<T> iGenericService;

	public abstract void initAddView();

	public abstract void initUpdateView(int id);

	public abstract void addAction();

	public abstract void updateAction();

	public abstract void cancelAction();

	public abstract void initActionListener();

	public String[] getHeaderName() {
		return this.headerName;
	};

	public String[] getListSearchName() {
		return this.listSearchName;
	};

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
