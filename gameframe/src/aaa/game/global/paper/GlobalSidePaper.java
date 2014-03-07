package aaa.game.global.paper;

import java.util.ArrayList;
import java.util.List;

import org.loon.framework.javase.game.core.graphics.window.LButton;

import aaa.game.component.paper.PaperSideTemplate;
import aaa.game.constv.ConstVar;
import aaa.game.global.button.AttackButton;
import aaa.game.global.button.GoInCity;
import aaa.game.global.button.MoveHomeButton;
import aaa.game.global.button.OutButton;
import aaa.game.global.button.PauseButton;

public class GlobalSidePaper extends PaperSideTemplate {

	private static final int button_count = 5;
	private List<LButton> buttons = new ArrayList<>();
	private AttackButton attackButton = null;
	private GoInCity goInCity = null;
	private MoveHomeButton moveHomeButton = null;
	private OutButton outButton = null;
	private PauseButton pauseButton = null;

	public GlobalSidePaper() {
		super(button_count);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * 初始化全国按钮 待完成？？？？？？？？？？？？？？？？？
	 */
	private void initialize() {
		pauseButton = new PauseButton();
		buttons.add(pauseButton);

		goInCity = new GoInCity();
		buttons.add(goInCity);

		moveHomeButton = new MoveHomeButton();
		buttons.add(moveHomeButton);

		outButton = new OutButton();
		buttons.add(outButton);

		attackButton = new AttackButton();
		buttons.add(attackButton);

		int index = 0;
		for (LButton lButton : buttons) {
			lButton.setLocation(ConstVar.COMMON_SIDE_PAPER_WIDTH_BORD,
					ConstVar.COMMON_SIDE_PAPER_HEIGHT_BORD + index
							* ConstVar.COMMON_SIDE_BUR_HEIGHT);
			index ++;
			add(lButton);
		}
	}

}
