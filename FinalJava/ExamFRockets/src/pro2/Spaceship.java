package pro2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Spaceship {
	//Group root = new Group(); 
	Rectangle base;
	Circle window;
	Polygon LeftWing = new Polygon();
	Polygon RightWing = new Polygon();
	Polygon Nose = new Polygon();
	
	
	public Spaceship() {
		base = new Rectangle(-25, 0, 50, 100);
		window = new Circle(base.getX()+(base.getWidth()/2), base.getY()+base.getHeight()/2, 10);
		base.setFill(Color.WHITE);
		window.setFill(Color.AQUA);
		window.setTranslateY(window.getTranslateY()-20);
		
		LeftWing.getPoints().addAll(base.getX(), base.getY()+100, base.getX(), base.getY()+50, base.getX()-50,base.getY()+100);
		LeftWing.setFill(Color.BLUE);
		
		RightWing.getPoints().addAll(base.getX()+50, base.getY()+100, base.getX()+50, base.getY()+49,base.getX()+100, base.getY()+100);
		RightWing.setFill(Color.BLUE);
		
		Nose.getPoints().addAll(base.getX(), base.getY(), base.getX()+50, base.getY(), base.getX()+25, base.getY()-50);
		Nose.setFill(Color.RED);
		
		
	}
	
	
	public Rectangle getBase() {
		return base;
		
	}
	
	public Circle getwindow() {
		return window;
		
	}
}
