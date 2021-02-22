package shape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class GeneralizationLine extends BasicLine {
	private double arrowCenterX; // 菱形中心點
	private double arrowCenterY; // 菱形中心點
	
	public GeneralizationLine(Port port) {
		super(port);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		if(isCreated == true) {
			g2d.drawOval(ports[0].getPoint().x, ports[0].getPoint().y, 10, 10);
			if(isDragging == true) {
				drawDraggingArrow(g2d, draggingPoint);
				g2d.drawLine(ports[0].getPoint().x, ports[0].getPoint().y, 
							 (int)arrowCenterX, (int)arrowCenterY);
			}
			if(isDragging == false && isFinished == true) {
				drawArrow(g2d, ports[1].getPoint());
				g2d.drawLine(ports[0].getPoint().x, ports[0].getPoint().y, 
							 (int)arrowCenterX, (int)arrowCenterY);
				g2d.drawOval(ports[1].getPoint().x, ports[1].getPoint().y, 10, 10);
			}
		}
	}
	
	private void drawArrow(Graphics2D g2d, Point p) {
		double vectorX = (ports[1].getPoint().x - ports[0].getPoint().x); // 起點到終點的距離
		double vectorY = (ports[1].getPoint().y - ports[0].getPoint().y); // 起點到終點的距離
		// 菱形中心點
		arrowCenterX = ports[1].getPoint().x - 
							vectorX*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		arrowCenterY = ports[1].getPoint().y - 
							vectorY*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		// 菱形左右兩點座標
		double arrow1X = arrowCenterX - vectorY*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		double arrow1Y = arrowCenterY + vectorX*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		double arrow2X = arrowCenterX + vectorY*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		double arrow2Y = arrowCenterY - vectorX*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		g2d.drawLine(p.x, p.y, (int)arrow1X, (int)arrow1Y);
		g2d.drawLine(p.x, p.y, (int)arrow2X, (int)arrow2Y);
		g2d.drawLine((int)arrow1X, (int)arrow1Y, (int)arrow2X, (int)arrow2Y);
	}
	
	private void drawDraggingArrow(Graphics2D g2d, Point p) {
		double vectorX = (draggingPoint.x - ports[0].getPoint().x); // 起點到終點的距離
		double vectorY = (draggingPoint.y - ports[0].getPoint().y); // 起點到終點的距離
		// 菱形中心點
		arrowCenterX = draggingPoint.x - 
							vectorX*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		arrowCenterY = draggingPoint.y - 
							vectorY*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		// 菱形左右兩點座標
		double arrow1X = arrowCenterX - vectorY*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		double arrow1Y = arrowCenterY + vectorX*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		double arrow2X = arrowCenterX + vectorY*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		double arrow2Y = arrowCenterY - vectorX*(10/Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2)));
		g2d.drawLine(p.x, p.y, (int)arrow1X, (int)arrow1Y);
		g2d.drawLine(p.x, p.y, (int)arrow2X, (int)arrow2Y);
		g2d.drawLine((int)arrow1X, (int)arrow1Y, (int)arrow2X, (int)arrow2Y);
	}
	
}
