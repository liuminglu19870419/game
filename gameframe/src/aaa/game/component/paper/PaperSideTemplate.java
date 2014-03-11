package aaa.game.component.paper;

import java.awt.Color;
import java.util.List;

import org.loon.framework.javase.game.core.graphics.window.LPaper;

import aaa.game.component.button.ButtonSideTemplate;
import aaa.game.constv.ConstVar;

public class PaperSideTemplate extends LPaper {

	public PaperSideTemplate(int count) {
		super(0, 0, 0, 0);
		setSizeByButtonCount(count);
		setAlpha(ConstVar.COMMON_SIDE_ALPHA);
		// setBackground(Color.WHITE);
		setLocation(ConstVar.COMMON_SIDE_PAPER_X, ConstVar.COMMON_SIDE_PAPER_Y);
	}

	/**
	 * 重新根据按键数目设定边缘按钮栏大小
	 */
	public void setSizeByButtonCount(int count) {
		int w = ConstVar.COMMON_SIDE_PAPER_WIDTH_BORD * 2
				+ ConstVar.COMMON_SIDE_BUR_WIDTH;
		int h = ConstVar.COMMON_SIDE_PAPER_HEIGHT_BORD * 2 + count
				* ConstVar.COMMON_SIDE_BUR_HEIGHT;
		setSize(w, h);
	}

	/**
	 * 根据按钮列表重新填充边缘按钮栏，需要默认原来的按钮栏已经被清空
	 */
	public void setButtons(List<ButtonSideTemplate> buttonSideTemplates) {
		int index = 0;
		for (ButtonSideTemplate lButton : buttonSideTemplates) {
			lButton.setLocation(ConstVar.COMMON_SIDE_PAPER_WIDTH_BORD,
					ConstVar.COMMON_SIDE_PAPER_HEIGHT_BORD + index
							* ConstVar.COMMON_SIDE_BUR_HEIGHT);
			index++;
			add(lButton);
		}
	}

}
