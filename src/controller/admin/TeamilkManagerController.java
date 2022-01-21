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

	@Override
	public void getAddAction() {

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
			MessagePopup.showMessage("Bạn đã thêm thành công món " + t.getName());
			addFoodView.dispose();
		} else {
			MessagePopup.showMessage("Thêm món ăn thất bại");
		}

	}

	@Override
	public void initAddView() {

		addFoodView = new AddFoodView();
		addFoodView.setVisible(true);
		String nameText = "Tên Món";
		String priceText = "Giá";
		String quantityText = "Số lượng";

		addFoodView.getField_name().setText(nameText);
		addFoodView.getField_price().setText(priceText);
		addFoodView.getField_quanity().setText(quantityText);

		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (Category c : categoryService.findAll()) {
			defaultComboBoxModel.addElement(c.getName());
		}
		addFoodView.getComboBox_category().setModel(defaultComboBoxModel);
		addFocusAction(addFoodView.getField_name(), nameText);
		addFocusAction(addFoodView.getField_price(), priceText);
		addFocusAction(addFoodView.getField_quanity(), quantityText);
	}


}
