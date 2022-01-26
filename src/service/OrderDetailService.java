package service;

import java.util.HashMap;
import java.util.List;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import DAO.OrderDetailDAO;
import mapper.OrderDetailMapper;
import model.Order;
import model.OrderDetail;
import model.OrderToppingDetail;
import model.TeaMilk;

public class OrderDetailService {
	private OrderDetailDAO orderDetailDAO;
	private TeaMilkService teaMilkService;

	public OrderDetailService() {
		orderDetailDAO = new OrderDetailDAO();
		teaMilkService = new TeaMilkService();
	}

	public Long save(OrderDetail o) {
		return orderDetailDAO.save(o);

	}

	public OrderDetail findByID(int id) {
		return orderDetailDAO.findById(id);
	}

	public List<OrderDetail> findByOrderID(int id) {
		return orderDetailDAO.findByOrderId(id);
	}

	public List<OrderDetail> findByTeamilkID(int id) {
		return orderDetailDAO.findByTeamilkID(id);
	}

	public List<OrderDetail> findByGroupTeamilkID() {
		return orderDetailDAO.findByGroupTeamilkID();
	}

	public HashMap<Integer, Integer> getStatisticTeamilkFromOrder(List<Order> list) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Order o : list) {
			List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(o.getId());
			for (OrderDetail od : orderDetails) {
				if (map.containsKey(od.getTeaMilkID())) {
					int value = map.get(od.getTeaMilkID()) + od.getQuantity();
					map.put(od.getTeaMilkID(), value);
				} else {
					map.put(od.getTeaMilkID(), od.getQuantity());

				}
			}

		}
		return map;
	}

	public double getTotal(OrderDetail orderDetail) {
		double rs = orderDetail.getQuantity() * orderDetail.getTeaMilk().getPrice();
		for (OrderToppingDetail orderToppingDetail : orderDetail.getListToppingDetails()) {
			TeaMilk topping = teaMilkService.findByID(orderToppingDetail.getToppingId());
			rs += topping.getPrice() * orderDetail.getQuantity();
		}
		return rs;
	}
}
