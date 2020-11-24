package mainComponent;
import javax.swing.*;
import java.awt.*;
import panel.TopPanel;
import panel.ButtonPanel;
import panel.CanvasPanel;

public class UMLEditor extends JFrame{
	private TopPanel topPanel;
	private ButtonPanel buttonPanel;
	private CanvasPanel canvasPanel;
	
	public UMLEditor(String name) {
		this.setTitle(name);
		topPanel = new TopPanel();
		this.getContentPane().add(BorderLayout.NORTH, topPanel);
		buttonPanel = new ButtonPanel();
		this.getContentPane().add(BorderLayout.WEST, buttonPanel);
		canvasPanel = new CanvasPanel();
		this.getContentPane().add(BorderLayout.CENTER, canvasPanel);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UMLEditor editor = new UMLEditor("UML Editor");
		editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		editor.setSize(800,600);
		editor.setVisible(true);
	}
}
