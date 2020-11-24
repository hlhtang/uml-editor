package src;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;

public class ChooseRect extends JComponent {
	Point source;
	Point destination;
	int height;
	int width;
	Point topLeft = new Point();
	Point topRight = new Point();
	Point floorLeft = new Point();
	Point floorRight = new Point();
	
	public ChooseRect(Point source, Point destination) {
		// TODO Auto-generated constructor stub
		this.source = source;
		this.destination = destination;
		width = Math.abs(source.x - destination.x); 
		height = Math.abs(source.y - destination.y);
		if(destination.x > source.x && destination.y > source.y) {
			topLeft.setLocation(source.x, source.y);
			topRight.setLocation(source.x + width, source.y);
			floorLeft.setLocation(source.x, source.y + height);
			floorRight.setLocation(destination.x, destination.y);
		}
		if(destination.x > source.x && destination.y < source.y) {
			topLeft.setLocation(source.x, source.y - height);
			topRight.setLocation(destination.x, destination.y);
			floorLeft.setLocation(source.x, source.y);
			floorRight.setLocation(source.x + width, destination.y - height);
		}
		if(destination.x < source.x && destination.y > source.y) {
			topLeft.setLocation(source.x - width, source.y);
			topRight.setLocation(source.x, source.y);
			floorLeft.setLocation(destination.x, destination.y);
			floorRight.setLocation(destination.x + width, destination.y);
		}
		if(destination.x < source.x && destination.y < source.y) {
			topLeft.setLocation(destination.x, destination.y);
			topRight.setLocation(source.x, destination.y);
			floorLeft.setLocation(source.x - width, source.y);
			floorRight.setLocation(source.x, source.y);
		}
	}
	
	public Point getTopLeft() {
		return topLeft;
	}
	public Point getTopRight() {
		return topRight;
	}
	public Point getFloorLeft() {
		return floorLeft;
	}
	public Point getFloorRight() {
		return floorRight;
	}
	
	public void draw(Graphics g) {
		if(destination.x > source.x && destination.y > source.y)
			g.drawRect(source.x, source.y, destination.x - source.x, destination.y - source.y);
		if(destination.x > source.x && destination.y < source.y)
			g.drawRect(source.x, source.y - (source.y - destination.y), destination.x - source.x, source.y - destination.y);
		if(destination.x < source.x && destination.y > source.y)
			g.drawRect(source.x - (source.x - destination.x), source.y, source.x - destination.x, destination.y - source.y);
		if(destination.x < source.x && destination.y < source.y)
			g.drawRect(source.x - (source.x - destination.x), source.y - (source.y - destination.y), source.x - destination.x, source.y - destination.y);
	}	
}
