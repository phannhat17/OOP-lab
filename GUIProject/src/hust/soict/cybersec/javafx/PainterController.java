package hust.soict.cybersec.javafx;

import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {
	@FXML
	private Pane drawingAreaPane;
	
	@FXML
	private RadioButton pen;
	
	@FXML
	private RadioButton eraser;
	
	@FXML
	private ToggleGroup drawTools;
	
	
	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	
	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		Rectangle clipArea = new Rectangle(0, 0, drawingAreaPane.getWidth(), drawingAreaPane.getHeight());
		drawingAreaPane.setClip(clipArea);
		if (pen.isSelected() || eraser.isSelected()) {
			Color inkColor;
			if (pen.isSelected()) {
				inkColor = Color.BLACK;
			} else {
				inkColor = Color.WHITE;
			}
			Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
			drawingAreaPane.getChildren().add(newCircle);
		}
	}
}