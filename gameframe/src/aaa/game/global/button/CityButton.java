package aaa.game.global.button;

import org.loon.framework.javase.game.core.graphics.window.LButton;

import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;
import aaa.game.global.screen.GlobalScreen;

public class CityButton extends LButton {

	static String buttonImage = "images/citybutton.png";
	private String cityId = null;
	private boolean isSelect = false;


	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	private int xPos = 0;
	private int yPos = 0;
	

	public CityButton(String id) {
		super(buttonImage, null, 140,88,0,0);
		// TODO Auto-generated constructor stub
		this.cityId = id;
		setText(ShareData.cities.get(id, ConstVar.City.NAME_KEY));
		xPos = Integer.parseInt(ShareData.cities.get(id, ConstVar.City.CITY_X));
		yPos = Integer.parseInt(ShareData.cities.get(id, ConstVar.City.CITY_Y));
		setLocation(xPos, yPos);
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
