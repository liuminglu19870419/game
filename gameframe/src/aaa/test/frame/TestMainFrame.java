package aaa.test.frame;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.loon.framework.javase.game.GameScene;
import org.loon.framework.javase.game.core.graphics.Deploy;
import org.loon.framework.javase.game.core.graphics.Screen;
import org.loon.framework.javase.game.core.graphics.device.LGraphics;

public class TestMainFrame {

	static class MyScreen extends Screen {

		
		public MyScreen() {
			super();
			this.add(new TestLPanel(10, "test1"));
			this.add(new TestLPanel2(20, "people"));
			
		}
		@Override
		public void rightClick(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onKeyUp(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onKey(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void middleClick(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void leftClick(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void draw(LGraphics g) {
			// TODO Auto-generated method stub

		}

		public void init() {
			this.add(new TestLPanel(10, "test"));
			this.add(new TestLPanel2(20, "people"));
		}
	};

	public static void main(String[] args) {
		GameScene gameScene = new GameScene("test", 1440, 960);
		Deploy deploy = gameScene.getDeploy();
		MyScreen myScreen = new MyScreen();
		myScreen.setBackground("images/global.jpg");
		deploy.setScreen(myScreen);
		deploy.setFPS(100);
		deploy.mainLoop();
		deploy.setLogo(false);
		gameScene.setCursor("images/cursor.png");
		gameScene.showFrame();
	}
}
