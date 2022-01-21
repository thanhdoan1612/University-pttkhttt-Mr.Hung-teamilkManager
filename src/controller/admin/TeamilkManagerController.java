package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import model.Category;
import model.TeaMilk;
import service.CategoryService;
import service.TeaMilkService;
import utils.ConvertNumber;
import utils.MessagePopup;
import view.admin.AddFoodView;

public class TeamilkManagerController extends ManagerController<TeaMilk> {

	private String[] header = new String[] { "STT", "Tên món", "Giá", "Tên nhóm", "Đơn vị Tính", "Số Lượng" };
	private String[] listSearch = new String[] { "ID", "Name", "Price", "CategoryID", "Unit" };
	private CategoryService categoryService;
	private AddFoodView addFoodView;

	public TeamilkManagerController() {
		this.categoryService = new CategoryService();
		this.iGenericService = new TeaMilkService();
		this.headerName = header;
		this.listSearchName = listSearch;
	}

	@Override
	public void addAction() {

		String name = addFoodView.getField_name().getText();
		String price = addFoodView.getField_price().getText();
		int number = ConvertNumber.priceToNumber(price);
		String unit = addFoodView.getField_unit().getText();
		String quantity = addFoodView.getField_quanity().getText();
		String categoryName = (String) addFoodView.getComboBox_category().getSelectedItem();
		TeaMilk t = new TeaMilk();
		t.setCategoryId(categoryService.findByName(categoryName).getID());
		t.setName(name);
		t.setPrice(number);
		t.setUnit(unit);
		t.setQuantity(Integer.parseInt(quantity));
		if (iGenericService.add(t)) {
			MessagePopup.showSuccessMessage("Bạn đã thêm thành công món " + t.getName());
			addFoodView.dispose();
		} else {
			MessagePopup.showMessage("Thêm món ăn thất bại");
		}

	}

	@Override
	public void initAddView() {

		addFoodView = new AddFoodView();
		addFoodView.setVisible(true);

		addFoodView.getField_name().setText(header[0]);
		addFoodView.getField_price().setText(header[1]);
		addFoodView.getField_quanity().setText(header[5]);

		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (Category c : categoryService.findAll()) {
			defaultComboBoxModel.addElement(c.getName());
		}
		addFoodView.getComboBox_category().setModel(defaultComboBoxModel);
		initActionListener();
	}

	@Override
	public void initActionListener() {
		addFoodView.getBtn_cancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cancelAction();
			}
		});
		addFoodView.getBtn_ok().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addAction();
			}
		});
		addFocusAction(addFoodView.getField_name(), header[1]);
		addFocusAction(addFoodView.getField_price(), header[2]);
		addFocusAction(addFoodView.getField_quanity(), header[5]);
	}

	@Override
	public void cancelAction() {
		// TODO Auto-generated method stub
		addFoodView.dispose();
	}

}
