package button;

import mode.ClassMode;
import mode.Mode;
import mode.SelectMode;

public class ClassBtn extends Button{
	private Mode classMode = new ClassMode();
	
	public ClassBtn(String name) {
		super(name);
	}
	
	public Mode getMode() {
		return classMode;
	}
}
