package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import controller.admin.AdminController;
import controller.employee.EmployeeController;
import model.Employee;
import service.EmployeeService;
import utils.Session;
import view.LoginView;

public class LoginController {
	
	private EmployeeService employeeService;
	private LoginView loginView;

	public LoginController() {
		this.employeeService = new EmployeeService();
		this.loginView = new LoginView();
		this.loginView.setVisible(true);
		init();
		addAction();
	}
	public void init() {
		loginView.getField_username().setText("Tên Đăng Nhập");
		loginView.getField_password().setText("********");
	}

	public void login() {
		String username = this.loginView.getField_username().getText();
		String password = new String(this.loginView.getField_password().getPassword());
		Employee employee = employeeService.login(username, password);
		if (employee != null) {
			Session.USERLOGIN = employee;
			if (employee.isAdmin()) {
				AdminController adminController = new AdminController();
				adminController.init(employee);
				this.loginView.dispose();
			} else {
				EmployeeController employeeController = new EmployeeController();
				employeeController.init(employee);
				this.loginView.dispose();
			}

		} else {
			this.loginView.showError("Sai tên đăng nhập hoặc mật khẩu");
		}

	}

	public void addAction() {
		this.loginView.getField_password().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginView.getBtn_login().doClick();
				}
			}
		});
		this.loginView.getBtn_login().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				login();

			}
		});
		this.loginView.getBtn_exit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		this.loginView.getField_username().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (loginView.getField_username().getText().isEmpty())
					loginView.getField_username().setText("Tên Đăng Nhập");

			}
			@Override
			public void focusGained(FocusEvent e) {
				if (loginView.getField_username().getText().equals("Tên Đăng Nhập"))
					loginView.getField_username().setText("");

			}
		});
		this.loginView.getField_password().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (loginView.getField_password().getPassword().toString().isEmpty())
					loginView.getField_password().setText("********");

			}
			@Override
			public void focusGained(FocusEvent e) {
				if (loginView.getField_password().getText().equals("********"))
					loginView.getField_password().setText("");

			}
		});
	}

}
