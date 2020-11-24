package panel;
import javax.swing.*;
import java.awt.*;
import mainComponent.Canvas;

public class CanvasPanel extends JPanel{

	public CanvasPanel() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		Canvas.getCanvas().setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(Canvas.getCanvas());
	}
}
