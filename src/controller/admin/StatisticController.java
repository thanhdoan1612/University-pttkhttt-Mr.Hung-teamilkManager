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
import model.OrderToppingDetail;
import model.TeaMilk;
import service.EmployeeService;
import service.OrderDetailService;
import service.OrderService;
import service.OrderToppingDetailService;
import service.TeaMilkService;
import utils.ConvertNumber;
import view.admin.StatisticView;

public class StatisticController {
	private String[] headerByOrder = new String[] { "Mã Hóa Đơn", "Tên nhân viên", "Thành tiền", "Ngày tạo đơn" };
	private String[] headerByTeamilk = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Số lượng bán ra", "Thành tiền" };
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
		listOrder = orderService.findAll();
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
		Object[] rowData;
		for (Order o : list) {
			employee = employeeService.findByID(o.getEmployeeID());
			List<OrderDetail> listOrderDetails = orderDetailService.findByOrderID(o.getId());

			rowData = new Object[] { o.getId(), employee.getFullOfName(), o.getTotal(), o.getCreateDate() };
			model.addRow(rowData);

			o.setEmployee(employee);

		}
		statisticView.getTable().setModel(model);
		statisticView.getField_total().setText(ConvertNumber.numberToPrice((int) orderService.getAllTotal(list)));
		statisticView.getField_totalOrder().setText(list.size() + "");

	}

	public void renderModelByTeamilk() {
		model.setColumnIdentifiers(headerByTeamilk);
		model.setRowCount(0);
		HashMap<Integer, Integer> map = orderDetailService.getStatisticTeamilkFromOrder(listOrder);
		for (int id : map.keySet()) {
			TeaMilk t = teaMilkService.findByID(id);
			int quantity = map.get(id);
			Object[] row = new Object[] { t.getId(), t.getName(), quantity, quantity * t.getPrice() };
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
				renderModelByOrder(listOrder);

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
