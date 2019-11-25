package zt.proj.sudoku;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import zt.proj.sudoku.view.MainSceneController;

public class Main extends Application {
	
	private Stage primaryStage;
	private AnchorPane MainScene;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("SAT_Sudoku_Solver");
		primaryStage.setResizable(false);
		this.primaryStage.getIcons().add(new Image("file:resources/images/sudokuIcon.png"));
		
		initialScene();
	}
	
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}


	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}



	private void initialScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MainScene.fxml"));
			MainScene = (AnchorPane)loader.load();
			
			Scene scene= new Scene(MainScene);
			primaryStage.setScene(scene);
			
			MainSceneController controller = loader.getController();
			controller.setMainClass(this);
			
			primaryStage.show();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
