package button;

import mode.AssociationLineMode;
import mode.Mode;
import mode.SelectMode;

public class AssociationLineBtn extends Button {
	private Mode associationLineMode = new AssociationLineMode();
	
	public AssociationLineBtn(String name) {
		super(name);
	}
	
	public Mode getMode() {
		return associationLineMode;
	}
}
