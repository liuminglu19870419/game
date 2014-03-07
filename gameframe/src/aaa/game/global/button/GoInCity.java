package aaa.game.global.button;

import aaa.game.component.button.ButtonSideTemplate;
import aaa.game.global.screen.GlobalScreen;

/**
 * 进城按钮
 */
public class GoInCity extends ButtonSideTemplate {

	public GoInCity() {
		super();
		setText("进城");
	}

	@Override
	public void doClick() {
		String selectCityId = null;
		for (CityButton cityButton : GlobalScreen.getCityButtons()) {
			if(cityButton.isSelected()) {
				selectCityId = cityButton.getId();
				System.out.println(selectCityId);
				break;
			}
		}
	}
}
