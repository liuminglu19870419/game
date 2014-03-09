package aaa.game.component.paper;

import java.awt.Color;
import java.util.List;

import org.loon.framework.javase.game.core.graphics.window.LPaper;

import aaa.game.component.button.ButtonBottomTemplate;
import aaa.game.constv.ConstVar;

public class PaperBottomTemplate extends LPaper {

	public PaperBottomTemplate(int count) {
		super(0, 0, 0, 0);
		setLocation(ConstVar.COMMON_BOTTOM_PAPER_X,
				ConstVar.COMMON_BOTTOM_PAPER_Y);
		int line = count / ConstVar.COMMON_BOTTOM_BUR_MAXX_SIZE;
		if (count % ConstVar.COMMON_BOTTOM_BUR_MAXX_SIZE != 0) {
			line += 1;
		}
		int width = ConstVar.COMMON_BOTTOM_PAPER_WIDTH_BORD * 2
				+ ConstVar.COMMON_BOTTOM_BUR_MAXX_SIZE
				* ConstVar.COMMON_BOTTOM_BUR_WIDTH;
		int height = ConstVar.COMMON_BOTTOM_PAPER_HEIGHT_BORD * 2
				+ ConstVar.COMMON_SIDE_BUR_HEIGHT * line;
		setSize(width, height);
		setAlpha(ConstVar.COMMON_SIDE_ALPHA);
//		setBackground(Color.WHITE);
	}

	/**
	 * 根据按钮数目重新设定底部按钮栏大小
	 */
	public void setSizeByButtonCount(int count) {
		int line = count / ConstVar.COMMON_BOTTOM_BUR_MAXX_SIZE;
		if (count % ConstVar.COMMON_BOTTOM_BUR_MAXX_SIZE != 0) {
			line += 1;
		}
		int width = ConstVar.COMMON_BOTTOM_PAPER_WIDTH_BORD * 2
				+ ConstVar.COMMON_BOTTOM_BUR_MAXX_SIZE
				* ConstVar.COMMON_BOTTOM_BUR_WIDTH;
		int height = ConstVar.COMMON_BOTTOM_PAPER_HEIGHT_BORD * 2
				+ ConstVar.COMMON_BOTTOM_BUR_HEIGHT * line;
		setSize(width, height);
	}

	/**
	 * 根据按钮列表，将底部栏重新填充，需要确保原来的边框已经被清空
	 */
	public void setButtons(List<ButtonBottomTemplate> buttonBottomTemplates) {
		int xCount = 0;
		int yCount = 0;
		for (ButtonBottomTemplate buttonBottomTemplate : buttonBottomTemplates) {
			buttonBottomTemplate.setLocation(
					ConstVar.COMMON_BOTTOM_PAPER_WIDTH_BORD + xCount
							* ConstVar.COMMON_BOTTOM_BUR_WIDTH,
					ConstVar.COMMON_BOTTOM_PAPER_HEIGHT_BORD + yCount
							* ConstVar.COMMON_BOTTOM_BUR_HEIGHT);
			add(buttonBottomTemplate);
			xCount++;
			if (xCount == ConstVar.COMMON_BOTTOM_BUR_MAXX_SIZE) {
				xCount = 0;
				yCount++;
			}
		}

	}
}
