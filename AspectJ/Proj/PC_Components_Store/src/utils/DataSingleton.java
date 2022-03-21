package utils;

import AOP.GuiController;

public class DataSingleton {
	private static DataSingleton single_instance = null;

	GuiController guiController;
	String connectionString;

	

	private DataSingleton() {
		
		guiController = new GuiController();
		
	}

	public static DataSingleton getInstance() {
		if (single_instance == null)
			single_instance = new DataSingleton();

		return single_instance;
	}

	public GuiController getGuiController() {

		return guiController;
	}

	public void setGuiController(GuiController guiController) {
		this.guiController = guiController;
	}
}
