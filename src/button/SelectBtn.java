package button;
import java.awt.Color;
import mode.Mode;
import mode.SelectMode;

public class SelectBtn extends Button {
	private boolean isSelected = true;
	private Mode selectMode = new SelectMode();
	
	public SelectBtn(String name) {
		super(name);
		this.setBackground(Color.GRAY);
	}
	
	public Mode getMode() {
		return selectMode;
	}
}
