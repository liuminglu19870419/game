package aaa.game.facility.paper;

import java.util.ArrayList;
import java.util.List;

import aaa.game.component.button.ButtonSideTemplate;
import aaa.game.component.button.SideButtonBack;
import aaa.game.component.paper.PaperSideTemplate;
import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;
import aaa.game.facility.button.FacilitySideButtonFactory;
import aaa.game.facility.screen.FacilityScreen;

public class FacilitySidePaper extends PaperSideTemplate {

	private List<ButtonSideTemplate> buttonSideTemplates = new ArrayList<>();
	private String cityId = null;
	private FacilityScreen currentScreen = null;

	public FacilitySidePaper() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	public List<ButtonSideTemplate> getButtons() {
		return buttonSideTemplates;
	}

	/**
	 * 使用一组按钮重新归一化设施按钮
	 */
	public void resetFacilitySidePaper(List<ButtonSideTemplate> list) {
		for (ButtonSideTemplate buttonSideTemplate : this.buttonSideTemplates) {
			this.remove(buttonSideTemplate);
		}
		buttonSideTemplates = list;
		setSizeByButtonCount(list.size());
		setButtons(list);
	}

	/**
	 * 使用城市id号重新设置城市内部设施
	 */
	public void resetCitySidePaper(String cityId, FacilityScreen currentScreen) {
		this.cityId = cityId;
		for (ButtonSideTemplate buttonSideTemplate : buttonSideTemplates) {
			this.remove(buttonSideTemplate);
		}
		buttonSideTemplates = new ArrayList<>();
		// 寻找该城市所拥有的设施id号，使用这些id号作为如城市最左边栏的按钮名称
		String facilities[] = ShareData.cities.get(cityId,
				ConstVar.City.FACILITIES_KEY).split(
				ConstVar.LIST_ELEMENT_SEPERATOR);
		if (facilities.length == 0) {
			facilities = new String[1];
			facilities[0] = ShareData.cities.get(cityId,
					ConstVar.City.FACILITIES_KEY);
		}
		int length = facilities.length;

		for (int i = 0; i < length; i++) {
			ButtonSideTemplate buttonSideTemplate = FacilitySideButtonFactory
					.getCitySideButton(facilities[i]);
			buttonSideTemplates.add(buttonSideTemplate);
		}
		buttonSideTemplates.add(new SideButtonBack());// 添加一个回全地图按钮
		setSizeByButtonCount(buttonSideTemplates.size());
		setButtons(buttonSideTemplates);
	}
}
