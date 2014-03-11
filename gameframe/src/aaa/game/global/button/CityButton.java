package aaa.game.global.button;

import org.loon.framework.javase.game.core.graphics.window.LButton;

import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;
import aaa.game.global.screen.GlobalScreen;

public class CityButton extends LButton {

	static String buttonImage = "images/citybutton.png";
	private String cityId = null;
	private boolean isSelect = false;

	public CityButton(String id) {
		super(buttonImage, null, 140,88,0,0);
		// TODO Auto-generated constructor stub
		this.cityId = id;
		setText(ShareData.cities.get(id, ConstVar.City.NAME_KEY));
	}

	public String getId() {
		return cityId;
	}

	@Override
	public void doClick() {
		for (CityButton cityButton : GlobalScreen.getCityButtons()) {
			if (cityButton.getId().equals(getId())) {
				if (isSelect == false) {
					isSelect = true;
					cityButton.setForceSelect(isSelect);
					continue;
				} else {
					isSelect = false;
					cityButton.setForceSelect(isSelect);
				}
			} else {
				cityButton.setForceSelect(false);
				cityButton.isSelect = false;
			}
		}
	}

	@Override
	public boolean isSelected() {
		return isSelect;
	}
}
