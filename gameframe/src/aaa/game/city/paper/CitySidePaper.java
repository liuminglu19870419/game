package aaa.game.city.paper;

import java.util.ArrayList;
import java.util.List;

import org.loon.framework.javase.game.core.graphics.window.LButton;

import aaa.game.city.button.CitySideButtonFactory;
import aaa.game.city.screen.CityScreen;
import aaa.game.component.button.ButtonSideTemplate;
import aaa.game.component.button.SideButtonBack;
import aaa.game.component.paper.PaperSideTemplate;
import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;

public class CitySidePaper extends PaperSideTemplate {

	private List<ButtonSideTemplate> buttonSideTemplates = new ArrayList<>();
	private String cityId = null;

	public CitySidePaper() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	public void resetCitySidePaper(String cityId) {
		this.cityId = cityId;
		for (ButtonSideTemplate buttonSideTemplate : buttonSideTemplates) {
			this.remove(buttonSideTemplate);
		}
		buttonSideTemplates = new ArrayList<>();
		//寻找该城市所拥有的设施id号，使用这些id号作为如城市最左边栏的按钮名称
		String facilities[] = ShareData.cities.get(cityId,
				ConstVar.City.FACILITIES_KEY).split(
				ConstVar.LIST_ELEMENT_SEPERATOR);
		
		int length = facilities.length;
		
		
		for (int i = 0; i < length; i++) {
			ButtonSideTemplate buttonSideTemplate = CitySideButtonFactory
					.getCitySideButton(facilities[i]);
			buttonSideTemplates.add(buttonSideTemplate);
		}
		buttonSideTemplates.add(new SideButtonBack());//添加一个回全地图按钮
		setSizeByButtonCount(buttonSideTemplates.size());
		setButtons(buttonSideTemplates);
	}
}
