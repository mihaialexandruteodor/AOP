package main;

import CRUD.DBConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Product;
import model.Shop;
import utils.DataSingleton;

public class MainFxClass extends Application {

	static FXMLLoader fxmlLoader;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		    DBConnector dbConn  =new DBConnector();
		    Thread thread1 = new Thread(dbConn, "Thread to make sure DB is connected before UI is created");
		    thread1.start();
		    thread1.join();
			
			fxmlLoader = new FXMLLoader(getClass().getResource("/resources/GUI.fxml"));
			Pane root = fxmlLoader.load();
			Scene scene = new Scene(root, 1200, 600);

			primaryStage.setScene(scene);
			primaryStage.setTitle("AOP Project, Mihai Alexandru Teodor");
			primaryStage.setMinWidth(1200);
			primaryStage.setMinHeight(600);
			primaryStage.show();
			
			DataSingleton.getInstance().setGuiController(fxmlLoader.getController());
			
			/*Shop shop = new Shop();
			shop.setShopName("Galaxy Components");
			Product product = new Product();
			product.setProduct_name("Mac Studio");
			product.setId(dbConn.getNumberOfProducts()+1);
			product.setProduct_price(100);
			product.setProduct_quantity(30);
			shop.addProduct(product);
			
			
			dbConn.addProduct(product);*/
			
			dbConn.disconnect();

		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
		
		
		
		
	}


}