package shape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class ClassObj extends BasicObj{
	private final int width = 100;
	private final int height = 120;
	private final int portOffset = 10;
	private final int nameOffsetX = 25;
	private final int nameOffsetY = 15;
	
	public ClassObj(Point center) {
		super(center);
		this.setWidth(width);
		this.setHeight(height);
		ports[0] = new Port(this, new Point(this.center.x + width/2, this.center.y - portOffset));
		ports[1] = new Port(this, new Point(this.center.x - portOffset, this.center.y + height/2));
		ports[2] = new Port(this, new Point(this.center.x + width/2, this.center.y + height));
		ports[3] = new Port(this, new Point(this.center.x + width, this.center.y + height/2));
	}
	
	@Override
	public void setCenter(Point center) {
		this.center = center;
		setPorts(new Point(getCenter().x + getWidth()/2, getCenter().y - portOffset), 0);
		setPorts(new Point(getCenter().x - portOffset, getCenter().y + getHeight()/2), 1);
		setPorts(new Point(getCenter().x + getWidth()/2, getCenter().y + getHeight()), 2);
		setPorts(new Point(getCenter().x + getWidth(), getCenter().y + getHeight()/2), 3);		
	}
	
	public void draw(Graphics g) {
		g.drawRect(center.x, center.y, width, height);
		g.drawLine(center.x, center.y + height/3, center.x + width, center.y + height/3);
		g.drawLine(center.x, center.y + (height/3)*2, center.x + width, center.y + (height/3)*2);
		g.drawString(name, center.x + nameOffsetX, center.y + nameOffsetY);
		
		if(this.isSelected == true) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawOval(ports[0].getPoint().x, ports[0].getPoint().y, portOffset, portOffset);
			g2d.drawOval(ports[1].getPoint().x, ports[1].getPoint().y, portOffset, portOffset);
			g2d.drawOval(ports[2].getPoint().x, ports[2].getPoint().y, portOffset, portOffset);
			g2d.drawOval(ports[3].getPoint().x, ports[3].getPoint().y, portOffset, portOffset);
		}
	}
}
