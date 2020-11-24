package button;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import mainComponent.Canvas;
import panel.CanvasPanel;
import shape.BasicObj;
import shape.GroupObj;
import shape.Shape;

public class EditButton extends JMenu{
	private JMenuItem groupItem;
	private JMenuItem ungroupItem;
	private JMenuItem renameItem;
	
	public EditButton(String name) {
		this.setText(name);
		groupItem = new JMenuItem("Group");
		groupItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 設定極大、極小的source、destination座標來方便未來更新source、destination座標值
				Point source = new Point(10000, 10000);
				Point destination = new Point(0, 0);
				int width;
				int height;
				// 若選取方形內有任何物件:
				if(Canvas.getCanvas().getSelectedObjsArray().size() > 0) {
					// 判斷有無BasicCase的座標能拿來更新至即將新增的Composite物件的座標
					for(Integer index: Canvas.getCanvas().getSelectedObjsArray()) {
						Canvas.getCanvas().getObjectList().get(index).setIsGrouped(true);
						Canvas.getCanvas().getObjectList().get(index).setIsSelected(false);
						if(Canvas.getCanvas().getObjectList().get(index).getCenter().x < source.x)
							source.x = Canvas.getCanvas().getObjectList().get(index).getCenter().x;
						if(Canvas.getCanvas().getObjectList().get(index).getCenter().y < source.y)
							source.y = Canvas.getCanvas().getObjectList().get(index).getCenter().y;
						if(Canvas.getCanvas().getObjectList().get(index).getCenter().x + Canvas.getCanvas().getObjectList().get(index).getWidth() > destination.x)
							destination.x = Canvas.getCanvas().getObjectList().get(index).getCenter().x + Canvas.getCanvas().getObjectList().get(index).getWidth();
						if(Canvas.getCanvas().getObjectList().get(index).getCenter().y + Canvas.getCanvas().getObjectList().get(index).getHeight() > destination.y)
							destination.y = Canvas.getCanvas().getObjectList().get(index).getCenter().y + Canvas.getCanvas().getObjectList().get(index).getHeight();
					}
					width = destination.x - source.x;
					height = destination.y - source.y;
					Shape groupObj = new GroupObj(source, destination, width, height, Canvas.getCanvas().getSelectedObjsArray());
					groupObj.setIsSelected(true);
					Canvas.getCanvas().getObjectList().add(groupObj);
				}
				Canvas.getCanvas().repaint();
			}
		});
		
		ungroupItem = new JMenuItem("UnGroup");
		ungroupItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> deleteObjs = new ArrayList();
				if(Canvas.getCanvas().getObjectList().size() > 0) {
					for(Shape obj: Canvas.getCanvas().getObjectList()) {
						if(obj.getIsSelected() == true && obj.getIsGrouped() == false) {
							if(obj.isCompositeObj() == true) {
								for(Shape obj_ : obj.getCompositeObjs()) {
									Canvas.getCanvas().getObjectList().get(Canvas.getCanvas().getObjectList().indexOf(obj_)).setIsGrouped(false);
									Canvas.getCanvas().getObjectList().get(Canvas.getCanvas().getObjectList().indexOf(obj_)).setIsSelected(true);
								}
								deleteObjs.add(Canvas.getCanvas().getObjectList().indexOf(obj));
							}
						}
					}
					int counter = 0;
					for(Integer index: deleteObjs) {
						Canvas.getCanvas().getObjectList().remove(Canvas.getCanvas().getObjectList().get(index - counter));
						counter++;
					}
				}
				Canvas.getCanvas().repaint();
			}
		});
		
		renameItem = new JMenuItem("Change Object Name");
		renameItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("RenameBtn is Pressed!!");
				for(Shape obj: Canvas.getCanvas().getObjectList()) {
					if(obj.getIsSelected() == true && obj.isCompositeObj() == false) {
						rename((BasicObj)obj);
						break;
					}
				}
			}
		});
		this.add(groupItem);
		this.add(ungroupItem);
		this.add(renameItem);
	}
	
	public void rename(BasicObj obj) {
		JFrame smallFrame = new JFrame("Rename");
		smallFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
		JTextField textField = new JTextField("");
	    String input = null;
	    textField.setColumns(10);
	    textField.setVisible(true);
	    
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
	    JButton ensureButton = new JButton("OK");
	    ensureButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	        	String text = textField.getText();
	            obj.setName(text);
//	            CanvasPanel.canvas.repaint();
	            Canvas.getCanvas().repaint();
	            smallFrame.dispose();
	    	}
	    });
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
	    		smallFrame.dispose();
	    	}
	    });
	    buttonPanel.add(ensureButton);
	    buttonPanel.add(cancelButton);
	    smallPanel.add(textField);
	    smallPanel.add(buttonPanel);
	    smallFrame.add(smallPanel);
	    smallFrame.setSize(300, 100);
	    smallFrame.setVisible(true);
	}
}
