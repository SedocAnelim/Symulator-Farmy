package pszt.farmy.symulator;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import pszt.ga.exceptions.ElitismException;
import pszt.ga.exceptions.ParentSizeException;
import pszt.ga.exceptions.ProbabilityException;
import pszt.test.*;


public class Main extends Application {
	
	Stage window;
	Scene scene1, scene2;
	
	
	 @Override
	    public void start(Stage primaryStage) {
		 
		 window = primaryStage;
		 
		 Button test1Button = new Button();
		 test1Button.setText("New test");
		 test1Button.setOnAction(e -> {
			 try {
				Test.main();
			} catch (ProbabilityException | ElitismException | ParentSizeException e1) {
				e1.printStackTrace();
			}
			 Chart.display(Test.getDataList());
		 });
		 
		 StackPane layout1 = new StackPane();	
		 layout1.getChildren().addAll(test1Button);
		 scene1 = new Scene(layout1, 200, 200);
		 
		 window.setScene(scene1);
		 window.setTitle("Symulator Farmy");
		 window.show();
	 }
		 
	

    public static void main(String[] args) {
        launch(args);
    }
}
