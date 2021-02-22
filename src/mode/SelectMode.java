package mode;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.*;

import shape.BasicObj;
import shape.Port;
import shape.Shape;
import src.ChooseRect;
import mainComponent.Canvas;
import panel.CanvasPanel;

public class SelectMode extends Mode {
	private Point point = null;
	private boolean isSelectOnObject = false; // 用於線、選取方形的判斷
	private boolean isDragging = false; // 用於線、選取方形的判斷

	@Override
	public void mousePressed(MouseEvent e) {	
		point = e.getPoint();
		isSelectOnObject = false;
		Canvas.getCanvas().setSelectSourceLocation(new Point());
		Canvas.getCanvas().setSelectDestinationLocation(new Point());
				
		// 將所有物件的IsSelected狀態設為false
		for(Shape obj: Canvas.getCanvas().getObjectList())
			obj.setIsSelected(false);
		// 將選取多個物件的陣列從新初始化
		if(Canvas.getCanvas().getSelectedObjsArray().size() > 0)
			Canvas.getCanvas().setSelectedObjsArray(new ArrayList<Integer>());
		// 判斷物件有無重疊:
		ArrayList<Integer> overlapObjs = new ArrayList<>();
		for(Shape obj: Canvas.getCanvas().getObjectList()) {
			if(isPressed(point, obj) == true && obj.getIsGrouped() == false)
				overlapObjs.add(Canvas.getCanvas().getObjectList().indexOf(obj));
		}
		
		for(Shape obj: Canvas.getCanvas().getObjectList()) {
			if(overlapObjs.size() > 0 && 
			   Canvas.getCanvas().getObjectList().indexOf(obj) == overlapObjs.get(overlapObjs.size()-1)) {
					obj.setIsSelected(true);
					isSelectOnObject = true;
					break;
			}	
		}
		
		// 若點選位置不在物件上，抓取這個座標
		if(isSelectOnObject == false)
			Canvas.getCanvas().setSelectSourceLocation(new Point(point.x, point.y));
		Canvas.getCanvas().repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		point = e.getPoint();
  	  	// 若MousePressed的座標在物件裡
  	  	if(isSelectOnObject == true) {
  	  		// 若MousePressed的座標在物件裡
  	  		for(Shape obj: Canvas.getCanvas().getObjectList()) {
  	  			if(obj.getIsSelected() == true && obj.getIsGrouped() == false) {
  	  				obj.setCenter(new Point(point.x - obj.getWidth()/2, point.y - obj.getHeight()/2));
  	  				Canvas.getCanvas().repaint();
  				    break;
  	  			}
  	  		}
  	  	}
  	  	// 若MousePressed的座標不在任何物件裡
  	  	if(isSelectOnObject == false) {
  	  		isDragging = true;
  	  		Canvas.getCanvas().setSelectDestinationLocation(new Point(point.x, point.y));
  	  		// Drag出一個選取方形
  	  		Canvas.getCanvas().setChooseRect(
  	  				new ChooseRect(Canvas.getCanvas().getSelectSourceLocation(), 
  	  						       Canvas.getCanvas().getSelectDestinationLocation()));
  	  		Canvas.getCanvas().repaint();
  	  	}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		point = e.getPoint();
		// 選取方形:
		if(isDragging == true) {
			// 判斷有無選取到物件且其未被Group
			for(Shape obj: Canvas.getCanvas().getObjectList()) {
				if(obj.getCenter().x + obj.getWidth() <= Canvas.getCanvas().getChooseRect().getTopRight().getX() &&
				   obj.getCenter().x >= Canvas.getCanvas().getChooseRect().getTopLeft().getX() &&
				   obj.getCenter().y + obj.getHeight() <= Canvas.getCanvas().getChooseRect().getFloorLeft().getY() &&
				   obj.getCenter().y >= Canvas.getCanvas().getChooseRect().getTopLeft().getY() &&
				   obj.getIsGrouped() == false) {
					 obj.setIsSelected(true);
					 // 加進選取方形
					 Canvas.getCanvas().getSelectedObjsArray().add(Canvas.getCanvas().getObjectList().indexOf(obj));	
				}
			}
		}
		Canvas.getCanvas().setChooseRect(new ChooseRect(new Point(), new Point()));
		Canvas.getCanvas().repaint();
 		isDragging = false;
	}
}
