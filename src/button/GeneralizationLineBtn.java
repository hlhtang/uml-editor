package button;
import mode.GeneralizationLineMode;
import mode.Mode;
import mode.SelectMode;

public class GeneralizationLineBtn extends Button {
	private Mode generalizationLineMode = new GeneralizationLineMode();
	
	public GeneralizationLineBtn(String name) {
		super(name);
	}
	
	public Mode getMode() {
		return generalizationLineMode;
	}
}
