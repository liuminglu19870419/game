package aaa.game.facility.school.screen;

import java.util.ArrayList;
import java.util.List;

import aaa.game.component.button.ButtonSideTemplate;
import aaa.game.component.button.SideButtonBack;
import aaa.game.facility.screen.FacilityScreen;

public class SchoolScreen extends FacilityScreen {
	public SchoolScreen(String facilityId) {
		super();
		/************************* ???????????????? ********************************************/
		List<ButtonSideTemplate> buttonSideTemplates = new ArrayList<>();
		ButtonSideTemplate buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("对诗");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("购地");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new SideButtonBack();
		buttonSideTemplates.add(buttonSideTemplate);
		this.resetFaciltyScreen(facilityId);
		this.resetSideButtonPaper(buttonSideTemplates);
	}
}
