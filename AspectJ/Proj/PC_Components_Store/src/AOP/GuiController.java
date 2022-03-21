package AOP;

import java.awt.Button;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

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
	Accordion prod_list_id;


	@FXML
	Button refreshButton;
	

	/**
	 * Methods
	 */

	public GuiController() {

	}

	public void loadDataIntoLists() {

		populateProductsList();

	}


	@FXML
	private void quitApp() {
		System.exit(0);
	}



	@FXML
	private void newProductWindow() {
		//CharacterWindow window = new CharacterWindow();
		//window.addPropertyChangeListener(this);

	}

	@FXML
	private void editProduct() {
		/*	String name, details;
		name = DataSingleton.getInstance().getCurrentCharacter().getName();
		details = DataSingleton.getInstance().getCurrentCharacter().getDetails();
		name = name.substring(1, name.length() - 1);
		details = details.substring(1, details.length() - 1);
		CharacterWindow window = new CharacterWindow(name, details);
		window.addPropertyChangeListener(this);*/
	}

	@FXML
	private void performRefresh() {
		loadDataIntoLists();
	}



	void populateProductsList() {

		/*char_list_id.getPanes().removeAll(observableSetCharFiles);
		observableSetCharFiles.clear();

		if (DataSingleton.getInstance().getCharFiles() != null
				&& DataSingleton.getInstance().getCharFiles().isEmpty() == false) {
			DataSingleton.getInstance().getCharFiles().forEach((c) -> {

				observableSetCharFiles.add(c);
			});

			char_list_id.getPanes().addAll(FXCollections.observableArrayList(observableSetCharFiles));

		}*/

	}

	public void initialize() {

		observableProducts = FXCollections.observableSet();

		//DataSingleton.getInstance().setTextBox(textBox);

		/*file_list_id.setCellFactory(lv -> {
			ListCell<TextFile> cell = new ListCell<TextFile>() {

				@Override
				protected void updateItem(TextFile item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.getFileName().replace("\"", ""));

					}
				}
			};

			cell.setOnMouseClicked(e -> {
				if (!cell.isEmpty()) {
					Document doc = Jsoup.parse(textBox.getHtmlText());
					DataSingleton.getInstance().getCurrentFile().setFileContent(
							DataSingleton.getInstance()
							.prepareHTMLtext(textBox.getHtmlText()));
					DataSingleton.getInstance().setCurrentFile(cell.getItem());
					String content = DataSingleton.getInstance()
							.prepareHTMLtext(DataSingleton.getInstance().getCurrentFile().getFileContent());

					textBox.setHtmlText(content);
					e.consume();
				}
			});

			return cell;
		});

		file_list_id.setOnMouseClicked(e -> {
			System.out.println("You clicked on an empty cell");
		});

		textBox.autosize();*/

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("refresh")) {
			Platform.runLater(() -> {
				loadDataIntoLists();
			});
		
	}

	}

}