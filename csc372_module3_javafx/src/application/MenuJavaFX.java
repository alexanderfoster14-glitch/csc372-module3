package application;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.scene.control.Alert;				//For Testing
//import javafx.scene.control.Alert.AlertType;		//For Testing

public class MenuJavaFX extends Application {
	
	private Pane topPane;
	private Pane middlePane;
	private Pane mainPane;
	private Scene scene;
	private TextArea textAreaInstructions = null;
	private TextArea textFieldIO = null;
	
	@Override
	public void start(Stage applicationStage) {
		topPane = new Pane();			//Create the Pane that will be used for layout
		middlePane = new Pane();
		mainPane = new Pane();			//Will contain all Panes
		
		topPane.setPrefSize(600,50);	//Set the preferred size of the GridPane
		middlePane.setPrefSize(600, 200);
		mainPane.setPrefSize(600, 400);
		
		mainPane.getChildren().addAll(topPane, middlePane);
		
		scene = new Scene(mainPane, 600, 400);	//Create the Scene that has the GridPane
		
		//Create the MenuItems
		Button menu1 = new Button();
		Button menu2 = new Button();
		Button menu3 = new Button();
		Button menu4 = new Button();
		
		//Set the names of the MenuItems
		menu1.setText("Display Time");
		menu2.setText("Save Text");
		menu3.setText("Change Color");
		menu4.setText("Exit");
		
		HBox hbox = new HBox(menu1, menu2, menu3, menu4);
		
		//menu1 selection functionality
		menu1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/*
				Alert alert = new Alert(AlertType.INFORMATION, "You selected menuItem1");
				alert.showAndWait();
				*/
				printTime();
			}
		});
		
		//menu2 selection functionality
		menu2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/*
				Alert alert = new Alert(AlertType.INFORMATION, "You selected menuItem2");
				alert.showAndWait();
				*/
				saveText();
			}
		});
		
		//menu3 selection functionality
		menu3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/*
				Alert alert = new Alert(AlertType.INFORMATION, "You selected menuItem3");
				alert.showAndWait();
				*/
				changeBackground();
			}
		});
		
		//menu4 selection functionality
		menu4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/*
				Alert alert = new Alert(AlertType.INFORMATION, "You selected menuItem4");
				alert.showAndWait();
				*/
				exit();
			}
		});
		
		//Instructions to user
		textAreaInstructions = new TextArea();
		textAreaInstructions.setText("Instructions. Select an option from the Menu above\n"
				+ "Option 1: Print the current date and time to the text box below.\n"
				+ "Option 2: Option 2 details\n"
				+ "Option 3: Option 3 details\n"
				+ "Option 4: Option 4 details");
		textAreaInstructions.setEditable(false);
		//textAreaInstructions.setPrefColumnCount(20);
		textAreaInstructions.setPrefRowCount(5);
		
		//Crate the TextField used for input and output
		textFieldIO = new TextArea();
		textFieldIO.setText("This is a TextField");
		textFieldIO.setPrefColumnCount(25);
		textFieldIO.setPrefRowCount(1);
		
		topPane.getChildren().addAll(hbox);
		middlePane.getChildren().addAll(textAreaInstructions);
		middlePane.getChildren().addAll(textFieldIO);
		
		//Set location of the objects
		topPane.relocate(0, 0);
		middlePane.relocate(0, 30);
		//textAreaInstructions.relocate(0, 30);
		textFieldIO.relocate(0, 110);
		
		applicationStage.setScene(scene);					//Add the Scene to the window
		applicationStage.setTitle("Menu Button Program");	//She the window title
		applicationStage.show();							//Show the window
		
	}
	
	//Method to print the current date and time to the text box
	public void printTime() {
		LocalDateTime now = LocalDateTime.now();	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
		String formattedTime = now.format(formatter);
		textFieldIO.setText("The current time is: " + formattedTime);
	}
	
	//Method to save the current text box text to a file
	public void saveText() {
		//FileInputStream fileInStream = null;
		String fileLocation = null;
		PrintWriter outFS = null;
		fileLocation = "C:/Users/alexa/git/csc372-module3/csc372_module3_javafx/Text File.txt";
		try {
			outFS = new PrintWriter(fileLocation);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outFS.print(textFieldIO.getText());
		outFS.close();
	}
	
	public void changeBackground() {
		int x = 0;
		int y = 0;
		String valx = "0";
		String valy = "0";
		Random random = new Random();
		x = random.nextInt(16);			//gets random number from 0 to 15 inclusive
		y = random.nextInt(16);
		
		switch (x) {
			case 0:
				valx = "0";
				break;
			case 1:
				valx = "1";
				break;
			case 2:
				valx = "2";
				break;
			case 3:
				valx = "3";
				break;
			case 4:
				valx = "4";
				break;
			case 5:
				valx = "5";
				break;
			case 6:
				valx = "6";
				break;
			case 7:
				valx = "7";
				break;
			case 8:
				valx = "8";
				break;
			case 9:
				valx = "9";
				break;
			case 10:
				valx = "A";
				break;
			case 11:
				valx = "B";
				break;
			case 12:
				valx = "C";
				break;
			case 13:
				valx = "D";
				break;
			case 14:
				valx = "E";
				break;
			case 15:
				valx = "F";
				break;
		}
		
		switch (y) {
			case 0:
				valy = "0";
				break;
			case 1:
				valy = "1";
				break;
			case 2:
				valy = "2";
				break;
			case 3:
				valy = "3";
				break;
			case 4:
				valy = "4";
				break;
			case 5:
				valy = "5";
				break;
			case 6:
				valy = "6";
				break;
			case 7:
				valy = "7";
				break;
			case 8:
				valy = "8";
				break;
			case 9:
				valy = "9";
				break;
			case 10:
				valy = "A";
				break;
			case 11:
				valy = "B";
				break;
			case 12:
				valy = "C";
				break;
			case 13:
				valy = "D";
				break;
			case 14:
				valy = "E";
				break;
			case 15:
				valy = "F";
				break;
		}
		
		String randomColor = "#00" + valx + valy + "00";

		mainPane.setStyle("-fx-background-color: " + randomColor);
		textFieldIO.setText("The random color selected is: " + randomColor);
	}
	
	public void exit() {
		Platform.exit();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}



