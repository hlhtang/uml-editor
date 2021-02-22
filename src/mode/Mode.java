package mode;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.event.MouseAdapter;¡F
//import java.awt.event.MouseMotionAdapter;

import mainComponent.Canvas;
import shape.BasicObj;
import shape.Port;
import shape.Shape;

public abstract class Mode implements MouseListener, MouseMotionListener {

	public void mousePressed(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseMoved(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	
	public boolean isPressed(Point p,Shape basicObj) {
		if(p.x <= (basicObj.getCenter().x + basicObj.getWidth()) &&
		   p.x >=  basicObj.getCenter().x &&
		   p.y <= (basicObj.getCenter().y + basicObj.getHeight()) &&
		   p.y >=  basicObj.getCenter().y){
			return true;
		}
		else
			return false;
	}
	
	public Port getSourceLineLocation(Point point, BasicObj obj) {
		double d = 100;
		Port port = null;
		for(int i = 0; i < 4; i++) {
			double distance = Math.sqrt((Math.pow((point.x - obj.ports[i].getPoint().x), 2) + 
					          Math.pow((point.y - obj.ports[i].getPoint().y), 2)));
			if (distance < d) {
				d = distance;
				port = obj.ports[i];
			}
		}
		return port;
	}
	
	public Port getDestinationLineLocation(Point point, BasicObj obj) {
		double d = 100;
		Port port = null;
		for(int i = 0; i < 4; i++) {
			double distance = Math.sqrt((Math.pow((point.x - obj.ports[i].getPoint().x), 2) + 
			          		  Math.pow((point.y - obj.ports[i].getPoint().y), 2)));
			if (distance < d) {
				d = distance;
				port = obj.ports[i];
			}
		}
		return port;
	}
}
