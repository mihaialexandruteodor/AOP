package com.unibuc.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import com.unibuc.utils.DataSingleton;
import com.unibuc.view.ProductWindow;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import com.unibuc.model.Product;

public class GuiController implements PropertyChangeListener {

    private ObservableSet<Product> observableProducts;

    /**
     * Labels
     */

    @FXML
    Label text_label;

    /**
     * Lists
     */


    @FXML
    ListView<Product> prod_list_id;


    @FXML
    Button refreshButton;

    @FXML
    Button addProductButton;

    @FXML
    Button removeSelectedButton;


    @FXML
    Button updateSelectedButton;


    /**
     * Methods
     */

    public GuiController() {

    }



    @FXML
    private void quitApp() {
        System.exit(0);
    }



    @FXML
    private void newProductWindow() {
        ProductWindow window = new ProductWindow();
        window.addPropertyChangeListener(this);

    }

    @FXML
    private void removeProduct() throws SQLException {
        if(DataSingleton.getInstance().getCurrentProduct() != null)
        {
            DataSingleton.getInstance().getProductManager().deleteProduct(DataSingleton.getInstance().getCurrentProduct());
            DataSingleton.getInstance().setCurrentProduct(null);
            populateProductsList();
        }
    }

    @FXML
    private void updateProduct() throws SQLException {
        if(DataSingleton.getInstance().getCurrentProduct() != null)
        {
            Product prod = DataSingleton.getInstance().getCurrentProduct();
            ProductWindow window = new ProductWindow(prod.getProduct_name(), prod.getProduct_quantity(),
                    prod.getProduct_price(), prod.getId());
            window.addPropertyChangeListener(this);
        }
    }

    @FXML
    private void refreshGUI() {
        populateProductsList();
    }


    public void populateProductsList() {

        prod_list_id.getItems().removeAll(observableProducts);
        prod_list_id.getItems().clear();
        observableProducts.clear();

        if (DataSingleton.getInstance().getProducts() != null
                && DataSingleton.getInstance().getProducts().isEmpty() == false) {
            DataSingleton.getInstance().getProducts().forEach((c) -> {

                observableProducts.add(c);
            });

            prod_list_id.getItems().addAll(FXCollections.observableArrayList(observableProducts));

        }

    }

    public void initialize() {

        observableProducts = FXCollections.observableSet();



        prod_list_id.setCellFactory(lv -> {
            ListCell<Product> cell = new ListCell<Product>() {

                @Override
                protected void updateItem(Product item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getProduct_name());

                    }
                }
            };

            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    DataSingleton.getInstance().setCurrentProduct(cell.getItem());
                    e.consume();
                }
            });

            return cell;
        });

        prod_list_id.setOnMouseClicked(e -> {
            System.out.println("You clicked on an empty cell");
        });



    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("refresh")) {
            Platform.runLater(() -> {
                populateProductsList();
            });

        }

    }

}