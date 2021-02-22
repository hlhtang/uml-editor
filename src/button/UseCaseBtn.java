package button;

import mode.Mode;
import mode.SelectMode;
import mode.UseCaseMode;

public class UseCaseBtn extends Button {
	private Mode useCaseMode = new UseCaseMode();
	
	public UseCaseBtn(String name) {
		super(name);
	}
	
	public Mode getMode() {
		return useCaseMode;
	}
}
