package aaa.game.people.button;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.loon.framework.javase.game.action.avg.MessageDialog;
import org.loon.framework.javase.game.core.graphics.window.LMessage;
import org.loon.framework.javase.game.utils.collection.ArrayBag;

import aaa.game.component.button.ButtonBottomTemplate;
import aaa.game.component.button.ButtonSideTemplate;
import aaa.game.component.screen.ScreenTemplate;
import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;
import aaa.game.facility.screen.FacilityScreen;

public class CommonPeopleButton extends ButtonBottomTemplate {

	String roleId;
	FacilityScreen currentScreen;
	List<ButtonSideTemplate> buttonSideTemplates = new ArrayList<>();
	List<ButtonSideTemplate> prevSideTemplates = null;
	/************************ 测试使用 *************************************/
	{
		ButtonSideTemplate buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("对话");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("检视");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("战斗");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("乞讨");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new ButtonSideTemplate();
		buttonSideTemplate.setText("赠予");
		buttonSideTemplates.add(buttonSideTemplate);
		buttonSideTemplate = new ButtonSideTemplate() {
			@Override
			public void doClick() {
				currentScreen.resetSideButtonPaper(prevSideTemplates);
				currentScreen.setBottomPaperVisible(true);
				// currentScreen.createMessagePaper(CommonPeopleButton.this.roleId);
				currentScreen.setMessageVisible(false);
			}
		};
		buttonSideTemplate.setText("返回");
		buttonSideTemplates.add(buttonSideTemplate);
	}

	public CommonPeopleButton(String roleId, FacilityScreen currentScreen) {
		super(roleId);
		// TODO Auto-generated constructor stub
		this.roleId = roleId;
		this.currentScreen = currentScreen;
		setText(ShareData.peoples.get(roleId, ConstVar.People.NAME_KEY));
	}

	@Override
	public void doClick() {
		prevSideTemplates = currentScreen.getSideButtons();
		currentScreen.resetSideButtonPaper(buttonSideTemplates);
		currentScreen.setBottomPaperVisible(false);

		currentScreen.initialMessageDialog("", roleId);
		// currentScreen.setMessagePaper(CommonPeopleButton.this.roleId);

		currentScreen
				.setMessage(
						roleId,
						"一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");
		currentScreen.getMessagePaper().setVisible(true);
	}

}
