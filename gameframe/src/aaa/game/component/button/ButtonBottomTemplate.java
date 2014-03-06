package aaa.game.component.button;

import org.loon.framework.javase.game.core.graphics.window.LButton;

import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;

/**
 * 通用底部边框按钮
 * ??????????未完成???????????*/
public class ButtonBottomTemplate extends LButton {

	String id = null;
	public ButtonBottomTemplate(String id) {
		super(ShareData.peoples.get(id, ConstVar.People.PEOPLE_IMAGE_KEY));
	}

}
