package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.xml.bind.DataBindingException;

import model.AdminType;
import model.Employee;
import service.EmployeeService;
import utils.ConvertNumber;
import utils.MessagePopup;
import view.admin.AddEmployeeView;

public class EmployeeMangerController extends ManagerController<Employee> {
	private String[] header = new String[] { "STT", "Họ Tên", "Tên Đăng nhập", "Mật Khẩu", "Ngày Sinh",
			"Số Điện Thoại" };
	private String[] listSearch = new String[] { "ID", "FullOfName", "Username", "Password", "DateOfBirth", "isAdmin" };
	private AddEmployeeView addEmployeeView;
	

	public EmployeeMangerController() {
		this.iGenericService = new EmployeeService();
		this.headerName = header;
		this.listSearchName = listSearch;
		this.headerName = getHeaderName();
		this.listSearchName = getListSearchName();

	}

	public void initAddView() {
		id = -1;
		addEmployeeView = new AddEmployeeView();

		addEmployeeView.setVisible(true);

		addEmployeeView.getField_fullname().setText(header[1]);
		addEmployeeView.getField_username().setText(header[2]);
		addEmployeeView.getField_password().setText(header[3]);
		addEmployeeView.getField_phoneNumber().setText(header[5]);
		addEmployeeView.getField_dateOfBirth().setText("dd/mm/yyyy");
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for (AdminType aType : AdminType.values()) {
			model.addElement(aType.getType());
		}
		model.setSelectedItem(AdminType.EMPLOYEE.getType());
		addEmployeeView.getComboBox_isAdmin().setModel(model);
		initActionListener();

	}

	public void initUpdateView(int id) {
		this.id = id;
		Employee employee = iGenericService.findByID(id);
		String dateOfBirth = ConvertNumber.sqlDateToString(employee.getDateOfBirth());
		addEmployeeView = new AddEmployeeView();

		addEmployeeView.setVisible(true);
		addEmployeeView.getBtn_add().setText("Cập nhật");
		addEmployeeView.getField_fullname().setText(employee.getFullOfName());
		addEmployeeView.getField_username().setText(employee.getUsername());
		addEmployeeView.getField_password().setText(employee.getPassword());
		addEmployeeView.getField_phoneNumber().setText(employee.getPhoneNumber());
		addEmployeeView.getField_dateOfBirth().setText(dateOfBirth);
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		for (AdminType aType : AdminType.values()) {
			model.addElement(aType.getType());
		}
		model.setSelectedItem(AdminType.findByIsAdmin(employee.isAdmin()).getType());
		addEmployeeView.getComboBox_isAdmin().setModel(model);

		initActionListener();

	}

	@Override
	public void addAction() {

		String fullname = addEmployeeView.getField_fullname().getText();
		String username = addEmployeeView.getField_username().getText();
		String password = String.valueOf(addEmployeeView.getField_password().getPassword());
		String phoneNumber = addEmployeeView.getField_phoneNumber().getText();
		String dateOfBirth = addEmployeeView.getField_dateOfBirth().getText();

		Employee employee = new Employee();

		employee.setFullOfName(fullname);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setPhoneNumber(phoneNumber);
		employee.setDateOfBirth(ConvertNumber.stringToSQLDate(dateOfBirth));
		employee.setAdmin(false);
		if (iGenericService.add(employee)) {
			MessagePopup.showSuccessMessage("Bạn đã thêm thành công nhân viên " + employee.getFullOfName());
			addEmployeeView.dispose();
		} else {
			MessagePopup.showMessage("Thêm nhân viên thất bại. Bạn vui lòng kiểm tra lại");
		}

	}

	@Override
	public void initActionListener() {
		addEmployeeView.getBtn_cancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cancelAction();
			}
		});
		addEmployeeView.getBtn_add().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (id == -1) {
					addAction();
				} else {
					updateAction();
				}
			}
		});
		addFocusAction(addEmployeeView.getField_fullname(), header[1]);
		addFocusAction(addEmployeeView.getField_username(), header[2]);
		addFocusAction(addEmployeeView.getField_password(), header[3]);
		addFocusAction(addEmployeeView.getField_phoneNumber(), header[5]);

		addFocusAction(addEmployeeView.getField_dateOfBirth(), "dd/mm/yyyy");
	}

	@Override
	public void cancelAction() {
		addEmployeeView.dispose();
	}

	@Override
	public void updateAction() {
		String fullname = addEmployeeView.getField_fullname().getText();
		String username = addEmployeeView.getField_username().getText();
		String password = String.valueOf(addEmployeeView.getField_password().getPassword());
		String phoneNumber = addEmployeeView.getField_phoneNumber().getText();
		String dateOfBirth = addEmployeeView.getField_dateOfBirth().getText();
		String isAdminType = (String) addEmployeeView.getComboBox_isAdmin().getSelectedItem();

		Employee employee = new Employee();
		boolean isAdmin = AdminType.findByType(isAdminType).isAdmin();
		employee.setId(id);
		employee.setFullOfName(fullname);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setPhoneNumber(phoneNumber);
		employee.setDateOfBirth(ConvertNumber.stringToSQLDate(dateOfBirth));
		employee.setAdmin(isAdmin);
		if (iGenericService.update(employee)) {
			MessagePopup.showSuccessMessage("Bạn đã cập nhật thành công nhân viên " + employee.getFullOfName());
			addEmployeeView.dispose();
		} else {
			MessagePopup.showMessage("Cập nhật nhân viên thất bại. Bạn vui lòng kiểm tra lại");
		}

	}

}
