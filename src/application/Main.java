package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Main extends Application {
	String text1=new String();
	
@Override
	public void start(Stage primaryStage) {
		try {
			
			GridPane root = new GridPane();
			//root.setAlignment(Pos.BASELINE_RIGHT);
			root.setAlignment(Pos.CENTER);
			root.setHgap(10);
			root.setVgap(5);
			root.setPadding(new Insets(25,25,25,25));
			//root.setGridLinesVisible(true);
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Label source=new Label ("èrÛd≥o:");
			root.add(source,0,0);
			Label equals= new Label("Wynik operacji:");
			root.add(equals, 0, 4);
			
			source.getStyleClass().add("label");
			equals.getStyleClass().add("label");
			
			
			TextField text1=new TextField();
			root.add(text1, 0, 1,2,1);
			//double value1 = Double.parseDouble(text1.getText());
			TextField text2=new TextField();
			root.add(text2, 0, 5,2,1);
			//double value2 = Double.parseDouble(text2.getText());
		
			
			text1.getStyleClass().add("my-field");
			text2.getStyleClass().add("my-field");
			
			Button copyButton=new Button("Kopiuj");
			root.add(copyButton, 1, 2);
			Button doButton=new Button("Wykonaj");
			root.add(doButton, 0, 8);
			
			copyButton.setId("copyButton");
			//button1.setId("button1");
			
			//dodanie przciskÛw do HBoxa
			HBox hBox = new HBox();
			HBox hBox2 = new HBox();
			hBox.setAlignment(Pos.BOTTOM_RIGHT);
			hBox.getChildren().add(copyButton);
			hBox2.getChildren().add(doButton);
			root.add(hBox,1,2);
			root.add(hBox2,0,8);
				
			 //Prawa strona
			 Label operation= new Label("Opercja:"); //wstawia tekst
			root.add(operation, 3 ,0);
			
			//przyciski radiowe
			RadioButton code=new RadioButton("kodowanie");
			RadioButton decode=new RadioButton("dekodowanie");
			root.add(code, 3 ,1);
			root.add(decode, 3 ,2);
			code.setUserData("Wybrano kodowanie");
			decode.setUserData("Wybrano dekodowanie");
			//podlaczenie przyciskow w grupe
			ToggleGroup tgroup=new ToggleGroup();
			code.setToggleGroup(tgroup);
			decode.setToggleGroup(tgroup);
			tgroup.selectedToggleProperty().addListener(
					(ov,oldToggle,newToggle)->{
						System.out.println(newToggle.getUserData().toString());});
			
			//lambda dla przycisku 1
			//parametrem funkcji setOnAction jest wyrazenie lambda definiujace co sie stanie po wcisnieciu przycisku
			copyButton.setOnAction(event->{System.out.println("Kopiuj z wyniku operacji"+" "+text2.getText()); //na konsoli wywietli sie napis
			text1.clear();
				text1.appendText(text2.getText());
				text2.clear();
			});
			
			//lambda dla przycisku 2
			//parametrem funkcji setOnAction jest wyrazenie lambda definiujace co sie stanie po wcisnieciu przycisku
			doButton.setOnAction(event->{System.out.println("Nacisnieto wykonaj"+" "+text1.getText());
			if (code.isSelected()==true) {
				text2.clear();
				text2.appendText(Rle.encode(text1.getText()));}
			else 
			 {text2.clear();
					text2.appendText(Rle.decode(text1.getText()));
				};
			});
			
			
		//=====================================	
			primaryStage.setTitle("Praca domowa nr 1"); //tytu≈Ç okienka
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch(Exception e) {
			e.printStackTrace();
		}
	}

	

public static void main(String[] args) {
		launch(args);
	}



}
