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
import model.OrderDetail;
import model.TeaMilk;
import service.EmployeeService;
import service.OrderDetailService;
import service.OrderService;
import service.TeaMilkService;
import utils.ConvertNumber;
import view.admin.StatisticView;

public class StatisticController {
	private String[] headerByOrder = new String[] { "ID", "Employee", "Teamilk", "Total", "CreatedDate" };
	private String[] headerByTeamilk = new String[] { "ID", "Teamilk", "Quantity", "TotalOrder", "Total" };
	private String[] headerByEmployee = new String[] { "ID", "Employee", "Total" };
	private StatisticView statisticView;
	private SimpleDateFormat simpleDateFormat;
	private DefaultTableModel model;
	private OrderService orderService;
	private OrderDetailService orderDetailService;
	private EmployeeService employeeService;
	private TeaMilkService teaMilkService;
	private List<Order> listOrder;

	public StatisticController() {
		statisticView = new StatisticView();
		model = new DefaultTableModel();
		orderService = new OrderService();
		employeeService = new EmployeeService();
		orderDetailService = new OrderDetailService();
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		teaMilkService = new TeaMilkService();
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
		initAction();
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
		TeaMilk t;
		Object[] rowData ;
		for (Order o : list) {
			employee = employeeService.findByID(o.getEmployeeID());
			List<OrderDetail> listOrderDetails = orderDetailService.findByOrderID(o.getId());
			for (OrderDetail od : listOrderDetails) {
				t = teaMilkService.findByID(od.getTeaMilkID());
				rowData= new Object[] { o.getId(), employee.getFullOfName(), t.getName(), o.getTotal(),
						o.getCreateDate() };
				model.addRow(rowData);
			}
			o.setEmployee(employee);

		}
		statisticView.getTable().setModel(model);
		statisticView.getField_total().setText(ConvertNumber.numberToPrice((int) orderService.getAllTotal(list)));
		statisticView.getField_totalOrder().setText(list.size() + "");

	}

	public void renderModelByEmployee() {
		model.setColumnIdentifiers(headerByEmployee);
		model.setRowCount(0);
		HashMap<Integer, Double> map = orderService.statisticByEmployee();
		for (int key : map.keySet()) {
			Employee employee = employeeService.findByID(key);
			Object[] row = new Object[] { employee.getId(), employee.getFullOfName(), map.get(key) };
			model.addRow(row);
		}
		statisticView.getTable().setModel(model);

	}

	public void renderModelByTeamilk() {
		model.setColumnIdentifiers(headerByTeamilk);
		model.setRowCount(0);
		List<OrderDetail> listOrderDetails = orderDetailService.findByGroupTeamilkID();

		for (OrderDetail orderD : listOrderDetails) {
			TeaMilk t = teaMilkService.findByID(orderD.getTeaMilkID());
			int totalOrder = orderDetailService.findByTeamilkID(t.getId()).size();
			Object[] row = new Object[] { t.getId(), t.getName(), orderD.getQuantity(), totalOrder, orderD.getTotal() };
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

	public void initAction() {
		statisticView.getBtn_statisticByProduct().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				renderModelByTeamilk();

			}
		});
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
