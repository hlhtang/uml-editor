package panel;
import javax.swing.*;
import java.util.ArrayList;
import button.Button;
import button.SelectBtn;
import button.AssociationLineBtn;
import button.GeneralizationLineBtn;
import button.CompositionLineBtn;
import button.ClassBtn;
import button.UseCaseBtn;
import mode.Mode;
import mode.SelectMode;

public class ButtonPanel extends JPanel {
	public static ArrayList<Button> buttonList = new ArrayList();
	
	public ButtonPanel() {
		// ³]©wpanel¤WÂ\³]componentsªº¯d¥ÕÃä½t
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Button selectBtn = new SelectBtn("Select");
		Button associationLineBtn = new AssociationLineBtn("AssociationLine");
		Button generalizationLineBtn = new GeneralizationLineBtn("GeneralizationLine");
		Button compositionLineBtn = new CompositionLineBtn("CompositionLine");
		Button classBtn = new ClassBtn("Class");
		Button useCaseBtn = new UseCaseBtn("UseCase");
		buttonList.add(selectBtn);
		buttonList.add(associationLineBtn);
		buttonList.add(generalizationLineBtn);
		buttonList.add(compositionLineBtn);
		buttonList.add(classBtn);
		buttonList.add(useCaseBtn);
		for(Button btn: buttonList)
			this.add(btn);
	}

	public static Mode getMode() {
		for(Button btn: buttonList) {
			if(btn.getIsSelected() == true)
				return btn.getMode();
		}
		Mode selectMode = new SelectMode();
		return selectMode;
	}	
}
