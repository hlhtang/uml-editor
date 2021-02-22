package panel;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.Arrays;
import java.awt.*;
import button.FileButton;
import button.EditButton;

public class TopPanel extends JPanel {
	private FileButton fileButton;
	private EditButton editButton;
	private JMenuBar bar;
	
	public TopPanel() {
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.setBackground(Color.lightGray);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		fileButton = new FileButton("File");
		editButton = new EditButton("Edit");
		bar = new JMenuBar();
		bar.add(fileButton);
		bar.add(editButton);
		this.add(bar);
	}
}
