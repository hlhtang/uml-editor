package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;

import mainComponent.Canvas;

public class GroupObj extends Shape {
	private Point center; // center在GroupObj是指長方形的左上方座標
	private int width;
	private int height;
	private int distanceX;
	private int distanceY;
	private boolean isSelected;
	private boolean isGrouped;
	private ArrayList<Shape> objs = new ArrayList();
	
	public GroupObj(Point source, Point destination, int width, int height, 
			        ArrayList<Integer> selectedObjsIndex) {
		this.center = source;
		this.width = width;
		this.height = height;
		for(Integer index: selectedObjsIndex)
			objs.add(Canvas.getCanvas().getObjectList().get(index));
	}
	
	public void changeCenter(Point center) {
		distanceX = center.x - center.x;
		distanceY = center.y - center.y;
		this.center = center;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		distanceX = center.x - this.center.x;
		distanceY = center.y - this.center.y;
		for(Shape obj: objs) {
			Canvas.getCanvas().getObjectList()
					.get(Canvas.getCanvas().getObjectList().indexOf(obj))
					    .setCenter(new Point(
							   Canvas.getCanvas().getObjectList().get(Canvas.getCanvas().getObjectList().indexOf(obj)).getCenter().x + distanceX,
							   Canvas.getCanvas().getObjectList().get(Canvas.getCanvas().getObjectList().indexOf(obj)).getCenter().y + distanceY)
							       );
		}
		this.center = center;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public boolean checkIsSelected() {
		return isSelected;
	}
	
	public boolean getIsSelected() {
		return isSelected;
	}

	public void setIsGrouped(boolean isGrouped) {
		this.isGrouped = isGrouped;
	}
	
	public boolean getIsGrouped() {
		return isGrouped;
	}
	
	public ArrayList<Shape> getCompositeObjs(){
		return objs;
	}
	
	public boolean isCompositeObj() {
		if(objs == null)
			return false;
		return true;
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawRect(center.x, center.y, width, height);
	}
}
