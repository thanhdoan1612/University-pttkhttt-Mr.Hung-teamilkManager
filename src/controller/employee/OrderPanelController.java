package controller.employee;

import java.awt.Font;
import java.awt.Graphics2D;
import java.io.FileOutputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import model.Employee;
import model.Order;
import model.OrderDetail;
import utils.ConvertString;
import view.employee.EmployeeView;
import view.employee.OrderPanelView;

public class OrderPanelController {
	private OrderPanelView orderPanelView;
	private Order order;
	private int count;
	private JLabel[] stt_labels;
	private JLabel[] name_labels;
	private JLabel[] quantity_labels;
	private JLabel[] total_labels;

	public OrderPanelController(Order order) {
		this.orderPanelView = new OrderPanelView();
		this.order = order;
		this.count = 0;
		this.stt_labels = new JLabel[order.getListOrderDetail().size()];
		this.name_labels = new JLabel[order.getListOrderDetail().size()];
		this.quantity_labels = new JLabel[order.getListOrderDetail().size()];
		this.total_labels = new JLabel[order.getListOrderDetail().size()];
	}

	public OrderPanelView getOrderPanelView() {
		return orderPanelView;
	}

	public void setOrderPanelView(OrderPanelView orderPanelView) {
		this.orderPanelView = orderPanelView;
	}

	public void renderEmployee(Employee employee) {
		this.orderPanelView.getLabel_employeeName().setText(employee.getFullOfName());
	}

	public void renderCreatedDate() {
		this.orderPanelView.getLabel_createDate().setText(order.getCreateDate().toString());
	}
	public void renderTotal(String total) {
		this.orderPanelView.getField_total().setText(total);
	}
	public void renderReceivedMoney(String price) {
		this.orderPanelView.getField_receivedMoney().setText(price);

	}
	public void renderBackMoney(String price) {
		this.orderPanelView.getField_backMoney().setText(price);

	}

	public void renderOrder() {

		for (OrderDetail orderDetail : order.getListOrderDetail()) {
			renderOrderDetail(orderDetail);
			count++;
		}
		renderCreatedDate();
	}

	public void renderOrderDetail(OrderDetail orderDetail) {
		stt_labels[count] = new JLabel();
		name_labels[count] = new JLabel();
		quantity_labels[count] = new JLabel();
		total_labels[count] = new JLabel();

		JLabel stt = this.getOrderPanelView().getLabel_stt_1();
		JLabel name = this.getOrderPanelView().getLabel_nameMilkTea_1();
		JLabel quantity = this.getOrderPanelView().getLabel_quantity_1();
		JLabel total = this.getOrderPanelView().getLabel_total_1();
		stt.setVisible(false);
		name.setVisible(false);
		quantity.setVisible(false);
		total.setVisible(false);

		stt_labels[count].setFont(new Font("Arial", Font.PLAIN, 13));
		name_labels[count].setFont(new Font("Arial", Font.PLAIN, 13));
		quantity_labels[count].setFont(new Font("Arial", Font.PLAIN, 13));
		total_labels[count].setFont(new Font("Arial", Font.PLAIN, 13));

		int y = name.getHeight() * (count);
		stt_labels[count].setBounds(stt.getX(), y, stt.getWidth(), stt.getHeight());
		name_labels[count].setBounds(name.getX(), y, name.getWidth(), name.getHeight());
		quantity_labels[count].setBounds(quantity.getX(), y, quantity.getWidth(), quantity.getHeight());
		total_labels[count].setBounds(total.getX(), y, total.getWidth(), total.getHeight());

		stt_labels[count].setText((count + 1) + "");
		name_labels[count].setText(ConvertString.vietnameseToEnglish(orderDetail.getTeaMilk().getName()));
		quantity_labels[count].setText(orderDetail.getQuantity() + "");
		total_labels[count].setText(orderDetail.getTotal() + "");
		this.orderPanelView.getPanel_orderDetail().add(stt_labels[count]);
		this.orderPanelView.getPanel_orderDetail().add(name_labels[count]);
		this.orderPanelView.getPanel_orderDetail().add(quantity_labels[count]);
		this.orderPanelView.getPanel_orderDetail().add(total_labels[count]);
		

	}

	public void printOrderIntoPDF() {

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("order\\test2.pdf"));
			document.open();
			PdfContentByte contentByte = writer.getDirectContent();
			PdfTemplate template = contentByte.createTemplate(800, 500);
			Graphics2D g2 = template.createGraphics(800, 500);
			this.getOrderPanelView().getContentPane().print(g2);
			g2.dispose();
			contentByte.addTemplate(template, 30, 300);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (document.isOpen()) {
				document.close();
			}
		}
	}

	public static void main(String[] args) {
		OrderPanelController orderPanelController = new OrderPanelController(new Order());
//		orderPanelController.getOrderPanelView().setVisible(true);
		orderPanelController.printOrderIntoPDF();
	}

}
