package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import mainComponent.Canvas;
import panel.CanvasPanel;
import shape.AssociationLine;
import shape.BasicObj;
import shape.CompositionLine;
import shape.Port;
import shape.Shape;

public class CompositionLineMode extends Mode{
	private Point point = null;
	private Port port;
	private boolean releaseOnObj = false;
	
	@Override
	public void mousePressed(MouseEvent e) {
		point = e.getPoint();
		System.out.println("(CompositionLineMode)Pressed Point: " + point);
		for(Shape obj: Canvas.getCanvas().getObjectList()) {
			obj.setIsSelected(false);
			Canvas.getCanvas().repaint();
			try {
				if(isPressed(point, obj) == true) {
					port = getSourceLineLocation(point, (BasicObj) obj); 
					Shape line = new CompositionLine(port);
					Canvas.getCanvas().getLineList().add(line);
					line.setIsCreated(true);
					Canvas.getCanvas().repaint();
				}
			}catch(ClassCastException ex) {
				System.out.println("Catch ClassCastException");
			}
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		point = e.getPoint();
		for(Shape line: Canvas.getCanvas().getLineList()) {
			if(line.getIsCreated() == true && !line.getIsFinished()) {
				line.setIsDragging(true);
				line.setDraggingPoint(point);
				Canvas.getCanvas().repaint();
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		point = e.getPoint();
		releaseOnObj = false;
		for(Shape line: Canvas.getCanvas().getLineList()) {
			if(line.getIsCreated() == true && line.getIsDragging() == true) {
				for(Shape obj: Canvas.getCanvas().getObjectList()) {
					try{
						if(isPressed(point, obj) == true){
							port = getDestinationLineLocation(point, (BasicObj) obj); 
							if(!line.getPort(0).getParent().equals(obj)) { // 避免自己連到自己
								line.setPorts(port, 1);
								line.setIsFinished(true);
								line.setIsDragging(false);
								releaseOnObj = true;
								Canvas.getCanvas().repaint();
								break;
							}
						}
					}catch(ClassCastException ex) {
						System.out.println("Catch ClassCastException");
						line.setIsCreated(false);
						Canvas.getCanvas().repaint();
					}
				}
				if(releaseOnObj == false) {
					line.setIsCreated(false);
					Canvas.getCanvas().repaint();
				}
			}
		}
	}
}
