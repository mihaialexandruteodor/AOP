package com.unibuc.controller;



import com.unibuc.model.Product;
import com.unibuc.repository.ProductRepository;
import com.unibuc.service.ProductManager;
import com.unibuc.utils.DataSingleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class MainFXClass extends Application {

    static FXMLLoader fxmlLoader;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            ApplicationContext context = new ClassPathXmlApplicationContext
                    ("applicationContext.xml");

            ProductManager manager = context.getBean(ProductManager.class);

            DataSingleton.getInstance().setProductManager(manager);

            fxmlLoader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root, 800, 500);

            primaryStage.setScene(scene);
            primaryStage.setTitle("AOP Project, Mihai Alexandru Teodor");
            primaryStage.setMinWidth(800);
            primaryStage.setMinHeight(500);
            primaryStage.show();

            DataSingleton.getInstance().setGuiController(fxmlLoader.getController());

            List<Product> products =  DataSingleton.getInstance().getProductManager().getAllProducts();
            DataSingleton.getInstance().setProducts(products);

            DataSingleton.getInstance().getGuiController().populateProductsList();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
