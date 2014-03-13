package aaa.game.facility.screen;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.loon.framework.javase.game.action.avg.MessageDialog;
import org.loon.framework.javase.game.action.sprite.SpriteImage;
import org.loon.framework.javase.game.core.graphics.device.LGraphics;
import org.loon.framework.javase.game.core.graphics.window.LMessage;
import org.loon.framework.javase.game.core.graphics.window.LPaper;

import aaa.game.component.button.ButtonSideTemplate;
import aaa.game.component.screen.ScreenTemplate;
import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;
import aaa.game.facility.paper.FacilityBottomPaper;
import aaa.game.facility.paper.FacilitySidePaper;

public class FacilityScreen extends ScreenTemplate {

	protected FacilitySidePaper facilitySidePaper = null;
	protected FacilityBottomPaper facilityBottomPaper = null;
	protected String backImage = null;
	protected LMessage messagePaper = null;
	private Map<String, SpriteImage> spriteImages = new HashMap<String, SpriteImage>();
	private LPaper face = new LPaper(15, 15, 90, 90);

	public void initialMessageDialog(String eventId, String... roleIds) {
		// 首先将原来的对话中存在的人物移除
		for (String id : spriteImages.keySet()) {
			this.remove(spriteImages.get(id));
		}

		// 添加新的人物
		spriteImages = new HashMap<String, SpriteImage>();
		for (String roleId : roleIds) {
			SpriteImage spriteImage = new SpriteImage(ShareData.peoples.get(
					roleId, ConstVar.People.PEOPLE_BODY_IMAGE_KEY));
			spriteImages.put(roleId, spriteImage);
			spriteImage.setLocation(650, 250);
			spriteImage.setVisible(false);
			add(spriteImage);
		}

	}

	public void setMessage(String roleId, String message) {
		for (String id : spriteImages.keySet()) {
			if (id.equals(roleId)) {
				spriteImages.get(roleId).setVisible(true);
			} else {
				spriteImages.get(id).setVisible(false);
			}
		}
		setMessagePaper(roleId);
		messagePaper.setMessage(message);
	}

	public void setMessageVisible(boolean isVisible) {
		messagePaper.setVisible(isVisible);
		if(!isVisible) {
			for (String string : spriteImages.keySet()) {
				spriteImages.get(string).setVisible(false);
			}
		}
	}
	static private class CitySingle {

		static public FacilityScreen cityScreen = new FacilityScreen();
	}

	static public FacilityScreen getCityScreen() {
		return FacilityScreen.CitySingle.cityScreen;
	}

	public FacilityScreen() {
		facilitySidePaper = new FacilitySidePaper();
		facilityBottomPaper = new FacilityBottomPaper();
		this.add(facilitySidePaper);
		this.add(facilityBottomPaper);
		messagePaper = new LMessage(ConstVar.COMMON_BOTTOM_MESSAGE_WIDTH,
				ConstVar.COMMON_BOTTOM_MESSAGE_HEIGHT) {
			int count = 1;

			@Override
			public void doClick() {
				// TODO Auto-generated method stub
				super.doClick();

			};
		};
		messagePaper.setLocation(ConstVar.COMMON_BOTTOM_MESSAGE_X,
				ConstVar.COMMON_BOTTOM_MESSAGE_Y);
		Image messageBackImage = MessageDialog.getRMXPDialog(
				ConstVar.COMMON_BOTTOM_BACK_IMAGE,
				ConstVar.COMMON_BOTTOM_MESSAGE_WIDTH,
				ConstVar.COMMON_BOTTOM_MESSAGE_HEIGHT);
		messagePaper.setDelay(10);
		messagePaper.setLeftOffset(25);
		messagePaper.setMessageLength(30);
		messagePaper.setBackground(messageBackImage);
		face = new LPaper(15, 15, 90, 90);
		messagePaper.add(face);
		messagePaper.setVisible(false);
		this.add(messagePaper);
	}

	public LMessage getMessagePaper() {
		return messagePaper;
	}

	public void setMessagePaper(String roleId) {
		face.setBackground(ShareData.peoples.get(roleId,
				ConstVar.People.PEOPLE_IMAGE_KEY));
		messagePaper.setRoleName(
				ShareData.peoples.get(roleId, ConstVar.People.NAME_KEY), 35,
				125);
		return;
	}

	public List<ButtonSideTemplate> getSideButtons() {
		return facilitySidePaper.getButtons();
	}

	public void setBottomPaperVisible(boolean visible) {
		facilityBottomPaper.setVisible(visible);
	}

	/**
	 * 初始化设施背景
	 */
	public FacilityScreen resetFaciltyScreen(String facilityId) {
		if (facilityId.startsWith(ConstVar.City.CITY_ID_PRE)) {
			backImage = ShareData.cities.get(facilityId,
					ConstVar.City.CITY_BACK_IMAGE);
			this.facilitySidePaper.resetCitySidePaper(facilityId, this);
			facilityId = ShareData.cities.get(facilityId,
					ConstVar.City.MAIN_FACILITY);
		} else {
			backImage = ShareData.facilities.get(facilityId,
					ConstVar.Facility.BACK_IMAGE);
		}
		this.setBackground(backImage);
		this.facilityBottomPaper.resetFacilityBottomPaper(facilityId, this);
		return this;
	}

	public void resetSideButtonPaper(
			List<ButtonSideTemplate> buttonSideTemplates) {
		this.facilitySidePaper.resetFacilitySidePaper(buttonSideTemplates);
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
