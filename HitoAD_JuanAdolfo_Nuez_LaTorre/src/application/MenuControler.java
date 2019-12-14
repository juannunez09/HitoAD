package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuControler {

	public void abrirJSON() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("json.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("JSON");
		stage.setScene(new Scene(root1,600, 440));
		stage.setResizable(false);
		stage.show();
	}

	public void abrirTXT() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("txt.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("TXT");
		stage.setScene(new Scene(root1, 700, 430));
		stage.setResizable(false);
		stage.show();
	}

	public void abrirXML() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("xml.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("XML");
		stage.setScene(new Scene(root1, 600, 440));
		stage.setResizable(false);
		stage.show();
	}

}
