package aaa.game.component.paper;

import org.loon.framework.javase.game.core.graphics.window.LPaper;

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
	}

}
