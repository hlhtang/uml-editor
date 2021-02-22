package shape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class BasicLine extends Shape {
	protected boolean isCreated;
	protected boolean isDragging;
	protected boolean isFinished;
	protected Point draggingPoint;
	protected Port[] ports = new Port[2];
	
	public BasicLine(Port port) {
		// 線被初始化時起終點一樣
		ports[0] = port;
		ports[1] = port;
	}
	
	public boolean getIsCreated() {
		return isCreated;
	}
	
	public void setIsCreated(boolean isCreated) {
		this.isCreated = isCreated;
	}
	
	public boolean getIsDragging() {
		return isDragging;
	}
	public void setIsDragging(boolean isDragging) {
		this.isDragging = isDragging;
	}
	
	public boolean getIsFinished() {
		return isFinished;
	}
	
	public void setIsFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	
	public Point getDraggingPoint() {
		return draggingPoint;
	}
	
	public void setDraggingPoint(Point draggingPoint) {
		this.draggingPoint = draggingPoint;
	}
	
	public Port getPort(int num) {
		return ports[num];
	}
	
	public void setPorts(Port port, int portNum) {
		ports[portNum] =  port;
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		if(isCreated == true) {
			g2d.drawOval(ports[0].getPoint().x, ports[0].getPoint().y, 10, 10);
			if(isDragging == true) {
				g2d.drawLine(ports[0].getPoint().x, ports[0].getPoint().y, 
						     draggingPoint.x, draggingPoint.y);
			}
			if(isDragging == false && isFinished == true) {
				g2d.drawLine(ports[0].getPoint().x, ports[0].getPoint().y, 
						     ports[1].getPoint().x, ports[1].getPoint().y);
				g2d.drawOval(ports[1].getPoint().x, ports[1].getPoint().y, 10, 10);
			}
		}
	}
	
	public void drawArrow(Graphics2D g, int x1, int y1, int x2, int y2, int x3, int y3) {
		
	}
	
}
