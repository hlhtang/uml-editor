package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class BasicObj extends Shape {
	protected String name = new String("No Name");
	protected Point center = null;
	protected int width;
	protected int height;
	protected boolean isSelected;
	protected ArrayList<Shape> objs;
	public Port[] ports = new Port[4];
	
	public BasicObj(Point center) {
		this.center = center;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Port[] getPorts() {
		return ports;
	}
	
	public void setPorts(Point point, int portNum) {
		this.ports[portNum].setPoint(point);
	}
	
	public boolean getIsSelected() {
		return isSelected;
	}
	
	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public boolean isCompositeObj() {
		if(objs == null)
			return false;
		return true;
	}
	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
	}
}
