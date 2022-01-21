package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Employee;
import model.Order;
import service.EmployeeService;
import service.OrderService;
import utils.ConvertNumber;
import view.admin.StatisticView;

public class StatisticController {
	private String[] headerByOrder = new String[] { "ID", "Employee", "Total", "CreatedDate" };
	private String[] headerByTeamilk = new String[] { "ID", "Teamilk", "Quantity", "Total" };
	private String[] headerByEmployee = new String[] { "ID", "Employee", "Total" };
	private StatisticView statisticView;
	private SimpleDateFormat simpleDateFormat;
	private DefaultTableModel model;
	private OrderService orderService;
	private EmployeeService employeeService;
	private List<Order> listOrder;

	public StatisticController() {
		statisticView = new StatisticView();
		model = new DefaultTableModel();
		orderService = new OrderService();
		employeeService = new EmployeeService();
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		listOrder = orderService.findAll();
		statisticView.setVisible(false);
		init();

	}

	public StatisticView getStatisticView() {
		return statisticView;
	}

	public void init() {
		initDate();
		initModel();
		addAction();
	}

	public void initDate() {
		Date date = new Date();
		statisticView.getDateChoose_from().setDate(new Timestamp(System.currentTimeMillis()));
		statisticView.getDateChoose_to().setDate(new Timestamp(System.currentTimeMillis()));

		String dateFrom = simpleDateFormat.format(date);
		statisticView.getField_dateFrom().setText(dateFrom);
		String dateTo = simpleDateFormat.format(date);
		statisticView.getField_dateTo().setText(dateTo);
	}

	public void initModel() {
		model.setColumnIdentifiers(headerByOrder);
		renderModelByOrder(listOrder);
	}

	public void renderModelByOrder(List<Order> list) {
		model.setColumnIdentifiers(headerByOrder);
		model.setRowCount(0);
		Employee employee;
		for (Order o : listOrder) {
			employee = employeeService.findById(o.getEmployeeID());
			o.setEmployee(employee);
			model.addRow(o.toRowTable());
		}
		model.fireTableDataChanged();
		statisticView.getTable().setModel(model);
		statisticView.getField_total().setText(ConvertNumber.numberToPrice((int) orderService.getAllTotal(list)));
		statisticView.getField_totalOrder().setText(list.size() + "");

	}

	public void renderModelByEmployee() {
		model.setColumnIdentifiers(headerByEmployee);
		model.setRowCount(0);
		HashMap<Integer, Double> map = orderService.statisticByEmployee();
		for (int key : map.keySet()) {
			Employee employee = employeeService.findById(key);
			Object[] row = new Object[] { employee.getId(), employee.getFullOfName(), map.get(key) };
			model.addRow(row);
		}
		statisticView.getTable().setModel(model);

	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public void addAction() {
		statisticView.getBtn_statisticByOrder().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listOrder = orderService.findAll();
				renderModelByOrder(listOrder);
				
			}
		});
		statisticView.getBtn_statisticByEmployee().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				renderModelByEmployee();
			}
		});
		statisticView.getBtn_filter().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listOrder.clear();
				Date from = statisticView.getDateChoose_from().getDate();
				Date to = statisticView.getDateChoose_to().getDate();
				Timestamp dateFrom = new Timestamp(from.getTime());
				Timestamp dateTo = new Timestamp(to.getTime());
				for (Order o : orderService.findAll()) {
					Timestamp orderCreatedDate = o.getCreateDate();
					if (orderCreatedDate.compareTo(dateFrom) >= 0 && orderCreatedDate.compareTo(dateTo) <= 0) {
						listOrder.add(o);
					}
				}
				renderModelByOrder(listOrder);
			}
		});
		statisticView.getDateChoose_from().getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub

				Date date = statisticView.getDateChoose_from().getDate();
				if (date != null) {
					String dateFrom = simpleDateFormat.format(date);
					statisticView.getField_dateFrom().setText(dateFrom);
				}

			}
		});
		statisticView.getDateChoose_to().getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				Date date = statisticView.getDateChoose_to().getDate();
				if (date != null) {
					String dateTo = simpleDateFormat.format(date);
					statisticView.getField_dateTo().setText(dateTo);
				}

			}
		});
	}
}
