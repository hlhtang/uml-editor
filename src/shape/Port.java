package shape;

import java.awt.Point;

public class Port{
	private BasicObj parent;
	private Point p;
	
	public Port(BasicObj parent, Point p) {
		this.parent = parent;
		this.p = p;
	}
	
	public BasicObj getParent() {
		return parent;
	}
	
	public void setParent(BasicObj parent) {
		this.parent = parent;
	}
	
	public Point getPoint() {
		return p;
	}
	
	public void setPoint(Point p) {
		this.p = p;
	}
}
