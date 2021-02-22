package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import mainComponent.Canvas;
import panel.CanvasPanel;
import shape.Shape;
import shape.UseCase;

public class UseCaseMode extends Mode {
	private Point point = null;
	private final int width = 120;
	private final int height = 100;
	
	@Override
	public void mousePressed(MouseEvent e) {
		point = e.getPoint();
		System.out.println("(UseCaseMode)Pressed Point: " + point);
		Shape useCase = new UseCase(new Point(point.x - width/2 , point.y - height/2));
		Canvas.getCanvas().getObjectList().add(useCase);
		Canvas.getCanvas().repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
