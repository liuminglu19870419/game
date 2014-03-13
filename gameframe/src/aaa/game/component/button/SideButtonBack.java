package aaa.game.component.button;

import aaa.game.mainframe.MainFrame;

public class SideButtonBack extends ButtonSideTemplate {
	public SideButtonBack() {
		setText("返回");
	}
	
	@Override
	public void doClick() {
		MainFrame.getFrame().popScreen();
	}
}
