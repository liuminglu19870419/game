package aaa.game.global.screen;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.xml.bind.JAXBElement.GlobalScope;

import org.loon.framework.javase.game.core.graphics.Screen;
import org.loon.framework.javase.game.core.graphics.device.LGraphics;
import org.loon.framework.javase.game.core.graphics.window.LPaper;

import aaa.game.component.screen.ScreenTemplate;
import aaa.game.global.paper.GlobalSidePaper;

public class GlobalScreen extends ScreenTemplate{
	
	GlobalSidePaper globalSidePaper = null;
	int buttonCount = 9;
	public GlobalScreen() {
		super();
		this.globalSidePaper = new GlobalSidePaper();
		add(globalSidePaper);
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
