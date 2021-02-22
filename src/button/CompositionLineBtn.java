package button;

import mode.CompositionLineMode;
import mode.Mode;
import mode.SelectMode;

public class CompositionLineBtn extends Button {
	private Mode compositionLineMode = new CompositionLineMode();
	
	public CompositionLineBtn(String name) {
		super(name);
	}
	
	public Mode getMode() {
		return compositionLineMode;
	}
}
