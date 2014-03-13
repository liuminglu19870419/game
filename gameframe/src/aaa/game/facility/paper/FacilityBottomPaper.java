package aaa.game.facility.paper;

import java.util.ArrayList;
import java.util.List;

import aaa.game.component.button.ButtonBottomTemplate;
import aaa.game.component.paper.PaperBottomTemplate;
import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;
import aaa.game.facility.screen.FacilityScreen;
import aaa.game.people.button.CommonPeopleButton;

public class FacilityBottomPaper extends PaperBottomTemplate {
	private String facilityId= null;
	private FacilityScreen currentScreen = null;
	private List<ButtonBottomTemplate> buttonBottomTemplates = new ArrayList<>();
	public FacilityBottomPaper() {
		super(0);
		// TODO Auto-generated constructor stub
	}
	
	public void resetFacilityBottomPaper(String facilityId, FacilityScreen currentScreen) {
		this.facilityId = facilityId;
		this.currentScreen = currentScreen;
		for (ButtonBottomTemplate buttonBottomTemplate : buttonBottomTemplates) {
			remove(buttonBottomTemplate);
		}
		buttonBottomTemplates = new ArrayList<>();
		String peoples[] = ShareData.facilities.get(facilityId, ConstVar.Facility.PEOPLES_KEY).split(ConstVar.LIST_ELEMENT_SEPERATOR);
		for (String roleId : peoples) {
			CommonPeopleButton facilityBottomButton = new CommonPeopleButton(roleId,currentScreen);
			buttonBottomTemplates.add(facilityBottomButton);
		}
		setSizeByButtonCount(buttonBottomTemplates.size());
		setButtons(buttonBottomTemplates);
	}
}
