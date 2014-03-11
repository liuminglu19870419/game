package aaa.game.facility.home.screen;

import java.util.ArrayList;
import java.util.List;

import aaa.game.component.button.ButtonSideTemplate;
import aaa.game.component.button.SideButtonBack;
import aaa.game.facility.screen.FacilityScreen;

public class HomeScreen extends FacilityScreen {
	public HomeScreen(String facilityId) {
		super();
		/************************* ???????????????? ********************************************/
		List<ButtonSideTemplate> buttonSideTemplates = new ArrayList<>();
		ButtonSideTemplate buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("扩仓");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("资产");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new SideButtonBack();
		buttonSideTemplates.add(buttonSideTemplate);
		this.resetFaciltyScreen(facilityId);
		this.resetSideButtonPaper(buttonSideTemplates);
	}
}
