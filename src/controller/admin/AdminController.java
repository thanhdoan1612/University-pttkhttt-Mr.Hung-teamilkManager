package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.table.DefaultTableModel;

import controller.employee.EmployeeController;
import model.Employee;
import utils.Session;
import view.admin.AdminView;

public class AdminController {
	private AdminView adminView;
	private ManagerController managerController;
	private StatisticController statisticController;

	public AdminController() {
		this.adminView = new AdminView();
		this.statisticController = new StatisticController();
		this.adminView.setVisible(true);
		addAction();
	}

	public void init(Employee employee) {
		setEmployeeName(employee.getFullOfName());
		adminView.add(statisticController.getStatisticView());
	}

	public void setEmployeeName(String name) {
		adminView.getLabel_name().setText(name);
	}

	public void setManagerController(ManagerController managerController) {
		adminView.getView_panel().setVisible(true);
		statisticController.getStatisticView().setVisible(false);
		adminView.getTable_view().setModel(managerController.getData());
		adminView.getComboBox_search().setModel(managerController.getSearchComboBoxModel());
		adminView.revalidate();
	}

	public void setStatisticController() {
		adminView.getView_panel().setVisible(false);
		statisticController.getStatisticView().setVisible(true);
		adminView.revalidate();
	}

	public ActionListener btnDeleteAction() {
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRowNumber = adminView.getTable_view().getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) adminView.getTable_view().getModel();
				Integer id = (int) (model.getValueAt(selectedRowNumber, 0));
				if (id != null) {
					boolean isDeleted = managerController.iGenericService.delete(id);
					if (isDeleted) {
						model.removeRow(selectedRowNumber);
						model.fireTableDataChanged();
					} else {
						System.out.println("xóa không thành công");
					}
				}
			}
		};
		return action;
	}

	public void searchAction() {
		String value = adminView.getField_search().getText();
		if (value != null) {
			String nameSearch = (String) adminView.getComboBox_search().getSelectedItem();
			adminView.getTable_view().setModel(managerController.getSearchData(nameSearch, value));
		}
	}

	public void addAction() {

		this.adminView.getBtn_teamilk_manager().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerController = new TeamilkManagerController();
				setManagerController(managerController);
			}
		});
		this.adminView.getBtn_user_manager().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerController = new EmployeeMangerController();
				setManagerController(managerController);
			}
		});
		this.adminView.getBtn_statistic().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setStatisticController();
			}
		});
		this.adminView.getBtn_delete().addActionListener(this.btnDeleteAction());
		this.adminView.getBtn_add().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerController.initAddView();
			}
		});
		this.adminView.getField_search().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				searchAction();
			}
		});
		this.adminView.getBtn_switch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EmployeeController employeeController = new EmployeeController();
				employeeController.init(Session.USERLOGIN);
				employeeController.getEmployeeView()
						.setDefaultCloseOperation(employeeController.getEmployeeView().DISPOSE_ON_CLOSE);
			}
		});
	}

}
