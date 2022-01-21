package controller.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.employee.EmployeeView;
import view.employee.QuantityView;

public class QuantityController {
	private QuantityView quantityView;
	private int quantity;

	public QuantityController() {
		this.quantityView = new QuantityView();
		addAction();

	}
	public void init() {
		this.quantity = 0;
		this.quantityView.setVisible(true);
		this.quantityView.getField_number().setText(quantity+"");
	}
	public boolean isOn() {
		return this.quantityView.isVisible();
	}

	public void addAction() {
		this.quantityView.getBtn_add().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				quantity = getQuantityFromField() + 1;
				quantityView.getField_number().setText(quantity + "");

			}
		});
		this.quantityView.getBtn_sub().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				quantity = getQuantityFromField();
				quantity = quantity == 0 ? 0 : quantity - 1;
				quantityView.getField_number().setText(quantity + "");

			}
		});
	
	}
	
	
	public int getQuantityFromField() {
		return Integer.parseInt(quantityView.getField_number().getText());
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public QuantityView getQuantityView() {
		return quantityView;
	}

	public void setQuantityView(QuantityView quantityView) {
		this.quantityView = quantityView;
	}

}
