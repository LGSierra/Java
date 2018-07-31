package pro2;

import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Rocket extends Application{

	
	public int score = 0;
	private Line beam;
	public Spaceship ship = new Spaceship();
	public Group rocket = new Group(ship.getBase(), ship.getwindow(), ship.LeftWing, ship.RightWing, ship.Nose);
	public Random gen = new Random();
	public MediaPlayer laser;
	public MediaPlayer tunes;
	public Timer timer = new Timer();
	public Baddies baddie1 = new Baddies();
	public Baddies baddie2 = new Baddies();
	public Baddies baddie3 = new Baddies();
	public Baddies baddie4 = new Baddies();
	public Baddies baddie5 = new Baddies();
	public Baddies baddie6 = new Baddies();
	
	/*
	public Baddies baddieGen = new Baddies();
	public Group enemyGen = new Group(baddieGen.getBase(), baddieGen.getwindow());
	public Group en = new Group(enemyGen);
	*/
	public Group enemy1 = new Group(baddie1.getBase(), baddie1.getwindow());
	public Group enemy2= new Group(baddie2.getBase(), baddie2.getwindow());
	public Group enemy3 = new Group(baddie3.getBase(), baddie3.getwindow());
	public Group enemy4= new Group(baddie4.getBase(), baddie4.getwindow());
	public Group enemy5 = new Group(baddie5.getBase(), baddie5.getwindow());
	public Group enemy6= new Group(baddie6.getBase(), baddie6.getwindow());
	public Group enemies = new Group(enemy1, enemy2, enemy3,enemy4 , enemy5, enemy6);
	public Text text;
	public Text message = new Text("");
	public Text GameOver = new Text(" ");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		
		
        GameOver.setFont(Font.font("Monospaced", FontWeight.BOLD, 45));
        GameOver.setFill(Color.WHITE);
        GameOver.setTranslateX(100);
        GameOver.setTranslateY(400);
        
		
        message.setFont(Font.font("Monospaced", FontWeight.BOLD, 45));
        message.setFill(Color.WHITE);
        message.setTranslateX(300);
        message.setTranslateY(500);
        
        
        
		Media audiofile = new Media(getClass().getResource("MoonTheme.mp3").toExternalForm());
		tunes = new MediaPlayer(audiofile);
		tunes.setAutoPlay(true);
		tunes.play();
		Media effect = new Media(getClass().getResource("FLATALO.mp3").toExternalForm());
		laser = new MediaPlayer(effect);
		
		
		tunes.setOnEndOfMedia(new Runnable(){
			public void run() {
				tunes.seek(Duration.ZERO);
			}
		});
		
		
		beam = new Line(0,0,0,0);
		beam.setStroke(Color.BLUEVIOLET);
		beam.setStrokeWidth(4);
		
		rocket.setTranslateX(400);
		rocket.setTranslateY(690);
		
		enemy1.setTranslateX(100);
		enemy2.setTranslateX(200);
		enemy3.setTranslateX(300);
		enemy4.setTranslateX(400);
		enemy5.setTranslateX(500);
		enemy6.setTranslateX(600);

		enemies. setTranslateY(100);
		
		Circle star = new Circle (gen.nextInt(800)+ 1, gen.nextInt(800) + 1, 1); 
		star.setFill(Color.WHITE);
		Group root = new Group(star);
		
		for(int i=0; i<300; i++) {
			star = new Circle (gen.nextInt(800)+ 1, gen.nextInt(800) + 1, 1);
			star.setFill(Color.WHITE);
			root.getChildren().add(star);
		}
		
		double a=100;
		
		Timeline timeline = new Timeline(new KeyFrame(
           Duration.millis(1000),valor ->{
        	   boolean result;
        	   result = DoSomething(enemies, a);
	           System.out.println("pass");
	                 
	       }));
	     timeline.play();   	        
	     timeline.setCycleCount(Animation.INDEFINITE);
	     timeline.playFromStart();
		
	     /*
	     //added
	     Timeline generation = new Timeline(new KeyFrame(
	             Duration.millis(2000),valor ->{
	          	   boolean result;
	          	   
	          	   enemyGen.setTranslateX(gen.nextInt(800)+ 1);
	          	   enemyGen.setTranslateY(1);
	          	   root.getChildren().add(enemyGen);
	          	   
	          	   
	          	   result = DoSomething(en, a);
	  	           System.out.println("pass 2");
	  	                 
	  	       }));
	  	     generation.play();   	        
	  	     generation.setCycleCount(Animation.INDEFINITE);
	  	     generation.playFromStart();
	     
	     */
	     
		root.getChildren().add(enemies);
		root.getChildren().add(beam);
		root.getChildren().add(rocket);
		root.getChildren().add(GameOver);
		root.getChildren().add(message);
		
		
		
		Scene scene = new Scene (root, 800, 800, Color.BLACK);
		
		scene.setOnMousePressed(this::processMousePress);//beam sale
        scene.setOnMouseMoved(this::processMouseClick); //rocket se mueve
        scene.setOnMouseReleased(this::processMouseRelease);//beam para de salir
		primarystage.setTitle("Space lazerr");
		primarystage.setScene(scene);
		primarystage.show();
		
		
	}


	private boolean DoSomething(Group enemies, double a) {
		 a = enemies.getTranslateY();
		 a+=50;
		 enemies.setTranslateY(a);
		 
		 /*
		 if(enemies.getChildren().isEmpty()) {
			 GameOver.setText("You got the enemies! \n  Congratulations!");
			 return true; 
		 }*/
			 
		 if(enemies.getTranslateY() >=650) {
			GameOver.setText("You hit " + score + " enemies.");
			
			if(score == 0) {
				System.out.println("eval1");
				message.setFill(Color.RED);
				message.setText("Earth is doomed....");
			}
			
			else if(enemies.getChildren().isEmpty()) {
				System.out.println("eval2");
				message.setFill(Color.GREEN);
				message.setText("Earth is saved!");
			}
			
			return false;
		}
		return false;
	}

	public void processMousePress(MouseEvent event) {
		double a = event.getSceneX();	
		beam.setStartX(a);
		beam.setStartY(0);
		beam.setEndX(a);
		beam.setEndY(690);
		beam.setStroke(randomColor());
		laser.play();
		if(tunes.isMute()) {
			tunes.play();
		}
		
		if(beam.getStartX() <= 120 && beam.getStartX() >= 80) {
			score++;
			enemies.getChildren().remove(enemy1);
		}
		
		if(beam.getStartX() <= 220 && beam.getStartX() >= 180) {
			score++;
			enemies.getChildren().remove(enemy2);
		}
		if(beam.getStartX() <= 320 && beam.getStartX() >= 280) {
			score++;
			enemies.getChildren().remove(enemy3);
		}
		if(beam.getStartX() <= 420 && beam.getStartX() >= 380) {
			score++;
			enemies.getChildren().remove(enemy4);
		}
		if(beam.getStartX() <= 520 && beam.getStartX() >= 480) {
			score++;
			enemies.getChildren().remove(enemy5);
		}
		if(beam.getStartX() <= 620 && beam.getStartX() >= 580) {
			score++;
			enemies.getChildren().remove(enemy6);
		}
		
	}
	public void processMouseClick(MouseEvent event) {
		double a = event.getX();
		
		rocket.setTranslateX(a);
		rocket.setTranslateY(690);
		
		
	}
	
	public void processMouseRelease(MouseEvent event) {
		beam.setStartX(0);
		beam.setStartY(0);
		beam.setEndX(0);
		beam.setEndY(0);
		laser.stop();
	}
	
	public Paint randomColor() {
		int r = gen.nextInt(255);
		int g = gen.nextInt(255);
		int b = gen.nextInt(255);
		return Color.rgb(r, g, b);
	}
}
