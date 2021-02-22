package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import shape.Shape;
import shape.ClassObj;
import mainComponent.Canvas;
import panel.CanvasPanel;

public class ClassMode extends Mode {
	private Point point = null;
	private final int width = 100;
	private final int height = 120;
	
	@Override
	public void mousePressed(MouseEvent e) {
		point = e.getPoint();
		System.out.println("(ClassMode)Pressed Point: " + point);
		Shape classObj = new ClassObj(new Point(point.x - width/2, point.y - height/2));
		Canvas.getCanvas().getObjectList().add(classObj);
		Canvas.getCanvas().repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
