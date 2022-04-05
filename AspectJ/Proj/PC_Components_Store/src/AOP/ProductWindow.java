package AOP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import javafx.application.Platform;
import model.Product;
import utils.DataSingleton;

public class ProductWindow {
	String productName;
	int quantity, price;
	boolean editing;

	private final PropertyChangeSupport support = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}

	public ProductWindow() {
		setProductName("");
		setWindow();
		editing = false;
	}

	public ProductWindow(String prName, int _quant, int _price) {
		setProductName(prName);
		setWindow();
		editing = true;
	}

	public void setWindow() {
		JFrame frame = new JFrame("Create or edit a product! ");


		JLabel labelName = new JLabel();
		labelName.setText("Product name:");
		labelName.setBounds(10, 10, 300, 100);

		JTextArea prNameBox = new JTextArea();
		prNameBox.setBounds(210, 50, 250, 30);
		prNameBox.setText(productName);
		prNameBox.setLineWrap(true);
		prNameBox.setWrapStyleWord(true);

		JLabel labelQuantity = new JLabel();
		labelQuantity.setText("Quantity:");
		labelQuantity.setBounds(10, 90, 300, 30);

		JTextArea quantBox = new JTextArea();
		quantBox.setBounds(210, 90, 250, 200);
		quantBox.setText(Integer.toString(quantity));
		quantBox.setLineWrap(true);
		quantBox.setWrapStyleWord(true);

		JLabel labelPrice = new JLabel();
		labelPrice.setText("Price:");
		labelPrice.setBounds(10, 300, 300, 30);

		JTextArea priceBox = new JTextArea();
		priceBox.setBounds(210, 310, 250, 300);
		priceBox.setText(Integer.toString(price));
		priceBox.setLineWrap(true);
		priceBox.setWrapStyleWord(true);

		JButton buttonSubmit = new JButton("Submit");
		buttonSubmit.setBounds(80, 630, 140, 40);

		JButton buttonClose = new JButton("Close");
		buttonClose.setBounds(230, 630, 140, 40);

		frame.add(prNameBox);
		frame.add(labelName);
		frame.add(labelQuantity);
		frame.add(quantBox);
		frame.add(labelPrice);
		frame.add(priceBox);
		frame.add(buttonSubmit);
		frame.add(buttonClose);
		frame.setSize(500, 730);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				productName = prNameBox.getText();
				price = Integer.parseInt(priceBox.getText());
				quantity = Integer.parseInt(quantBox.getText());
				Product product = new Product();
				try {
					product.setId(DataSingleton.getInstance().getDBConnection().getMaxIDProducts()+1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				product.setProduct_name(productName);
				product.setProduct_price(price);
				product.setProduct_quantity(quantity);
				try {
					DataSingleton.getInstance().getDBConnection().addProduct(product);
					Platform.runLater(new Runnable(){
						@Override public void run() {
						DataSingleton.getInstance().getGuiController().populateProductsList();
						}
						});
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		buttonClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				support.firePropertyChange("refreshCharacters", true, false);
				frame.dispose();
			}
		});
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String characterName) {
		this.productName = characterName;
	}

	public int getProductPrice() {
		return price;
	}

	public void setProductPrice(int _price)
	{
		price = _price;
	}
	
	public int getProductQuantity() {
		return quantity;
	}

	public void setProductQuantity(int _quantity)
	{
		quantity = _quantity;
	}
	
}
