package button;
import javax.swing.*;

import mainComponent.Canvas;
import mode.Mode;
import mode.SelectMode;
import java.awt.event.*;
import java.awt.*;
import panel.ButtonPanel;
import panel.CanvasPanel;

public class Button extends JButton implements ActionListener {
	private boolean isSelected = false;
	
	public Button(String name) {
		this.setText(name);
		this.addActionListener(this);
	}
	
	public boolean getIsSelected() {
		return isSelected;
	}
	
	public void setIsSelected(boolean isSelected) {
		this.isSelected= isSelected; 
	}
	
	public Mode getMode() {
		Mode selectMode = new SelectMode();
		return selectMode;
	}
	
	public void actionPerformed(ActionEvent event) {
		Color color = UIManager.getColor("Button.background");
		for(Button btn: ButtonPanel.buttonList) {
			btn.setIsSelected(false);
			btn.setBackground(color);
		}
		this.setIsSelected(true);
		this.setBackground(Color.GRAY);
		Canvas.getCanvas().setMode();
	}
}
