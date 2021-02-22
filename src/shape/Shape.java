package shape;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public abstract class Shape extends JComponent {
	protected boolean isGrouped;
	
	public Shape() {}
	
	public boolean getIsGrouped() {
		return isGrouped;
	}
	
	public void setIsGrouped(boolean isGrouped) {
		this.isGrouped = isGrouped;
	}
	
	// for BasicObj
	public boolean getIsSelected() {
		return false;
	}
	public void setIsSelected(boolean isSelected) {}
	public Point getCenter() {
		return null;
	}
	public void setCenter(Point center) {}
	public Port[] getPorts() {
		return null;
	}
	public void setPorts(Point point, int portNum) {}
	
	// for BasicLine
	public boolean getIsCreated() {
		return false;
	}
	public void setIsCreated(boolean isCreated) {}
	public boolean getIsDragging() {
		return false;
	}
	public void setIsDragging(boolean isDragging) {}
	public boolean getIsFinished() {
		return false;
	}
	public void setIsFinished(boolean isFinished) {}
	public Point getDraggingPoint() {
		return null;
	}
	public void setDraggingPoint(Point draggingPoint) {}
	public Port getPort(int num) {
		return null;
	}
	public void setPorts(Port port, int portNum) {}
	
	// for GroupObj
	public ArrayList<Shape> getCompositeObjs(){
		return null;
	}
	public boolean isCompositeObj() {
		return false;
	}
	
	public abstract void draw(Graphics g);
}
