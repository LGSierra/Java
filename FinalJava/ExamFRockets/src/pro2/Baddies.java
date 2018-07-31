package pro2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Baddies {

	Circle base;
	Circle window;
	
	public Baddies() {
		base = new Circle(5, 5, 20);
		window = new Circle(base.getCenterX(), base.getCenterY()+ 20, 10);
		base.setFill(Color.RED);
		window.setFill(Color.GREEN);
		window.setTranslateY(window.getTranslateY()-20);
	}
	public Circle getBase() {
		return base;
		
	}
	
	public Circle getwindow() {
		return window;
		
	}
	
}
