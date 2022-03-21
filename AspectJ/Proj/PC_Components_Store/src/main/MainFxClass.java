package main;

import AOP.Product;
import AOP.Shop;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.DataSingleton;

public class MainFxClass extends Application {

	static FXMLLoader fxmlLoader;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			fxmlLoader = new FXMLLoader(getClass().getResource("/resources/GUI.fxml"));
			Pane root = fxmlLoader.load();
			Scene scene = new Scene(root, 1200, 600);

			primaryStage.setScene(scene);
			primaryStage.setTitle("AOP Project, Mihai Alexandru Teodor");
			primaryStage.setMinWidth(1200);
			primaryStage.setMinHeight(600);
			primaryStage.show();
			
			DataSingleton.getInstance().setGuiController(fxmlLoader.getController());

		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		Shop shop = new Shop("Galaxy Components");
		Product product = new Product("Mac Studio");
		shop.addProductToShop(product);
		
		
		launch(args);
	}


}