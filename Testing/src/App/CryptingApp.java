/**
 * @author Dominik Leipelt
 */
package App;

import java.util.Random;

import MyObjects.Cryptor;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CryptingApp extends Application {
	String chin = "財奴自己痛3恨7Tc$聖誕4節和洗澡一組3頌歌3545的歌f456手在14\n\n自1己g6家門口的一桶冷水。他32345g遇到2了小蒂90姆，誰是他535\n0的員工，克瑞奇先生的兒34f";
	
	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox();
		
		TextArea input = new TextArea();
		TextArea output = new TextArea();
		input.setWrapText(true);
		output.setWrapText(true);
		input.setText("Enter Text you like to Crypt, and Push the Button 'Crypt', same for 'Decrypting' with the 'decrypt' Button dont forget to enter the Key" );
		output.setText("Ecrypted or decryptet will be displayed here!");
		Button crypt = new Button("Crypt");
		Button decrypt = new Button("deCrypt");
		TextField key = new TextField("key");
		VBox holder = new VBox();
		crypt.minWidth(150);
		decrypt.minWidth(150);
		output.setEditable(false);
		Pane p = new Pane();
		p.setMaxWidth(150);
		animator(p);
		holder.getChildren().addAll(key,crypt,decrypt,p);
		holder.setMinWidth(150);
		root.getChildren().addAll(input,holder,output);
		crypt.setPrefWidth(150);
		decrypt.setPrefWidth(150);
		
		
		
		
		
		
		
		crypt.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				Cryptor c = new Cryptor(keyIntValue((key.getText())));
				
				output.setText(c.crypt(input.getText()));
			}
		});
		
		decrypt.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Cryptor c = new Cryptor(keyIntValue((key.getText())));
				
				output.setText(c.decrypt(input.getText()));
			}
		});
		Scene s = new Scene(root,900,500);
		
		s.getStylesheets().add("App/Stylsheet.css");
		holder.getStyleClass().add("vbox");
		primaryStage.setScene(s);
		primaryStage.show();
		
	}
	
	private int keyIntValue(String s){
		int x = 0;
		for (char c : s.toCharArray()) {
			x += (int) c;
			
		}
		
		return x;
	}
	
	public void animator(Pane p){
		
		for (int i = 0; i < 100; i++) {
			Label node = new Label(chin.substring(23,39));
			
			if(i < 60)node.setTranslateX(-30+ (i+1)/2);
			if(i >= 60)node.setTranslateX(-35+ new Random().nextInt(111));
			node.setTranslateY(-100);
			
			node.setRotate(90);
			Random randomno = new Random();
			shuffling(node);
			
			 
			   // check next int value  
		
			Timeline timeline = new Timeline(
			        new KeyFrame(Duration.ZERO, new KeyValue(node.translateYProperty(),150)),
			        new KeyFrame(Duration.seconds(randomno.nextInt(22)+6), evt -> shuffling(node), new KeyValue(node.translateYProperty(), 600))
			        
					);
			timeline.setCycleCount(Animation.INDEFINITE);
	        timeline.play();
	        
	       node.getStyleClass().add("texti");
	        
		p.getChildren().add(node);
		
		}
	}
	
	public void shuffling(Label node){
		//node.setVisible((new Random().nextInt(4)>1));
		Cryptor c = new Cryptor(3);
		int start = (new Random().nextInt(26)+1);
		node.setText((c.shuffle(chin).substring(start,40)));
		node.setOpacity(1.0/(new Random().nextInt(10)+1));
		double value = Math.random()*1.3;
		node.setScaleX(value);
		node.setScaleY(value);
		
		node.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				node.setLayoutY(event.getY()+30);
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
