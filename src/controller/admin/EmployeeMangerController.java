package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.headerName = getHeaderName();
		this.listSearchName = getListSearchName();
	}

	@Override
	public String[] getHeaderName() {
		// TODO Auto-generated method stub
		return header;
	}

	@Override
	public String[] getListSearchName() {
		// TODO Auto-generated method stub
		return listSearch;
	}

	public void initAddView() {

		addEmployeeView = new AddEmployeeView();

		addEmployeeView.setVisible(true);

		addEmployeeView.getField_fullname().setText(header[1]);
		addEmployeeView.getField_username().setText(header[2]);
		addEmployeeView.getField_password().setText(header[3]);
		addEmployeeView.getField_phoneNumber().setText(header[5]);
		addEmployeeView.getField_dateOfBirth().setText("dd/mm/yyyy");

		addFocusAction(addEmployeeView.getField_fullname(), header[1]);
		addFocusAction(addEmployeeView.getField_username(), header[2]);
		addFocusAction(addEmployeeView.getField_password(), header[3]);
		addFocusAction(addEmployeeView.getField_phoneNumber(), header[5]);

		addFocusAction(addEmployeeView.getField_dateOfBirth(), "dd/mm/yyyy");
		addEmployeeView.getBtn_cancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addEmployeeView.dispose();
			}
		});
		addEmployeeView.getBtn_add().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getAddAction();
			}
		});
	}

	@Override
	public void getAddAction() {

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

}
