package button;
import javax.swing.*;
import java.awt.event.*;

public class FileButton extends JMenu{
	private JMenuItem exitItem;
	
	public FileButton(String name) {
		this.setText(name);
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(exitItem);
	}
}
	

