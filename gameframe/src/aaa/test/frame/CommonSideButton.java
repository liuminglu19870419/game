package aaa.test.frame;

import org.loon.framework.javase.game.core.graphics.window.LButton;

import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;

public class CommonSideButton extends LButton {

	protected String buttonText = "";
	protected String buttonId = "";
	
	public CommonSideButton(String id) {
		super(ConstVar.COMMON_SIDE_BUR_IMAGE);
		this.buttonId = id;
		String preString = id.substring(0, 3);
		switch (preString) {
		case ConstVar.CITY_ID_PRE:
			buttonText = ShareData.cities.get(id, "name");
			break;
		case ConstVar.FACILATY_ID_PRE:
			buttonText = ShareData.facilities.get(id, "name");
		default:
			break;
		}
		setText(buttonText);
	}
}
