package aaa.game.facility.market.screen;

import java.util.ArrayList;
import java.util.List;

import aaa.game.component.button.ButtonSideTemplate;
import aaa.game.component.button.SideButtonBack;
import aaa.game.facility.screen.FacilityScreen;

public class MarketScreen extends FacilityScreen{
	public MarketScreen(String facilityId) {
		super();
		/************************* ???????????????? ********************************************/
		List<ButtonSideTemplate> buttonSideTemplates = new ArrayList<>();
		ButtonSideTemplate buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("交易");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("买地");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new SideButtonBack();
		buttonSideTemplates.add(buttonSideTemplate);
		this.resetFaciltyScreen(facilityId);
		this.resetSideButtonPaper(buttonSideTemplates);
	}
}
