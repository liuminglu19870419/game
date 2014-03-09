package aaa.game.city.screen;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.loon.framework.javase.game.core.graphics.device.LGraphics;

import aaa.facility.paper.FacilityBottomPaper;
import aaa.game.city.paper.CitySidePaper;
import aaa.game.component.screen.ScreenTemplate;
import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;

public class CityScreen extends ScreenTemplate {

	private CitySidePaper citySidePaper = null;
	private FacilityBottomPaper cityBottomPaper = null;
	private String backImage = null;
	static private class CitySidePaperSingle {

		static public CityScreen cityScreen = new CityScreen();
	}

	static public CityScreen getCityScreen() {
		return CityScreen.CitySidePaperSingle.cityScreen;
	}

	private CityScreen() {
		citySidePaper = new CitySidePaper();
		cityBottomPaper = new FacilityBottomPaper();
		this.add(citySidePaper);
		this.add(cityBottomPaper);
	}

	public CityScreen resetCityScreen(String cityId) {
		backImage = ShareData.cities.get(cityId, ConstVar.City.CITY_BACK_IMAGE);
		this.setBackground(backImage);
		this.citySidePaper.resetCitySidePaper(cityId);
		String []facilities = ShareData.cities.get(cityId, ConstVar.City.FACILITIES_KEY).split(ConstVar.LIST_ELEMENT_SEPERATOR);
		String facilityId = "";
		for (String string : facilities) {
			if (ShareData.facilities.get(string, ConstVar.Facility.NAME_KEY).equals("jiedao")) {
				facilityId = string;
				break;
			}
		}
		this.cityBottomPaper.resetFacilityBottomPaper(facilityId);
		return this;
	}

	@Override
	public void draw(LGraphics g) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onKey(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onKeyUp(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void leftClick(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void middleClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
