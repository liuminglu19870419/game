package aaa.game.component.paper;

import org.loon.framework.javase.game.core.graphics.window.LPaper;

import aaa.game.constv.ConstVar;

public class PaperSideTemplate extends LPaper {

	public PaperSideTemplate(int count) {
		super(0, 0, 0, 0);
		int w = ConstVar.COMMON_BOTTOM_PAPER_WIDTH_BORD * 2 + ConstVar.COMMON_SIDE_BUR_WIDTH;
		int h = ConstVar.COMMON_SIDE_PAPER_HEIGHT_BORD * 2 + count
				* ConstVar.COMMON_SIDE_BUR_HEIGHT;
		setSize(w, h);
		setLocation(ConstVar.COMMON_SIDE_PAPER_X, ConstVar.COMMON_SIDE_PAPER_Y);
	}

}
